package com.myWallet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myWallet.dto.CategoryDto;
import com.myWallet.model.AppUser;
import com.myWallet.model.Category;
import com.myWallet.repositories.CategoryRepository;
import com.myWallet.transformers.CategoryTransformer;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserSessionService userSessionService;
	
	@Autowired
	private CategoryTransformer categoryTransformer;

	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
		Category category = categoryRepository.save(categoryTransformer.transformFromDto(new Category(), categoryDto));
		return categoryTransformer.transformFromEntity(category);
	}

	@Override
	public List<CategoryDto> getCategoryList() {
		AppUser appUser = userSessionService.getLoggedUser();
		List<Category> categories = (List<Category>) categoryRepository.findAllByAppUser(appUser);
		return categoryTransformer.transformFromEntity(categories);
	}

	@Override
	public CategoryDto getCategoty(Long id) {
		CategoryDto dto = new CategoryDto();
		categoryTransformer.transformFromDto(categoryRepository.findOne(id), dto);
		return dto;
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepository.delete(id);
	}
}
