package com.msk.sl.bean;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;

/**
 * Created by gyh on 2016/1/14.
 */
public class ISL231101RsParam extends BaseParam{
    /**时间戳YYYY-MM-DD HH24:mi:ss*/
    private String incrementalTime;

    /**
     * 获得incrementalTime
     */
    public String getIncrementalTime() {
        return incrementalTime;
    }

    /**
     * 设置incrementalTime
     */
    public void setIncrementalTime(String incrementalTime) {
        this.incrementalTime = incrementalTime;
    }
}
