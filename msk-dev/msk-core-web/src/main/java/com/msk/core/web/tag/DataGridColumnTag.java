package com.msk.core.web.tag;

import com.msk.core.web.base.BaseTag;
import com.msk.core.web.bean.DataGridColumn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.JspTag;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * DataGridColumnTag
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class DataGridColumnTag extends BaseTag implements DynamicAttributes {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(DataGridColumnTag.class);
    private String colType;
    private String name;
    private boolean filter;
    private boolean edit;
    private String title;
    private Map<String,Object> attrMap;
    @Override
    protected void doTag(HttpServletRequest request) throws JspException, IOException {
        logger.debug("生成子节点");
        JspTag superTag = findAncestorWithClass(this, DataGridTag.class);
        DataGridTag parent = (DataGridTag) superTag;
        DataGridColumn column = new DataGridColumn(colType,name,filter,edit,title,attrMap);
        parent.getColumnList().add(column);
    }

    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        if(this.attrMap==null){
            this.attrMap = new HashMap<String,Object>();
        }
        attrMap.put(localName, value);
    }
    /**
     * Get Filter
     * @return filter
     */
    public boolean isFilter(){
        return this.filter;
    }
    /**
     * Get edit
     * @return edit
     */
    public boolean isEdit(){
        return this.edit;
    }
    /**
     * Setter method for property <tt>filter</tt>.
     *
     * @param filter value to be assigned to property filter
     */
    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    /**
     * Setter method for property <tt>edit</tt>.
     *
     * @param edit value to be assigned to property edit
     */
    public void setEdit(boolean edit) {
        this.edit = edit;
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
     * Getter method for property <tt>attrMap</tt>.
     *
     * @return property value of attrMap
     */
    public Map<String, Object> getAttrMap() {
        return attrMap;
    }

    /**
     * Setter method for property <tt>attrMap</tt>.
     *
     * @param attrMap value to be assigned to property attrMap
     */
    public void setAttrMap(Map<String, Object> attrMap) {
        this.attrMap = attrMap;
    }

    /**
     * Getter method for property <tt>colType</tt>.
     *
     * @return property value of colType
     */
    public String getColType() {
        return colType;
    }

    /**
     * Setter method for property <tt>colType</tt>.
     *
     * @param colType value to be assigned to property colType
     */
    public void setColType(String colType) {
        this.colType = colType;
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


}
