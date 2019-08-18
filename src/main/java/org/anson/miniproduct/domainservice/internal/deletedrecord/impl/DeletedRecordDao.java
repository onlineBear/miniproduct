package org.anson.miniproduct.domainservice.internal.deletedrecord.impl;

import org.anson.miniproduct.domainservice.base.BaseDao;
import org.anson.miniproduct.framework.req.RequestHolder;
import org.anson.miniproduct.infrastructure.tool.id.IdHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component
@Transactional(rollbackFor = Exception.class)
class DeletedRecordDao extends BaseDao<DeletedRecordPO, DeletedRecordMapper> {
    public String insert(DeletedRecordPO deletedRecord){
        Date reqTime = RequestHolder.getReqTime();

        deletedRecord.setId(IdHelper.nextSnowflakeId());

        deletedRecord.setCreateTime(reqTime);
        deletedRecord.setUpdateTime(reqTime);

        this.mapper.insert(deletedRecord);

        return deletedRecord.getId();
    }

    // 注入
    @Autowired
    @Override
    protected void setMapper(DeletedRecordMapper mapper) {
        this.mapper = mapper;
    }
}
