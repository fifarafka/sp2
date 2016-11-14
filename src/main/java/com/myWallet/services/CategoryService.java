package com.myWallet.services;

import java.util.List;

import com.myWallet.dto.CategoryDto;

public interface CategoryService {
	
	CategoryDto addCategory(CategoryDto categoryDto);
	
	List<CategoryDto> getCategoryList();
	
	CategoryDto getCategoty(Long id);
	
	void deleteCategory(Long id);

}
