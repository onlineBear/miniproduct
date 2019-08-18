package org.anson.miniproduct.domainservice.sys.permission.role.cmd;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UpdRoleCMD {
    @NotBlank
    private String id;
    private String name;
    private String description;
}
