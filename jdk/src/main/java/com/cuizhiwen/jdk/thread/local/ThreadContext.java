package com.cuizhiwen.jdk.thread.local;

import lombok.Data;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/21 13:43
 */
@Data
public class ThreadContext {
    private String userId;
    private Long transactionId;

    private static ThreadLocal threadLocal = new ThreadLocal() {
        @Override
        protected ThreadContext initialValue() {
            return new ThreadContext();
        }
    };
        public static ThreadContext get() {
            return (ThreadContext) threadLocal.get();
        }

    }


