package com.msk.sl.logic;

import java.util.ArrayList;
import java.util.List;

import com.msk.core.base.BaseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.core.base.BaseLogic;
import com.msk.sl.bean.SL241110Bean;

@Service
public class SL241110Logic extends BaseLogic {

	/** logger */
	private static Logger logger = LoggerFactory.getLogger(SL241110Logic.class);

	@Autowired
	@Override
	public void setBaseDao(BaseDao baseDao) {
		super.setBaseDao(baseDao);
	}

//    public List<SL241110Bean> queryList() {
//        SL241110Bean sL241110 = new SL241110Bean();
//        List<SL241110Bean> list = new ArrayList<>();
//        sL241110.setId("");
//        sL241110.setSlCode("001");
//        sL241110.setSlName("神舟");
//        sL241110.setSlIdea("经过我的亲身体验，这家店信誉是相当地不错。宝贝的质量更像钻石一般。太感谢了！ 不要以为信誉低的卖家货质量不好。我用我的亲身经历告诉大家，掌柜服务态度非常好。商品质量也非常不错。顶你了！");
//
//
//        SL241110Bean sL2411101_1 = new SL241110Bean();
//        sL2411101_1.setId("");
//        sL2411101_1.setSlCode("002");
//        sL2411101_1.setSlName("战神");
//        sL2411101_1.setSlIdea("店已经收藏了很久，不过是第一次下手。应该说还不错。");
//
//
//        SL241110Bean sL2411101_2 = new SL241110Bean();
//        sL2411101_2.setId("");
//        sL2411101_2.setSlCode("003");
//        sL2411101_2.setSlName("神舟");
//        sL2411101_2.setSlIdea("网上购物这么激烈，没想到店家的服务这么好，商品质量好而价低廉，我太感谢你了！ 店家很讲信誉，而且很不错哦，在这家店买东东，我很满意~ ");
//
//        list.add(sL241110);
//        list.add(sL2411101_1);
//        list.add(sL2411101_2);
//
//
//
//        return list;
//
//
//    }
}
