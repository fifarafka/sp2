package com.myWallet.services;

import java.util.List;

import com.myWallet.dto.CategoryDto;
import com.myWallet.model.AppUser;

public interface CategoryService {
	
	CategoryDto addCategory(CategoryDto categoryDto, AppUser user);
	
	List<CategoryDto> getCategoryList(AppUser appUser);
	
	CategoryDto getCategory(Long id);
	
	void deleteCategory(Long id);

}
