
package com.cuizhiwen.jdk.utils;

import lombok.Data;


@Data
public class YtoInvoiceException extends RuntimeException {
    InvoiceErrorEnum errorCode;
    String extraMsg;
    Throwable t;
    Object data;

    /**
     * 错误信息模板
     */
    private final static String MSG_TEMPLATE = "错误码:%d, 描述:%s, 异常信息:%s";

    public YtoInvoiceException(InvoiceErrorEnum errorCode, String extraMsg, Throwable t){
        super(getMessage(errorCode, extraMsg), t);
        this.errorCode = errorCode;
        this.extraMsg = extraMsg;
        this.t = t;
    }
    public YtoInvoiceException(InvoiceErrorEnum errorCode, String extraMsg){
        super(getMessage(errorCode, extraMsg), null);
        this.errorCode = errorCode;
        this.extraMsg = extraMsg;
    }


    public YtoInvoiceException(InvoiceErrorEnum errorCode, String extraMsg, Object data){
        super(getMessage(errorCode, extraMsg), null);
        this.errorCode = errorCode;
        this.extraMsg = extraMsg;
        this.data = data;
    }


    /**
     * 根据错误信息模板返回错误信息
     * @param errorCode
     * @param extraMessage
     * @return
     */
    private static String getMessage(InvoiceErrorEnum errorCode, String extraMessage) {
        extraMessage = (null != extraMessage) ? extraMessage : "";
        try{
            return String.format(MSG_TEMPLATE, errorCode.getCode(), errorCode.getMsg(), extraMessage);
        }catch (Exception e){
            return "";
        }
    }

}