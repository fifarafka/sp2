package com.myWallet.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class AppUser extends AbstractEntity {
	
	private static final long serialVersionUID = -8738600184924825511L;

	private String login;
	
	private String password;
	
	@OneToMany
	//@ElementCollection
	private List<Category> categories = new ArrayList<>();
	
	
	@OneToMany
	//@ElementCollection
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
}
