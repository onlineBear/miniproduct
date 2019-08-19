package org.anson.miniproduct.domainservice.sys.permission.role;

import org.anson.miniproduct.domainservice.sys.permission.role.cmd.AddRoleCMD;
import org.anson.miniproduct.domainservice.sys.permission.role.cmd.UpdRoleCMD;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Validated
public interface IRoleDMService {
    String addRole(@Valid AddRoleCMD cmd) throws Exception;
    void updateRole(@Valid UpdRoleCMD cmd) throws Exception;
    void deleteRole(@Valid @NotBlank String id) throws Exception;

    void relateToResource(@Valid @NotBlank String roleId, @Valid @NotNull Collection<String> resourceIds);
    void unrelateToResource(@Valid @NotBlank String roleId, @Valid @NotNull Collection<String> resourceIds) throws Exception;

    void relateToUser(@Valid @NotBlank String roleId, @Valid @NotNull Collection<String> userIds);
    void unrelateToUser(@Valid @NotBlank String roleId, @Valid @NotNull Collection<String> userIds) throws Exception;
}
