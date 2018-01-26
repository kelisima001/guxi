package com.smart.service;

import org.springframework.transaction.annotation.Transactional;

import com.smart.model.Tag;
import com.smart.model.TagCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Transactional(readOnly=true)
public interface TagService extends BaseService<Tag, TagCond, Long>{

}
