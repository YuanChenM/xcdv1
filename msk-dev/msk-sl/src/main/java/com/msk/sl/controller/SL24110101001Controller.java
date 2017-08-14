package com.msk.sl.controller;

import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseUploadController;
import com.msk.sl.bean.SlEpAgentAuthBean;
import com.msk.sl.logic.SL241103010Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by writer on 2016/1/27.
 */
@Controller
@RequestMapping("SL24110101001")
public class SL24110101001Controller extends BaseUploadController {

    @Autowired
    private SL241103010Logic sl241103010Logic;

    /**
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("save")
    public
    @ResponseBody
    int insert2(SlEpAgentAuthBean slEpAgentAuthBean, HttpServletResponse response, HttpServletRequest request) throws IOException {
        //根据brandName和epId来查找数据库是否存在
        if (null == request.getSession().getAttribute("jsp_epId2") || "".equals(request.getSession().getAttribute("jsp_epId2"))) {
            throw new BusinessException("已失效,请重新进入");
        }
        Long epid = (Long) request.getSession().getAttribute("jsp_epId2");
        //不存在账户，那么就新增即可
        if (null == request.getSession().getAttribute("jsp_slCode") || "".equals(request.getSession().getAttribute("jsp_slCode"))) {
            throw new BusinessException("请先创建账号信息");
        }
        String slCode = request.getSession().getAttribute("jsp_slCode").toString();
        slEpAgentAuthBean.setCrtId(super.getLoginUser().getCrtId());
        int num = sl241103010Logic.saveData(slCode, slEpAgentAuthBean);
        int count=0;
        if (num > 0) {
            count = NumberConst.IntDef.INT_ONE;
        }
        return count;
    }


    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init() {
        return "sl/SL24110101001";
    }
}
