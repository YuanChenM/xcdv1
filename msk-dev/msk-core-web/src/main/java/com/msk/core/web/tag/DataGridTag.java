package com.msk.core.web.tag;

import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseTag;
import com.msk.core.web.bean.DataGridColumn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.tags.form.TagWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DataGridTag
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class DataGridTag extends BaseTag implements DynamicAttributes {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(DataGridTag.class);
    private String actionUrl;
    private String tableId;
    private List<DataGridColumn> columnList;
    private Map<String,Object> attrMap;
    /**
     * The Constructors Method.
     */
    public DataGridTag() {
        columnList = new ArrayList<DataGridColumn>();
    }
    @Override
    protected void doTag(HttpServletRequest request) throws JspException, IOException {
        logger.debug("生成 Data Grid Table");
        StringBuffer dataGridHtml = new StringBuffer();
        dataGridHtml.append("<table id='"+tableId+"' ");
        if(!StringUtil.isEmpty(actionUrl)){
            dataGridHtml.append(" actionUrl='"+actionUrl+"'");
        }
        if(!CollectionUtils.isEmpty(this.attrMap)){
            for(Map.Entry<String,Object> entry : this.attrMap.entrySet()){
                dataGridHtml.append(" "+entry.getKey() +"='"+entry.getValue()+"'");
            }
        }
        dataGridHtml.append(">");
        dataGridHtml.append("<thead>");
        dataGridHtml.append("<tr>");
        for (DataGridColumn column:this.columnList) {
            dataGridHtml.append(column.toString());
        }
        dataGridHtml.append("</tr>");
        dataGridHtml.append("</thead>");
        dataGridHtml.append("<tbody>");
        dataGridHtml.append("</tbody>");
        dataGridHtml.append("</table>");
        JspWriter out = this.getJspContext().getOut();
        out.write(dataGridHtml.toString());
    }



    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        if (attrMap == null) {
            attrMap = new HashMap<String, Object>();
        }
        attrMap.put(localName, value);
    }

    /**
     * Getter method for property <tt>columnList</tt>.
     *
     * @return property value of columnList
     */
    public List<DataGridColumn> getColumnList() {
        return columnList;
    }

    /**
     * Setter method for property <tt>columnList</tt>.
     *
     * @param columnList value to be assigned to property columnList
     */
    public void setColumnList(List<DataGridColumn> columnList) {
        this.columnList = columnList;
    }

    /**
     * Getter method for property <tt>actionUrl</tt>.
     *
     * @return property value of actionUrl
     */
    public String getActionUrl() {
        return actionUrl;
    }

    /**
     * Setter method for property <tt>actionUrl</tt>.
     *
     * @param actionUrl value to be assigned to property actionUrl
     */
    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    /**
     * Getter method for property <tt>tableId</tt>.
     *
     * @return property value of tableId
     */
    public String getTableId() {
        return tableId;
    }

    /**
     * Setter method for property <tt>tableId</tt>.
     *
     * @param tableId value to be assigned to property tableId
     */
    public void setTableId(String tableId) {
        this.tableId = tableId;
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
