package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SlPdBrand;
import com.msk.sl.bean.SL2411030033Bean;
import com.msk.sl.bean.SL2411030073Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fjm on 2016/2/1.
 */
@Service
public class SL24110107Logic extends BaseLogic{

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao){
        super.setBaseDao(baseDao);
    }

    interface Sql{
        String SQL_ID_MODIFY_BRAND="modifyBrand";
        String SQL_ID_MODIFY_HONOR="modifyHonor";
        String SQL_ID_DELETE_BRAND="deleteBrand";
        String SQL_ID_DELETE_HONOR="deleteHonor";
        String SQL_ID_DELETE_PDBRAND="deletePdBrand";
        String SQL_ID_UPDATE_SLPDBRAND="updatePdBrand";
        String SQL_ID_FIND_SLPDBRANDLIST="findSlPdBrandList";
        String SQL_ID_UPDATE_SLAGENTPDBRAND="updateAgentPdBrand";
        String SQL_ID_DELETE_AGENTPDBRAND="deleteAgentPdBrand";
    }

    /**
     * 删除代理的品牌
     * @param sl2411030073Bean 参数
     */
    public void deleteAgentPdBrand(SL2411030073Bean sl2411030073Bean) {
        super.modify(Sql.SQL_ID_DELETE_AGENTPDBRAND,sl2411030073Bean);
    }

    /**
     * 更新代理品牌信息
     * @param sl2411030073Bean 画面修改后的参数
     */
    public void updateAgentPdBrand(SL2411030073Bean sl2411030073Bean) {
        super.modify(Sql.SQL_ID_UPDATE_SLAGENTPDBRAND,sl2411030073Bean);
    }

    /**
     * 删除自有品牌的时候
     * 根据品牌ID和企业ID查询该品牌是否有其他的卖家使用，如果没有使用，则删除，如果有使用，则告知不能删除
     * @param brandId 品牌ID
     * @param epId 卖家企业ID
     * @return 返回集合
     */
    public List<SlPdBrand> findListByEpId(String brandId,String epId) {
        BaseParam base = new BaseParam();
        base.setFilter("brandId",brandId);
        base.setFilter("epId",epId);
        List<SlPdBrand> list = super.findList(Sql.SQL_ID_FIND_SLPDBRANDLIST,base);
        return list;
    }

    /**更新卖家产品品牌信息*/
    public void updatePdBrand(SL2411030033Bean sL2411030033Bean) {
        super.modify(Sql.SQL_ID_UPDATE_SLPDBRAND,sL2411030033Bean);
    }

    public int removePDBrand(SL2411030033Bean sl2411030033Bean){
        return super.remove(Sql.SQL_ID_DELETE_PDBRAND,sl2411030033Bean);
    }
    public int removeBrand(SL2411030033Bean sl2411030033Bean){
        return super.remove(Sql.SQL_ID_DELETE_BRAND,sl2411030033Bean);
    }

    public int removeHonor(SL2411030033Bean sl2411030033Bean){
        return super.remove(Sql.SQL_ID_DELETE_HONOR,sl2411030033Bean);
    }

    public int updateBrand(SL2411030033Bean sL2411030033Bean){
        return  super.modify(Sql.SQL_ID_MODIFY_BRAND, sL2411030033Bean);
    }

    public int updateHonor(SL2411030033Bean sL2411030033Bean){
        return  super.modify(Sql.SQL_ID_MODIFY_HONOR, sL2411030033Bean);
    }
}
