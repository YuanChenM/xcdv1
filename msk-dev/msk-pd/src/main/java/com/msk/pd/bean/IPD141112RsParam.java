package com.msk.pd.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.bean.RsPageParam;
import com.msk.core.entity.BaseEntity;
import com.msk.core.entity.PdQltStdSubCla;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装参数
 * IPD141112RsParam.
 *
 * @author xhy
 */
@JsonIgnoreProperties(value = {"delFlg", "crtId", "crtTime", "updId", "updTime", "ver", "actId"})
public class IPD141112RsParam extends RsPageParam {

    private static final long serialVersionUID = 1L;

}