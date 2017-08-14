package com.msk.core.web.controller;

import com.alibaba.fastjson.TypeReference;
import com.msk.common.utils.RsClientUtil;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.core.web.bean.FavoritesBean;
import com.msk.core.web.bean.FavoritesRedisBean;
import com.msk.core.web.bean.LoginUser;
import com.msk.core.web.utils.RestClientUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by rong_ting on 2016/8/24.
 */
@Controller
@RequestMapping("favorites")
public class FavoritesController extends BaseController {

    /** logger */
    private static Logger logger = getLogger(FavoritesController.class);

    /** 调用redis */
    @Autowired
    private RsClientUtil rsClientUtil;
    /**
     * 收藏夹功能
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String save(FavoritesBean bean, String sysCode){
        LoginUser loginUser = this.getLoginUser();
        String loginId = loginUser.getEmplId();

        RsRequest<FavoritesRedisBean> requestExist = new RsRequest<>();
        FavoritesRedisBean existBean = new FavoritesRedisBean();
        existBean.setDbNumber(NumberConst.IntDef.INT_NINE);
        existBean.setKey(loginId + sysCode);
        requestExist.setParam(existBean);
        //查询key存在
        String checkUrl = StringUtil.formatMessage("{0}/api/favorite/exist/_check", ConfigManager.getFavoritesUrl());
        RsResponse<Boolean> responseExist = RestClientUtil.post(checkUrl, requestExist, new TypeReference<RsResponse<Boolean>>() {
        });
        if(responseExist.getResult().booleanValue()) {
            //查询收藏夹数据
            String getFavoritesUrl = StringUtil.formatMessage("{0}/api/favorites/_load", ConfigManager.getFavoritesUrl());
            RsResponse<HashMap<String,String>> responseMap = RestClientUtil.post(getFavoritesUrl, requestExist, new TypeReference<RsResponse<HashMap<String, String>>>() {
            });
            Map<String, String> mapGet = responseMap.getResult();
            if(!mapGet.containsKey(bean.getPageUrl())) {
                requestExist.getParam().setField(bean.getPageUrl());
                requestExist.getParam().setValue(bean.getPageName());
                //收藏夹保存一条数据
                String saveFavoritesOneUrl = StringUtil.formatMessage("{0}/api/favorites/item/_save", ConfigManager.getFavoritesUrl());
                RestClientUtil.post(saveFavoritesOneUrl, requestExist, new TypeReference<RsResponse<Boolean>>() {
                });
            } else {
                return "HAS";
            }
        } else {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(bean.getPageUrl(), bean.getPageName());
            requestExist.getParam().setData(map);
            //第一次时保存数据
            String saveFavoritesUrl = StringUtil.formatMessage("{0}/api/favorites/_save", ConfigManager.getFavoritesUrl());
            RestClientUtil.post(saveFavoritesUrl, requestExist, new TypeReference<RsResponse<Boolean>>() {
            });
        }

        return "SUCCESS";
    }

    /**
     * 收藏夹删除
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(String pageUrl, String sysCode){
        LoginUser loginUser = this.getLoginUser();
        String loginId = loginUser.getEmplId();
        RsRequest<FavoritesRedisBean> requestExist = new RsRequest<>();
        FavoritesRedisBean existBean = new FavoritesRedisBean();
        existBean.setDbNumber(NumberConst.IntDef.INT_NINE);
        existBean.setKey(loginId + sysCode);
        requestExist.setParam(existBean);
        //查询key存在
        String checkUrl = StringUtil.formatMessage("{0}/api/favorite/exist/_check", ConfigManager.getFavoritesUrl());
        RsResponse<Boolean> responseExist = RestClientUtil.post(checkUrl, requestExist, new TypeReference<RsResponse<Boolean>>() {
        });
        if(responseExist.getResult().booleanValue()) {
            List<String> list = new ArrayList<>();
            list.add(pageUrl);
            requestExist.getParam().setFields(list);
            String delFavoritesUrl = StringUtil.formatMessage("{0}/api/favorites/item/_delete", ConfigManager.getFavoritesUrl());
            RestClientUtil.post(delFavoritesUrl, requestExist, new TypeReference<RsResponse<Long>>() {
            });
        }

        return "SUCCESS";
    }
}
