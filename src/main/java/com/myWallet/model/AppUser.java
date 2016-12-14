package com.myWallet.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class AppUser extends AbstractEntity {
	
	private static final long serialVersionUID = -8738600184924825511L;

	private String login;
	
	private String password;
	
	private String token;

	private boolean report;
	
	private Integer reminder = new Integer("0");
	
	private BigDecimal monthExpenses = BigDecimal.ZERO;

	@OneToMany
	private List<Category> categories = new ArrayList<>();
	
	@OneToMany
	private List<Expense> expenses = new ArrayList<>();

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isReport() {
		return report;
	}

	public void setReport(boolean report) {
		this.report = report;
	}

	public Integer getReminder() {
		return reminder;
	}

	public void setReminder(Integer reminder) {
		this.reminder = reminder;
	}

	public BigDecimal getMonthExpenses() {
		return monthExpenses;
	}

	public void setMonthExpenses(BigDecimal monthExpenses) {
		this.monthExpenses = monthExpenses;
	}
}
