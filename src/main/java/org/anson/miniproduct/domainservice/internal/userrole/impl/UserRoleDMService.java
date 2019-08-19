package org.anson.miniproduct.domainservice.internal.userrole.impl;

import org.anson.miniproduct.domainservice.internal.userrole.IUserRoleDMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Component
@Transactional(rollbackFor = Exception.class)
class UserRoleDMService implements IUserRoleDMService {
    @Override
    public void addByUser(@Valid @NotBlank String userId, @Valid @NotNull Collection<String> roleIds) {
        this.dao.insertByUser(userId, roleIds);
    }

    @Override
    public void addByRole(@Valid @NotBlank String roleId, @Valid @NotNull Collection<String> userIds) {
        this.dao.insertByRole(roleId, userIds);
    }

    @Override
    public void deleteByUser(@Valid @NotBlank String userId, Collection<String> roleIds) throws Exception {
        this.dao.deleteByUser(userId, roleIds);
    }

    @Override
    public void deleteByRole(@Valid @NotBlank String roleId, Collection<String> userIds) throws Exception {
        this.dao.deleteByRole(roleId, userIds);
    }

    // 注入
    @Autowired
    private UserRoleDao dao;
}
