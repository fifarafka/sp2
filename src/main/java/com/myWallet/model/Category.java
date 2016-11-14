package com.myWallet.model;

import javax.persistence.Entity;

@Entity
public class Category extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7430939352333014152L;
	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
