package com.myWallet.dto;

import java.util.ArrayList;
import java.util.List;


import com.myWallet.model.Category;
import com.myWallet.model.Expense;

public class AppUserDto {
	
private String login;
	
	private String password;
	
	private List<Category> categories = new ArrayList<>();
	
	private List<Expense> expenses = new ArrayList<>();

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

}
