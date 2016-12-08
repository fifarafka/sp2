package com.myWallet.dto;

import java.math.BigDecimal;

public class MonthStatisticDto extends AbstractDto implements Comparable<MonthStatisticDto>{
	
	private int year;
	
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

	private int month;
	
	private BigDecimal value;

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public int compareTo(MonthStatisticDto o) {
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
		if (yearCompare == -1) {
			return -1;
		} else if (yearCompare == 1) {
			return 1;
		} else {
			return monthCompare;
		}
	}
	

}
