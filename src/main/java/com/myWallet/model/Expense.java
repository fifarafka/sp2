package com.myWallet.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Expense extends AbstractEntity {
	
	
	private BigDecimal value;
	
	private LocalDate dateOfExpense;

	
	@NotNull
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
