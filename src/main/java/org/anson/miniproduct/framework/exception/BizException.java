package org.anson.miniproduct.framework.exception;

public class BizException extends RuntimeException{
    public BizException(){}

    public BizException(String message){
        super(message);
    }
}
