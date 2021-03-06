package com.smart.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 笛卡尔乘积工具 - String类型
 * @author Sunxin
 *
 */
public class CrossUtil {

	public static List<List<String>> cross(List<List<String>> crossArgs) {

		// 计算出笛卡尔积行数
		int rows = crossArgs.size() > 0 ? 1 : 0;

		for (List<String> data : crossArgs) {
			rows *= data.size();
		}

		// 笛卡尔积索引记录
		int[] record = new int[crossArgs.size()];

		List<List<String>> results = new ArrayList<List<String>>();

		// 产生笛卡尔积
		for (int i = 0; i < rows; i++) {
			List<String> row = new ArrayList<String>();

			// 生成笛卡尔积的每组数据
			for (int index = 0; index < record.length; index++) {
				row.add(crossArgs.get(index).get(record[index]));
			}

			results.add(row);
			crossRecord(crossArgs, record, crossArgs.size() - 1);
		}

		return results;
	}

	private static void crossRecord(List<List<String>> sourceArgs, int[] record, int level) {
		record[level] = record[level] + 1;

		if (record[level] >= sourceArgs.get(level).size() && level > 0) {
			record[level] = 0;
			crossRecord(sourceArgs, record, level - 1);
		}
	}
	
	public static void main(String[] args){
		List<List<String>> param = new ArrayList<List<String>>();
		List<String> dim1 = new ArrayList<String>();
		dim1.add("a");
		dim1.add("b");
		dim1.add("c");
		
		List<String> dim2 = new ArrayList<String>();
		dim2.add("1");
		dim2.add("2");
		
		List<String> dim3 = new ArrayList<String>();
		dim3.add("#");
		dim3.add("~");
		
		param.add(dim1);
		param.add(dim2);
		param.add(dim3);
		List<List<String>> result = cross(param);
		for(List<String> dim : result){
			for(String s : dim){
				System.out.print(s + " ");
			}
			System.out.println();
		}
		
	}
}
