package org.anson.miniproduct.domainservice.account;

import org.anson.miniproduct.constrant.enums.ClientEnum;

public interface IUserDMService {
    void login(String userNo, String encryptedPsd, ClientEnum client);
    void logout(ClientEnum client);
}
