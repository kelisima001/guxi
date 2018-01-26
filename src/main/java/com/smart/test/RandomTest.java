package com.smart.test;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		for(int i=0; i<=20; i++) {
			System.out.println(random.nextInt(50));
		}
	}

}
