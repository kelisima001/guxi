package com.smart.dao;
 
import org.springframework.stereotype.Repository;

import com.smart.model.Suggestion;
import com.smart.model.SuggestionCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Repository
public class SuggestionDaoImpl extends BaseEntityDao<Suggestion, SuggestionCond, Long> implements SuggestionDao{

}
