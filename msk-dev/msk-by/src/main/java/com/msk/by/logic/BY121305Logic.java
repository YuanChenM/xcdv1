package com.msk.by.logic;

import com.msk.by.bean.IBY121202RsParam;
import com.msk.by.bean.IBY121205RsParam;
import com.msk.by.bean.IBY121206RsParam;
import com.msk.by.bean.IBY121207RsParam;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.*;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.md.utils.DistrictAreaUtils;
import com.msk.pd.logic.ProductLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * BY121305Logic.
 *
 * @author zhou_ling
 */
@Service
public class BY121305Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BY121305Logic.class);

    @Autowired
    private CommonLogic commonLogic;


    /**
     * (non-Javadoc)
     *
     * @see BaseLogic#setBaseDao(BaseDao)
     */
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SQL Map 中SQL ID定义
     *
     * @author zhou_Ling
     */
    interface SqlId {
        //批发市场详细信息获取
        static String SQL_TERMARKET_DETAIL_INFO_FIND = "findTerMarketInfo";
        //批发市场详细信息更新
        static String SQL_TERMARKET_DETAIL_INFO_SAVE = "saveTerMarketInfo";
        //批发市场详细信息增加
        static String SQL_TERMARKET_DETAIL_INFO_ADD = "addTerMarketInfo";
    }


    /**
     * 批发市场详细信息查询接口
     *
     * @param terMarketId terMarketId
     * @return
     */
    @Transactional(readOnly = true)
    public ByMarketTerminal findMarketTerminal(String terMarketId) {
        BasePageParam inParam = new BasePageParam();
        inParam.setFilter("terMarketId", terMarketId);
        ByMarketTerminal byMarketTerminal = super.findOne(SqlId.SQL_TERMARKET_DETAIL_INFO_FIND, inParam);
        return byMarketTerminal;
    }

    /**
     * 批发市场详细信息更新
     * @param byMarketTerminal
     * @return
     */
    public int byMarketTerminalModify(ByMarketTerminal byMarketTerminal){

        // 更新市场详细信息
        byMarketTerminal.setUpdId("admin");
        byMarketTerminal.setUpdTime(DateTimeUtil.getCustomerDate());
        int count = super.save(SqlId.SQL_TERMARKET_DETAIL_INFO_SAVE, byMarketTerminal);
        return count;
    }

    /**
     * 批发市场详细信息增加
     * @param byMarketTerminal
     * @return
     */
    public int byMarketTerminalAdd(ByMarketTerminal byMarketTerminal){

        // 增加批发市场详细信息
        byMarketTerminal.setCrtId("admin");
        byMarketTerminal.setCrtTime(DateTimeUtil.getCustomerDate());
        int count = super.save(SqlId.SQL_TERMARKET_DETAIL_INFO_ADD, byMarketTerminal);
        return count;
    }
}
