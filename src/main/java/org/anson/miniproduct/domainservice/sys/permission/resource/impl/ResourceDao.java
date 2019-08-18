package org.anson.miniproduct.domainservice.sys.permission.resource.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.anson.miniproduct.domainservice.base.BaseDao;
import org.anson.miniproduct.domainservice.internal.deletedrecord.IDeletedRecordHelper;
import org.anson.miniproduct.framework.req.RequestHolder;
import org.anson.miniproduct.infrastructure.tool.id.IdHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component
@Transactional(rollbackFor = Exception.class)
class ResourceDao extends BaseDao<ResourcePO, ResourceMapper> {

    public String insert(ResourcePO resourcePO) throws CloneNotSupportedException {
        ResourcePO po = (ResourcePO) resourcePO.clone();

        Date operTime = RequestHolder.getReqTime();

        po.setId(IdHelper.nextSnowflakeId());
        po.setCreateTime(operTime);
        po.setUpdateTime(operTime);

        this.mapper.insert(po);
        return po.getId();
    }

    public void updateById(ResourcePO resourcePO) throws CloneNotSupportedException {
        ResourcePO po = (ResourcePO) resourcePO.clone();

        Date operTime = RequestHolder.getReqTime();

        po.setCreateTime(null);
        po.setUpdateTime(operTime);

        this.mapper.updateById(po);
    }

    public void deleteById(String id) throws JsonProcessingException {
        ResourcePO po = this.mapper.selectById(id);

        if (po == null){
            return;
        }

        this.mapper.deleteById(id);
        this.delHelper.recordDelData(po);
    }

    // 注入
    @Override
    @Autowired
    protected void setMapper(ResourceMapper mapper) {
        this.mapper = mapper;
    }
    @Autowired
    private IDeletedRecordHelper delHelper;
}
