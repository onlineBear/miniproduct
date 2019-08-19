package org.anson.miniproduct.domainservice.internal.userrole.impl;

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
class UserRoleDao extends BaseDao<UserRolePO, UserRoleMapper> {

    public void insertByUser(String userId, Collection<String> roleIds){
        List<UserRolePO> poList = new ArrayList<>();
        UserRolePO po = null;

        Date operTime = RequestHolder.getReqTime();

        for (String roleId : roleIds){
            po = new UserRolePO();
            po.setRoleId(roleId);
            po.setUserId(userId);

            po.setId(IdHelper.nextSnowflakeId());
            po.setCreateTime(operTime);
            po.setUpdateTime(operTime);

            poList.add(po);
        }

        this.mapper.batchInsert(poList);
    }

    public void insertByRole(String roleId, Collection<String> userIds){
        List<UserRolePO> poList = new ArrayList<>();
        UserRolePO po = null;

        Date operTime = RequestHolder.getReqTime();

        for (String userId : userIds){
            po = new UserRolePO();
            po.setUserId(userId);
            po.setRoleId(roleId);

            po.setId(IdHelper.nextSnowflakeId());
            po.setCreateTime(operTime);
            po.setUpdateTime(operTime);

            poList.add(po);
        }

        this.mapper.batchInsert(poList);
    }

    public void deleteByUser(String userId, Collection<String> roleIds) throws JsonProcessingException {
        QueryWrapper<UserRolePO> qw = new QueryWrapper<>();
        qw.eq(UserRolePO.USERID, userId);

        if (IterUtil.isNotEmpty(roleIds)){
            qw.in(UserRolePO.ROLEID, roleIds);
        }

        List<UserRolePO> poList = this.mapper.selectList(qw);

        if (IterUtil.isEmpty(poList)){
            return;
        }

        this.mapper.delete(qw);
        this.delHelper.batchRecord(poList);
    }

    public void deleteByRole(String roleId, Collection<String> userIds) throws JsonProcessingException {
        QueryWrapper<UserRolePO> qw = new QueryWrapper<>();
        qw.eq(UserRolePO.ROLEID, roleId);

        if (IterUtil.isNotEmpty(userIds)){
            qw.in(UserRolePO.USERID, userIds);
        }

        List<UserRolePO> poList = this.mapper.selectList(qw);

        if (IterUtil.isEmpty(poList)){
            return;
        }

        this.mapper.delete(qw);
        this.delHelper.batchRecord(poList);
    }

    // 注入
    @Autowired
    @Override
    protected void setMapper(UserRoleMapper mapper) {
        this.mapper = mapper;
    }
    @Autowired
    private IDeletedRecordHelper delHelper;
}
