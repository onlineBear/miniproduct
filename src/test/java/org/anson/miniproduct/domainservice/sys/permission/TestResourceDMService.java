package org.anson.miniproduct.domainservice.sys.permission;

import org.anson.miniproduct.BaseTest;
import org.anson.miniproduct.domainservice.sys.permission.resource.IResourceDMService;
import org.anson.miniproduct.domainservice.sys.permission.resource.cmd.AddResourceCMD;
import org.anson.miniproduct.framework.req.RequestHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class TestResourceDMService extends BaseTest {
    @Test
    public void testRecordDelData() throws Exception {
        AddResourceCMD cmd = new AddResourceCMD();
        cmd.setName("test02");
        cmd.setUrl("/test02");
        this.service.addResource(cmd);
    }

    @Autowired
    private IResourceDMService service;
}
