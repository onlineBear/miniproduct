package org.anson.miniproduct;

import lombok.extern.slf4j.Slf4j;
import org.anson.miniproduct.framework.req.RequestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
// 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
@Slf4j
public class BaseTest {
    @Before
    public void init() {
        log.info("init junit");
        // 设置时间
        RequestHelper.setReqTimeToThreadLocal(new Date());
    }

    @After
    public void after() {
        log.info("after junit");
    }
}
