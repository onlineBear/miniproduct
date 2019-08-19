package org.anson.miniproduct.domainservice.sys.permission.role.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.anson.miniproduct.domainservice.base.BaseDao;
import org.anson.miniproduct.domainservice.internal.deletedrecord.IDeletedRecordHelper;
import org.anson.miniproduct.framework.req.RequestHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component
@Transactional(rollbackFor = Exception.class)
class RoleDao extends BaseDao<RolePO, RoleMapper> {
    public String insert(RolePO rolePO) throws CloneNotSupportedException {
        RolePO po = (RolePO) rolePO.clone();

        Date operTime = RequestHolder.getReqTime();

        po.setId(po.getNo());
        po.setCreateTime(operTime);
        po.setUpdateTime(operTime);

        this.mapper.insert(po);

        return po.getId();
    }

    public void updateById(RolePO rolePO) throws CloneNotSupportedException {
        RolePO po = (RolePO) rolePO.clone();

        Date operTime = RequestHolder.getReqTime();

        po.setCreateTime(null);
        po.setUpdateTime(operTime);

        this.mapper.updateById(po);
    }

    public void deleteById(String id) throws JsonProcessingException {
        RolePO po = this.mapper.selectById(id);

        if (po == null){
            return;
        }

        this.mapper.deleteById(id);
        this.delHelper.record(po);
    }

    // 注入
    @Override
    @Autowired
    protected void setMapper(RoleMapper mapper) {
        this.mapper = mapper;
    }
    @Autowired
    private IDeletedRecordHelper delHelper;
}
