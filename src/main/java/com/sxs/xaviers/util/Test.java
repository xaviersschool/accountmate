package com.sxs.xaviers.util;

import java.time.LocalDateTime;

public class Test {
public static void main(String[] args) {
	
	
	LocalDateTime now = LocalDateTime.now();
	System.out.println(now.getMonth().toString().toLowerCase());
}
public enum Month {
	JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6), JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10),
	NOVEMBER(11), DECEMBER(12);
	private final int number;
	Month(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
}
