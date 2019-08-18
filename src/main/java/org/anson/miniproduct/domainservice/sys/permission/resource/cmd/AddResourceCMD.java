package org.anson.miniproduct.domainservice.sys.permission.resource.cmd;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddResourceCMD {
    private String moduleId;

    @NotBlank
    private String name;
    private String description;
    @NotBlank
    private String url;
}
