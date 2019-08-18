package org.anson.miniproduct.domainservice.sys.permission.resource.impl;

import org.anson.miniproduct.domainservice.sys.permission.resource.cmd.UpdResourceCMD;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface UpdResourceCMDConverter {
    ResourcePO toResourcePO(UpdResourceCMD cmd);
}
