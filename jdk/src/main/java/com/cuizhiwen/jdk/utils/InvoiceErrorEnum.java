
package com.cuizhiwen.jdk.utils;

import lombok.Getter;

/**
 * @author songbin
 * @version Id: InvoiceErrorCodeEnum.java, v 0.1 2018/5/29 16:20 Lenovo Exp $$
 */
@Getter
public enum InvoiceErrorEnum {
    SUCCESS(200, "成功"),
    FAILED(400, "失败"),
    EXCEPTION(4001, "系统异常"),
    WAYBILL_EXCEPTION(4999, "开票申请异常,请检查开票信息"),
    TB_FAILED(4002, "百望云返回失败"),
    EMPTY_DATA(4003, "没有找到订单"),
    PARAM_ERROR(4004, "参数错误"),
    PARAM_ERROR_BILL_COUNT(4004, "最大支持20个运单的查询"),
    CMD_INVALID(4005, "请求命令不存在"),
    CONFIG_INVALID(4006, "内部配置错误"),
    INSTANCE_SERVICE_EXCEPTION(4007, "服务实例化异常"),
    ENCRYPT_EXCEPTION(4008, "内部加密异常"),
    DB_EXCEPTION(4009, "数据库操作异常"),
    SIGN_VERIFY_FAILED(4010, "签名校验失败"),
    IDEMPOTENT_VALID(4011, "重复请求"),
    BILL_REOPEN(4012, "运单重复开票"),
    NOTEXIST_TAXSUBJECT(4013, "税务主体不存在"),
    EXIST_TAXSUBJECT(4020, "税务主体已存在"),
    EXIST_TAXPAYERNAME(4014, "税务主体-销售方名称已存在，请在编辑页面进行更新操作"),
    EXIST_TAXPAYERCODE(4015, "税务主体-销售方纳税识别号已存在，请在编辑页面进行更新操作"),
    EXIST_BWOFFICE(4016, "该税务主体已配置开票网点，不能删除"),
    NOTEXIST_BUSIOFFICE(4017, "网点信息不存在"),
    SYNCERROR_BUSIOFFICE(4018, "网点信息同步异常"),
    NOTEXIST_INVOICEINFOS(4019, "运单开票信息不存在"),
    NOTEXIST_CUSTOMER(4020,"客户信息不存在"),
    NULL_CUSTOMERCODE(4021,"客户编码不能为空"),
    LIMIT_BILL(4022,"开票金额超出限额"),
    LIMIT_REOPEN(4023,"没有开票额度了"),
	ERROR_INVOICESTATUS(4024,"开票状态不是成功"),
	LIMIT_TIME(4025,"开票时间不够30天"),
    BILL_EXIST(4026,"此账单已存在"),
    NO_SELLER_INFO(4027,"网点没有匹配的销售方信息"),
    SING_BILL_LIMIT(4028,"获取百望单笔限额失败"),
    DATE_LIMIT(4029,"某账单已过期"),
    NO_RED(4030,"该条信息不符合红冲条件"),
    NO_INVALID(4031,"该条信息不符合作废条件"),
    COUNTS_LIMIT(4032,"一次最多可选20条账单"),
    Length_LIMIT(4033,"超出长度限制"),
    GOODS_LIMIT(4034,"请填写商品名称"),
    OPEN_AMT(4035,"开票金额与运单总金额不符"),
    OPEN_WAY_BILL_NO(4036,"申请开票的运单号不存在"),
    WAY_BILL_NO(4037,"非承诺达运单号"),
    TAKEING_TIME_EMPTY(4038,"寄件时间为空"),
    TAKEING_TIME_ERR(4039,"寄件时间大于60天"),
    WAY_BILL_NO_OK(4040, "可以开票"),
    OPEN_AMT_ZERO(4041, "运单金额为0"),
    TAX_NO(4042, "纳税人编号不能为空"),
    BANK_NAME(4043, "开户银行名称不能为空"),
    BANK_NO(4044, "开户银行账号不能为空"),
    COMPANY_ADDRESS(4045, "注册地址不能为空"),
    COMPANY_PHONE(4046,"注册电话不能为空"),
    OPEN_AMT_EMPTY(4047, "该运单金额为0"),
    INVOICE_TYPE(4048, "发票类型必须为：0:个人，1:单位"),
    WAY_BILL_NO_EXIT(4049, "申请开票的运单号有重复"),
    LIMIT_BAIWANG(4050,"调用百旺限额失败"),
    RE_REDINFO_NO(4051,"请输入正确的红冲编号"),
    PART_FAILED(4052,"部分失败"),
    EXIST_INFO(4053,"该主服务器编码已存在"),
    EXIST_CODE(4054,"该备用服务器编码已存在"),
    EQUAL_CODE(4055,"主服务器和备用服务器不能相同"),
    ERROR_MESSAGE(4056,"同一账单不能被多个人操作");

//    error_00	String
//    可以开票
//
//    error_01	String
//    网点非直营
//
//    error_02	String
//    为月结用户
//
//    error_03	String
//    该单号不支持开票
//
//    error_04	String
//    取件超过30天
//
//    error_05	String
//    网点未取件
//
//    error_06	String
//    开票中
//
//    error_07	String
//    已开票
//
//    error_08	String
//    开票

    Integer code;
    String msg;

    InvoiceErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static InvoiceErrorEnum explain(Integer code) {
        for (InvoiceErrorEnum errorCodeEnum : InvoiceErrorEnum.values()) {
            if (errorCodeEnum.getCode().equals(code)) {
                return errorCodeEnum;
            }
        }
        return null;
    }
}