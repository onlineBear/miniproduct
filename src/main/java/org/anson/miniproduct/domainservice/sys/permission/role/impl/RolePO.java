package org.anson.miniproduct.domainservice.sys.permission.role.impl;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.anson.miniproduct.domainservice.base.BasePO;

@Data
@TableName("role")
class RolePO extends BasePO {
    private String no;
    private String name;
    private String description;

    public static final String NO = "no";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";

    private static final String _TABLENAME = "role";
    @Override
    public String TABLENAME() {
        return _TABLENAME;
    }
}
