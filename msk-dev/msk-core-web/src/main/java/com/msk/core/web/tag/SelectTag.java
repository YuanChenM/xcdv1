package com.msk.core.web.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;

import com.msk.common.logic.CommonLogic;
import com.msk.core.entity.CommConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.msk.core.web.base.BaseTag;

/**
 * SelectTag
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class SelectTag extends BaseTag implements DynamicAttributes {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SelectTag.class);
    private String codeName;
    private String selectValue;
    private String id;
    private String name;
    private boolean blank;
    private Map<String,Object> attrMap;

    @Override
    protected void doTag(HttpServletRequest request) throws JspException, IOException {
        logger.debug("生成Select");
        CommonLogic commonLogic = super.getApplicationBean("commonLogic",CommonLogic.class);
        StringBuffer selectHtml = new StringBuffer();
        selectHtml.append("<select id='"+id+"'");
        selectHtml.append(" name='"+this.name+"'");
        if(!CollectionUtils.isEmpty(this.attrMap)){
            for (Map.Entry<String,Object> entry : this.attrMap.entrySet()){
                String key = entry.getKey();
                Object value = entry.getValue();
                selectHtml.append(" "+key+"='"+value+"'");
            }
        }
        selectHtml.append(" >");
        if(this.blank){
            selectHtml.append("<option value=''>--请选择--</option>");
        }
        List<CommConstant> constantList = commonLogic.findConstantList(codeName);
        if(!CollectionUtils.isEmpty(constantList)){
            for (CommConstant selectValue : constantList){
                String key = String.valueOf(selectValue.getConstantValue());
                String value = selectValue.getConstantName();
                selectHtml.append("<option value='"+key+"'>"+value+"</option>");
            }
        }
        selectHtml.append("</select>");
        selectHtml.append("<script>");
        selectHtml.append("     $(document).ready(function() {");
        selectHtml.append("         $('#"+this.id+"').selectmenu();");
        selectHtml.append("     });");
        selectHtml.append("</script>");
        JspWriter out = this.getJspContext().getOut();
        out.write(selectHtml.toString());
    }

    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        if (attrMap == null) {
            attrMap = new HashMap<String, Object>();
        }
        attrMap.put(localName, value);
    }
    public void setBlank(boolean blank){
        this.blank = blank;
    }
    public boolean isBlank(){
        return this.blank;
    }
    /**
     * Getter method for property <tt>codeName</tt>.
     *
     * @return property value of codeName
     */
    public String getCodeName() {
        return codeName;
    }

    /**
     * Setter method for property <tt>codeName</tt>.
     *
     * @param codeName value to be assigned to property codeName
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    /**
     * Getter method for property <tt>selectValue</tt>.
     *
     * @return property value of selectValue
     */
    public String getSelectValue() {
        return selectValue;
    }

    /**
     * Setter method for property <tt>selectValue</tt>.
     *
     * @param selectValue value to be assigned to property selectValue
     */
    public void setSelectValue(String selectValue) {
        this.selectValue = selectValue;
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
}

