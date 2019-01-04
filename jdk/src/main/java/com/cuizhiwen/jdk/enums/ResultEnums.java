package com.cuizhiwen.jdk.enums;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/4 14:18
 */
public enum ResultEnums {
    /**
     * 枚举类
     */


    /**
     * 未知系统异常
     */
    ERROR_CODE_EP9999("EP9999", "未知系统异常"),
    /**
     * 成功返回
     */
    SUCCESS_CODE_200("200", "请求成功！"),
    /**
     * 数据库异常
     */
    ERROR_CODE_EP3001("EP3001", "数据库异常！"),
    /**
     * 未查到数据！
     */
    ERROR_CODE_EP3002("EP3002", "未查到数据！"),
    /**
     * 新增失败！
     */
    ERROR_CODE_EP3003("EP3003", "ES更新失败！");


    private String status;
    private String message;

    ResultEnums(final String status, final String messgae) {
        this.status = status;
        this.message = messgae;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
