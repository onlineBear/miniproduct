package org.anson.miniproduct.domainservice.sys.permission.role.impl;

import org.anson.miniproduct.domainservice.sys.permission.role.IRoleDMService;
import org.anson.miniproduct.domainservice.sys.permission.role.cmd.AddRoleCMD;
import org.anson.miniproduct.domainservice.sys.permission.role.cmd.UpdRoleCMD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

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
    }

    // 注入
    @Autowired
    private RoleDao dao;
    @Autowired
    private AddRoleCMDConverter addRoleCMDConverter;
    @Autowired
    private UpdRoleCMDConverter updRoleCMDConverter;
}
