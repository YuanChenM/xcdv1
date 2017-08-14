package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.SlEnterprise;
import com.msk.core.entity.SlEpAgentAuth;
import com.msk.core.entity.SlEpOemAuth;
import com.msk.core.entity.SlSeller;
import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231134RsParam;
import com.msk.sl.bean.ISL231134RsResult;
import com.msk.sl.bean.ISL231180SLEpAuth;
import com.msk.sl.logic.ISL231134RsLogic;
import com.msk.sl.logic.ISL231180RsLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/3/9.
 */
@RestController
public class ISL231134RsController extends BaseRsController {
    /**注入logic*/
    @Autowired
    private ISL231134RsLogic isl231134RsLogic;

    /**
     * 新增企业生产商信息
     * @param param 传入参数
     * @return 返回参数
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slProducer/new",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231134Validator")
    public RsResponse<ISL231134RsResult> deleteSLEpCert(@RequestBody RsRequest<ISL231134RsParam> param) {
        ISL231134RsParam isl231134RsParam = param.getParam();
        /**根据slCode查询用户传入的参数中卖家账号和生产商企业id是否存在，不存在 则报错*/
        if(null!=isl231134RsParam){
            /**查询卖家账号*/
            String slCode = isl231134RsParam.getSlCode();
            SlSeller slSeller=this.isl231134RsLogic.findIsl231180SLEpAuthIfExist(slCode);
            /**如果查询结果为空，录入的卖家编码不存在，报错*/
            if(null==slSeller){
                throw new BusinessException("对不起，输入了无效的卖家编码");
            }
            /**根据epID查询生产商企业ID是否存在*/
            Long epId = isl231134RsParam.getProducerEpId();
            SlEnterprise slEnterprise = this.isl231134RsLogic.findSlEnterpriseIfExist(epId);
            if(null==slEnterprise){
                throw new BusinessException("您录入的生产商企业ID不存在");
            }
            /**如果1：卖家代理及分销授权:2：卖家OEM委托授权标志*/
            if("1".equals(isl231134RsParam.getFlag())){
                /**根据slCode 和epId查询代理中是否已经存在,存在 就通知用户，不存在正常存储*/
                this.isl231134RsLogic.findIfExist(slCode,epId);
                SlEpAgentAuth slEpAgentAuth = new SlEpAgentAuth();
                slEpAgentAuth.setSlCode(slCode);
                slEpAgentAuth.setProducerEpId(epId);
                slEpAgentAuth.setContractNo(isl231134RsParam.getContractNo());
                slEpAgentAuth.setAuthEpName(isl231134RsParam.getAuthEpName());
                slEpAgentAuth.setAuthTermBegin(isl231134RsParam.getAuthTermBegin());
                slEpAgentAuth.setAuthTermEnd(isl231134RsParam.getAuthTermEnd());
                slEpAgentAuth.setAuthTermUnliimited(isl231134RsParam.getAuthTermUnliimited());
                slEpAgentAuth.setCrtId(isl231134RsParam.getCrtId());
                slEpAgentAuth.setDelFlg("0");
                slEpAgentAuth.setVer(NumberConst.IntDef.INT_ONE);
                this.isl231134RsLogic.saveSlEpAgentAuth(slEpAgentAuth);
            }
            if("2".equals(isl231134RsParam.getFlag())){
                this.isl231134RsLogic.findOemIfExist(slCode, epId);
                SlEpOemAuth slEpOemAuth =new SlEpOemAuth();
                slEpOemAuth.setSlCode(slCode);
                slEpOemAuth.setProducerEpId(epId);
                slEpOemAuth.setContractNo(isl231134RsParam.getContractNo());
                slEpOemAuth.setAuthEpName(isl231134RsParam.getAuthEpName());
                slEpOemAuth.setAuthTermBegin(isl231134RsParam.getAuthTermBegin());
                slEpOemAuth.setAuthTermEnd(isl231134RsParam.getAuthTermEnd());
                slEpOemAuth.setAuthTermUnliimited(isl231134RsParam.getAuthTermUnliimited());
                slEpOemAuth.setCrtId(isl231134RsParam.getCrtId());
                slEpOemAuth.setDelFlg("0");
                slEpOemAuth.setVer(NumberConst.IntDef.INT_ONE);
                this.isl231134RsLogic.saveSlEpOemAuth(slEpOemAuth);
            }
        }
        RsResponse<ISL231134RsResult> rs = new RsResponse<ISL231134RsResult>();
        rs.setMessage("保存成功");
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        return rs;
    }
}
