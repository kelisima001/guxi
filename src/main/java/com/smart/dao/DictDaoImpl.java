package com.smart.dao;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.smart.model.Dict;
import com.smart.model.DictCond;

@Repository
public class DictDaoImpl extends BaseEntityDao<Dict, DictCond, Long> implements DictDao{

	@Override
	public Page<Dict> findPageByModule(PageRequest pageRequest, String moduleName) {
		Criteria crit = getSession().createCriteria(Dict.class);
		crit.add(Restrictions.eq("module", moduleName));
		return super.findPage(pageRequest, crit);
	}

	@Override
	public String getDictValue(String module, String key) {
		Dict dict = getDict(module, key);
		return dict == null ? null : dict.getValue();
	}

	@Override
	public Dict getDict(String moduleName, String key) {
		Criteria crit = getSession().createCriteria(Dict.class);
		crit.add(Restrictions.eq("module", moduleName));
		crit.add(Restrictions.eq("code", key));
		List<Dict> list = super.find(crit);
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		return list.get(0);
	}

}
