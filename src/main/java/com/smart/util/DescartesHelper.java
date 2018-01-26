package com.smart.util;

public class DescartesHelper<T> {
	public void doCross(Dim<T>[] dims){
		for(int i=0; i<getTotalResultCount(dims); i++){
			
		}
	}
	
	public static int getTotalResultCount(Dim[] dims){
		int result = 1;
		for(Dim dim : dims){
			if(dim.getLength()!=0){
				result *= dim.getLength();
			}
		}
		return result;
	}
	public static void main(String[] args){
		
	}
	
}
