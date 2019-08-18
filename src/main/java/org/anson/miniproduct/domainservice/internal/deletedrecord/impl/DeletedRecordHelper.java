package org.anson.miniproduct.domainservice.internal.deletedrecord.impl;

import org.anson.miniproduct.domainservice.base.BasePO;
import org.anson.miniproduct.domainservice.internal.deletedrecord.IDeletedRecordHelper;
import org.anson.miniproduct.framework.jackson.Jackson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(rollbackFor = Exception.class)

class DeletedRecordHelper implements IDeletedRecordHelper {
    @Override
    public <P extends BasePO> String recordDelData(P po) throws Exception {
        DeletedRecordPO record = new DeletedRecordPO();
        record.setTableName(po.TABLENAME());
        record.setPk(po.getId());
        record.setRecord(jackson.toJson(po));

        return this.dao.insert(record);
    }

    // 注入
    @Autowired
    private DeletedRecordDao dao;
    @Autowired
    private Jackson jackson;
}
