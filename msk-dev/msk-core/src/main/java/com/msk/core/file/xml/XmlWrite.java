package com.msk.core.file.xml;

import com.msk.core.exception.SystemException;
import com.msk.core.file.FileUtils;
import com.msk.core.file.xml.bean.EntityTemplate;
import com.msk.core.file.xml.bean.ListTemplate;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 根据Freemarker模板生成Xml文件
 * *@author jiang_nan
 * *@version 1.0
 **/
public class XmlWrite<T> {
    private static Logger logger = LoggerFactory.getLogger(XmlWrite.class);
    private  Configuration config = null;
    private String templateFile;

    private ListTemplate<T> listTemplate;

    private EntityTemplate<T> entityTemplate;

    public XmlWrite(ListTemplate<T> listTemplate){
        this.listTemplate = listTemplate;
    }

    public XmlWrite(EntityTemplate<T> entityTemplate){
        this.entityTemplate = entityTemplate;
    }



    public String createXmlString(Object object,Class templateClass){
        try {
            JAXBContext jc = JAXBContext.newInstance(templateClass);
            Marshaller ms = jc.createMarshaller();
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            StringWriter writer = new StringWriter();
            ms.marshal(object, writer);
            String xml = writer.toString();
            logger.info("输出XML:"+xml);
            return xml;
        } catch (JAXBException e) {
            e.printStackTrace();
            logger.error("生成XML失败:"+e.getMessage());
        }
        return null;
    }

    public InputStream createEntityTemplateXml(Class entityTemplateClass){
        String xml = this.createXmlString(this.entityTemplate,entityTemplateClass);
        logger.info("输出XML:"+xml);
        return new ByteArrayInputStream(xml.getBytes());
    }

    public InputStream createListTemplateXml(Class listTemplateClass){
        String xml = this.createXmlString(this.listTemplate,listTemplateClass);
        logger.info("输出XML:"+xml);
        return new ByteArrayInputStream(xml.getBytes());
    }


    /**
     * 默认构造函数
     * @param templatePatch 模板目录
     * @param templateFile 模板文件
     */
    public XmlWrite(String templatePatch,String templateFile){
        this.templateFile = templateFile;
        config = new Configuration();
        config.setClassForTemplateLoading(this.getClass(),templatePatch);
        //config.setDirectoryForTemplateLoading(new File(templatePatch));
        config.setDefaultEncoding("UTF-8");
//        try {
//            config.setClassForTemplateLoading(this.getClass(),templatePatch);
//            //config.setDirectoryForTemplateLoading(new File(templatePatch));
//            config.setDefaultEncoding("UTF-8");
//        } catch (IOException e) {
//           throw new SystemException(e);
//        }
    }

    /**
     * 根据模板文件生成输出XML文件。返回生成的XML文件路径
     * @param entity 传入参数
     * @param outputFile 输出文件名称
     * @return 生成的XML文件路径
     */
    public String createXml(T entity,String outputFile){
        BufferedWriter writer = null;
        String fileTemp = FileUtils.getSystemTmpDir() + File.separator + outputFile;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileTemp), "UTF-8"));
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("entity", entity);
            Template tpl = config.getTemplate(templateFile);
            tpl.setEncoding("UTF-8");
            tpl.process(paramMap, writer);
        } catch (UnsupportedEncodingException e) {
            throw new SystemException(e);
        } catch (FileNotFoundException e) {
            throw new SystemException(e);
        } catch (IOException e) {
            throw new SystemException(e);
        } catch (TemplateException e) {
            throw new SystemException(e);
        } finally {
            if (null != writer) {
                try {
                    writer.flush();
                    writer.close();
                }catch (IOException e){
                    throw new SystemException(e);
                }
            }
        }
        return fileTemp;
    }
}
