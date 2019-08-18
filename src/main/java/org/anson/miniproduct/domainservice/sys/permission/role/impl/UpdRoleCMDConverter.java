package org.anson.miniproduct.domainservice.sys.permission.role.impl;

import org.anson.miniproduct.domainservice.sys.permission.resource.cmd.UpdResourceCMD;
import org.anson.miniproduct.domainservice.sys.permission.role.cmd.AddRoleCMD;
import org.anson.miniproduct.domainservice.sys.permission.role.cmd.UpdRoleCMD;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface UpdRoleCMDConverter {
    RolePO toRolePO(UpdRoleCMD cmd);
}
