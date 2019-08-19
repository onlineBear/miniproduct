package org.anson.miniproduct.domainservice.internal.userrole.impl;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.anson.miniproduct.domainservice.base.BasePO;

@Data
@TableName("user_role")
class UserRolePO extends BasePO<UserRolePO> {
    private String userId;
    private String roleId;

    public static final String USERID = "user_id";
    public static final String ROLEID = "role_id";

    private static final String _TABLENAME = "user_role";
    @Override
    public String TABLENAME() {
        return _TABLENAME;
    }
}
