package com.msk.core.utils;

import com.msk.core.consts.NumberConst;
import com.msk.core.exception.SystemException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * JsonUtils
 *
 * @author jiang_nan
 * @version 1.0
 **/
public final class JsonUtils {

    private static Object createEntity(Object object){
        Object entity = null;
        try {
            entity = object.getClass().newInstance();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return entity;
    }

    public static List<Object> getCollection(Object object, JSONArray jsonArray) {
        List<Object> resultList = new ArrayList<Object>();
        if (jsonArray != null && jsonArray.length() > NumberConst.IntDef.INT_ZERO) {
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                Object entity = createEntity(object);
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Iterator iterator = jsonObject.keys();
                while (iterator.hasNext()) {
                    String key = (String) iterator.next();
                    Object jsonData = jsonObject.get(key);
                    if (jsonData instanceof JSONArray) {

                    }

                }

                resultList.add(entity);
            }

        }
        return resultList;
    }

}
