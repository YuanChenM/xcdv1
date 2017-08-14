package com.msk.so.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * 
 * ISO151421RsResult接口返回结果信息.
 *
 * @author pxg
 */
public class ISO151421RsResult extends RsPageResult {
    // 投訴列表
    private List<ISO151421ComplainRsResult> complains;

    public List<ISO151421ComplainRsResult> getComplains() {
        return complains;
    }

    public void setComplains(List<ISO151421ComplainRsResult> complains) {
        this.complains = complains;
    }
}
