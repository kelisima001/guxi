package com.smart.service.init;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smart.consts.DocType;
import com.smart.core.init.AbstractDataInitializeService;
import com.smart.core.init.InitServiceOrder;
import com.smart.model.Doc;
import com.smart.util.CollectionUtil;

/**
 * 初始化常见文案
 * 
 * @author Xin.Sun
 *
 */
@Service
public class DocInitService extends AbstractDataInitializeService{

	@Override
	public int getOrder() {
		return InitServiceOrder.INIT_ORDER_DOC;
	}

	@Override
	public void initData() throws Exception {
		List<Doc> list = docService.findBy("type", DocType.prod);
		if(!CollectionUtil.isEmpty(list)){
			return;
		}
		
		Doc doc = new Doc();
		doc.setTitle("空白文案");
		doc.setContent("小编还在熬夜想文案中...");
		doc.setType(DocType.prod);
		docService.save(doc);
	}

}
