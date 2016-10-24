package com.myWallet.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseDto extends AbstractDto {
	
	private CategoryDto category;
	
	private BigDecimal value;
	
	private LocalDate dateOfExpense;

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public LocalDate getDateOfExpense() {
		return dateOfExpense;
	}

	public void setDateOfExpense(LocalDate dateOfExpense) {
		this.dateOfExpense = dateOfExpense;
	}
}
