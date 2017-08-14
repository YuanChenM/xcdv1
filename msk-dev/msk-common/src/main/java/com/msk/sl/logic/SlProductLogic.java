package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.sl.bean.SlProductBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.SQLClientInfoException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yang_chunyan on 2016/4/8.
 */
@Service
public class SlProductLogic extends BaseLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SlProductLogic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        String SQL_ID_SAVE_PD_STATUS_HIS = "saveSlProductHis";
        //Modify for bug#1189 at 2016/07/13 by wanng_jianzhou Start.
        String SQL_ID_FIND_PD_FOR_DH = "findPdForDh";
        //Modify for bug#1189 at 2016/07/13 by wanng_jianzhou end.
    }

    /**
     * 获取产品信息
     * @param slCode 卖家编码
     * @param slPdId 卖家产品Id
     * @return
     */
    //Modify for bug#1189 at 2016/07/13 by wanng_jianzhou Start.
    public List<SlProductBean> findProduct(String slCode,String slPdId)
    {
        Map<String,Object> param = new HashMap<>();
        param.put("slCode",slCode);
        //param.put("slPdId",slPdId);
        //如果slPdId为pdCode的情况
        if (StringUtils.hasLength(slPdId) && slPdId.length() != 10)
        {
            return null;
        }
        String classesCode = slPdId.substring(0,2);
        String machiningCode = slPdId.substring(2,3);
        String breedCode = slPdId.substring(3,5);
        String featureCode = slPdId.substring(5,7);
        String weightCode = slPdId.substring(7,9);
        String gradeCode = slPdId.substring(9);//目前数据库没有产品等级字段
        param.put("classesCode",classesCode);
        param.put("machiningCode",machiningCode);
        param.put("breedCode",breedCode);
        param.put("featureCode",featureCode);
        param.put("weightCode",weightCode);
        param.put("gradeCode",gradeCode);
        return super.findList(param,SqlId.SQL_ID_FIND_PD_FOR_DH);
        //Modify for bug#1189 at 2016/07/13 by wanng_jianzhou end.
    }

    public void saveProductStatusHis(SlProductBean slProductBean)
    {
        super.save(SqlId.SQL_ID_SAVE_PD_STATUS_HIS,slProductBean);
    }
}
