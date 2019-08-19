package org.anson.miniproduct.domainservice.sys.permission.resource;

import org.anson.miniproduct.domainservice.sys.permission.resource.cmd.AddResourceCMD;
import org.anson.miniproduct.domainservice.sys.permission.resource.cmd.UpdResourceCMD;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Validated
public interface IResourceDMService {
    String addResource(@Valid AddResourceCMD cmd) throws Exception;
    void updateResource(@Valid UpdResourceCMD cmd) throws Exception;
    void deleteResource(@Valid @NotBlank String id) throws Exception;

    void relateToRole(@Valid @NotBlank String resourceId, @Valid @NotNull Collection<String> roleIds);
    void unrelateToRole(@Valid @NotBlank String resourceId, @Valid @NotNull Collection<String> roleIds) throws Exception;
}
