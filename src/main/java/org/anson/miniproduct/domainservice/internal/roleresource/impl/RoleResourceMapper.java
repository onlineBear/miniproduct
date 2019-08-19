package org.anson.miniproduct.domainservice.internal.roleresource.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Mapper
interface RoleResourceMapper extends BaseMapper<RoleResourcePO> {
    void batchInsert(Collection<RoleResourcePO> pos);
}
