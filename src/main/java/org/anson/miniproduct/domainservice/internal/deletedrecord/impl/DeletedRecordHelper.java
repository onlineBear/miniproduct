package org.anson.miniproduct.domainservice.internal.deletedrecord.impl;

import cn.hutool.core.collection.IterUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.anson.miniproduct.domainservice.base.BasePO;
import org.anson.miniproduct.domainservice.internal.deletedrecord.IDeletedRecordHelper;
import org.anson.miniproduct.framework.jackson.Jackson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@Transactional(rollbackFor = Exception.class)

class DeletedRecordHelper implements IDeletedRecordHelper {
    @Override
    public <P extends BasePO> String record(P po) throws JsonProcessingException {
        DeletedRecordPO record = new DeletedRecordPO();
        record.setTableName(po.TABLENAME());
        record.setPk(po.getId());
        record.setRecord(jackson.toJson(po));

        return this.dao.insert(record);
    }

    @Override
    public <P extends BasePO> void batchRecord(Collection<P> poList) throws JsonProcessingException {
        List<DeletedRecordPO> recordList = new ArrayList<>();
        DeletedRecordPO record = null;

        for (P po : poList){
            record = new DeletedRecordPO();
            record.setTableName(po.TABLENAME());
            record.setPk(po.getId());
            record.setRecord(jackson.toJson(po));

            recordList.add(record);
        }

        this.dao.batchInsert(recordList);
    }

    // 注入
    @Autowired
    private DeletedRecordDao dao;
    @Autowired
    private Jackson jackson;
}
