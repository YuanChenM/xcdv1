package com.msk.by.controller;

import com.msk.by.bean.IBY121207RsParam;
import com.msk.by.logic.BY12130401Logic;
import com.msk.common.logic.CommonLogic;
import com.msk.core.entity.ByBuyerEmployee;
import com.msk.core.entity.CommConstant;
import com.msk.core.utils.ConfigManager;
import com.msk.core.web.base.BaseController;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 买家雇员信息编辑画面
 *
 * @author yuan_chen
 */
@Controller
@RequestMapping("BY12130401")
public class BY12130401Controller extends BaseUploadController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(BY12130401Controller.class);

    @Autowired
    private BY12130401Logic by12130401Logic;
    @Autowired
    private CommonLogic commonLogic;
    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init/{editType}",
        method = RequestMethod.POST)
    public String init(@PathVariable("editType") String editType,ByBuyerEmployee byBuyerEmployee,Model model) {
        logger.debug("买家雇员信息编IBY121207RsParam辑画面");
        List<IBY121207RsParam> employeeList = new ArrayList<>();
        if(!("BY121307Add".equals(editType)) && !("BY121304Add".equals(editType))){
            employeeList = by12130401Logic.buyerEmployeeFind(byBuyerEmployee);
            if(!CollectionUtils.isEmpty(employeeList)){
                model.addAttribute("buyerEmployee",employeeList.get(0));
            }
        }
        //员工类型
        List<CommConstant> employeeTypeList = commonLogic.findConstantList("EmployeeType");
        model.addAttribute("employeeTypeList",employeeTypeList);
        model.addAttribute("id",byBuyerEmployee.getId());
        model.addAttribute("buyerId",byBuyerEmployee.getBuyerId());
        model.addAttribute("editType",editType);
        return "by/BY12130401";
    }

    /**
     * 买家雇员信息编辑保存
     * @param byBuyerEmployee
     * @return
     */
    @RequestMapping(value = "save",
            method = RequestMethod.POST)
    public void saveChange(MultipartFile busCardPic,IBY121207RsParam byBuyerEmployee,HttpServletResponse response) throws IOException{
        //买家图片上传共通对象
        BY121106Controller by121106Controller = new BY121106Controller();
        //图片上传临时文件路径
        String http = "http://";
        String url = ConfigManager.getFtpIp();
        String uploadTempFilePath = ConfigManager.getFtpImageRootPath() + BusinessConst.BYPath.TEMPIMAGEPATH + "/" + byBuyerEmployee.getBuyerId() +"/";
        //雇员名片照上传
        if(busCardPic.getSize() != 0){
            String busCardPicName = this.getFileName(busCardPic);
            by121106Controller.picFileUpload(byBuyerEmployee.getBuyerId(),busCardPic);
            byBuyerEmployee.setBusCardPicPath(http + url + uploadTempFilePath + busCardPicName);
        }
        int updateCount = by12130401Logic.buyerEmployeeModify(byBuyerEmployee);

        super.callBack(null, "保存成功", response);
    }
}
