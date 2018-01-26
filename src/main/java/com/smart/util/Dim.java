package com.smart.util;

import java.util.List;

public class Dim<T> {
	private List<T> elements;
	private int index = 0;
	private int length = 0;
	public Dim(List<T> list){
		this.elements = list;
		this.length = list.size();
	}
	public List<T> getElements() {
		return elements;
	}
	public void setElements(List<T> elements) {
		this.elements = elements;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	
}
