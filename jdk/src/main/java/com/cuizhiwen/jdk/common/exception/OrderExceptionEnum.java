package com.cuizhiwen.jdk.common.exception;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/9 10:09
 */
public enum OrderExceptionEnum {

    /** 未知异常 */
    UNKNOWN_EXCEPTION("OE001","未知异常","warn"),
    /** 系统错误 */
    SYSTEM_ERROR("OE002","系统错误","error");


    private String errorCode;
    private String errorMsg;
    private String errorType;


    OrderExceptionEnum(String errorCode, String errorMsg, String errorType) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.errorType = errorType;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }





}
