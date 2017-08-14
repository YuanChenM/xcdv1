package com.msk.bs.controller;

import com.msk.bs.bean.BS2101105Bean;
import com.msk.bs.bean.IBS2101102RsParam;
import com.msk.bs.logic.BS2101107Logic;
import com.msk.bs.logic.BSCommLogic;
import com.msk.bs.logic.IBS2101102RsLogic;
import com.msk.core.bean.RsRequest;
import com.msk.core.entity.MdCity;
import com.msk.core.entity.MdDistrict;
import com.msk.core.entity.MdProvince;
import com.msk.core.entity.SlAccount;
import com.msk.core.file.FileUploadUtil;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseUploadController;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping(value = "BS2101105")
public class BS2101105Controller extends BaseUploadController {

    private static Logger logger = LoggerFactory.getLogger(BS2101105Controller.class);

    @Autowired
    private IBS2101102RsLogic ibs2101102RsLogic;
    @Autowired
    private BSCommLogic bsCommLogic;
    @Autowired
    private BS2101107Logic bs2101107Logic;

    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init(/*SlAccount slAccount,SlSeller slSeller,SlShopInfo slShopInfo,SlBuyershop slBuyershop,*/BS2101105Bean bs2101105Bean,Model model) {
        logger.debug("买手账号信息编辑");
        if (isDebug) {
            return null;
        }
        model.addAttribute("bs2101105Bean",bs2101105Bean);
        return "bs/BS2101105";
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void update(MultipartFile file,SlAccount slAccount,HttpServletResponse response,HttpServletRequest request) throws IOException {
        RsRequest<IBS2101102RsParam> param = new RsRequest<IBS2101102RsParam>();
        param.setLoginId(this.getLoginUser().getUpdId());
        IBS2101102RsParam ibs2101102RsParam=new IBS2101102RsParam();
        param.setParam(ibs2101102RsParam);
        String slAccount1 = slAccount.getSlAccount();
        //将account信息放进session里面
        request.getSession().setAttribute("slAccount1", slAccount1);

        if (file.getSize() > 0) {
            String imgPath = ImgUpload(file);
            slAccount.setAccountImg(imgPath);
        }
        param.getParam().setSlAccount(slAccount);
        ibs2101102RsLogic.editAccount(param);
        super.callBack(null,"保存成功",response);
    }

    /**
     * 根据provinceId查询地市
     * @param provinceCode 省Code
     * @return
     */
    @RequestMapping(value = "findCity", method = RequestMethod.POST)
    public @ResponseBody
    List<MdCity> findCity(String provinceCode) {
        MdProvince mdProvince = this.bs2101107Logic.findProvince(provinceCode);
        return this.bsCommLogic.findCityList(StringUtil.toSafeString(mdProvince.getProvinceId()));
    }

    /**
     * 根据cityId查询地市
     * @param cityCode 省Id
     * @return
     */
    @RequestMapping(value = "findDistrict", method = RequestMethod.POST)
    public @ResponseBody List<MdDistrict> findDistrict(String cityCode) {
        MdCity mdCity = this.bs2101107Logic.findCity(cityCode);
        return this.bsCommLogic.findDistrictList(StringUtil.toSafeString(mdCity.getCityId()));
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
