package com.smart.service;

import org.springframework.transaction.annotation.Transactional;

import com.smart.model.Suggestion;
import com.smart.model.SuggestionCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Transactional(readOnly=true)
public interface SuggestionService extends BaseService<Suggestion, SuggestionCond, Long>{

}
