package org.anson.miniproduct.domainservice.sys.permission.role.impl;

import org.anson.miniproduct.domainservice.sys.permission.role.cmd.AddRoleCMD;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface AddRoleCMDConverter {
    RolePO toRolePO(AddRoleCMD cmd);
}
