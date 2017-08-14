package com.msk.so.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.so.bean.ReturnOrderBuyersBean;

/**
 * 退货人信息 OMReturnBuyers
 * 
 * @author hyx
 */
@Service
public class OMReturnBuyersLogic extends BaseLogic {

    /**
     * 
     * SqlId. 定义方法名
     *
     * @author xhy
     */
    interface SqlId {
        String SQL_ID_FIND_ONE_RETURN_BUYERS = "findOneReturnBuyers";
    }

    /**
     * 退货人信息
     * 
     * @return ReturnOrderBuyersBean
     * @author hyx
     */
    public ReturnOrderBuyersBean getReturntOrderBuyers() {

        ReturnOrderBuyersBean bean = new ReturnOrderBuyersBean();

        bean.setBuyersCode("10111010110101");// 退货买家编号
        bean.setBuyersName("李四"); // 退货买家名称
        bean.setConsignee("李四"); // 退货联系人
        bean.setConsigneeMobile("1839876567"); // 退货联系电话
        bean.setConsigneeQq("326787589");// 退货联系QQ号
        bean.setConsigneeWeixin("326787589@qq.com"); // 退货联系微信号
        bean.setConsigneeAddrProvince("上海"); // 退货地址省份
        bean.setConsigneeAddrCity("上海市"); // 退货地址市
        bean.setConsigneeAddrArea("闵行区"); // 退货地址区
        bean.setConsigneeAddr("浦江镇万源路1209弄36号");// 退货人详细地址
        return bean;
    }

    /**
     * 退货人信息DB
     * 
     * @param returnId 根据退货单id查询语句
     * @return ReturnOrderBuyersBean
     * @author hyx
     */
    @Transactional(readOnly = true)
    public ReturnOrderBuyersBean findOneReturntOrderBuyers(String returnId) {
        BaseParam param = new BaseParam();
        param.setFilter("returnId", returnId);
        return super.findOne(SqlId.SQL_ID_FIND_ONE_RETURN_BUYERS, param);
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

}
