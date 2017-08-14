package com.msk.sl.controller;

import java.util.ArrayList;
import java.util.List;

import com.msk.core.bean.BasePageParam;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.SL241109Bean;
import com.msk.sl.bean.SLUploadFile;
import com.msk.sl.logic.SL241109Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msk.sl.logic.Sl241113Logic;

/**
 * 分销章程预览Controller.
 *
 * @author gyh
 */
@Controller
@RequestMapping(value = "SL241113")
public class SL241113Controller extends BaseController {
    @Autowired
    private Sl241113Logic sl241113Logic;
    @Autowired
    private SL241109Logic sl241109Logic;
    /**
     * 实例化页面
     *
     * @return分销章程预览页面
     */
    @RequestMapping(value = "init/{chapClass}", method = RequestMethod.POST)
    private String init(Model model,@PathVariable(value = "chapClass")String chapClass) {
        List<SL241109Bean> info=null;
        if(this.isDebug){
            info = sl241113Logic.getListInfo();
        }else{
            BasePageParam basePageParam=new BasePageParam();
            basePageParam.setPaging(false);
            basePageParam.setFilter("chapClass",chapClass);
            info=sl241109Logic.findPageList(basePageParam, SL241109Bean.class);
            String uploadFilePath = BusinessConst.SLPath.SERVICEIMAGEPATH + "/" + BusinessConst.SLPath.SLSLDISTREGUCHAP;
            for (SL241109Bean sl241109Bean:info){
                String uploadFileName = chapClass+"_"+StringUtil.toSafeString(sl241109Bean.getChapNo());
                SLUploadFile slUploadFile = new SLUploadFile();
                String content = slUploadFile.findSlDistReguChapByFtp(uploadFilePath, uploadFileName);
                sl241109Bean.setContent(content);
            }
        }
        model.addAttribute("info", info);
        return "sl/SL241113";
    }
}
