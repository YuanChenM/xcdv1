package com.msk.pd.controller;

import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseController;
import com.msk.pd.bean.PD141103Param;
import com.msk.pd.logic.PD14112403Logic;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 四级产品分类操作
 *
 * @author xhy
 */
@Controller
@RequestMapping("PD14112403")
public class PD14112403Controller extends BaseController {
    @Autowired
    private PD14112403Logic pd14112403Logic;

    /**
     * 实例化页面
     *
     * @param bean  参数
     * @param model 参数
     * @return 页面
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(
            Model model, PD141103Param bean) {
        //四级分类类目操作
        model.addAttribute("classestree", bean);
        return "pd/PD14112403";
    }

    /**
     * 保存修改三级类别信息
     *
     * @param model
     * @param bean
     * @return 页面
     */
    @RequestMapping(value = "addAndEdit",
            method = RequestMethod.POST)
    public @ResponseBody String save(PD141103Param bean) {
        BaseParam param = new BaseParam();
        super.setCommonParam(param);
        //添加操作 产品特征新增操作
        if (StringUtils.isBlank(bean.getClassestreeCode4())) {
            int saveClassesTree = this.pd14112403Logic.saveClassesTree(bean,param);
            if (saveClassesTree <= NumberConst.IntDef.INT_ZERO) throw new BusinessException("数据插入失败");
            return saveClassesTree + "";
        } else {
           /* 修改操作*/
            int updataClassesTree = this.pd14112403Logic.modifyClassesTreeLevel4(bean,param);
            if (updataClassesTree <= NumberConst.IntDef.INT_ZERO) throw new BusinessException("数据修改失败");
            return updataClassesTree + "";
        }
    }

    /**
     * 四级类别删除操作 xhy
     *
     * @return
     */
    @RequestMapping(value = "delete",
            method = RequestMethod.POST)
    public
    @ResponseBody
    String delete(PD141103Param bean) {
        if (StringUtils.isBlank(bean.getClassestreeCode4())
                ||StringUtils.isBlank(bean.getClassestreeCode3())
                ||StringUtils.isBlank(bean.getClassestreeCode2())
                ||StringUtils.isBlank(bean.getClassestreeCode1()))
            throw new BusinessException("数据异常,请联系管理员(四级级类别删除)");
        int removeOk =  this.pd14112403Logic.removeFeature(bean);
        return removeOk+"";
    }

}
