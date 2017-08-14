package com.msk.pd.bean;

import java.util.List;

import com.msk.core.entity.PdQltStdSubCla;

/**
 * QltStdSubCla Controller
 * @author pxg
 *
 */
public class QltStdSubCla extends PdQltStdSubCla{

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    
    private List<QltStdItemAndQltstd> qltStdItemAndQltstdList;

    /**
     * Get the qltStdItemAndQltstdList.
     *
     * @return qltStdItemAndQltstdList
     *
     * @author Administrator
     */
    public List<QltStdItemAndQltstd> getQltStdItemAndQltstdList() {
        return this.qltStdItemAndQltstdList;
    }

    /**
     * Set the qltStdItemAndQltstdList.
     *
     * @param qltStdItemAndQltstdList qltStdItemAndQltstdList
     *
     * @author Administrator
     */
    public void setQltStdItemAndQltstdList(List<QltStdItemAndQltstd> qltStdItemAndQltstdList) {
        this.qltStdItemAndQltstdList = qltStdItemAndQltstdList;
    }

}
