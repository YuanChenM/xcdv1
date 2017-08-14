package com.msk.sl.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.entity.SlPdPkg;

import java.util.List;

/**
 * Created by gyh on 2016/2/29.
 */
@JsonIgnoreProperties(value = {"delFlg", "crtId", "crtTime", "updId", "updTime", "actId", "actTime"})
public class ISL231109RsSlPdPkg extends SlPdPkg {
}
