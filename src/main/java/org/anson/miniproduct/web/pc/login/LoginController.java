package org.anson.miniproduct.web.pc.login;

import lombok.extern.slf4j.Slf4j;
import org.anson.miniproduct.framework.res.ResHelper;
import org.anson.miniproduct.framework.res.Response;
import org.anson.miniproduct.web.pc.login.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/pc")
@Slf4j
public class LoginController {
    @GetMapping("/login")
    public Response login(@ModelAttribute LoginDTO dto) throws Exception{
        this.service.login(dto);
        return ResHelper.ok(new Date());
    }

    @GetMapping("/logout")
    public Response logout() throws Exception{
        this.service.logout();
        return ResHelper.ok(new Date());
    }

    @GetMapping("/hasLogin")
    public Response hasLogin(HttpSession session) throws Exception{
        return ResHelper.ok(session.getAttribute("client-pc-sessionId"), new Date());
    }

    @Autowired
    private LoginService service;
}
