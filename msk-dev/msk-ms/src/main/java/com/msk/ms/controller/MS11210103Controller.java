package com.msk.ms.controller;
import com.msk.core.web.base.*;
import com.msk.ms.logic.*;
import com.msk.core.entity.MsCardmanager;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.io.InputStream;
/**
 * 会员卡发卡签收管理表
 * @author fjm 
 *
 */
@Controller
@RequestMapping("MS11210103")
public class MS11210103Controller extends BaseController{
    
    @Autowired 
    private MS11210103Logic mS11210103Logic;

    /**
     * 下载打印excel
     * @param request 请求
     * @param response 响应
     * @param msId 传入msId
     * @throws java.io.IOException 异常抛出
     */
    @RequestMapping(value="downExcel/{msId}",method=RequestMethod.POST)
    public void download(@PathVariable String msId,HttpServletRequest request,HttpServletResponse response) throws IOException{
       
        MsCardmanager msCardmanager = this.mS11210103Logic.mS11210103Entity(msId);
       /**
        * 获取excel模板在工程项目里面的地址
        */
      // String path = request.getSession().getServletContext().getRealPath("/")+"WEB-INF/resources/images/会员卡发卡签收管理表模板.xlsx";
      //  String paths=request.getSession().getServletContext().getAttribute("fileSerUrl").toString()+"/MemberShip/会员卡发卡签收管理表模板.xlsx";
        String paths=request.getSession().getServletContext().getAttribute("fileSerUrl").toString()+"/MemberShip/";
        String fileName="会员卡发卡签收管理表模板.xlsx";
        String encoded = URLEncoder.encode(fileName, "UTF-8");
        URL url=new URL(paths+encoded);
        HttpURLConnection connect = (HttpURLConnection)url.openConnection();
        connect.setRequestMethod("GET");
        InputStream fs=connect.getInputStream();

       /**
        * input流读取模板信息
        */
      // FileInputStream fs=new FileInputStream(paths);
       
       /**
        * poi对象获取模板信息
        */
       XSSFWorkbook xwb = new XSSFWorkbook(fs);
       XSSFSheet sheet=xwb.getSheetAt(0);
       XSSFRow row=sheet.getRow(1);
       XSSFRow row1=sheet.getRow(2);
       
       /**
        * 填入数据库查询的数据
        */
       row.getCell(2).setCellValue(msCardmanager.getMsCardno());
       row1.getCell(2).setCellValue(msCardmanager.getBuyerCode());
       row1.getCell(6).setCellValue(msCardmanager.getBuyerName());
       
       /**
        * 先放入缓冲流
        */
       ByteArrayOutputStream baos = new ByteArrayOutputStream();
       baos.flush();
       xwb.write(baos);
       baos.close();
        fs.close();
        connect.disconnect();
       
       /**
        * 设置页面下载弹窗信息
        */
       String returnName="会员卡发卡签收管理表.xlsx";
       returnName = response.encodeURL(new String(returnName.getBytes(),"iso8859-1")); //保存的文件名先转码
       response.setHeader("content-disposition", "attachment;filename=" + returnName);
       response.setContentLength(baos.size());
       
       /**
        * 最后输出到OutputStream
        */
       OutputStream outputstream = response.getOutputStream();  //取得输出流
       baos.writeTo(outputstream);                    //写到输出流
       baos.close();                                  //关闭
       outputstream.flush();  
        }
}
