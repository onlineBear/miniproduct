package org.anson.miniproduct.domainservice.sys.permission.resource.cmd;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UpdResourceCMD {
    @NotBlank
    private String id;

    private String moduleId;

    private String name;
    private String description;
    private String url;
}
