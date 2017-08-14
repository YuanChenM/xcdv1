package com.msk.core.web.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.springframework.util.CollectionUtils;

import com.msk.common.logic.CityLogic;
import com.msk.common.logic.DistrictLogic;
import com.msk.common.logic.LogisticsAreaLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.MdCity;
import com.msk.core.entity.MdDistrict;
import com.msk.core.entity.MdLogisticsArea;
import com.msk.core.web.base.BaseTag;

/**
 * SelectDistrict
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class SelectDistrictTag extends BaseTag {
    private String selectType;
    private LogisticsAreaLogic logisticsAreaLogic;
    private CityLogic cityLogic;
    private DistrictLogic districtLogic;

    private String selectAreaName;
    private String selectAreaId;
    private String selectCityName;
    private String selectCityId;
    private String selectDistrictId;
    private String selectDistrictName;
    private List<MdLogisticsArea> logisticsAreaList;
    private List<MdCity> cityList;
    private List<MdDistrict> districtList;

    /**
     * 下拉框区域类型
     */
    private interface SelectType {
        String AREA = "Area";
        String CITY = "City";
        String DISTRICT = "District";
    }

    @Override
    protected void doTag(HttpServletRequest request) throws JspException, IOException {
        if (null == this.logisticsAreaLogic) {
            this.logisticsAreaLogic = super.getApplicationBean("logisticsAreaLogic", LogisticsAreaLogic.class);
        }
        if (null == this.cityLogic) {
            this.cityLogic = super.getApplicationBean("cityLogic", CityLogic.class);
        }
        if (null == this.districtLogic) {
            this.districtLogic = super.getApplicationBean("districtLogic", DistrictLogic.class);
        }

        BaseParam param = new BaseParam();
        StringBuffer html = new StringBuffer();
        StringBuffer loadSelect = new StringBuffer();
        if (SelectType.AREA.equals(selectType)) {
            this.logisticsAreaList = this.logisticsAreaLogic.findList(param);
            html.append(this.createAreaSelectTag());
            loadSelect.append("$(\"#"+this.selectAreaId+"\").selectmenu({width:\"135px\"});\n");
        } else if (SelectType.CITY.equals(selectType)) {
            this.logisticsAreaList = this.logisticsAreaLogic.findList(param);
            html.append(this.createAreaSelectTag());
            loadSelect.append("$(\"#"+this.selectAreaId+"\").selectmenu({width:\"135px\",change:changeArea});\n");
            this.initCityList(param);
            html.append(this.createCitySelectTag());
            loadSelect.append("$(\"#"+this.selectCityId+"\").selectmenu({width:\"135px\"},change:changeArea);\n");
        } else if (SelectType.DISTRICT.equals(selectType)) {
            this.logisticsAreaList = this.logisticsAreaLogic.findList(param);
            html.append(this.createAreaSelectTag());
            loadSelect.append("$(\"#"+this.selectAreaId+"\").selectmenu({width:\"135px\"});\n");
            this.initCityList(param);
            html.append(this.createCitySelectTag());
            loadSelect.append("$(\"#"+this.selectCityId+"\").selectmenu({width:\"135px\"});\n");
            this.initDistrictList(param);
            html.append(this.createDistrictSelectTag());
            loadSelect.append("$(\"#"+this.selectDistrictId+"\").selectmenu({width:\"135px\"});\n");
        }
        JspWriter out = this.getJspContext().getOut();
        out.write(html.toString());
        out.write("<script>\n");
        out.write("function changeArea(){\n");
        out.write("var lgcsId = $('#"+this.selectAreaId+" option:selected').attr('lgcsId');\n");
        out.write("var lgcsCode = $('#"+this.selectAreaId+"').val();");
        out.write("var url='"+this.getRequest().getContextPath()+"'+'/district/searchCity';\n");
        out.write("$('#hiddenDiv').postUrl(url,{'lgcsId':lgcsId},function(data){\n" +
                "$('#"+this.selectCityId+"').empty();\n"+
                "$.each(data,function(index,context){\n" +
                "$('#"+this.selectCityId+"').append('<option value=\"'+context[\"cityCode\"]+'\">'+context[\"cityName\"]+'</option>');\n"+
                "});\n"+
                "$('#"+this.selectCityId+"').selectmenu('refresh');\n"+
                "},{refreshHtml:false});\n");
        out.write("}\n");
        out.write("$(document).ready(function() {\n");
        out.write(loadSelect.toString());
        out.write("});\n");
        out.write("</script>\n");
    }

    /**
     * 加载区信息,根据城市ID作为条件
     * @param param Base Param
     */
    private void initDistrictList(BaseParam param) {
        if(!CollectionUtils.isEmpty(cityList)){
            MdCity city = cityList.get(NumberConst.IntDef.INT_ZERO);
            Long cityId = city.getCityId();
            param.setFilterObject("cityId",cityId);
            this.districtList = this.districtLogic.findList(param);
        }
    }

    /**
     * 加载城市数据,根据区域ID
     * @param param BaseParam
     */
    private void initCityList(BaseParam param) {
        if (!CollectionUtils.isEmpty(logisticsAreaList)) {
            MdLogisticsArea logisticsArea = logisticsAreaList.get(NumberConst.IntDef.INT_ZERO);
            Long lgcsId = logisticsArea.getLgcsAreaId();
            param.setFilterObject("lgcsId", lgcsId);
            this.cityList = this.cityLogic.findList(param);
        } else {
            this.cityList = new ArrayList<MdCity>();
        }
    }

    /**
     * 创建区下拉框信息
     * @return 下拉框Select
     */
    private String createDistrictSelectTag() {
        StringBuffer selectHtml = new StringBuffer();
        selectHtml.append("<select id='" + this.selectDistrictId + "' name='" + this.selectDistrictName + "'>");
        for (MdDistrict district : this.districtList) {
            selectHtml.append("<option value='" + district.getDistrictCode() + "'>" + district.getDistrictName() + "</option>");
        }
        selectHtml.append("</select>");
        return selectHtml.toString();
    }

    /**
     * 创建城市下拉框数据
     * 
     * @return 下拉框Select
     */
    private String createCitySelectTag() {
        StringBuffer selectHtml = new StringBuffer();
        selectHtml.append("<select id='" + this.selectCityId + "' name='" + this.selectCityName + "'>");
        for (MdCity city : cityList) {
            selectHtml.append("<option value='" + city.getCityCode() + "'>" + city.getCityName() + "</option>");
        }
        selectHtml.append("</select>");
        return selectHtml.toString();
    }

    /**
     * 创建区域下拉框信息
     * 
     * @return Select Html
     */
    private String createAreaSelectTag() {
        StringBuffer selectHtml = new StringBuffer();
        selectHtml.append("<select id='" + this.selectAreaId + "' name='" + this.selectAreaName + "'>");
        for (MdLogisticsArea area : logisticsAreaList) {
            selectHtml.append("<option lgcsId='"+area.getLgcsAreaId()+"' value='" + area.getLgcsAreaCode() + "'>" + area.getLgcsAreaName() + "</option>");
        }
        selectHtml.append("</select>");
        return selectHtml.toString();
    }

    /**
     * Getter method for property <tt>selectAreaName</tt>.
     *
     * @return property value of selectAreaName
     */
    public String getSelectAreaName() {
        return selectAreaName;
    }

    /**
     * Setter method for property <tt>selectAreaName</tt>.
     *
     * @param selectAreaName value to be assigned to property selectAreaName
     */
    public void setSelectAreaName(String selectAreaName) {
        this.selectAreaName = selectAreaName;
    }

    /**
     * Getter method for property <tt>selectAreaId</tt>.
     *
     * @return property value of selectAreaId
     */
    public String getSelectAreaId() {
        return selectAreaId;
    }

    /**
     * Setter method for property <tt>selectAreaId</tt>.
     *
     * @param selectAreaId value to be assigned to property selectAreaId
     */
    public void setSelectAreaId(String selectAreaId) {
        this.selectAreaId = selectAreaId;
    }

    /**
     * Getter method for property <tt>selectCityName</tt>.
     *
     * @return property value of selectCityName
     */
    public String getSelectCityName() {
        return selectCityName;
    }

    /**
     * Setter method for property <tt>selectCityName</tt>.
     *
     * @param selectCityName value to be assigned to property selectCityName
     */
    public void setSelectCityName(String selectCityName) {
        this.selectCityName = selectCityName;
    }

    /**
     * Getter method for property <tt>selectCityId</tt>.
     *
     * @return property value of selectCityId
     */
    public String getSelectCityId() {
        return selectCityId;
    }

    /**
     * Setter method for property <tt>selectCityId</tt>.
     *
     * @param selectCityId value to be assigned to property selectCityId
     */
    public void setSelectCityId(String selectCityId) {
        this.selectCityId = selectCityId;
    }

    /**
     * Getter method for property <tt>selectDistrictId</tt>.
     *
     * @return property value of selectDistrictId
     */
    public String getSelectDistrictId() {
        return selectDistrictId;
    }

    /**
     * Setter method for property <tt>selectDistrictId</tt>.
     *
     * @param selectDistrictId value to be assigned to property selectDistrictId
     */
    public void setSelectDistrictId(String selectDistrictId) {
        this.selectDistrictId = selectDistrictId;
    }

    /**
     * Getter method for property <tt>selectDistrictName</tt>.
     *
     * @return property value of selectDistrictName
     */
    public String getSelectDistrictName() {
        return selectDistrictName;
    }

    /**
     * Setter method for property <tt>selectDistrictName</tt>.
     *
     * @param selectDistrictName value to be assigned to property selectDistrictName
     */
    public void setSelectDistrictName(String selectDistrictName) {
        this.selectDistrictName = selectDistrictName;
    }

    /**
     * Getter method for property <tt>selectType</tt>.
     *
     * @return property value of selectType
     */
    public String getSelectType() {
        return selectType;
    }

    /**
     * Setter method for property <tt>selectType</tt>.
     *
     * @param selectType value to be assigned to property selectType
     */
    public void setSelectType(String selectType) {
        this.selectType = selectType;
    }
}
