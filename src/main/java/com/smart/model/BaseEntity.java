package com.smart.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.smart.util.DateUtil;

@MappedSuperclass
public class BaseEntity<T extends BaseEntity<T>> implements Serializable{
	protected static final SimpleDateFormat LONG_DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
	protected static final SimpleDateFormat LONG_DATETIME_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	protected static final SimpleDateFormat SHORT_DATETIME_FORMATTER = new SimpleDateFormat("MM-dd HH:mm");
	private static final long serialVersionUID = 8005980104474496794L;

	@Id
	@GeneratedValue(generator = "longIdGenerator")
	@GenericGenerator(name = "longIdGenerator", strategy = "com.smart.model.LongIdGenerator")
	protected Long id;

	/**
	 * 被查看次数
	 */
	private int viewCount;
	
	/**
	 * 专属排序字段
	 */
	private int sort = 0;
	
	/**
	 * 创建日期
	 */
	protected Date timeCreated = new Date();
	
	/**
	 * 修改日期
	 */
	protected Date timeUpdated = new Date();
	
	@Transient
	protected String timeCreatedStr;
	
	@Transient
	protected String timeUpdateStr;
	
	@Transient
	protected String validateCode;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Date getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Date getTimeUpdated() {
		return timeUpdated;
	}

	public void setTimeUpdated(Date timeUpdated) {
		this.timeUpdated = timeUpdated;
	}

	public String getTimeCreatedStr() {
		int days = Math.abs(DateUtil.daysBetween(timeCreated, new Date()));
		if(days>=1){
			return LONG_DATE_FORMATTER.format(timeCreated);
		}
		return SHORT_DATETIME_FORMATTER.format(timeCreated);
	}
	
	public String getTimeUpdatedStr() {
		int days = Math.abs(DateUtil.daysBetween(timeUpdated, new Date()));
		if(days>=1){
			return LONG_DATE_FORMATTER.format(timeUpdated);
		}
		return SHORT_DATETIME_FORMATTER.format(timeUpdated);
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	
	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	@Override
	public int hashCode() {
		int hashCode = 17;
		hashCode += null == getId() ? 0 : getId().hashCode() * 31;
		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity<?> other = (BaseEntity<?>) obj;
		return null == this.getId() ? false : this.getId().equals(other.getId());
	}

}