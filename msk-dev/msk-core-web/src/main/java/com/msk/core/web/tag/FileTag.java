package com.msk.core.web.tag;

import com.msk.core.file.FileUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

/**
 * FileTag
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class FileTag extends BaseTag {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(FileTag.class);
    private String fileName;
    private String fileType;
    private String modular;
    private Boolean editmodel = Boolean.TRUE;
    private String name;
    private String id;
    private String title;
    /** 实际文件前缀, 如业务单号,非必须 */
    private String prefix;
    @Override
    protected void doTag(HttpServletRequest request) throws JspException, IOException {
        String contextPath = request.getContextPath();
        StringBuffer html = new StringBuffer();
        String aTagId = "file"+System.nanoTime();
        String fileSuffix = FileUtils.getFileSuffix(fileName);
        if(!StringUtil.isEmpty(this.fileName)){
            String href = fileName;
            if (!StringUtil.isEmpty(this.title)) {
                html.append("<a id='" + aTagId + "' class='tooltip'  title='" + this.title + "' href='" + href + "' target='_blank' src='" + href + "'>" + this.title + "</a>");
            } else {
                html.append("<a id='" + aTagId + "' class='tooltip'  title='" + fileName + "' href='" + href + "' target='_blank' src='" + href + "'>" + this.fileName + "</a>");
            }
        }
        JspWriter out = this.getJspContext().getOut();
        out.write(html.toString());
    }

    /**
     * Getter method for property <tt>fileName</tt>.
     *
     * @return property value of fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Setter method for property <tt>fileName</tt>.
     *
     * @param fileName value to be assigned to property fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Getter method for property <tt>fileType</tt>.
     *
     * @return property value of fileType
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * Setter method for property <tt>fileType</tt>.
     *
     * @param fileType value to be assigned to property fileType
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * Getter method for property <tt>modular</tt>.
     *
     * @return property value of modular
     */
    public String getModular() {
        return modular;
    }

    /**
     * Setter method for property <tt>modular</tt>.
     *
     * @param modular value to be assigned to property modular
     */
    public void setModular(String modular) {
        this.modular = modular;
    }

    /**
     * Getter method for property <tt>editmodel</tt>.
     *
     * @return property value of editmodel
     */
    public Boolean getEditmodel() {
        return editmodel;
    }

    /**
     * Setter method for property <tt>editmodel</tt>.
     *
     * @param editmodel value to be assigned to property editmodel
     */
    public void setEditmodel(Boolean editmodel) {
        this.editmodel = editmodel;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>title</tt>.
     *
     * @return property value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter method for property <tt>title</tt>.
     *
     * @param title value to be assigned to property title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter method for property <tt>prefix</tt>.
     *
     * @return property value of prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Setter method for property <tt>prefix</tt>.
     *
     * @param prefix value to be assigned to property prefix
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}

