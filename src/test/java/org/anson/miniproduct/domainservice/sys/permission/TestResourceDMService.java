package org.anson.miniproduct.domainservice.sys.permission;

import org.anson.miniproduct.BaseTest;
import org.anson.miniproduct.domainservice.sys.permission.resource.IResourceDMService;
import org.anson.miniproduct.domainservice.sys.permission.resource.cmd.AddResourceCMD;
import org.anson.miniproduct.domainservice.sys.permission.resource.cmd.UpdResourceCMD;
import org.anson.miniproduct.framework.req.RequestHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class TestResourceDMService extends BaseTest {
    @Test
    public void addResource() throws Exception {
        AddResourceCMD cmd = new AddResourceCMD();
        cmd.setName("test02");
        cmd.setUrl("/test02");
        this.service.addResource(cmd);
    }

    @Test
    public void updateResource() throws Exception {
        UpdResourceCMD cmd = new UpdResourceCMD();
        cmd.setId("1163074880153980928");
        cmd.setDescription("test01");
        this.service.updateResource(cmd);
    }

    @Test
    public void deleteResource() throws Exception {
        this.service.deleteResource("1163076061811052544");
    }

    @Autowired
    private IResourceDMService service;
}
