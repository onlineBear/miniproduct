package org.anson.miniproduct.web.pc.login;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.anson.miniproduct.constrant.enums.ClientEnum;
import org.anson.miniproduct.domainservice.account.IUserDMService;
import org.anson.miniproduct.web.pc.login.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Component("pcLoginService")
@Transactional(rollbackFor = Exception.class)
@Validated
public class LoginService {
    public void login(@Valid LoginDTO dto) throws Exception{
        this.service.login(dto.getUserNo(), dto.getPsd(), ClientEnum.PC);
    }

    public void logout() throws Exception{
        this.service.logout(ClientEnum.PC);
    }

    @Autowired
    private IUserDMService service;
}
