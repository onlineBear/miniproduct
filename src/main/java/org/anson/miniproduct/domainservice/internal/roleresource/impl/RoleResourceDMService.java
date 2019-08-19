package org.anson.miniproduct.domainservice.internal.roleresource.impl;

import org.anson.miniproduct.domainservice.internal.roleresource.IRoleResourceDMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Component
@Transactional(rollbackFor = Exception.class)
class RoleResourceDMService implements IRoleResourceDMService {
    @Override
    public void addByRole(@Valid @NotBlank String roleId, @Valid @NotNull Collection<String> resourceIds) {
        this.dao.insertByRole(roleId, resourceIds);
    }

    @Override
    public void addByResource(@Valid @NotBlank String resourceId, @Valid @NotNull Collection<String> roleIds) {
        this.dao.insertByResource(resourceId, roleIds);
    }

    @Override
    public void deleteByRole(@Valid @NotBlank String roleId, Collection<String> resourceIds) throws Exception {
        this.dao.deleteByRole(roleId, resourceIds);
    }

    @Override
    public void deleteByResource(@Valid @NotBlank String resourceId, Collection<String> roleIds) throws Exception {
        this.dao.deleteByResource(resourceId, roleIds);
    }

    // 注入
    @Autowired
    private RoleResourceDao dao;
}
