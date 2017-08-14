package com.msk.by.rs;

import com.msk.by.bean.IBY121202RsParam;
import com.msk.by.logic.IBY121202Logic;
import com.msk.by.logic.IBY121203Logic;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.ByBuyerBasicInfo;
import com.msk.core.entity.ByBuyerPdCla;
import com.msk.core.entity.ByMarketFood;
import com.msk.core.entity.ByMarketTerminal;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * IBY121202RsController.
 *
 * @author zhou_yajun
 */
@RestController
public class IBY121202RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IBY121202RsController.class);

    @Autowired
    private IBY121202Logic iby121202Logic;

    @Autowired
    private IBY121203Logic iby121203Logic;


    /**
     * 买家基本信息更新接口
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/buyerInfo/update",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<ByBuyerBasicInfo> buyerInfoUpdate(@RequestBody RsRequest<IBY121202RsParam> param) {
        RsResponse<ByBuyerBasicInfo> rs = new RsResponse<>();
        int modifyCount = iby121202Logic.buyerInfoModify(param.getParam());

        if (modifyCount == NumberConst.IntDef.INT_ONE) {
            ByBuyerBasicInfo byBuyerBasicInfo = new ByBuyerBasicInfo();
            byBuyerBasicInfo.setBuyerCode(param.getParam().getBuyerCode());
            rs.setResult(byBuyerBasicInfo);
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家基本信息更新成功");
        } else {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("买家基本信息更新失败");
        }
        return rs;
    }

    /**
     * 买家基本信息查询接口
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/buyerInfo/findDetail",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<ByBuyerBasicInfo> findBuyerDetailInfo(@RequestBody RsRequest<IBY121202RsParam> param) {
        RsResponse<ByBuyerBasicInfo> rs = new RsResponse<>();
        ByBuyerBasicInfo buyerDetail = iby121202Logic.findBuyerDetailInfo(param.getParam());
        if (null == buyerDetail) {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("该买家没有注册");
        } else {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家基本信息获取成功");
            rs.setResult(buyerDetail);
        }
        return rs;
    }

    /**
     * 获取区域中的所有买家
     * 
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/v1/by/disirictCode/findBuyers",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<IBY121202RsParam>> findBuyerList(@RequestBody RsRequest<IBY121202RsParam> param) {
        RsResponse<List<IBY121202RsParam>> rs = new RsResponse<>();
        List<IBY121202RsParam> buyerList = iby121202Logic.findBuyerList(param.getParam());
        if (CollectionUtils.isEmpty(buyerList)) {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("该区域没有买家信息");
        } else {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("该区域的买家信息获取成功");
            rs.setResult(buyerList);
        }
        return rs;
    }

    /**
     * 根据指定条件获取买家信息
     * 
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/v1/by/condition/findBuyers",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<IBY121202RsParam>> findConditionBuyerList(@RequestBody RsRequest<IBY121202RsParam> param) {
        RsResponse<List<IBY121202RsParam>> rs = new RsResponse<>();
        List<IBY121202RsParam> buyerList = iby121202Logic.findConditionBuyerList(param.getParam());
        if (CollectionUtils.isEmpty(buyerList)) {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("输入条件中没有买家信息");
        } else {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("输入条件中买家信息获取成功");
            rs.setResult(buyerList);
        }
        return rs;
    }

    /**
     * 根据指定条件获取批发市场信息
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/v1/by/condition/findMarketTerminal",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<ByMarketTerminal>> findConditionMarketTerminal(@RequestBody RsRequest<ByMarketTerminal> param){
        RsResponse<List<ByMarketTerminal>> rs = new RsResponse<>();
        List<ByMarketTerminal> marketTerminalList = iby121202Logic.findConditionMarketTerminalList(param.getParam());
        if (CollectionUtils.isEmpty(marketTerminalList)) {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("查询不到符合条件批发市场信息");
        } else {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("查询符合条件批发市场信息成功");
            rs.setResult(marketTerminalList);
        }
        return rs;
    }
    /**
     * 根据指定条件获取菜场信息
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/v1/by/condition/findMarketFood",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<ByMarketFood>> findConditionMarketFood(@RequestBody RsRequest<ByMarketFood> param){
        RsResponse<List<ByMarketFood>> rs = new RsResponse<>();
        List<ByMarketFood> marketFoodList = iby121202Logic.findConditionMarketFoodList(param.getParam());
        if (CollectionUtils.isEmpty(marketFoodList)) {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("查询不到符合条件菜场信息");
        } else {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("查询符合条件菜场信息成功");
            rs.setResult(marketFoodList);
        }
        return rs;
    }

    /**
     * 根据批发市场或菜场ID查询买家信息
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/v1/by/buyer/findBuyerByMarketId",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<IBY121202RsParam>> findBuyerByMarketId(@RequestBody RsRequest<IBY121202RsParam> param){
        RsResponse<List<IBY121202RsParam>> rs = new RsResponse<>();
        List<IBY121202RsParam> buyerList = iby121202Logic.findBuyerByMarketId(param.getParam());
        if (CollectionUtils.isEmpty(buyerList)) {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("查询不到符合条件的买家信息");
        } else {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("查询符合条件买家信息成功");
            rs.setResult(buyerList);
        }
        return rs;
    }
    /**
     * 买家基本和全部销售对象信息
     * 
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/v1/by/buyerId/findBasicInfo",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<IBY121202RsParam> findBasicInfo(@RequestBody RsRequest<IBY121202RsParam> param) {
        RsResponse<IBY121202RsParam> rs = new RsResponse<>();
        IBY121202RsParam buyerDetail = iby121202Logic.findBuyerDetailInfo(param.getParam());
        ByBuyerPdCla byBuyerPdCla = new ByBuyerPdCla();
        byBuyerPdCla.setBuyerId(buyerDetail.getBuyerId());
        List<ByBuyerPdCla> buyerPdClaList = iby121203Logic.buyerPdClassificationFind(byBuyerPdCla);
        String sellerObject = "";
        for (int i = 0; i < buyerPdClaList.size(); i++) {
            if (i == buyerPdClaList.size() - 1) {
                sellerObject = sellerObject + buyerPdClaList.get(i).getClassName();
            } else {
                sellerObject = sellerObject + buyerPdClaList.get(i).getClassName() + ",";
            }
        }
        buyerDetail.setSellerObject(sellerObject);
        if (null == buyerDetail) {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("该买家没有注册");
        } else {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家基本信息获取成功");
            rs.setResult(buyerDetail);
        }
        return rs;
    }

    /**
     * 批发市场信息更新接口
     *
     * @param param param
     * @return 结果
     * @author zhou_ling
     */
    @RequestMapping(value = "/api/v1/by/byMarketTerminal/update",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<ByMarketTerminal> byMarketTerUpdate(@RequestBody RsRequest<ByMarketTerminal> param) {
        RsResponse<ByMarketTerminal> rs = new RsResponse<>();
        int modifyCount = iby121202Logic.byMarketTerModify(param.getParam());

        if (modifyCount == NumberConst.IntDef.INT_ONE) {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("批发市场信息更新成功");
        } else {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("批发市场信息更新失败");
        }
        return rs;
    }

    /**
     * 菜场信息更新接口
     *
     * @param param param
     * @return 结果
     * @author zhou_ling
     */
    @RequestMapping(value = "/api/v1/by/byMarketFood/update",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<ByMarketFood> byMarketFoodUpdate(@RequestBody RsRequest<ByMarketFood> param) {
        RsResponse<ByMarketFood> rs = new RsResponse<>();
        int modifyCount = iby121202Logic.byMarketFoodModify(param.getParam());

        if (modifyCount == NumberConst.IntDef.INT_ONE) {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("批发市场信息更新成功");
        } else {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("批发市场信息更新失败");
        }
        return rs;
    }
}
