package com.msk.batch.wq;

import com.msk.batch.base.BaseBatch;
import com.msk.batch.wq.bean.*;
import com.msk.batch.wq.logic.BWQ201701Logic;
import com.msk.batch.wq.logic.BWQ201702Logic;
import com.msk.batch.wq.logic.BWQ201704Logic;
import com.msk.batch.wq.util.WqHttpClient;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DateTimeUtil;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by air on 2017/1/23.
 */

@Component("BWQ201704")
public class BWQ201704Batch extends BaseBatch{


    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BWQ201701Logic.class);
    //插入数据成功统计
    private Integer insertSuccessCount=0;
    //更新成功数据统计
    private Integer updateSuccessCount=0;
    //插入数据失败统计
    private Integer insertErrorCount=0;
    //更新数据失败统计
    private Integer updateErrorCount=0;


    /** 注入BWQ201701Logic */
    @Autowired
    private BWQ201704Logic bwq201704Logic;


    /**
     * 创建Param
     *
     * @param args String[]
     * @return BWQ201704Param
     */
    @Override
    public BaseParam createParam(String[] args) {
        logger.debug("BWQ201704Batch创建param");

        BWQ201704Param param = new BWQ201704Param();

        Date currentDate = DateTimeUtil.getCustomerDate();
        param.setCurrentDate(currentDate);
        return param;
    }


    /**
     * 业务处理
     *
     * @param param param
     */
    @Override
    public void doOperate(BaseParam param) {
        logger.debug("BWQ201704Batch的doOperate");

        //String url = "employee/v1/queryCustomer";
       // String msgId = "BWQ201701";

        //联合查询sl_bs_account表和sl_bs_basic_info表
        List<BWQ201704Bean> bwq201704BeanList = this.bwq201704Logic.queryTwoBSTable();
        for(BWQ201704Bean bwq201704Bean:bwq201704BeanList){
            String msCode = bwq201704Bean.getSlCodeDis();
            String msId = bwq201704Bean.getSlCode();
            String msName = bwq201704Bean.getSlShowName();

         //拿买手名称，去wq_employee表中查询emp_name是否有同名的员工
            BWQ201704Bean wqBean =  this.bwq201704Logic.checkNameExist(msName);

            if(wqBean!=null){
                //有同名员工，获取wq_employee表中对应记录的ID和EMP_ID，调用外勤365的员工修改接口，更新对应买手的扩展字段 “买手ID”和“买手编码”
                String id = wqBean.getId();
                String empId = wqBean.getEmpId();

                BWQ201702Result bwq201702Result = new BWQ201702Result();
                this.bwq201704Logic.setExts(bwq201702Result,msCode,msId);

                if(empId==null || empId==""){
                    //更新参数只包括id
                    bwq201702Result.setId(id);
                }else{
                    //更新参数只包括emp_id
                    bwq201702Result.setEmpId(empId);
                }

                String saveUrl="employee/v2/modifyEmployee";
                String msgId = "BWQ201704";
                WqResponse<?> wqResponseData= WqHttpClient.httpPost(saveUrl, bwq201702Result, msgId,null);
                if(null!=wqResponseData){
                    if(wqResponseData.getReturnCode().equals("0")){
                        logger.info(msName+"：更新外勤365员工成功");
                        updateSuccessCount++;
                    }else{
                        logger.error(msName+"：更新外勤365员工失败");
                        updateErrorCount++;
                    }
                }
            }
        }
        logger.info("添加成功："+insertSuccessCount);
        logger.error("添加失败：" + insertErrorCount);
        logger.info("更新成功："+updateSuccessCount);
        logger.error("更新失败：" + updateErrorCount);
    }

}
