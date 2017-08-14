package com.msk.by.logic;

import com.msk.by.bean.IBY121202RsParam;
import com.msk.by.bean.IBY121205RsParam;
import com.msk.by.bean.IBY121206RsParam;
import com.msk.by.bean.IBY121207RsParam;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
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

import java.util.List;

/**
 * BY121304Logic.
 *
 * @author yuan_chen
 */
@Service
public class BY121304Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BY121304Logic.class);

    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private IBY121202Logic iby121202Logic;
    @Autowired
    private IBY121203Logic iby121203Logic;
    @Autowired
    private IBY121204Logic iby121204Logic;
    @Autowired
    private IBY121205Logic iby121205Logic;
    @Autowired
    private IBY121206Logic iby121206Logic;
    @Autowired
    private IBY121208Logic iby121208Logic;
    @Autowired
    private IBY121209Logic iby121209Logic;
    @Autowired
    private ProductLogic productLogic;
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
     * @author zhou_yajun
     */
    interface SqlId {
        //买家证照信息获取
        static String SQL_FIND_LINECE = "findLinece";
        static String SQL_FIND_ACCOUNT_INFO = "findAccountInfo";
        static String SQL_DELETE_EMPLOYEE = "deleteEmployee";
        static String SQL_FIND_MARKET_TERMINAL_LIST = "findMarkerTerminalList";
        static String SQL_FIND_MARKET_TERMINAL = "findMarkerTerminal";
        static String SQL_FIND_MARKET_FOOD_LIST = "findMarkerFoodList";
        static String SQL_FIND_MARKET_FOOD = "findMarkerFood";
        static String SQL_FIND_BUYYERS_TYPE_INFO = "findBuyyersTypeInfo";
        static String SQL_DELETE_ACCOUNT_PWORD = "deleteAccountPwd";
        static String SQL_FIND_ACCOUNT = "findAccount";
    }

    /**
     * 获取买家账号信息
     * @param buyerId
     * @return
     */
    public ByBuyerAccount findBuyerAccount(String buyerId){
        BaseParam inParam = new BaseParam();
        inParam.setFilter("buyerId",buyerId);
        ByBuyerAccount buyerAccount = super.findOne(SqlId.SQL_FIND_ACCOUNT_INFO,inParam);
        return buyerAccount;
    }
    /**
     * 获取买家详细信息
     * @param buyerId
     * @return
     */
    public IBY121202RsParam findBuyerDetail(String buyerId){
        IBY121202RsParam iby121202RsParam = new IBY121202RsParam();
        iby121202RsParam.setBuyerId(buyerId);
        IBY121202RsParam buyerDetail = iby121202Logic.findBuyerDetailInfo(iby121202RsParam);
        if(StringUtil.isNullOrEmpty(buyerDetail.getLgcsAreaCode())){
            buyerDetail.setLgcsAreaCode("");
        }
        if(StringUtil.isNullOrEmpty(buyerDetail.getCityCode())){
            buyerDetail.setCityCode("");
        }
        if(StringUtil.isNullOrEmpty(buyerDetail.getDistrictCode())){
            buyerDetail.setDistrictCode("");
        }
        buyerDetail.setLgcsAreaName(DistrictAreaUtils.getLogisticsAreaName(buyerDetail.getLgcsAreaCode()));
        buyerDetail.setCityName(DistrictAreaUtils.getCityName(buyerDetail.getCityCode()));
        buyerDetail.setDistrictName(DistrictAreaUtils.getDistrictName(buyerDetail.getCityCode(), buyerDetail.getDistrictCode()));
        return buyerDetail;
    }

    /**
     * 删除买家雇员信息
     * @param param
     * @return
     */
    public int deleteEmployee(IBY121207RsParam param){
        return super.modify(SqlId.SQL_DELETE_EMPLOYEE,param);
    }
    /**
     * 获取批发市场数据
     * @param lgcsAreaCode
     * @param cityCode
     * @param districtCode
     * @return
     */
    public List<ByMarketTerminal> findBuyerMarketTerminalList(String lgcsAreaCode,String cityCode,String districtCode){
        BaseParam inParam = new BaseParam();
        inParam.setFilter("lgcsAreaCode",lgcsAreaCode);
        inParam.setFilter("cityCode",cityCode);
        inParam.setFilter("districtCode",districtCode);
        List<ByMarketTerminal> byMarketTerminal = super.findList(SqlId.SQL_FIND_MARKET_TERMINAL_LIST,inParam);
        return byMarketTerminal;
    }
    /**
     * 获取批发市场信息
     * @param terMarketId
     * @return
     */
    public ByMarketTerminal findBuyerMarketTerminal(String terMarketId){
        BaseParam inParam = new BaseParam();
        inParam.setFilter("terMarketId",terMarketId);
        ByMarketTerminal marketTerminal = super.findOne(SqlId.SQL_FIND_MARKET_TERMINAL,inParam);
        return marketTerminal;
    }
    /**
     * 获取菜场数据
     * @param lgcsAreaCode
     * @param cityCode
     * @param districtCode
     * @return
     */
    public List<ByMarketFood> findBuyerMarketFoodList(String lgcsAreaCode,String cityCode,String districtCode){
        BaseParam inParam = new BaseParam();
        inParam.setFilter("lgcsAreaCode",lgcsAreaCode);
        inParam.setFilter("cityCode",cityCode);
        inParam.setFilter("districtCode",districtCode);
        List<ByMarketFood> byMarketFoods = super.findList(SqlId.SQL_FIND_MARKET_FOOD_LIST,inParam);
        return byMarketFoods;
    }
    /**
     * 获取菜场信息
     * @param fodMarketId
     * @return
     */
    public ByMarketFood findByMarketFood(String fodMarketId){
        BaseParam inParam = new BaseParam();
        inParam.setFilter("fodMarketId",fodMarketId);
        ByMarketFood marketFood = super.findOne(SqlId.SQL_FIND_MARKET_FOOD,inParam);
        return marketFood;
    }

    /**
     *重置账号和密码
     * @param
     * @return
     */
    public int resetAccountPwd(ByBuyerAccount byBuyerAccount){
         int i = super.getCount(SqlId.SQL_FIND_ACCOUNT, byBuyerAccount);
        if(i>0){
            // 若该账号已存在
            return 0;
        }else{
            super.modify(SqlId.SQL_DELETE_ACCOUNT_PWORD, byBuyerAccount);
            byBuyerAccount.setId(commonLogic.maxId("by_buyer_account", "ID"));
            byBuyerAccount.setCrtTime(DateTimeUtil.getCustomerDate());
            byBuyerAccount.setUpdTime(DateTimeUtil.getCustomerDate());
            byBuyerAccount.setActTime(DateTimeUtil.getCustomerDate());
           return super.save(byBuyerAccount);
        }
    }
    /**
     * 买家证照信息查询
     * @param buyerId
     * @return
     */
    public IBY121205RsParam buyerLicenceFind(String buyerId){
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("buyerId",buyerId);
        IBY121205RsParam iby121205RsParam = super.findOne(SqlId.SQL_FIND_LINECE, baseParam);
        return iby121205RsParam;
    }

    /**
     * 买家证照信息更新
     * @param param
     * @return
     */
    public int buyerLicenceModify(ByBuyerLicence param){
        return iby121205Logic.buyerLicenceModify(param);
    }
    /**
     * 买家证照图片信息更新
     * @param param
     * @return
     */
    public int buyerLicencePicModify(IBY121206RsParam param){
        return iby121206Logic.buyerLicencePicModify(param);
    }
    /**
     * 买家图片信息查询
     * @param buyerId
     * @return
     */
    public IBY121206RsParam buyerLicencePicFind(String buyerId){
        IBY121206RsParam iby121206RsParam = new IBY121206RsParam();
        iby121206RsParam.setBuyerId(buyerId);
        IBY121206RsParam buyerLicencePic = iby121206Logic.buyerLicencePicFind(iby121206RsParam);
        return buyerLicencePic;
    }

    /**
     * 买家收货地址查询
     * @param buyerId
     * @return
     */
    public List<ByBuyerRecAddr> buyerReceiveAddrFind(String buyerId){
        ByBuyerRecAddr byBuyerRecAddr = new ByBuyerRecAddr();
        byBuyerRecAddr.setBuyerId(buyerId);
        List<ByBuyerRecAddr> recAddrList = iby121208Logic.buyerReceiveAddrFind(byBuyerRecAddr);
        return recAddrList;
    }
    /**
     * 买家收货时间查询
     * @param buyerId
     * @return
     */
    public List<ByBuyerRecTime> buyerReceiveTimeFind(String buyerId){
        ByBuyerRecTime byBuyerRecTime = new ByBuyerRecTime();
        byBuyerRecTime.setBuyerId(buyerId);
        List<ByBuyerRecTime> recTimeList = iby121209Logic.buyerReceiveTimeFind(byBuyerRecTime);
        return recTimeList;
    }
    /**
     * 买家销售对象查询
     * @param buyerId
     * @return
     */
    public List<ByBuyerSalestarget> buyerSalesTargetFind(String buyerId){
        ByBuyerSalestarget byBuyerSalestarget = new ByBuyerSalestarget();
        byBuyerSalestarget.setBuyerId(buyerId);
        List<ByBuyerSalestarget> salestargetList = iby121204Logic.buyerSalesTargetFind(byBuyerSalestarget);
        return salestargetList;
    }
    /**
     * 买家销售产品查询
     * @param buyerId
     * @return
     */
    public List<ByBuyerPdCla> buyerPdClassificationFind(String buyerId){
        ByBuyerPdCla byBuyerPdCla = new ByBuyerPdCla();
        byBuyerPdCla.setBuyerId(buyerId);
        List<ByBuyerPdCla> pdClaList = iby121203Logic.buyerPdClassificationFind(byBuyerPdCla);
        return pdClaList;
    }

    /**
     * 买家销售产品
     * @return
     */
    public List<PdClasses> findPdClassesList(){
        BaseParam inParam = new BaseParam();
        List<PdClasses> pdClaCommList = productLogic.findPdClasses(inParam);
        return pdClaCommList;
    }

    public List<CommConstant> findBuyerTypes(String buyyersType)
    {
        BaseParam param = new BaseParam();
        param.getFilterMap().put("buyyersType",buyyersType);
        return this.findList(SqlId.SQL_FIND_BUYYERS_TYPE_INFO,param);
    }

}
