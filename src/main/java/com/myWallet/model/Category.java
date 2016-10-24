package com.myWallet.model;

import javax.persistence.Entity;

@Entity
public class Category extends AbstractEntity {
	
	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
