package org.anson.miniproduct.domainservice.internal.roleresource;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Validated
public interface IRoleResourceDMService {
    void addByRole(@Valid @NotBlank String roleId, @Valid @NotNull Collection<String> resourceIds);
    void addByResource(@Valid @NotBlank String resourceId, @Valid @NotNull Collection<String> roleIds);
    void deleteByRole(@Valid @NotBlank String roleId, Collection<String> resourceIds) throws Exception;
    void deleteByResource(@Valid @NotBlank String resourceId, Collection<String> roleIds) throws Exception;
}
