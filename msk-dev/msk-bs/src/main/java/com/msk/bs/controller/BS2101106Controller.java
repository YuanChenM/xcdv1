package com.msk.bs.controller;

import com.msk.bs.bean.BS2101105Bean;
import com.msk.bs.bean.IBS2101102RsParam;
import com.msk.bs.logic.BS2101106Logic;
import com.msk.bs.logic.BSCommLogic;
import com.msk.bs.logic.IBS2101102RsLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.entity.*;
import com.msk.core.file.FileUploadUtil;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseUploadController;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 买手账号信息编辑
 *
 * @author cx
 */
@Controller
@RequestMapping(value = "BS2101106")
public class BS2101106Controller extends BaseUploadController {

    private static Logger logger = LoggerFactory.getLogger(BS2101106Controller.class);

    @Autowired
    private BSCommLogic bSCommLogic;
    @Autowired
    private IBS2101102RsLogic ibs2101102RsLogic;
    @Autowired
    private BS2101106Logic bs2101106Logic;

    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init(SlSeller slSeller, SlBuyershop slBuyershop, BS2101105Bean bs2101105Bean, Model model) {
        logger.debug("买手基本信息编辑");
        if (isDebug) {
            return null;
        }
        //地区回显
        BaseParam baseParam = new BaseParam();
        List<MdProvince> mdProvinces = this.bSCommLogic.findMdProvinces(baseParam);
        List<MdCity> cityList = null;
        List<MdDistrict> mdDistrictList = null;
        String provinceId = "";
        String cityId = "";
        if (null != slSeller) {
            for (int i = 0; i < mdProvinces.size(); i++) {
                MdProvince mdProvince = mdProvinces.get(i);
                if (mdProvince.getProvinceCode().equals(slSeller.getProvinceCode())) {
                    provinceId = StringUtil.toSafeString(mdProvince.getProvinceId());
                }
            }
            cityList = this.bSCommLogic.findCityList(provinceId);
            for (int i = 0; i < cityList.size(); i++) {
                MdCity mdCity = cityList.get(i);
                if (mdCity.getCityCode().equals(slSeller.getCityCode())) {
                    cityId = StringUtil.toSafeString(mdCity.getCityId());
                }
            }
        }
        mdDistrictList = bSCommLogic.findDistrictList(cityId);
        String flagNum = bs2101105Bean.getFlagNum();
        model.addAttribute("mdProvinces", mdProvinces);
        model.addAttribute("cityList", cityList);
        model.addAttribute("mdDistrictList", mdDistrictList);

        model.addAttribute("slSeller", slSeller);
        model.addAttribute("slBuyershop", slBuyershop);
        model.addAttribute("bs2101105Bean", bs2101105Bean);
        model.addAttribute("flagNum", flagNum);

        return "bs/BS2101106";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void update(MultipartFile file, SlSeller slSeller, SlBuyershop slBuyershop, BS2101105Bean bs2101105Bean, HttpServletRequest request, HttpServletResponse response) throws IOException {
        RsRequest<IBS2101102RsParam> param = new RsRequest<IBS2101102RsParam>();
        param.setLoginId(this.getLoginUser().getUpdId());
        IBS2101102RsParam ibs2101102RsParam = new IBS2101102RsParam();
        param.setParam(ibs2101102RsParam);

        String slAccount2 = (String) request.getSession().getAttribute("slAccount1");

        if(null == slAccount2 || "".equals(slAccount2)){

            String slAccount = bs2101105Bean.getSlAccount();
            slSeller.setSlAccount(slAccount);
        }else {
            slSeller.setSlAccount(slAccount2);
        }
        //设置买手主分类4
        slSeller.setSlMainClass(4);
        if (file.getSize() > 0) {
            String imgPath = ImgUpload(file);
            slSeller.setMemo8(imgPath);
        }
        param.getParam().setSlSeller(slSeller);

        BaseParam baseParam = new BaseParam();
        String slCode = slBuyershop.getSlCode();
        baseParam.setFilter("slCode", slCode);
        //判断sl_buyershop 是否存在 如不存在设置slcode为“” 接口会走新增操作
        int num = bs2101106Logic.findSlBuyerhop(baseParam);
        if (num <= 0) {
            slBuyershop.setSlCode("");
        }
        param.getParam().setSlBuyerShop(slBuyershop);
        ibs2101102RsLogic.editAccount(param);

        super.callBack(null, "保存成功", response);
    }

    public static String ImgUpload(MultipartFile file) throws IOException {
        //MultipartFile转换为file
        MultipartFile multipartFile = file;
        CommonsMultipartFile cf = (CommonsMultipartFile) multipartFile;
        DiskFileItem fi = (DiskFileItem) cf.getFileItem();
        File file1 = fi.getStoreLocation();

        HashMap<String, File> map = new HashMap<String, File>();
        map.put("fileImg", file1);
        Map<String, String> result = FileUploadUtil.uploadFiles(map);
        String imgString = result.toString();
        String imgName = imgString.substring(imgString.indexOf("=") + 1, imgString.indexOf("}"));
        String imgPath = "http://t-file.xianchida.com/_download/" + imgName;
        return imgPath;
    }
}
