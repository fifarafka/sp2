package com.myWallet.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	public void addCategory(@RequestBody @Valid CategoryDto categoryDto) {
		categoryService.addCategory(categoryDto);
	}

}
