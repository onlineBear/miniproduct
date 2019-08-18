package org.anson.miniproduct.domainservice.account.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
interface UserMapper extends BaseMapper<UserPO> {
}
