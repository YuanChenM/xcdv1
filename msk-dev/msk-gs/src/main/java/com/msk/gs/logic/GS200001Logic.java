package com.msk.gs.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.StringConst;
import com.msk.gs.bean.GS200001Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * GYH on 2016/6/22.
 */
@Service
public class GS200001Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(GS200001Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SQL Map 中SQL ID定义
     *
     * @author yuan_chen
     */
    interface SqlId {
        static final String SQL_ID_FIND_RESULT = "findResult";
    }

    /**
     * 执行sql查询
     * @param param
     * @return 结果
     */
    @Transactional(readOnly = true)
    public  List<Map<String,String>> findResult(GS200001Param param) {
        BaseParam param1 = new BaseParam();
        param1.setFilter("sqlInfo", param.getSqlInfo());
        List<Map<String,String>> fields = super.getBaseDao().getSqlSession().selectList(this.getNamespaceId() + StringConst.DOT + SqlId.SQL_ID_FIND_RESULT, param1);
        List<Map<String,String>> fields2=new ArrayList<Map<String,String>>(fields);
        Collections.sort(fields, new Comparator<Map<String, String>>() {
            public int compare(Map<String, String> o1, Map<String, String> o2) {

                int map1value =  o1.size();
                int map2value =  o2.size();

                return map2value - map1value;
            }
        });
        if(!CollectionUtils.isEmpty(fields)&&fields.size()>0){
            fields2.add(0,fields.get(0));
        }
        return fields2;
    }

    ;

    /**
     * 截取sql中查询的字段
     *
     * @param param sql
     * @return 字段集合
     */
    public String[] returnField(GS200001Param param) {
        List<String> fieldList = new ArrayList<String>();
        String sqlInfo = param.getSqlInfo().replace("\n","").replace("\r","");
        //截取查询字段
        int index=sqlInfo.indexOf("from");
        if(index==-1){
            index=sqlInfo.indexOf("FROM");
        }
        String fieldStr = sqlInfo.substring(sqlInfo.indexOf("select") + 7,index);
        //根据逗号进行字符串分隔
        String[] fieldArray = fieldStr.split(",");
        //去掉截取字段的空格
        for (int i = 0; i < fieldArray.length; i++) {
            fieldArray[i] = fieldArray[i].trim();
        }
        return fieldArray;
    }

}
