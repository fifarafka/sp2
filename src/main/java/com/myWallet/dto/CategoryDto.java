package com.myWallet.dto;


public class CategoryDto extends AbstractDto {
	
	private Long id;
	private String categoryName;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
