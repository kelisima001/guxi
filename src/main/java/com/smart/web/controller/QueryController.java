package com.smart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smart.consts.DictModules;
import com.smart.model.Dict;

@Controller
public class QueryController extends BaseController{
	@RequestMapping(value = "query.html", method=RequestMethod.GET)
	public String deleteDict(Long id) {
		Dict dict1 = dictService.getDict(DictModules.MOD_SYS, "count.user");
		Dict dict2 = dictService.getDict(DictModules.MOD_SYS, "count.platform");
		Dict dict3 = dictService.getDict(DictModules.MOD_SYS, "count.institution");
		int countUser = 5188 ;
		int countPlatform = 9822;
		int countInstitution = 7668;
		try { 
		countUser = Integer.parseInt(dict1.getValue());
		countPlatform = Integer.parseInt(dict2.getValue());
		countInstitution = Integer.parseInt(dict3.getValue());
		}
		catch(Exception e) {
			
		}
		countUser+=1;
		countPlatform+=1;
		countInstitution+=1;
		dict1.setValue(countUser+"");
		dict2.setValue(countPlatform + "");
		dict3.setValue(countInstitution + "");
		dictService.save(dict1);
		dictService.save(dict2);
		dictService.save(dict3);
		return "query";
	}
}
