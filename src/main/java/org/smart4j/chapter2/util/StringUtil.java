package org.smart4j.chapter2.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 * Created by Administrator on 2017/7/7.
 */
public final class StringUtil {

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if(str == null) {
            return true;
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断是否非空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
