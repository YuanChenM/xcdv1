package com.msk.core.web.tag;

import com.alibaba.fastjson.TypeReference;
import com.msk.common.utils.RsClientUtil;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseTag;
import com.msk.core.web.bean.FavoritesRedisBean;
import com.msk.core.web.utils.RestClientUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by rong_ting on 2016/8/24.
 */
public class FavoritesTag extends BaseTag implements DynamicAttributes {

    private Map<String, String> attrMap;
    /** 用户 */
    private String userId;
    /** 模块 */
    private String sysCode;


    @Override
    protected void doTag(HttpServletRequest httpServletRequest) throws JspException, IOException {

        RsClientUtil rsClientUtil = this.getApplicationBean("rsClientUtil", RsClientUtil.class);


        RsRequest<FavoritesRedisBean> requestExist = new RsRequest<>();
        FavoritesRedisBean existBean = new FavoritesRedisBean();
        existBean.setDbNumber(NumberConst.IntDef.INT_NINE);
        existBean.setKey(this.userId + this.sysCode);
        requestExist.setParam(existBean);
        // 获取接口
        String checkUrl = StringUtil.formatMessage("{0}/api/favorites/_load", ConfigManager.getFavoritesUrl());
        RsResponse<HashMap<String,String>> responseMap = RestClientUtil.post(checkUrl, requestExist, new TypeReference<RsResponse<HashMap<String, String>>>() {
        });

        Map<String, String> mapGet = responseMap.getResult();

        JspWriter out = this.getJspContext().getOut();
        StringBuffer buttonHtml = new StringBuffer();
        if(null == mapGet || mapGet.size() == 0){
            buttonHtml.append("<li style='color: darkgreen;' class='last'>");
            buttonHtml.append("点击收藏夹，添加你想收藏的一览画面！");
            buttonHtml.append("</li>");
        } else {
            for (String key : mapGet.keySet()) {
                buttonHtml.append("<li style='color: skyblue;' class='last'><a href='");
                buttonHtml.append(key);
                buttonHtml.append("' target='ajax' rel='main-content'>");
                buttonHtml.append("<span style='background: url(" + getRequest().getContextPath() + "/static/images/action/lost.png) no-repeat center;'></span>");
                buttonHtml.append(mapGet.get(key));
                buttonHtml.append("</a><span><img style='margin-left: 3px;margin-top: -2px;' src='" + getRequest().getContextPath() + "/static/images/action/close.png' alt='删除'></span></li>");
            }
        }
        out.write(buttonHtml.toString());
    }

    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {

        if (attrMap == null) {
            attrMap = new HashMap<String, String>();
        }
        attrMap.put(localName, value.toString());
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public Map<String, String> getAttrMap() {
        return attrMap;
    }

    public void setAttrMap(Map<String, String> attrMap) {
        this.attrMap = attrMap;
    }
}
