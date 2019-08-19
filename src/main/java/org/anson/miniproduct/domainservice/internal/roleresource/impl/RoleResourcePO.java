package org.anson.miniproduct.domainservice.internal.roleresource.impl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.anson.miniproduct.domainservice.base.BasePO;

@Data
@TableName("role_resource")
class RoleResourcePO extends BasePO<RoleResourcePO> {
    private String roleId;
    private String resourceId;

    public static final String ROLEID = "role_id";
    public static final String RESOURCEID = "resource_id";

    private static final String _TABLENAME = "role_resource";
    @Override
    public String TABLENAME() {
        return _TABLENAME;
    }
}
