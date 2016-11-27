package com.myWallet.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myWallet.dto.CategoryDto;
import com.myWallet.services.CategoryService;

@RequestMapping(value = "/api/category")
@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<CategoryDto> count() {
		return categoryService.getCategoryList();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public CategoryDto addCategory(@RequestBody @Valid CategoryDto categoryDto) {
		return categoryService.addCategory(categoryDto);
	}
	
	@RequestMapping(value = "/{categoryID}", method = RequestMethod.DELETE)
	public void deleteCategory(@PathVariable Long categoryID) {
		categoryService.deleteCategory(categoryID);
	}
	
	@RequestMapping(value = "/{categoryID}", method = RequestMethod.GET)
	public CategoryDto getCategory(@PathVariable Long categoryID) {
		return categoryService.getCategory(categoryID);
	}
}
