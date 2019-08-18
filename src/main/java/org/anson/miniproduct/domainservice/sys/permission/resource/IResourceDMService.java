package org.anson.miniproduct.domainservice.sys.permission.resource;

import org.anson.miniproduct.domainservice.sys.permission.resource.cmd.AddResourceCMD;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface IResourceDMService {
    String addResource(@Valid AddResourceCMD cmd) throws Exception;
}
