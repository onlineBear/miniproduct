package org.anson.miniproduct.domainservice.account.impl;

import lombok.extern.slf4j.Slf4j;
import org.anson.miniproduct.constrant.enums.ClientEnum;
import org.anson.miniproduct.domainservice.account.IUserDMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Component
@Transactional(rollbackFor = Exception.class)
@Slf4j
class UserDMService implements IUserDMService {

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public void login(String userNo, String encryptedPsd, ClientEnum client) {
        log.debug("userNo : [{}], encryptedPsd : [{}], ClientEnum : [{}]", userNo, encryptedPsd, client.getKey());
        if (!dao.authentication(userNo, encryptedPsd)){
            throw new RuntimeException("账号密码不正确");
        }

        // sessionId
        String sessionId = this.getSessionId(client);

        // 移除旧的 session
        session.removeAttribute(sessionId);

        // 添加新的 session
        session.setAttribute(sessionId, userNo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public void logout(ClientEnum client){
        session.removeAttribute(this.getSessionId(client));
    }

    private String getSessionId(ClientEnum client){
        return new StringBuilder(client.getKey()).append("-").append(SESSIONID).toString();
    }

    // 注入
    @Autowired
    private UserDao dao;
    @Autowired
    private HttpSession session;

    private static final String SESSIONID = "sessionId";
}
