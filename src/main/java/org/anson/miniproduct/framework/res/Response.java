package org.anson.miniproduct.framework.res;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class Response {
    private Integer code;
    private Object data;
    private String msg;
    private String debugMsg;
    /**
     * 请求时间
     */
    private Date reqTime;

    public Response(HttpStatus httpStatus, Object data, String msg, String debugMsg, Date reqTime){
        this.code = httpStatus.value();
        this.data = data;
        this.msg = msg;
        this.debugMsg = debugMsg;
        this.reqTime = reqTime;
    }
}
