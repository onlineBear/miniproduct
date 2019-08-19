package org.anson.miniproduct.domainservice.internal.deletedrecord;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.anson.miniproduct.domainservice.base.BasePO;

import java.util.Collection;

public interface IDeletedRecordHelper {
    <P extends BasePO> String record(P po) throws JsonProcessingException;
    <P extends BasePO> void batchRecord(Collection<P> po) throws JsonProcessingException;
}