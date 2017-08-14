package com.msk.ms.controller;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.*;
import com.msk.core.file.excel.*;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.ms.bean.MS112102Bean;
import com.msk.ms.logic.MS112102Logic;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * SO151502Controller
 * 会员卡台账信息上传
 * @author jiang_nan
 * @version 1.0
 **/
@Controller
@RequestMapping("MS112102")
public class MS112102Controller extends BaseUploadController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(MS112102Controller.class);
    @Autowired
    private MS112102Logic ms112102Logic;
    /** 读取上传的excel表格数据列数 */
    Integer col= NumberConst.IntDef.INT_FOUR;

    /**
     * Popu 弹出页面信息
     *
     * @return 会员卡上传信息
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init() {
        return "ms/MS112102";
    }

    /**
     * @param file 上传的文件
     * @throws java.io.IOException 抛出IO异常
     * @param response 响应
     *
     */
    @RequestMapping(value = "upload",
            method = RequestMethod.POST)
    public void upload(MultipartFile file, HttpServletResponse response) throws IOException {
        if (isDebug) {
            logger.info("假数据");
            super.callBack(null, "会员卡信息上传成功", response);
        } else {
            //读取上传Excel表格数据信息
            Workbook workbook = this.createWorkbook(file);
            PoiExcelRead read = new PoiExcelRead(workbook, 0, 0);
            List<MS112102Bean> dataList = read.readExcel(new MS112102BeanReadExcelColumn());
            MS112102Bean ms112102Bean = dataList.get(0);
            if(!("采购批次".equals(ms112102Bean.getPurchaseLot()) && "卡号".equals(ms112102Bean.getMsCardno()) && "初始密码".equals(ms112102Bean.getMsInitpw()) && "是否已激活".equals(ms112102Bean.getIsActivate()))){
                throw new BusinessException("文件格式不对，请参考台账模板录入");
            }

            //将读取的信息保存到数据库
            String result = this.ms112102Logic.saveDataList(dataList);
            if ("uploadSuccess".equals(result)) {
                super.callBack(null, "会员卡信息上传成功", response);
            } else {
                super.callBack(null, "会员卡信息上传失败", response);
            }
        }

    }

    /***
     * 定义SO151502BeanReadExcelColumn 实现ExcelReadColumn<T>
     * 读取excel整行数据
     * 将其封装在SO151502Bean对象中
     */
    class MS112102BeanReadExcelColumn implements ExcelReadColumn<MS112102Bean> {

        /**
         * 复写readColumn方法
         *
         * @return SO151502Bean 将每一行数据封装到SO151502Bean对象返回
         * @param row excel中一行数据
         */
        @Override
        public MS112102Bean readColumn(Row row) {
            int index = 0;
            if(row.getPhysicalNumberOfCells()>col){
                throw new  BusinessException("文件格式不对，请参考台账模板录入");
            }
            MS112102Bean ms112102Bean = new MS112102Bean();
            String purchaseLot=row.getCell(index++).getStringCellValue();
            if(StringUtil.isNullOrEmpty(purchaseLot.trim())){
                throw new BusinessException("采购批次不可为空，请确认后录入");
            }
            ms112102Bean.setPurchaseLot(purchaseLot);
            String msCardno=row.getCell(index++).getStringCellValue();
            if(StringUtil.isNullOrEmpty(msCardno.trim())){
                throw new BusinessException("卡号不能为空，请确认后录入");
            }
            ms112102Bean.setMsCardno(msCardno.trim());
            String password = row.getCell(index++).getStringCellValue();
            if (StringUtil.isNullOrEmpty(password.trim())) {
                throw new BusinessException("初始密码不能为空,请确认后录入");
            }
            ms112102Bean.setMsInitpw(password);
            String isActivate = row.getCell(index++).getStringCellValue();
            if(StringUtil.isNullOrEmpty(isActivate.trim())){
                throw new BusinessException("是否已激活不能为空，请确认后录入");
            }
            ms112102Bean.setIsActivate(isActivate);
            return ms112102Bean;
        }
//        @Override
//        public MS112102Bean readColumn(Row row) {
//            int index = 0;
//            if(row.getPhysicalNumberOfCells()>col){
//                throw new  BusinessException("文件格式不对，请参考台账模板录入");
//            }
//            MS112102Bean ms112102Bean = new MS112102Bean();
//            ms112102Bean.setPurchaseLot(row.getCell(index++).getStringCellValue());
//            ms112102Bean.setMsCardno(row.getCell(index++).getStringCellValue());
//            String password = row.getCell(index++).getStringCellValue();
//            // 使用DES加密
//            if (!StringUtil.isNullOrEmpty(password.trim())) {
//                password = ms112102Logic.encryDES(password.getBytes(), key);
//            } else {
//                throw new BusinessException("初始密码不能为空");
//            }
//            //初始化密码
//            ms112102Bean.setMsInitpw(password);
//            //传入初始密码时，将初始密码设置成为当前密码
//            ms112102Bean.setMsNowpw(password);
//            String isActivate = row.getCell(index++).getStringCellValue();
//            if (!StringUtil.isNullOrEmpty(isActivate)) {
//                if ("是".equals(isActivate.trim())) {
//                    ms112102Bean.setIsActivate("0");
//                } else {
//                    ms112102Bean.setIsActivate("1");
//                }
//            }
//            return ms112102Bean;
//        }
    }

}
