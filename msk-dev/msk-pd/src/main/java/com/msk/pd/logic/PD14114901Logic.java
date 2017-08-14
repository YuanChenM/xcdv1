package com.msk.pd.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.pd.bean.PDtncMarkeyBean;
import com.msk.pd.bean.PDtncProviderBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * PD14114901Logic
 *
 * @author xhy
 */

@Service
public class PD14114901Logic extends BaseLogic {

    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    /**
     * sqlName
     */
    interface SqlId {
        static final String SQL_ID_FIND_COUNT = "findCount";
        static final String SQL_ID_FIND_List_TNC_MARKEY = "findListTncMarkey"; //获取市场需求标准列表
        static final String SQL_ID_FIND_List_TNC_MARKEY_JIN = "findListTncMarkeyJin"; //获取供应商需求标准列表
    }
    /**
     * 新增修改操作
     *
     * @param bean
     * @param raiseDateString
     * @param fixDateString
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public List<PDtncMarkeyBean> saveAndEdit(PDtncMarkeyBean bean, String raiseDateString, String fixDateString,BaseParam param) {

        param.setFilter("standardId",bean.getStandardId().toString());
        param.setFilter("tncStdItemId",bean.getTncStdItemId());
        param.setFilter("discussStatus", String.valueOf(NumberConst.IntDef.INT_TWO));
        if (StringUtils.isNotBlank(raiseDateString)) {
            /*新增操作*/
            Date nedate = DateTimeUtil.parseDate(raiseDateString, DateTimeUtil.FORMAT_DATE_YYYYMMDD);
            bean.setRaiseDate(nedate);
            bean.setKeyId(commonLogic.maxId("PD_TNC_STD_DISCUSS_MARKET", "KEY_ID"));
            bean.setDiscussStatus(NumberConst.IntDef.INT_ZERO);//未禁止,为结案
            bean.setCrtId(param.getCrtId());
            bean.setUpdId(param.getUpdId());

            //查询该条数据是否存在
            param.setFilter("tncStdVal",bean.getTncStdVal());
            int exist = super.getCount(SqlId.SQL_ID_FIND_COUNT,param);
            if (exist > NumberConst.IntDef.INT_ZERO) throw new BusinessException("该条数据已经存在,请修改后添加!");
            int saveYes = super.save(bean);
            if (saveYes <= NumberConst.IntDef.INT_ZERO) throw new BusinessException("市场需求标准新增失败!");
            return this.queryListMar(param,bean);

        }
        if (StringUtils.isNotBlank(fixDateString)) {
            bean.setFixDate(DateTimeUtil.parseDate(fixDateString, DateTimeUtil.FORMAT_DATE_YYYYMMDD));
            bean.setDiscussStatus(NumberConst.IntDef.INT_ONE);//结案
            int modifoyJan = super.modify(bean);
            if (modifoyJan <= NumberConst.IntDef.INT_ZERO) throw new BusinessException("设置市场需求结案日失败!");
           return this.queryListMar(param,bean);

        }
        return null;
    }

    /**
     * 动态加载页面
     * @param bean
     * @return
     */
    @Transactional(readOnly = true)
   public List<PDtncMarkeyBean> queryListMar(BaseParam param,PDtncMarkeyBean bean) {

        List<PDtncMarkeyBean> list=  super.findList(SqlId.SQL_ID_FIND_List_TNC_MARKEY,param);
        if(list!=null){
            for(PDtncMarkeyBean bean1:list){
                bean1.setGetDivName(bean.getGetDivName());
                bean1.setFixDateShow(DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD, bean1.getFixDate()));
                bean1.setRaiseDateShow(DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD, bean1.getRaiseDate()));
            }
            return list;
        }
        return null;
    }

    /**
     * 动态加载页面
     * @param bean
     * @return
     */
    @Transactional(readOnly = true)
    public List<PDtncMarkeyBean> queryListMarJin(BaseParam param,PDtncMarkeyBean bean) {

        List<PDtncMarkeyBean> list=  super.findList(SqlId.SQL_ID_FIND_List_TNC_MARKEY_JIN,param);
        if(list!=null){
            for(PDtncMarkeyBean bean1:list){
                bean1.setGetDivJin(bean.getGetDivJin());
                bean1.setFixDateShow(DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD, bean1.getFixDate()));
            }
            return list;
        }
        return null;
    }
}
