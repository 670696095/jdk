package com.cuizhiwen.jdk.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author czw
 * 数据签名
 */
@Slf4j
public final class DataSignatureUtils {
    /**
     * 私有构造器
     */
    private DataSignatureUtils() {
    }
    /**
     * 数据签名
     * @param content 需要签名的内容
     * @param keys 秘钥
     * @return String 数字签名
     * @throws UnsupportedEncodingException  异常
     * @throws NoSuchAlgorithmException  异常
     */
    public static String getDataSignature(final String content, final String keys) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        String contentStr = content + keys;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(contentStr.getBytes("UTF-8"));
        return new String(Base64.encodeBase64(md.digest()),"UTF-8");
    }
    /**
     * md5工具类
     * @param content   签名内容
     * @return digest
     */
    public static String md5(final String content) {
        try {
            String charSet = "UTF-8";
            return org.apache.commons.codec.digest.DigestUtils.md5Hex(content.getBytes(charSet));
        } catch (final Exception e) {
            log.error("DigestUtils md5 error:{}", e);
            return "";
        }
    }
    /**
     * Description:md5加密
     * @param s
     * @return
     */
    public static String getMD5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(s.getBytes("utf-8"));
            return toHex(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 转为16进制
     * @param bytes
     * @return
     */
    private static String toHex(byte[] bytes) {

        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }
}

