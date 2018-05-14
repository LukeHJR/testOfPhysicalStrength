package com.example.test_physical_strength.util;


import com.example.test_physical_strength.constant.Errors;
import com.example.test_physical_strength.exception.BusinessException;

/**
 * 异常工具类
 *
 */
public class ExceptionUtil {

    public static void throwException(int code, String codeLabel) {
        BusinessException e = new BusinessException(code, codeLabel, codeLabel);
        throw e;
    }

    public static void throwException(Errors error) {
        BusinessException e = new BusinessException(error, error.label);
        throw e;
    }

    public static void throwException(Errors error, String msg) {
        BusinessException e = new BusinessException(error, msg);
        throw e;
    }

}
