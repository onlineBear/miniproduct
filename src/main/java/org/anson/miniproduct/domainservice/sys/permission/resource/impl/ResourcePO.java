package org.anson.miniproduct.domainservice.sys.permission.resource.impl;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.anson.miniproduct.domainservice.base.BasePO;

@Data
@TableName("resource")
class ResourcePO extends BasePO{
    private String moduleId;

    private String name;
    private String description;
    private String url;

    public static final String MODULEID = "module_id";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String URL = "url";

    private static final String _TABLENAME = "resource";
    @Override
    public String TABLENAME() {
        return _TABLENAME;
    }
}
