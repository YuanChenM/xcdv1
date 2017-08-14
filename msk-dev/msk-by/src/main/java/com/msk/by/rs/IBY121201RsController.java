package com.msk.by.rs;

import com.msk.by.logic.IBY121202Logic;
import com.msk.common.logic.CommonLogic;
import com.msk.core.entity.ByAccessAccount;
import com.msk.core.entity.ByBuyerBasicInfo;
import com.msk.core.entity.CommConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msk.by.bean.IBY121201RsParam;
import com.msk.by.logic.IBY121201Logic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.ByBuyerAccount;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;

import java.util.List;

/**
 * IBY121201RsController.
 *
 * @author zhou_yajun
 */
@RestController
public class IBY121201RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IBY121201RsController.class);

    @Autowired
    private IBY121201Logic iby121201Logic;
    @Autowired
    private IBY121202Logic iby121202Logic;
    @Autowired
    private CommonLogic commonLogic;

    /**
     * 买家注册接口
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/account/register",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<ByBuyerAccount> buyerRegister(@RequestBody RsRequest<IBY121201RsParam> param) {
        RsResponse<ByBuyerAccount> rs = new RsResponse<>();
        String message = iby121201Logic.buyerRegister(param.getParam());
        if (!StringUtil.isNullOrEmpty(message)) {
            rs.setMessage("买家注册失败");
            rs.setMessage(message);
            rs.setStatus(BusinessConst.RsStatus.FAIL);
        } else {
            rs.setMessage("买家注册成功");
            ByBuyerAccount account = iby121201Logic.getBuyerAccount(param.getParam());
            rs.setResult(account);
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        }
        return rs;
    }

    /**
     * 买家登录接口
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/account/login",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<ByBuyerBasicInfo> buyerLogin(@RequestBody RsRequest<ByBuyerAccount> param) {
        RsResponse<ByBuyerBasicInfo> rs = new RsResponse<>();
        if(iby121201Logic.findAccountByName(param.getParam()) == 1){
            ByBuyerAccount accountInfo = iby121201Logic.buyerLogin(param.getParam());
            if (null != accountInfo) {
                ByBuyerBasicInfo buyerInfo = iby121202Logic.findBuyerById(accountInfo.getBuyerId());
                rs.setStatus(BusinessConst.RsStatus.SUCCESS);
                rs.setResult(buyerInfo);
                rs.setMessage("登录成功");
            } else {
                rs.setStatus(BusinessConst.RsStatus.FAIL);
                rs.setMessage("输入密码错误");
            }
        }else{
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("输入账号错误");
        }
        return rs;
    }

    /**
     * 买家重设密码
     *
     * @param param param
     * @return 结果
     * @author zhou_ling
     */
    @RequestMapping(value = "/api/v1/by/password/reset",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<Object> resetPasswordUpdate(@RequestBody RsRequest<ByBuyerAccount> param) {
        RsResponse<Object> rs = new RsResponse<>();
        //重置新密码是手机号后六位
        String password = param.getParam().getTelNo();
        String accountPassword = password.substring(password.length() - 8, password.length());
        param.getParam().setAccountPass(accountPassword);

        int resultCount = iby121201Logic.resetPassword(param.getParam());
        if(resultCount == NumberConst.IntDef.INT_ZERO){
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("密码重置失败！");
        }else {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("密码重置成功！");
        }
        return rs;
    }

    /**
     * 通过买家id,买家账号,买家旧密码,更新新密码
     *
     * @param param param
     * @return 结果
     * @author yuan_chen
     */
    @RequestMapping(value = "/api/v1/by/account/updatePwd",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<Object> buyerUpdate(@RequestBody RsRequest<IBY121201RsParam> param) {

        RsResponse<Object> rs = new RsResponse<>();
        BaseParam baseParam = new BaseParam();
        baseParam.setUpdId(param.getParam().getUpdId());
        baseParam.getFilterMap().put("buyerId", param.getParam().getBuyerId());
        baseParam.getFilterMap().put("accountName", param.getParam().getAccountName());
        baseParam.getFilterMap().put("oldAccountPass", param.getParam().getOldAccountPass());
        baseParam.getFilterMap().put("newAccountPass", param.getParam().getNewAccountPass());
        if(iby121201Logic.findAccountByName(param.getParam()) == 1){
            int updateResult = iby121201Logic.updatePassword(baseParam);
            if (updateResult == NumberConst.IntDef.INT_ONE) {
                rs.setStatus(BusinessConst.RsStatus.SUCCESS);
                rs.setMessage("密码更新成功!");
            } else {
                rs.setStatus(BusinessConst.RsStatus.FAIL);
                rs.setMessage("密码更新失败!");
            }
        }else{
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("输入账号错误");
        }

        return rs;
    }

    /**
     * 前台手机验证成功后,通过手机号直接修改密码
     *
     * @param param param
     * @return 结果
     * @author yuan_chen
     */
    @RequestMapping(value = "/api/v1/by/account/updatePwdByTel",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<Object> buyerUpdateByTel(@RequestBody RsRequest<IBY121201RsParam> param) {

        RsResponse<Object> rs = new RsResponse<>();
        BaseParam baseParam = new BaseParam();
        baseParam.setUpdId(param.getParam().getUpdId());
        baseParam.getFilterMap().put("telNo", param.getParam().getTelNo());
        baseParam.getFilterMap().put("newAccountPass", param.getParam().getNewAccountPass());
        param.getParam().setAccountName(param.getParam().getTelNo());
        if(iby121201Logic.findAccountByName(param.getParam()) == 1){
            int updateResult = iby121201Logic.updatePasswordByTel(baseParam);
            if (updateResult == NumberConst.IntDef.INT_ONE) {
                rs.setStatus(BusinessConst.RsStatus.SUCCESS);
                rs.setMessage("密码更新成功!");
            } else {
                rs.setStatus(BusinessConst.RsStatus.FAIL);
                rs.setMessage("密码更新失败!");
            }
        }else{
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("输入手机号错误!");
        }

        return rs;
    }

    /**
     * 通路人员登录接口
     *
     * @param param param
     * @return 结果
     * @author yuan_chen
     */
    @RequestMapping(value = "/api/v1/by/access/login",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<ByAccessAccount> accessLogin(@RequestBody RsRequest<ByAccessAccount> param){
        RsResponse<ByAccessAccount> rs = new RsResponse<>();
        ByAccessAccount byAccessAccount = iby121201Logic.accessLogin(param.getParam());
        if(null == byAccessAccount){
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("用户名或密码错误,请重新输入");
        }else{
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setResult(byAccessAccount);
            rs.setMessage("登录成功");
        }
        return rs;
    }
    /**
     * SSO登录验证接口
     *
     * @param param param
     * @return 结果
     * @author yuan_chen
     */
    @RequestMapping(value = "/api/v1/by/sso/login",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<String> ssoLogin(@RequestBody RsRequest<IBY121201RsParam> param){
        RsResponse<String> rs = new RsResponse<>();
        List<CommConstant> commList = commonLogic.findConstantList("ByInterfaceToken");
        ByAccessAccount byAccessAccount = iby121201Logic.validateSSOLogin(param.getParam().getAccountName());
        if(param.getParam().getInterfaceToken().equals(commList.get(0).getConstantValue()) && null != byAccessAccount){
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("登录成功");
        }else{
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("用户名或密码错误,请重新输入");
        }
        return rs;
    }
}
