package org.anson.miniproduct.framework.req;

import java.util.Date;

public class RequestHolder {
    /**
     * 请求时间
     */
    private final static ThreadLocal<Date> REQTIME = new ThreadLocal<>();

    static void addReqTime(Date time){
        REQTIME.set(time);
    }

    static void removeReqTime(){
        REQTIME.remove();
    }

    public static Date getReqTime(){
        return REQTIME.get();
    }
}
