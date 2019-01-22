package com.cuizhiwen.jdk.common.utils;

import lombok.Data;

/**
 * @author 01418061(cuizhiwen)
 * @Description: 分页参数
 * @date 2019/1/3 10:03
 */
@Data
public class BaseEntity {
    private Integer pageNum = 1;

    private Integer pageSize = 10;

}
