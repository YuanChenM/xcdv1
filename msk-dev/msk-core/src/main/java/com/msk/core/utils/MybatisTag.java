package com.msk.core.utils;

import java.util.List;

/**
 * 
 * Mybatis Tag.
 * 
 * @author jiang_nan
 */
public class MybatisTag {
    /**
     * 是空
     * 
     * 
     * @param data String类型
     * @return true or false
     */
    public static boolean isEmpty(String data) {
        return StringUtil.isEmpty(data);
    }

    /**
     * 非空判断
     * 
     * 
     * @param value String
     * @return true or false
     */
    public static boolean notEmpty(String value) {
        return !StringUtil.isEmpty(value);
    }

    /**
     * 字符串对象比较
     * 
     * @param obj1 字符串1
     * @param obj2 字符串2
     * @return true or false
     */
    public static boolean equals(String obj1, String obj2) {
        if (obj1 == null && obj2 == null) {
            return true;
        }
        String _obj1 = StringUtil.trim(obj1);
        String _obj2 = StringUtil.trim(obj2);
        return _obj1.equals(_obj2);
    }

    /**
     * 字符串对象比较
     * 
     * @param obj1 字符串1
     * @param obj2 字符串2
     * @return true or false
     */
    public static boolean notEquals(String obj1, String obj2) {
        return !equals(obj1, obj2);
    }

    /**
     * 是空
     * 
     * 
     * @param list list数据集
     * @return true or false
     */
    public static boolean isListEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    /**
     * 判断List是否为空
     * 
     * @param list list数据集
     * @return true or false
     */
    public static boolean notListEmpty(List<?> list) {
        return list != null && !list.isEmpty();
    }

    /**
     * 是空
     * 
     * 
     * @param objects 数组对象
     * @return true or false
     */
    public static boolean isArrayEmpty(Object[] objects) {
        return objects == null || objects.length <= 0;
    }

    /**
     * 判断数组是否为空
     * 
     * @param objects 数组对象
     * @return true or false
     */
    public static boolean notArrayEmpty(Object[] objects) {
        return objects != null && objects.length > 0;
    }
    
    /**
     * 判断数组中是否包含某Object
     * 
     * @param objects 数组对象
     * @param match 匹配对象
     * @return true or false
     */
    public static boolean isArrayContains(Object[] objects, Object match) {
        boolean ret = false;
        if(objects != null && objects.length > 0){
            for(Object str : objects){
                if(str.equals(match)){
                    ret = true;
                    break;
                }
            }
        }
        return ret;
    }

}
