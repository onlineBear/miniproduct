package org.anson.miniproduct.domainservice.sys.permission;

import lombok.extern.slf4j.Slf4j;
import org.anson.miniproduct.domainservice.internal.deletedrecord.IDeletedRecordHelper;
import org.anson.miniproduct.domainservice.sys.permission.resource.IResourceDMService;
import org.anson.miniproduct.domainservice.sys.permission.resource.cmd.AddResourceCMD;
import org.anson.miniproduct.framework.req.RequestHelper;
import org.anson.miniproduct.framework.req.RequestHolder;
import org.anson.miniproduct.infrastructure.tool.id.IdHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@WebAppConfiguration  // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class TestResourceDMService {
    @Test
    public void testRecordDelData() throws Exception {
        RequestHelper.setReqTimeToThreadLocal(new Date());

        AddResourceCMD cmd = new AddResourceCMD();
        cmd.setName("test01");
        cmd.setUrl("/test01");
        this.service.addResource(cmd);
    }

    @Autowired
    private IResourceDMService service;
}
