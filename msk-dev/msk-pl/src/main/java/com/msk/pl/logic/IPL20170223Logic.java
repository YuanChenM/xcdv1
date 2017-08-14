package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.pl.bean.IPL20170223RsParam;
import com.msk.pl.bean.IPL20170223RsResult;
import com.msk.pl.bean.IPL20170223RsResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gyh on 2017/2/9.
 * 合伙人计费查询
 */
@Service
public class IPL20170223Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 合伙人任务完成统计
     *
     * @param param 参数
     * @return 结果
     */
    public IPL20170223RsResult partnerTaskPercent(IPL20170223RsParam param) {
        IPL20170223RsResult rsResult = new IPL20170223RsResult();
        List<IPL20170223RsResultBean> bsTaskList = new ArrayList<IPL20170223RsResultBean>();
        rsResult.setTotalCount(this.getPageCount(param));
        rsResult.setPageNo(param.getPageNo());
        if (rsResult.getTotalCount() != NumberConst.IntDef.INT_ZERO) {
            bsTaskList = this.findList(param);
            rsResult.setTotalPage(rsResult.getTotalCount(), param.getPageCount());
        }
        rsResult.setBsTaskList(bsTaskList);
        return rsResult;
    }
}
