package com.myWallet.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Category extends AbstractEntity {
	
	private static final long serialVersionUID = -7430939352333014152L;
	private String categoryName;
	private AppUser appUser;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@ManyToOne
	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}
	
}
