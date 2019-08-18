package org.anson.miniproduct.domainservice.sys.permission.role.cmd;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddRoleCMD {
    @NotBlank
    private String no;
    @NotBlank
    private String name;
    private String description;
}
