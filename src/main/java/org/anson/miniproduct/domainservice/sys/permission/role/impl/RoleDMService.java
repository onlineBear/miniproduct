package org.anson.miniproduct.domainservice.sys.permission.role.impl;

import org.anson.miniproduct.domainservice.internal.roleresource.IRoleResourceDMService;
import org.anson.miniproduct.domainservice.internal.userrole.IUserRoleDMService;
import org.anson.miniproduct.domainservice.sys.permission.role.IRoleDMService;
import org.anson.miniproduct.domainservice.sys.permission.role.cmd.AddRoleCMD;
import org.anson.miniproduct.domainservice.sys.permission.role.cmd.UpdRoleCMD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Component
@Transactional(rollbackFor = Exception.class)
class RoleDMService implements IRoleDMService {
    @Override
    public String addRole(@Valid AddRoleCMD cmd) throws Exception {
        RolePO po = addRoleCMDConverter.toRolePO(cmd);
        String id = this.dao.insert(po);
        return id;
    }

    @Override
    public void updateRole(@Valid UpdRoleCMD cmd) throws Exception {
        RolePO po = updRoleCMDConverter.toRolePO(cmd);
        this.dao.updateById(po);
    }

    @Override
    public void deleteRole(@Valid @NotBlank String id) throws Exception {
        // 删除角色
        this.dao.deleteById(id);

        // 删除相应的角色资源
        this.roleResourceDMService.deleteByRole(id, null);

        // 删除相应的角色用户
        this.userRoleDMService.deleteByRole(id, null);
    }

    @Override
    public void relateToResource(@Valid @NotBlank String roleId, @Valid @NotNull Collection<String> resourceIds) {
        this.roleResourceDMService.addByRole(roleId, resourceIds);
    }

    @Override
    public void unrelateToResource(@Valid @NotBlank String roleId, @Valid @NotNull Collection<String> resourceIds) throws Exception {
        this.roleResourceDMService.deleteByRole(roleId, resourceIds);
    }

    @Override
    public void relateToUser(@Valid @NotBlank String roleId, @Valid @NotNull Collection<String> userIds) {
        this.userRoleDMService.addByRole(roleId, userIds);
    }

    @Override
    public void unrelateToUser(@Valid @NotBlank String roleId, @Valid @NotNull Collection<String> userIds) throws Exception {
        this.userRoleDMService.deleteByRole(roleId, userIds);
    }

    // 注入
    @Autowired
    private RoleDao dao;
    @Autowired
    private IRoleResourceDMService roleResourceDMService;
    @Autowired
    private IUserRoleDMService userRoleDMService;

    // converter
    @Autowired
    private AddRoleCMDConverter addRoleCMDConverter;
    @Autowired
    private UpdRoleCMDConverter updRoleCMDConverter;
}
