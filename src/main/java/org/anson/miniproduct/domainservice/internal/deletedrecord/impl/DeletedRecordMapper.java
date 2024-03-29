package org.anson.miniproduct.domainservice.internal.deletedrecord.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Mapper
interface DeletedRecordMapper extends BaseMapper<DeletedRecordPO> {
    void batchInsert(Collection<DeletedRecordPO> list);
}
