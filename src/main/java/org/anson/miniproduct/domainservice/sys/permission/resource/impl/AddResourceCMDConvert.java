package org.anson.miniproduct.domainservice.sys.permission.resource.impl;

import org.anson.miniproduct.domainservice.sys.permission.resource.cmd.AddResourceCMD;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface AddResourceCMDConvert {
    ResourcePO toResourcePO(AddResourceCMD cmd);
}
