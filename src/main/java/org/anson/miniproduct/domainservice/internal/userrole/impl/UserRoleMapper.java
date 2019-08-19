package org.anson.miniproduct.domainservice.internal.userrole.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Mapper
interface UserRoleMapper extends BaseMapper<UserRolePO> {
    void batchInsert(Collection<UserRolePO> pos);
}
