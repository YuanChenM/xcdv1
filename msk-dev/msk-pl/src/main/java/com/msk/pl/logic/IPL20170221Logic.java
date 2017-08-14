package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.pl.bean.IPL20170221RsParam;
import com.msk.pl.bean.IPL20170221RsResult;
import com.msk.pl.bean.IPL20170221RsResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gyh on 2017/2/8.
 * 合伙人计费查询
 */
@Service
public class IPL20170221Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 合伙人计费查询
     * @param param 参数
     * @return 结果
     */
    public IPL20170221RsResult partnerFeeList(IPL20170221RsParam param){
        IPL20170221RsResult rsResult=new IPL20170221RsResult();
        List<IPL20170221RsResultBean> partnerFeeList=new ArrayList<IPL20170221RsResultBean>();
        rsResult.setTotalCount(this.getPageCount(param));
        rsResult.setPageNo(param.getPageNo());
        if (rsResult.getTotalCount() != NumberConst.IntDef.INT_ZERO) {
            partnerFeeList=this.findList(param);
            rsResult.setTotalPage(rsResult.getTotalCount(), param.getPageCount());
        }
        rsResult.setPartnerFeeList(partnerFeeList);
        return rsResult;
    }
}
