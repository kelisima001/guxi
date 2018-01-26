package com.smart.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 分页查询结果封装,可用于Hibernate的分页和Mybatis分页<br>
 * 分页参数用 {@link PageRequest}，分页序号从1开始<br>
 * @param <T> Page中记录的类型.
 */
public class Page<T> implements Iterable<T>, Serializable {

	private static final long serialVersionUID = 7056472893610088552L;
	
	private static final int additionalPages = 10;
	
	private final List<T> content = new ArrayList<T>();
	private final PageRequest pageRequest;
	private final long total;
	
	public Page(List<T> content, PageRequest pageRequest, long total) {
		if (null == content) {
			throw new IllegalArgumentException("Content must not be null!");
		}
		this.content.addAll(content);
		this.total = total;
		this.pageRequest = pageRequest;
	}

	public Page(List<T> content, PageRequest pageRequest) {
		if (null == content) {
			throw new IllegalArgumentException("Content must not be null!");
		}
		this.content.addAll(content);
		this.total = pageRequest.getTotal();
		this.pageRequest = pageRequest;
	}

	public int getPageNumber() {
		return pageRequest == null ? 0 : pageRequest.getPageNumber();
	}

	public int getPageSize() {
		return pageRequest == null ? 0 : pageRequest.getPageSize();
	}

	public int getTotalPages() {
		return getPageSize() == 0 ? 0 : (int) Math.ceil((double) total / (double) getPageSize());
	}

	public long getTotal() {
		return total;
	}

	@Override
	public Iterator<T> iterator() {
		return content.iterator();
	}

	public List<T> getContent() {
		return Collections.unmodifiableList(content);
	}

	public boolean hasContent() {
		return !content.isEmpty();
	}
	
	/**=================分页显示辅助方法==================*/
	public boolean isHasPre() {
		return getPageNumber() > 1;
	}
	
	public boolean isHasNext() {
		return ((getPageNumber()) * getPageSize()) < total;
	}

	public boolean isFirst() {
		return !isHasPre();
	}

	public boolean isLast() {
		return !isHasNext();
	}
	
	/**
	 * 显示当前页面之前的页
	 * @return
	 */
	public long getBeginPage() {
		if (getTotalPages() <= additionalPages || getPageNumber() <= additionalPages / 2) {
			return 1;
		}
		return (getTotalPages() - getPageNumber() <= additionalPages / 2) ? getTotalPages() - additionalPages : getPageNumber() - additionalPages / 2;
	}
	
	/**
	 * 显示当前页面之后的5页
	 * @return
	 */
	public long getEndPage() {
		if (getTotalPages() <= additionalPages || getTotalPages() - getPageNumber() <= additionalPages / 2) {
			return getTotalPages();
		}
		return (getPageNumber() <= additionalPages / 2) ? additionalPages : (getPageNumber() + additionalPages / 2);
	}
	

	@Override
	public String toString() {
		String contentType = "UNKNOWN";
		if (content.size() > 0) {
			contentType = content.get(0).getClass().getName();
		}
		return String.format("Page %s of %d containing %s instances", getPageNumber(), getTotalPages(), contentType);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + (int) (total ^ (total >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Page<?> other = (Page<?>) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (total != other.total)
			return false;
		return true;
	}
}
