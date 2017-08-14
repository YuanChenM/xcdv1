package com.msk.pl.bean;

/**
 * Created by tao_zhifa on 2017/4/25.
 */
public class PlTerminalPartnerResult extends PlDomainBs {

    //配送站ID
    private Long terminalId;
    //配送站名称
    private String terminalName;
    //配送站所属合伙人ID
    private Long partnerId;
    //配送站所属合伙人名称
    private String partnerName;

    @Override
    public Long getTerminalId() {
        return terminalId;
    }

    @Override
    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    @Override
    public String getTerminalName() {
        return terminalName;
    }

    @Override
    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }
}
