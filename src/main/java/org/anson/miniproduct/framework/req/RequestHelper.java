package org.anson.miniproduct.framework.req;

import java.util.Date;

public class RequestHelper {
    /**
     * 把请求时间设置到 ThreadLocal
     * @param reqTime
     */
    public static void setReqTimeToThreadLocal(Date reqTime){
        RequestHolder.addReqTime(reqTime);
    }

    /**
     * 把请求时间从 ThreadLocal 移除
     */
    public static void removeReqTimeFromThreadLocal(){
        RequestHolder.removeReqTime();
    }
}
