package org.anson.miniproduct.domainservice.internal.deletedrecord.impl;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.anson.miniproduct.domainservice.base.BasePO;

@Data
@TableName("deleted_record")
class DeletedRecordPO extends BasePO<DeletedRecordPO> {
    private String tableName;
    private String pk;
    private String record;

    public static final String TABLENAME = "table_name";
    public static final String PK = "pk";
    public static final String RECORD = "record";

    private static final String _TABLENAME = "deleted_record";

    @Override
    public String TABLENAME() {
        return _TABLENAME;
    }
}
