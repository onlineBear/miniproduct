package org.anson.miniproduct.domainservice.internal.deletedrecord;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.anson.miniproduct.domainservice.base.BasePO;

public interface IDeletedRecordHelper {
    <P extends BasePO> String recordDelData(P po) throws JsonProcessingException;
}