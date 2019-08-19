package org.anson.miniproduct.domainservice.sys.permission;

import org.anson.miniproduct.BaseTest;
import org.anson.miniproduct.domainservice.sys.permission.resource.IResourceDMService;
import org.anson.miniproduct.domainservice.sys.permission.resource.cmd.AddResourceCMD;
import org.anson.miniproduct.domainservice.sys.permission.resource.cmd.UpdResourceCMD;
import org.anson.miniproduct.domainservice.sys.permission.role.IRoleDMService;
import org.anson.miniproduct.domainservice.sys.permission.role.cmd.AddRoleCMD;
import org.anson.miniproduct.domainservice.sys.permission.role.cmd.UpdRoleCMD;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestRoleDMService extends BaseTest {
    @Test
    public void addRole() throws Exception {
        AddRoleCMD cmd = new AddRoleCMD();
        cmd.setNo("role02");
        cmd.setName("role02");
        this.service.addRole(cmd);
    }

    @Test
    public void updateRole() throws Exception {
        UpdRoleCMD cmd = new UpdRoleCMD();
        cmd.setId("role01");
        cmd.setDescription("role01 description");
        this.service.updateRole(cmd);
    }

    @Test
    public void deleteRole() throws Exception {
        this.service.deleteRole("role01");
    }

    public void relateToResource(){
        this.service.relateToResource("", null);
    }

    @Autowired
    private IRoleDMService service;
}
