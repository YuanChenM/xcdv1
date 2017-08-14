package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.file.excel.ExcelWrite;
import com.msk.core.file.excel.JxlsExcelWrite;
import com.msk.ds.bean.SC182101Bean;
import com.msk.ds.bean.SC182102Param;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DS174101Logic.
 *
 * @author pxg
 * @version 1.0
 **/
@Service
public class SC182101Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SC182101Logic.class);
    /**
     * SQL Map 中SQL ID定义
     *
     * @author pxg
     */
    private interface SqlId {
        String SQL_ID_FIND_MONTH = "findMonth";
        String SQL_ID_FIND_QTY = "findQtyList";
        String SQL_ID_FIND_ONE ="findOne";
        /** 应上海需求 #1791添加页面合计 modify by renyi on 2016/8/10 start */
        String SQL_ID_GET_CURRENT_INFO = "getCurrentInfo";
        /** 应上海需求 #1791添加页面合计 modify by renyi on 2016/8/10 end */
    }
    /**
     * 根据供应商Code获得月度
     * @param supCode 供应商编码
     * @return 月度信息
     */
    @Transactional
    public List<String> findMonth(String supCode){
        BaseParam param = new BaseParam();
        param.setFilter("supCode",supCode);
        return super.getBaseDao().getSqlSession().selectList(SqlId.SQL_ID_FIND_MONTH);
    }

    @Transactional
    public List<SC182101Bean> findQtyList(List<SC182101Bean> list) {
        Map<String,Object> param = new HashMap<>();
        param.put("list",list);
        return super.findList(param,SqlId.SQL_ID_FIND_QTY);
    }

    @Transactional
    public SC182101Bean findPdfInfo(BaseParam param){
        return super.findOne(param);
    }
    /** 修改sql modify by likai on 2016/8/16 start */
    @Transactional(readOnly = true)
    public SC182101Bean getCurrentInfo(BasePageParam pageParam) {
        return super.findOne(SqlId.SQL_ID_GET_CURRENT_INFO,pageParam);
    }
    /** 修改sql modify by likai on 2016/8/16 end */
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /** #1931,create by likai on 2016/8/17 start */
    @Transactional(readOnly = true)
    public void exportDeliveryData(OutputStream outputStream, BasePageParam pageParam) {
        InputStream inputStream = SC182101Logic.class.getResourceAsStream("/template/reportTemp182101.xlsx");
        ExcelWrite excelWrite = new JxlsExcelWrite(inputStream, new BufferedOutputStream(outputStream));
        pageParam.setPaging(false);
        //分页数据
        List<SC182101Bean> resultList = super.findPageList(pageParam,SC182101Bean.class);
        //总合计计算
        SC182101Bean totalListBean = getCurrentInfo(pageParam);
        // 初始化合计数据
        BigDecimal totalSendPlanNum = BigDecimal.ZERO;
        BigDecimal totalSendActualNum = BigDecimal.ZERO;
        BigDecimal totalReceiveNum = BigDecimal.ZERO;
        BigDecimal totalSendPlanQty = BigDecimal.ZERO;
        BigDecimal totalSendActualQty = BigDecimal.ZERO;
        BigDecimal totalRecriveQty = BigDecimal.ZERO;
        BigDecimal totalDifferNum = BigDecimal.ZERO;
        BigDecimal totalDifferQty = BigDecimal.ZERO;
        if (CollectionUtils.isNotEmpty(resultList) && resultList.size() > NumberConst.IntDef.INT_ZERO) {
            //所有数据合计
            if (null != totalListBean) {
                totalSendPlanNum = totalListBean.getCurrentSendPlanNum();
                totalSendActualNum = totalListBean.getCurrentSendActualNum();
                totalReceiveNum = totalListBean.getCurrentReceiveNum();
                totalSendPlanQty = totalListBean.getCurrentSendPlanQty();
                totalSendActualQty =totalListBean.getCurrentSendActualQty();
                totalRecriveQty = totalListBean.getCurrentRecriveQty();
                totalDifferNum = totalListBean.getCurrentDifferNum();
                totalDifferQty = totalListBean.getCurrentDifferQty();
            }
        }

        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("list",resultList);
        paramMap.put("totalSendPlanNum",totalSendPlanNum);
        paramMap.put("totalSendActualNum",totalSendActualNum);
        paramMap.put("totalReceiveNum",totalReceiveNum);
        paramMap.put("totalSendPlanQty",totalSendPlanQty);
        paramMap.put("totalSendActualQty",totalSendActualQty);
        paramMap.put("totalRecriveQty",totalRecriveQty);
        paramMap.put("totalDifferNum",totalDifferNum);
        paramMap.put("totalDifferQty",totalDifferQty);
        excelWrite.excelWrite(paramMap);

    }
    /** #1931,create by likai on 2016/8/17 end */

}
