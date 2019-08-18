package org.anson.miniproduct.domainservice.sys.permission.role;

import org.anson.miniproduct.domainservice.sys.permission.role.cmd.AddRoleCMD;
import org.anson.miniproduct.domainservice.sys.permission.role.cmd.UpdRoleCMD;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Validated
public interface IRoleDMService {
    String addRole(@Valid AddRoleCMD cmd) throws Exception;
    void updateRole(@Valid UpdRoleCMD cmd) throws Exception;
    void deleteRole(@Valid @NotBlank String id) throws Exception;
}
