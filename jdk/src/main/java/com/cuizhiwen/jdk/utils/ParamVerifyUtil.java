package com.cuizhiwen.jdk.utils;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import java.util.List;

public class ParamVerifyUtil {
    private static Validator validator = new Validator();

    /**
     * 1、请求参数非空、格式验证，请求对象
     *
     * @param object 请求校验参数
     */
    public static void validateObject(Object object) throws YtoInvoiceException {
        List<ConstraintViolation> list = validator.validate(object);
        if (null != list && !list.isEmpty()) {
            throw new YtoInvoiceException(InvoiceErrorEnum.PARAM_ERROR, list.get(0).getMessage());
        }
    }
}
