package com.myWallet.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myWallet.dto.CategoryDto;
import com.myWallet.model.AppUser;
import com.myWallet.services.CategoryService;
import com.myWallet.services.TokenService;

@RequestMapping(value = "/api/category")
@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private TokenService tokenService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<CategoryDto> count(HttpServletRequest request, HttpServletResponse response) {
		String token = request.getHeader("Authorization");
		AppUser user = tokenService.validateToken(token);
		if (user == null) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return null;
		} else {
			response.setStatus(HttpStatus.OK.value());
			return categoryService.getCategoryList(user);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
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