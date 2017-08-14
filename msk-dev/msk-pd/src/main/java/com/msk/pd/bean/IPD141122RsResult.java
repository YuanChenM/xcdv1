package com.msk.pd.bean;

import com.msk.core.entity.BaseEntity;

/**
 * Created by fjm on 2016/3/9.
 */
public class IPD141122RsResult extends BaseEntity {
    private String scientificName;

    private String localName;

    private String salesName;

    private String placeOrigin;

    private String placeCurrent;

    private String source;

    private String childType;

    private String feedType;

    private String feedPeriod;

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
    }

    public String getPlaceCurrent() {
        return placeCurrent;
    }

    public void setPlaceCurrent(String placeCurrent) {
        this.placeCurrent = placeCurrent;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getChildType() {
        return childType;
    }

    public void setChildType(String childType) {
        this.childType = childType;
    }

    public String getFeedType() {
        return feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public String getFeedPeriod() {
        return feedPeriod;
    }

    public void setFeedPeriod(String feedPeriod) {
        this.feedPeriod = feedPeriod;
    }

    /*private List<IPD141122RsParam> list = new ArrayList<IPD141122RsParam>();


    public List<IPD141122RsParam> getList() {
        return list;
    }

    public void setList(List<IPD141122RsParam> list) {
        this.list = list;
    }*/
}
