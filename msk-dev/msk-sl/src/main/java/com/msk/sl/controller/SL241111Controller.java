package com.msk.sl.controller;

import com.msk.common.logic.CommonLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.StringConst;
import com.msk.core.entity.SlDistReguChap;
import com.msk.core.exception.BusinessException;
import com.msk.core.file.FtpUtils;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.SL241109Bean;
import com.msk.sl.bean.SLUploadFile;
import com.msk.sl.logic.SL241109Logic;
import com.msk.sl.logic.SL241111Logic;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 编辑章程
 * @author gyh
 */
@Controller
@RequestMapping("SL241111")
public class SL241111Controller extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SL241111Controller.class);
    @Autowired
    private SL241111Logic sl241111Logic;
    @Autowired
    private SL241109Logic sl241109Logic;
    @Autowired
    private CommonLogic commonLogic;

    @RequestMapping(value = "init/{chapClass}", method = RequestMethod.POST)
    public String init(Model model, @RequestParam(required = false) String chapId,@PathVariable(value = "chapClass")String chapClass) {
        logger.debug("编辑章程");
        SL241109Bean sL241109Bean = new SL241109Bean();
        String isAdd="add";
        if (!"".equals(chapId) && null != chapId) {
            isAdd="update";
            if (this.isDebug) {
                sL241109Bean.setChapNo(1);
                sL241109Bean.setChapTitle("关于神农客商城分销");
                sL241109Bean.setContentHref("神农客商城分销章节第二版12.7-发文_第一章.mht");
            } else {
                BasePageParam pageParam = new BasePageParam();
                pageParam.setPaging(false);
                pageParam.setFilter("chapId", chapId);
                pageParam.setFilter("chapClass",chapClass);
                List<SL241109Bean> rcplist = sl241109Logic.findPageList(pageParam, SL241109Bean.class);
                if (!CollectionUtils.isEmpty(rcplist)) {
                    sL241109Bean = rcplist.get(0);
                    String uploadFilePath = BusinessConst.SLPath.SERVICEIMAGEPATH + "/" + BusinessConst.SLPath.SLSLDISTREGUCHAP;
                    String uploadFileName = StringUtil.toSafeString(chapClass+"_"+sL241109Bean.getChapNo());
                    SLUploadFile slUploadFile = new SLUploadFile();
                    String content = slUploadFile.findSlDistReguChapByFtp(uploadFilePath, uploadFileName);
                    sL241109Bean.setContent(content);
                }
            }
        }
        model.addAttribute("chapClass",chapClass);
        model.addAttribute("sL241109Bean", sL241109Bean);
        model.addAttribute("isAdd",isAdd);
        return "sl/SL241111";
    }

    @RequestMapping(value = "save/{isAdd}/{chapClass}", method = RequestMethod.POST)
    public String save(SL241109Bean sL241109Bean,@PathVariable(value = "isAdd")String isAdd,@PathVariable(value = "chapClass")String chapClass) {
        if("add".equals(isAdd)){
            BasePageParam pageParam = new BasePageParam();
            pageParam.setPaging(false);
            pageParam.setFilter("chapNo",StringUtil.toSafeString(sL241109Bean.getChapNo()));
            pageParam.setFilter("chapClass",chapClass);
            List<SL241109Bean> rcplist = sl241109Logic.findPageList(pageParam, SL241109Bean.class);
            if (!CollectionUtils.isEmpty(rcplist)) {
                throw new BusinessException("该章节已存在！请重新编辑。");
            }
            int maxId=commonLogic.maxId("sl_dist_regu_chap", "CHAP_ID").intValue();
            sL241109Bean.setChapId(maxId);
            sL241109Bean.setDelFlg("0");
            sL241109Bean.setChapClass(chapClass);
            logger.debug("新增章节");
            sL241109Bean.setCrtId(this.getLoginUser().getCrtId());
            sl241111Logic.save(sL241109Bean);
        }else{
            logger.debug("修改章节");
            sL241109Bean.setUpdId(this.getLoginUser().getUpdId());
            sl241111Logic.modify(sL241109Bean);
        }
        //分销章程内容文件路径
        String uploadFilePath = BusinessConst.SLPath.SERVICEIMAGEPATH + "/" + BusinessConst.SLPath.SLSLDISTREGUCHAP;
        String uploadFileName = chapClass+"_"+StringUtil.toSafeString(sL241109Bean.getChapNo());
        String content=sL241109Bean.getContent();
        if(!StringUtil.isNullOrEmpty(content)){
            content=content.replace("<p>\t\t\t","");
            content=content.replace("\n\t\t</p>","");
            SLUploadFile slUploadFile = new SLUploadFile();
            slUploadFile.saveSlDistReguChapToFtp(uploadFilePath, uploadFileName, content);
        }
        return "sl/SL241111";
    }
}
