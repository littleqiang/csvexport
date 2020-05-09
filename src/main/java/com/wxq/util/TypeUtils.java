package com.wxq.util;

import net.sf.cglib.beans.BeanMap;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: wangxuqiang
 * @Date: Created in 2019/1/30
 * @Version: 1.0
 */
public class TypeUtils {

    public static String formatDate(Date cellValue, String format) {
        SimpleDateFormat simpleDateFormat;
        if(!StringUtils.isEmpty(format)) {
            simpleDateFormat = new SimpleDateFormat(format);
        }else {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        return simpleDateFormat.format(cellValue);
    }

    /**
     * 获取对应字段的值
     * @param beanMap
     * @param fieldName
     * @param format
     * @return
     */
    public static String getFieldStringValue(BeanMap beanMap, String fieldName, String format) {
        String cellValue = null;
        Object value = beanMap.get(fieldName);
        if (value != null) {
            if (value instanceof Date) {
                cellValue = TypeUtils.formatDate((Date)value, format);
            } else {
                cellValue = value.toString();
            }
        }
        return cellValue;
    }

    /**
     * 将字段值转换为字符串
     *
     * @param o
     * @return
     */
    public static String formatFieldStringValue(Object o, String format) {

        String value = null;

        if (!ObjectUtils.isEmpty(o)) {

            if (o instanceof Date) {

                value = TypeUtils.formatDate((Date) o, format);

            } else {

                value = o.toString();

            }
        }

        return value;
    }
}
