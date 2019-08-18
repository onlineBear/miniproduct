package org.anson.miniproduct.web.pc.login.dto;

import lombok.Data;
import org.anson.miniproduct.web.base.BaseDTO;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDTO extends BaseDTO {
    @NotBlank(message = "请输入用户编码")
    private String userNo;
    @NotBlank(message = "请输入密码")
    private String psd;
}
