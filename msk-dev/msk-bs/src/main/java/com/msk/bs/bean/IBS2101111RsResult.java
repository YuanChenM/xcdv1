package com.msk.bs.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * Created by gyh on 2016/4/12.
 */
public class IBS2101111RsResult extends RsPageResult {
    private List<IBS210111101RsResult> slBsLeaguesList;//买手联盟List

    /**
     * Getter method for property <tt>slBsLeaguesList</tt>.
     *
     * @return property value of slBsLeaguesList
     */
    public List<IBS210111101RsResult> getSlBsLeaguesList() {
        return slBsLeaguesList;
    }

    /**
     * Setter method for property <tt>slBsLeaguesList</tt>.
     *
     * @param slBsLeaguesList value to be assigned to property slBsLeaguesList
     */
    public void setSlBsLeaguesList(List<IBS210111101RsResult> slBsLeaguesList) {
        this.slBsLeaguesList = slBsLeaguesList;
    }
}
