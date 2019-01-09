package com.cuizhiwen.jdk.common.exception;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/9 10:10
 */
public class OrderException extends RuntimeException {
    /**
     * 自定义异常类
     */
    private static final long serialVersionUID = 6958499248468627021L;


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /** 错误码 */
    private String errorCode;


    public OrderException(String errorCode, String errorMsg){
        super(errorMsg);
        this.errorCode = errorCode;
    }
    public OrderException(OrderExceptionEnum orderExceptionEnum){
        super(orderExceptionEnum.getErrorMsg());
        this.errorCode = orderExceptionEnum.getErrorCode();
    }

    public OrderException(String errorCode, String errorMsg,Throwable throwable){
        super(errorMsg,throwable);
        this.errorCode = errorCode;
    }
    public OrderException(OrderExceptionEnum orderExceptionEnum,Throwable throwable){
        super(orderExceptionEnum.getErrorMsg(),throwable);
        this.errorCode = orderExceptionEnum.getErrorCode();
    }

    public static void main(String[] args) {
        try{
            int i = 1/0;
        }catch (OrderException e){
            e.printStackTrace();
            throw new OrderException(OrderExceptionEnum.SYSTEM_ERROR,e);
        }
    }
}

