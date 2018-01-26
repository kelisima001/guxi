package com.smart.dao;
 
import org.springframework.stereotype.Repository;

import com.smart.model.Tag;
import com.smart.model.TagCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Repository
public class TagDaoImpl extends BaseEntityDao<Tag, TagCond, Long> implements TagDao{

}
