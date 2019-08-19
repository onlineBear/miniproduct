package org.anson.miniproduct.domainservice.internal.roleresource.impl;

import cn.hutool.core.collection.IterUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.anson.miniproduct.domainservice.base.BaseDao;
import org.anson.miniproduct.domainservice.internal.deletedrecord.IDeletedRecordHelper;
import org.anson.miniproduct.framework.req.RequestHolder;
import org.anson.miniproduct.infrastructure.tool.id.IdHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Component
@Transactional(rollbackFor = Exception.class)
class RoleResourceDao extends BaseDao<RoleResourcePO, RoleResourceMapper> {

    public void insertByRole(String roleId, Collection<String> resourceIds){
        List<RoleResourcePO> poList = new ArrayList<>();

        Date operTime = RequestHolder.getReqTime();

        RoleResourcePO po = null;

        for (String resourceId : resourceIds){
            po = new RoleResourcePO();
            po.setRoleId(roleId);
            po.setResourceId(resourceId);

            po.setId(IdHelper.nextSnowflakeId());
            po.setCreateTime(operTime);
            po.setUpdateTime(operTime);

            poList.add(po);
        }

        this.mapper.batchInsert(poList);
    }

    public void insertByResource(String resourceId, Collection<String> roleIds){
        List<RoleResourcePO> poList = new ArrayList<>();

        Date operTime = RequestHolder.getReqTime();

        RoleResourcePO po = null;

        for (String roleId : roleIds){
            po = new RoleResourcePO();
            po.setResourceId(resourceId);
            po.setRoleId(roleId);

            po.setId(IdHelper.nextSnowflakeId());
            po.setCreateTime(operTime);
            po.setUpdateTime(operTime);

            poList.add(po);
        }

        this.mapper.batchInsert(poList);
    }

    public void deleteByRole(String roleId, Collection<String> resourceIds) throws JsonProcessingException {
        QueryWrapper<RoleResourcePO> qw = new QueryWrapper<>();
        qw.eq(RoleResourcePO.ROLEID, roleId);

        if (IterUtil.isNotEmpty(resourceIds)){
            qw.in(RoleResourcePO.RESOURCEID, resourceIds);
        }

        List<RoleResourcePO> poList = this.mapper.selectList(qw);

        if (IterUtil.isEmpty(poList)){
            return;
        }

        this.mapper.delete(qw);
        this.delHelper.batchRecord(poList);
    }

    public void deleteByResource(String resourceId, Collection<String> roleIds) throws JsonProcessingException {
        QueryWrapper<RoleResourcePO> qw = new QueryWrapper<>();
        qw.eq(RoleResourcePO.RESOURCEID, resourceId);

        if (IterUtil.isNotEmpty(roleIds)){
            qw.in(RoleResourcePO.ROLEID, roleIds);
        }

        List<RoleResourcePO> poList = this.mapper.selectList(qw);

        if (IterUtil.isEmpty(poList)){
            return;
        }

        this.mapper.delete(qw);
        this.delHelper.batchRecord(poList);
    }

    // 注入
    @Autowired
    @Override
    protected void setMapper(RoleResourceMapper mapper) {
        this.mapper = mapper;
    }
    @Autowired
    private IDeletedRecordHelper delHelper;
}
