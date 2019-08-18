package org.anson.miniproduct.constrant.enums;

/**
 * 客户端
 */
public enum ClientEnum {

    /**
     * pc 端
     */
    PC("client-pc");

    private String key;

    private ClientEnum(String key){
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }
}
