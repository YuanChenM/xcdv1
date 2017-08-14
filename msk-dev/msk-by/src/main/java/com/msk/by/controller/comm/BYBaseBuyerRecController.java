package com.msk.by.controller.comm;

import com.msk.by.bean.BY121304Bean;
import com.msk.by.bean.IBY121207RsParam;
import com.msk.by.logic.*;
import com.msk.common.logic.CommonLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.*;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.pd.logic.ProductLogic;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 买家收货信息画面
 *
 * @author yuan_chen
 */
@Controller
@RequestMapping("by/baseBuyerRecInfo")
public class BYBaseBuyerRecController extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(BYBaseBuyerRecController.class);

    @Autowired
    private BY121304Logic by121304Logic;
    @Autowired
    private IBY121209Logic iby121209Logic;
    @Autowired
    private IBY121208Logic iby121208Logic;
    @Autowired
    private IBY121204Logic iby121204Logic;
    @Autowired
    private IBY121203Logic iby121203Logic;
    @Autowired
    private CommonLogic commonLogic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init/{buyerId}",
        method = RequestMethod.POST)
    public String init(@PathVariable("buyerId") String buyerId, Model model) {
        logger.debug("买家详细画面");
        model.addAttribute("buyerId", buyerId);
        // 买家收货地址信息
        List<ByBuyerRecAddr> recAddrList = by121304Logic.buyerReceiveAddrFind(buyerId);
        if(CollectionUtils.isEmpty(recAddrList)){
            ByBuyerRecAddr buyerRecAdd = new ByBuyerRecAddr();
            ByBuyerRecAddr buyerRecAdd1 = new ByBuyerRecAddr();
            buyerRecAdd.setBuyerId(buyerId);
            buyerRecAdd1.setBuyerId(buyerId);
            buyerRecAdd.setReceiveAddr("");
            recAddrList.add(buyerRecAdd);
            buyerRecAdd1.setReceiveAddr("");
            recAddrList.add(buyerRecAdd1);
        }
        model.addAttribute("recAddrList", recAddrList);
        // 买家收货时间信息
        List<ByBuyerRecTime> recTimeList = by121304Logic.buyerReceiveTimeFind(buyerId);
        model.addAttribute("recTimeList", recTimeList);
        // 收货时间
        List<CommConstant> recTimeCommList = commonLogic.findConstantList("ReceivePeriodType");
        List<BY121304Bean> recTimeShowList = new ArrayList<>();
        for (int i = 0; i < recTimeCommList.size(); i++) {
            BY121304Bean recTime = new BY121304Bean();
            recTime.setRecPerType(recTimeCommList.get(i).getConstantValue());
            recTime.setTimeDescribe(recTimeCommList.get(i).getConstantName());
            recTime.setIsChecked("0");
            for (int j = 0; j < recTimeList.size(); j++) {
                if (recTimeCommList.get(i).getConstantValue().equals(recTimeList.get(j).getRecPerType())) {
                    recTime.setIsChecked("1");
                    break;
                }
            }
            recTimeShowList.add(recTime);
        }
        model.addAttribute("recTimeShowList", recTimeShowList);
        // 买家销售对象信息
        List<ByBuyerSalestarget> salestargetList = by121304Logic.buyerSalesTargetFind(buyerId);
        model.addAttribute("salestargetList", salestargetList);
        // 销售对象
        List<CommConstant> salestargetCommList = commonLogic.findConstantList("SalesTarget");
        List<BY121304Bean> salestargetShowList = new ArrayList<>();
        for (int i = 0; i < salestargetCommList.size(); i++) {
            BY121304Bean salestarget = new BY121304Bean();
            salestarget.setSalesTargetType(salestargetCommList.get(i).getConstantValue());
            salestarget.setSalesTargetName(salestargetCommList.get(i).getConstantName());
            salestarget.setIsChecked("0");
            for (int j = 0; j < salestargetList.size(); j++) {
                if (salestargetCommList.get(i).getConstantValue().equals(salestargetList.get(j).getSalesTargetType())) {
                    salestarget.setIsChecked("1");
                    break;
                }
            }
            salestargetShowList.add(salestarget);
        }
        model.addAttribute("salestargetShowList", salestargetShowList);
        // 买家销售产品信息
        List<ByBuyerPdCla> pdClaList = by121304Logic.buyerPdClassificationFind(buyerId);
        model.addAttribute("pdClaList", pdClaList);
        // 销售产品
        List<PdClasses> pdClaCommList = by121304Logic.findPdClassesList();
        List<BY121304Bean> pdClaShowList = new ArrayList<>();
        for (int i = 0; i < pdClaCommList.size(); i++) {
            BY121304Bean pdCla = new BY121304Bean();
            pdCla.setClassCode(pdClaCommList.get(i).getClassesCode());
            pdCla.setClassName(pdClaCommList.get(i).getClassesName());
            pdCla.setIsChecked("0");
            for (int j = 0; j < pdClaList.size(); j++) {
                if (pdClaCommList.get(i).getClassesCode().equals(pdClaList.get(j).getClassCode())) {
                    pdCla.setIsChecked("1");
                    break;
                }
            }
            pdClaShowList.add(pdCla);
        }
        model.addAttribute("pdClaShowList", pdClaShowList);

        return "by/comm/BASE_BUYER_REC_INFO";
    }

    @RequestMapping(value = "update",
        method = RequestMethod.POST)
    public String recInfoUpdate(BY121304Bean by121304Bean, Model model) {
        logger.debug("买家基本信息更新");
        // 更新买家收货地址
        List<ByBuyerRecAddr> recAddrList = by121304Bean.getRecAddr();
        if (!CollectionUtils.isEmpty(recAddrList)) {
            for (int i = 0; i < recAddrList.size(); i++) {
                recAddrList.get(i).setBuyerId(by121304Bean.getBuyerId());
            }
        }
        int updateRecAddrCount = iby121208Logic.buyerReceiveAddrModify(recAddrList, new ArrayList<ByBuyerRecAddr>());
        // 更新买家收货时间
        List<ByBuyerRecTime> recTimeList = new ArrayList<>();
        List<CommConstant> recTimeCommList = commonLogic.findConstantList("ReceivePeriodType");
        String[] receiveTime = by121304Bean.getSelectRecTime();
        if (receiveTime == null) {
            ByBuyerRecTime byBuyerRecTime = new ByBuyerRecTime();
            byBuyerRecTime.setBuyerId(by121304Bean.getBuyerId());
            byBuyerRecTime.setRecPerType("");
            byBuyerRecTime.setTimeDescribe("");
            recTimeList.add(byBuyerRecTime);
        } else {
            for (int i = 0; i < receiveTime.length; i++) {
                for (int j = 0; j < recTimeCommList.size(); j++) {
                    if (receiveTime[i].equals(recTimeCommList.get(j).getConstantValue())) {
                        ByBuyerRecTime byBuyerRecTime = new ByBuyerRecTime();
                        byBuyerRecTime.setBuyerId(by121304Bean.getBuyerId());
                        byBuyerRecTime.setRecPerType(receiveTime[i]);
                        byBuyerRecTime.setTimeDescribe(recTimeCommList.get(j).getConstantName());
                        recTimeList.add(byBuyerRecTime);
                        break;
                    }
                }
            }
        }

        int updateRecTimeCount = iby121209Logic.buyerReceiveTimeModify(recTimeList);
        // 更新买家销售对象
        List<ByBuyerSalestarget> salestargetList = new ArrayList<>();
        List<CommConstant> salestargetCommList = commonLogic.findConstantList("SalesTarget");
        String[] salestarget = by121304Bean.getSalesTarget();
        if (salestarget == null) {
            ByBuyerSalestarget byBuyerSalestarget = new ByBuyerSalestarget();
            byBuyerSalestarget.setBuyerId(by121304Bean.getBuyerId());
            byBuyerSalestarget.setSalesTargetType("");
            byBuyerSalestarget.setSalesTargetName("");
            salestargetList.add(byBuyerSalestarget);
        } else {
            for (int i = 0; i < salestarget.length; i++) {
                for (int j = 0; j < salestargetCommList.size(); j++) {
                    if (salestarget[i].equals(salestargetCommList.get(j).getConstantValue())) {
                        ByBuyerSalestarget byBuyerSalestarget = new ByBuyerSalestarget();
                        byBuyerSalestarget.setBuyerId(by121304Bean.getBuyerId());
                        byBuyerSalestarget.setSalesTargetType(salestarget[i]);
                        byBuyerSalestarget.setSalesTargetName(salestargetCommList.get(j).getConstantName());
                        salestargetList.add(byBuyerSalestarget);
                        break;
                    }
                }
            }
        }
        int salesTargetCount = iby121204Logic.buyerSalesTargetModify(salestargetList);
        // 更新买家销售产品
        List<ByBuyerPdCla> pdClaList = new ArrayList<>();
        List<PdClasses> pdClaCommList = by121304Logic.findPdClassesList();
        String[] pdCla = by121304Bean.getSelectPdCla();
        if (pdCla == null) {
            ByBuyerPdCla buyerPdCla = new ByBuyerPdCla();
            buyerPdCla.setBuyerId(by121304Bean.getBuyerId());
            buyerPdCla.setClassCode("");
            buyerPdCla.setClassName("");
            pdClaList.add(buyerPdCla);
        } else {
            for (int i = 0; i < pdCla.length; i++) {
                for (int j = 0; j < pdClaCommList.size(); j++) {
                    if (pdCla[i].equals(pdClaCommList.get(j).getClassesCode())) {
                        ByBuyerPdCla buyerPdCla = new ByBuyerPdCla();
                        buyerPdCla.setBuyerId(by121304Bean.getBuyerId());
                        buyerPdCla.setClassCode(pdCla[i]);
                        buyerPdCla.setClassName(pdClaCommList.get(j).getClassesName());
                        pdClaList.add(buyerPdCla);
                        break;
                    }
                }
            }
        }
        iby121203Logic.buyerPdClassificationModify(pdClaList);

        return super.forward("/BY121304/init/" + by121304Bean.getBuyerId() + "");
    }
}

