package org.anson.miniproduct.domainservice.account.impl;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.anson.miniproduct.domainservice.base.BasePO;

import java.util.Date;

@Data
@TableName("user")
class UserPO extends BasePO {
    private String no;
    private String name;
    private String password;
    private Date registeredTime;

    public static final String NO = "no";
    public static final String NAME = "name";
    public static final String PASSWORD = "password";
    public static final String REGISTEREDTIME = "registered_time";

    private static final String _TABLENAME = "user";
    @Override
    public String TABLENAME() {
        return _TABLENAME;
    }
}
