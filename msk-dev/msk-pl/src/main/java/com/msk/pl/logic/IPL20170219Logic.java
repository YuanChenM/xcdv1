package com.msk.pl.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.pl.bean.IPL20170214RsParam;
import com.msk.pl.bean.PlDomainBs;
import com.msk.pl.bean.PlTerminalPartner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gyh on 2017/2/7.
 * 合伙人进货单查看接口
 */
@Service
public class IPL20170219Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Autowired
    private CommonLogic commonLogic;

    /**
     * SQL Map 中SQL ID定义
     *
     * @author gyh
     */
    interface SqlId {
        static final String SQL_ID_FIND_TERMINAL_LIST = "findTerminalList";
        static final String SQL_ID_FIND_DOMAIN_BS_LIST = "findDomainBsList";
    }

    /**
     * 合伙人下配送站列表查询
     *
     * @param param 参数
     * @return 结果
     */
    public List<PlTerminalPartner> findTerminalList(IPL20170214RsParam param) {
        return this.findList(SqlId.SQL_ID_FIND_TERMINAL_LIST, param);
    }

    /**
     * 合伙人下买手列表查询
     *
     * @param param 参数
     * @return 结果
     */
    public List<PlDomainBs> findDomainBsList(IPL20170214RsParam param) {
        return this.findList(SqlId.SQL_ID_FIND_DOMAIN_BS_LIST, param);
    }

}
