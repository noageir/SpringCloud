package com.micro.system.util;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

/**
 * @author Noageir
 * Date:2018-05-06 22:20
 * Project:com.spring.cloud
 * Package:com.micro.system.eureka
 */
public class RandomUtil {
    public static final String AGENT = "A";
    public static final String SYSTEM = "S";
    private static final String ALL_CHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBER_CHAR = "0123456789";
    private static final String SEPARATOR = "_";

    private RandomUtil() {
    }


    /**
     * 返回一个定长的随机字符串(只包含数字)
     */
    public static String generateNumber(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            sb.append(NUMBER_CHAR.charAt(random.nextInt(NUMBER_CHAR.length())));
        }
        return sb.toString();
    }

    /**
     * 返回一个定长的随机纯字母字符串(只包含大小写字母)
     */
    public static String generateString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            sb.append(ALL_CHAR.charAt(random.nextInt(ALL_CHAR.length())));
        }
        return sb.toString();
    }

    /**
     * 返回一个全球唯一字符串
     */
    public static String generateUniqueString(String prefix) {
        return prefix + SEPARATOR + DateUtil.generateCurrentTimeMillis() + SEPARATOR + UUID.randomUUID().toString().replaceAll("-", SEPARATOR);
    }

    /**
     * 生成一个Int类型的随机数
     */
    public static Integer generateSafeRandomNum(int maxNum) {
        SecureRandom secureRandom = new SecureRandom();
        int num;
        if (maxNum == 0) {
            num = secureRandom.nextInt();
        } else {
            num = secureRandom.nextInt(maxNum);
        }
        if (num == 0) {
            generateSafeRandomNum(maxNum);
        }
        return num;
    }
}
