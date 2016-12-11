package com.myWallet.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ExpenseDto extends AbstractDto {
	
	private Long id;
	
	private CategoryDto category;
	
	private String name;
	
	private BigDecimal value;
	
	private Date dateOfExpense;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getDateOfExpense() {
		return dateOfExpense;
	}

	public void setDateOfExpense(Date dateOfExpense) {
		this.dateOfExpense = dateOfExpense;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
