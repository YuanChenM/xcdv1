package com.msk.core.web.consts;

/**
 * Code Master Def
 *
 * @author jiang_nan
 */
public interface CodeMasterConst {
    /**
     * 组织级别
     *
     * @author jiang_nan
     */
    public interface OrgLevel {
        /** Code Master Model Name定义:OrgLevel */
        public String MODEL_NAME = "OrgLevel";
        /** ONE定义:1(级别1) */
        public String ONE = "1";
        /** TOW定义:2(级别2) */
        public String TOW = "2";
        /** THREE定义:3(级别3) */
        public String THREE = "3";
    }

    /**
     * 系统级别
     *
     * @author jiang_nan
     */
    public interface SysLevel {
        /** Code Master Model Name定义:systemLevel */
        public String MODEL_NAME = "systemLevel";
        /** SYSTEM:1(系统模块) */
        public String SYSTEM = "1";
        /** SUBSYSTEM:2(子系统) */
        public String SUBSYSTEM = "2";
        /** MODUL:3模块 */
        public String MODUL = "3";

    }

    /**
     * 登录表状态Code Master定义
     *
     * @author jian_gnan
     */
    public interface LoginStatus {
        /** Code Master Model Name定义:LoginStatus */
        public String MODUL_NAME = "LoginStatus";
        /** AVAILABLE:有效 */
        public String AVAILABLE = "0";
        /** FREEZE:冻结 */
        public String FREEZE = "1";
    }

    /**
     * 是否可用
     *
     * @author jian_gnan
     */
    public interface IsAvailable {
        /** Code Master Model Name定义:IsAvailable */
        public String MODUL_NAME = "IsAvailable";
        /** AVAILABLE:可用 */
        public String AVAILABLE = "0";
        /** NOAVAILABLE:不可用 */
        public String NOAVAILABLE = "1";
    }

    /**
     * 产品等级
     *
     * @author yuan_chen
     */
    public interface GradeCode {
        /** Code Master Model Name定义:GradeCode */
        public String NONE = "0";
        /** 等级:A1 */
        public String A1 = "1";
        /** 等级:A2 */
        public String A2 = "2";
        /** 等级:A3 */
        public String A3 = "2";
    }

    /**
     * 行政区域划分级别
     *
     * @author yuan_chen
     */
    public interface DivisionLevel {
        public String Type = "DivisionLevel";

        /** 大区 */
        public String Area = "1";
        /** 省或物流区 */
        public String PrLgcs = "2";
        /** 城市(区域) */
        public String City = "3";
        /** 区(县) */
        public String District = "4";
    }
    /**
     * 冻品管家与买家的关系：申请状态
     * 1：申请中 2：专属会员
     * @author chen_xin
     */
    public interface SlApplyStatus {
        public String Type = "SlApplyStatus";
        /** 申请中 */
        public String Apply = "1";
        /** 专属会员 */
        public String Exclusive = "2";
    }

    public interface OrderDetailType{
        public String TYPE = "OrderDetailType";
        public int NORMAL = 1;
    }

    interface OrderDetailLevel{
        String TYPE = "OrderDetailLevel";
        int NORMAL = 1;
    }

    /**
     * 产品状态
     * @author gyh
     */
    public interface slProductStatus{
        /**申请中*/
        String SQZ="1";
        /**论证中*/
        String LZZ="2";
        /**禁止准入*/
        String JZZR="3";
        /**试销*/
        String SX="4";
        /**正式上线*/
        String ZSSX="5";
        /**下线*/
        String XX="6";
        /**黑名单*/
        String HMD="7";
        /**断货*/
        String DH="8";
    }


    /**
     * 是否为目录产品
     *
     * @author yuan_chen
     */
    public interface IsStandard {
        //不是目录产品(新产品)
        static final String NO = "0";
        //是目录产品(已注册产品)
        static final String YES = "1";
    }

}
