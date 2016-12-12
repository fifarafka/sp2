package com.myWallet.dto;

import java.math.BigDecimal;

public class DayStatisticDto extends AbstractDto implements Comparable<DayStatisticDto>{
	
	private int year;
	private int month;
	private int day;
	private BigDecimal value;
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public int compareTo(DayStatisticDto o) {
		int yearCompare = 0;
		
		if (year < o.year) {
			yearCompare = -1;
		} else if (year > o.year) {
			yearCompare = 1;
		}
		
		int monthCompare = 0;
		
		if (month < o.month) {
			monthCompare = -1;
		} else if (month > o.month) {
			monthCompare = 1;
		}
		
		int dayCompare = 0;
		
		if (day < o.day) {
			dayCompare = -1;
		} else if (day > o.day) {
			dayCompare = 1;
		}
		
		if (yearCompare == -1) {
			return -1;
		} else if (yearCompare == 1) {
			return 1;
		} else if (monthCompare == -1) {
			return -1;
		} else if (monthCompare == 1) {
			return 1;
		} else {
			return dayCompare;
		}
	}
	

}
