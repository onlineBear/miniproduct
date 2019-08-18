package org.anson.miniproduct.domainservice.internale.deletedrecord;

import lombok.extern.slf4j.Slf4j;
import org.anson.miniproduct.domainservice.internal.deletedrecord.IDeletedRecordHelper;
import org.anson.miniproduct.infrastructure.tool.id.IdHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestDeletedRecordHelper {
    /*@Test
    public void testRecordDelData() throws Exception {
        DictTypePO po = new DictTypePO();
        po.setId(IdHelper.nextSnowflakeId());
        delHelper.recordDelData(po);
    }
    */

    @Autowired
    private IDeletedRecordHelper delHelper;
}
