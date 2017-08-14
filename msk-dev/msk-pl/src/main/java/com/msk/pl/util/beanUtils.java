package com.msk.pl.util;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.beanutils.BeanUtils.copyProperties;

/**
 * Created by tao_zhifa on 2017/4/17.
 */
public class beanUtils {

    /**
     * 将E对象的集合转换成T对象的集合
     */
    public static <E, T> List<T> toList(List<E> sourceList, Class<T> targetClass) {
        List<T> targetList = new ArrayList<>();
        for (E source : sourceList) {
            T target = toBean(source, targetClass);
            targetList.add(target);
        }
        return targetList;
    }
    /**
     * 将E对象转换成T对象
     */
    public static <E, T> T toBean(E source, Class<T> targetClass) {
        T target = null;
        try {
            target = targetClass.newInstance();
            if (null != source) {
                copyProperties(target, source);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return target;
    }
}
