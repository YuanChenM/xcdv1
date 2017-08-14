package com.msk.pd.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsPageParam;
import com.msk.core.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * 封装参数
 * PD141115RsParam
 *
 * @author xhy
 */
@JsonIgnoreProperties(value = { "delFlg", "crtId", "crtTime", "updId", "updTime", "ver", "actId" })
public class IPD141115RsParam extends RsPageParam {

    private static final long serialVersionUID = 1L;


}