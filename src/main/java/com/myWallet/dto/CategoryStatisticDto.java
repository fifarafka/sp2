package com.myWallet.dto;

import java.math.BigDecimal;

public class CategoryStatisticDto extends AbstractDto {
	
	private String categoryName;
	
	private BigDecimal value;

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
