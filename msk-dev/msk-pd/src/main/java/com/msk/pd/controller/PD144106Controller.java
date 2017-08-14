package com.msk.pd.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.msk.common.logic.LogisticsAreaLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.SystemConst;
import com.msk.core.entity.MdLogisticsArea;
import com.msk.core.utils.DbUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseUploadController;
import com.msk.pd.bean.PD144106Bean;
import com.msk.pd.bean.PD144106Param;
import com.msk.pd.bean.PD144107Param;
import com.msk.pd.logic.PD144106Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yang_chunyan on 2016/10/28.
 */
@Controller
@RequestMapping(value = "PD144106")
public class PD144106Controller extends BaseUploadController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(PD141121Controller.class);

    @Autowired
    private PD144106Logic pd144106Logic;
    @Autowired
    private LogisticsAreaLogic logisticsAreaLogic;

    /**
     * 实例化页面
     *
     * @param model 参数
     * @return 页面
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model) throws UnsupportedEncodingException {
        logger.debug("产品上下架页面初始化");
        List<MdLogisticsArea> logisticsAreas = this.logisticsAreaLogic.findList(new BaseParam());
        model.addAttribute("logisticsAreas",logisticsAreas);
        return "pd/PD144106";
    }


    /**
     * 分页查询数据
     *
     * @param param pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public @ResponseBody
    PageResult<PD144106Bean> search(BasePageParam param) {
        logger.debug("分页查询物流区产品信息");
        DbUtils.buildLikeCondition(param, "pdName", DbUtils.LikeMode.PARTIAL);
        return pd144106Logic.findPage(param, PD144106Bean.class);
    }

    /**
     * 更新物流区产品状态
     * @param param
     * @return
     */
    @RequestMapping(value = "update",
            method = RequestMethod.POST)
    @ResponseBody
    public String update(PD144106Param param){
        int count = pd144106Logic.modify(param);
        if(count >= NumberConst.IntDef.INT_ONE){
            return SystemConst.RsStatus.SUCCESS;
        }
        return SystemConst.RsStatus.FAIL;
    }

}
