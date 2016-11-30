package com.myWallet.transformers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myWallet.dto.CategoryDto;
import com.myWallet.model.Category;

@Service
public class CategoryTransformerImpl implements CategoryTransformer {
	
	
	@Override
	public List<Category> transformFromDto(List<CategoryDto> dtos) {
		List<Category> entities = new ArrayList<>();
		for(CategoryDto dto: dtos) {
			entities.add(transformFromDto(new Category(), dto));
		}
		return entities;
	}

	@Override
	public Category transformFromDto(Category entity, CategoryDto dto) {
		//entity.setAppUser(appUser);
		entity.setCategoryName(dto.getCategoryName());
		return entity;
	}

	@Override
	public List<CategoryDto> transformFromEntity(List<Category> entities) {
		List<CategoryDto> dtos = new ArrayList<>();
		for(Category entity: entities) {
			dtos.add(transformFromEntity(entity));
		}
		return dtos;
	}

	@Override
	public CategoryDto transformFromEntity(Category entity) {
		CategoryDto dto = new CategoryDto();
		dto.setCategoryName(entity.getCategoryName());
		return dto;
	}

}
