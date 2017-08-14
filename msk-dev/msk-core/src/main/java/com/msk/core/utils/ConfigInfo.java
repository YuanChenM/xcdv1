package com.msk.core.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ConfigInfo
 *
 * @author jiang_nan
 * @version 1.0
 **/
@Component("configInfo")
public class ConfigInfo {

    /** 工程版本号，来自工程的版本号 */
    @Value("#{configProperties['project.version']}")
    private String projectVersion;
    /** 代码版本号，来自SVN的版本号 */
    @Value("#{configProperties['svn.version']}")
    private String svnVersion;
    /** pom文件所在目录代码版本号，来自SVN的版本号 */
    @Value("#{configProperties['svn.subVersion']}")
    private String svnSubVersion;
    /** 版本编译时间，来自maven */
    @Value("#{configProperties['build.time']}")
    private String buildTime;
    /** 系统版本标识（GM:UAT，RC:生产） */
    @Value("#{configProperties['version.mark']}")
    private String versionMark;

    /** 供应商的部门ID固定值设定 */
    @Value("#{configProperties['supplier_dept_id']}")
    private String supplierDeptId;
    /** 供应商的角色ID固定值设定 */
    @Value("#{configProperties['supplier_role_id']}")
    private String supplierRoleId;

    /** 等级标准上限 */
    @Value("#{configProperties['LEVEL_STAND_MIN_ZERO']}")
    private String levelStandMinZero;
    @Value("#{configProperties['LEVEL_STAND_MIN_ONE']}")
    private String levelStandMinOne;
    @Value("#{configProperties['LEVEL_STAND_MIN_TWO']}")
    private String levelStandMinTwo;
    @Value("#{configProperties['LEVEL_STAND_MIN_THREE']}")
    private String levelStandMinThree;
    @Value("#{configProperties['LEVEL_STAND_MIN_FOUR']}")
    private String levelStandMinFour;
    @Value("#{configProperties['LEVEL_STAND_MIN_FIVE']}")
    private String levelStandMinFive;
    @Value("#{configProperties['LEVEL_STAND_MIN_SIX']}")
    private String levelStandMinSix;
    @Value("#{configProperties['LEVEL_STAND_MIN_SEVEN']}")
    private String levelStandMinSeven;
    @Value("#{configProperties['LEVEL_STAND_MIN_EIGHT']}")
    private String levelStandMinEight;
    @Value("#{configProperties['LEVEL_STAND_MIN_NINE']}")
    private String levelStandMinNine;

    /** 等级标准下限 */
    @Value("#{configProperties['LEVEL_STAND_MAX_ZERO']}")
    private String levelStandMaxZero;
    @Value("#{configProperties['LEVEL_STAND_MAX_ONE']}")
    private String levelStandMaxOne;
    @Value("#{configProperties['LEVEL_STAND_MAX_TWO']}")
    private String levelStandMaxTwo;
    @Value("#{configProperties['LEVEL_STAND_MAX_THREE']}")
    private String levelStandMaxThree;
    @Value("#{configProperties['LEVEL_STAND_MAX_FOUR']}")
    private String levelStandMaxFour;
    @Value("#{configProperties['LEVEL_STAND_MAX_FIVE']}")
    private String levelStandMaxFive;
    @Value("#{configProperties['LEVEL_STAND_MAX_SIX']}")
    private String levelStandMaxSix;
    @Value("#{configProperties['LEVEL_STAND_MAX_SEVEN']}")
    private String levelStandMaxSeven;
    @Value("#{configProperties['LEVEL_STAND_MAX_EIGHT']}")
    private String levelStandMaxEight;
    @Value("#{configProperties['LEVEL_STAND_MAX_NINE']}")
    private String levelStandMaxNine;

    /** 标准价盘等级系数 */
    @Value("#{configProperties['STANDARD_COEFFICIENT_ZERO']}")
    private String standardCoefficientZero;
    @Value("#{configProperties['STANDARD_COEFFICIENT_ONE']}")
    private String standardCoefficientOne;
    @Value("#{configProperties['STANDARD_COEFFICIENT_TWO']}")
    private String standardCoefficientTwo;
    @Value("#{configProperties['STANDARD_COEFFICIENT_THREE']}")
    private String standardCoefficientThree;
    @Value("#{configProperties['STANDARD_COEFFICIENT_FOUR']}")
    private String standardCoefficientFour;
    @Value("#{configProperties['STANDARD_COEFFICIENT_FIVE']}")
    private String standardCoefficientFive;
    @Value("#{configProperties['STANDARD_COEFFICIENT_SIX']}")
    private String standardCoefficientSix;
    @Value("#{configProperties['STANDARD_COEFFICIENT_SEVEN']}")
    private String standardCoefficientSeven;
    @Value("#{configProperties['STANDARD_COEFFICIENT_EIGHT']}")
    private String standardCoefficientEight;
    @Value("#{configProperties['STANDARD_COEFFICIENT_NINE']}")
    private String standardCoefficientNine;

    /** 折扣率 */
    @Value("#{configProperties['DIS_COUNT_ZERO']}")
    private String disCountZero;
    @Value("#{configProperties['DIS_COUNT_ONE']}")
    private String disCountOne;
    @Value("#{configProperties['DIS_COUNT_TWO']}")
    private String disCountTwo;
    @Value("#{configProperties['DIS_COUNT_THREE']}")
    private String disCountThree;
    @Value("#{configProperties['DIS_COUNT_FOUR']}")
    private String disCountFour;
    @Value("#{configProperties['DIS_COUNT_FIVE']}")
    private String disCountFive;
    @Value("#{configProperties['DIS_COUNT_SIX']}")
    private String disCountSix;
    @Value("#{configProperties['DIS_COUNT_SEVEN']}")
    private String disCountSeven;
    @Value("#{configProperties['DIS_COUNT_EIGHT']}")
    private String disCountEight;
    @Value("#{configProperties['DIS_COUNT_NINE']}")
    private String disCountNine;

    /** 市场指导价格系数 */
    @Value("#{configProperties['STANDARD_COEFFICIENT_QUOTIETY']}")
    private String standardCoefficientQuotiety;

    @Value("#{configProperties['SERVER_NAME']}")
    private String serverName;

    public String getServerName() {
        return serverName;
    }



    public String getLevelStandMinZero() {
        return levelStandMinZero;
    }

    public String getLevelStandMinOne() {
        return levelStandMinOne;
    }

    public String getLevelStandMinTwo() {
        return levelStandMinTwo;
    }

    public String getLevelStandMinThree() {
        return levelStandMinThree;
    }

    public String getLevelStandMinFour() {
        return levelStandMinFour;
    }

    public String getLevelStandMinFive() {
        return levelStandMinFive;
    }

    public String getLevelStandMinSix() {
        return levelStandMinSix;
    }

    public String getLevelStandMinSeven() {
        return levelStandMinSeven;
    }

    public String getLevelStandMinEight() {
        return levelStandMinEight;
    }

    public String getLevelStandMinNine() {
        return levelStandMinNine;
    }

    public String getLevelStandMaxZero() {
        return levelStandMaxZero;
    }

    public String getLevelStandMaxOne() {
        return levelStandMaxOne;
    }

    public String getLevelStandMaxTwo() {
        return levelStandMaxTwo;
    }

    public String getLevelStandMaxThree() {
        return levelStandMaxThree;
    }

    public String getLevelStandMaxFour() {
        return levelStandMaxFour;
    }

    public String getLevelStandMaxFive() {
        return levelStandMaxFive;
    }

    public String getLevelStandMaxSix() {
        return levelStandMaxSix;
    }

    public String getLevelStandMaxSeven() {
        return levelStandMaxSeven;
    }

    public String getLevelStandMaxEight() {
        return levelStandMaxEight;
    }

    public String getLevelStandMaxNine() {
        return levelStandMaxNine;
    }

    public String getStandardCoefficientZero() {
        return standardCoefficientZero;
    }

    public String getStandardCoefficientOne() {
        return standardCoefficientOne;
    }

    public String getStandardCoefficientTwo() {
        return standardCoefficientTwo;
    }

    public String getStandardCoefficientThree() {
        return standardCoefficientThree;
    }

    public String getStandardCoefficientFour() {
        return standardCoefficientFour;
    }

    public String getStandardCoefficientFive() {
        return standardCoefficientFive;
    }

    public String getStandardCoefficientSix() {
        return standardCoefficientSix;
    }

    public String getStandardCoefficientSeven() {
        return standardCoefficientSeven;
    }

    public String getStandardCoefficientEight() {
        return standardCoefficientEight;
    }

    public String getStandardCoefficientNine() {
        return standardCoefficientNine;
    }

    public String getDisCountZero() {
        return disCountZero;
    }

    public String getDisCountOne() {
        return disCountOne;
    }

    public String getDisCountTwo() {
        return disCountTwo;
    }

    public String getDisCountThree() {
        return disCountThree;
    }

    public String getDisCountFour() {
        return disCountFour;
    }

    public String getDisCountFive() {
        return disCountFive;
    }

    public String getDisCountSix() {
        return disCountSix;
    }

    public String getDisCountSeven() {
        return disCountSeven;
    }

    public String getDisCountEight() {
        return disCountEight;
    }

    public String getDisCountNine() {
        return disCountNine;
    }

    public String getStandardCoefficientQuotiety() {
        return standardCoefficientQuotiety;
    }

    /**
     * 获取工程版本号
     * 
     * @return 工程版本号
     */
    public String getProjectVersion() {
        return projectVersion;
    }

    /**
     * 获取SVN版本号
     * 
     * @return SVN版本号
     */
    public String getSvnVersion() {
        return svnVersion;
    }

    /**
     * Getter method for property <tt>svnSubVersion</tt>.
     *
     * @return property value of svnSubVersion
     */
    public String getSvnSubVersion() {
        return svnSubVersion;
    }

    /**
     * 获取版本编译时间
     *
     * @return 版本编译时间
     */
    public String getBuildTime() {
        return buildTime;
    }

    /**
     * 获取系统版本标识
     *
     * @return 系统版本标识
     */
    public String getVersionMark() {
        return versionMark;
    }

    /**
     * 供应商的部门ID固定值
     * 
     * @return 供应商的部门ID固定值
     */
    public String getSupplierDeptId() {
        return supplierDeptId;
    }

    /**
     * 供应商的角色ID固定值
     * 
     * @return 供应商的角色ID固定值设定
     */
    public String getSupplierRoleId() {
        return supplierRoleId;
    }
}
