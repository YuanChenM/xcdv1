package com.msk.pd.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.bean.RsPageParam;

/**
 * 封装参数
 * PD141143RsParam 神农客价盘通道同步接口
 *
 * @author xhy
 */
@JsonIgnoreProperties(value = { "delFlg", "crtId", "crtTime", "updId", "updTime", "ver", "actId" })
public class IPD141143RsParam extends RsPageParam {

    private static final long serialVersionUID = 1L;


}