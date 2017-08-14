package com.msk.bs.bean;

import com.msk.core.entity.SlBsBuyerLeagues;

import java.util.List;

/**
 * Created by gyh on 2016/4/8.
 */
public class IBS2101110RsParam {
    private List<IBS210111001RsParam> slBsLeaguesList;//买手联盟List

    /**
     * Getter method for property <tt>slBsLeaguesList</tt>.
     *
     * @return property value of slBsLeaguesList
     */
    public List<IBS210111001RsParam> getSlBsLeaguesList() {
        return slBsLeaguesList;
    }

    /**
     * Setter method for property <tt>slBsLeaguesList</tt>.
     *
     * @param slBsLeaguesList value to be assigned to property slBsLeaguesList
     */
    public void setSlBsLeaguesList(List<IBS210111001RsParam> slBsLeaguesList) {
        this.slBsLeaguesList = slBsLeaguesList;
    }
}
