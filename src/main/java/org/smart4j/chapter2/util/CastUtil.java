package org.smart4j.chapter2.util;


/**
 * 转换工具
 * Created by Administrator on 2017/7/7.
 */
public class CastUtil {

    /**
     * 转为String型
     * @param object
     * @return
     */
    public static String castString(Object object) {
        return CastUtil.castString(object, "");
    }

    /**
     * 转为String型(带默认值）
     * @param object
     * @return
     */
    public static String castString(Object object, String defaultValue) {
        return object!=null ? String.valueOf(object) : defaultValue;
    }

    /**
     * 转为double型
     * @param object
     * @return
     */
    public static double castDouble(Object object) {
        return castDouble(object, 0);
    }

    /**
     * 转为double型(带默认值）
     * @param object
     * @return
     */
    public static double castDouble(Object object, double defaultValue) {
        double doubleValue = defaultValue;
        if (object != null) {
            String strValue = castString(object);
            if(StringUtil.isNotEmpty(strValue)) {
                try {
                    doubleValue = Double.parseDouble(strValue);
                } catch (NumberFormatException e) {
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    /**
     * 转为long型
     * @param object
     * @return
     */
    public static long castLong(Object object) {
        return castLong(object, 0);
    }

    /**
     * 转为long型(带默认值）
     * @param object
     * @return
     */
    public static long castLong(Object object, long defaultValue) {
        long longValue = defaultValue;
        if(object != null) {
            String strValue = castString(object);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    longValue = Long.parseLong(strValue);
                } catch (NumberFormatException e) {
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }

    /**
     * 转为int型
     * @param object
     * @return
     */
    public static int castInt(Object object) {
        return castInt(object, 0);
    }

    /**
     * 转为int型(带默认值）
     * @param object
     * @return
     */
    public static int castInt(Object object, int defaultValue) {
        int intValue = defaultValue;
        if (object != null) {
            String strValue = castString(object);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    intValue = Integer.parseInt(strValue);
                } catch (NumberFormatException e) {
                    intValue = defaultValue;
                }
            }
        }
        return intValue;
    }

    /**
     * 转为boolean型
     * @param object
     * @return
     */
    public static boolean castBoolean(Object object) {
        return castBoolean(object, false);
    }

    /**
     * 转为boolean型(带默认值）
     * @param object
     * @return
     */
    public static boolean castBoolean(Object object, boolean b) {
        boolean booleanValue = b;
        if(object != null) {
            booleanValue = Boolean.parseBoolean(castString(object));
        }
        return booleanValue;
    }
}
