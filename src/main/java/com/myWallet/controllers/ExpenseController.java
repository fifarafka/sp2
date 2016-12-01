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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myWallet.dto.ExpenseDto;
import com.myWallet.model.AppUser;
import com.myWallet.services.ExpenseService;
import com.myWallet.services.TokenService;

@RequestMapping(value = "/api/expense")
@RestController
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@Autowired
	private TokenService tokenService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<ExpenseDto> getExpenseList(@RequestParam(value = "categoryName", required = false) String categoryName, HttpServletRequest request, HttpServletResponse response) {
		String token = request.getHeader("Authorization");
		AppUser user = tokenService.validateToken(token);
		if (user == null) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return null;
		} else {
			response.setStatus(HttpStatus.OK.value());
			return expenseService.getListExpense(user);
		}
	}
	
	@RequestMapping(value = "/list/{sortType}", method = RequestMethod.GET)
	public List<ExpenseDto> getSortedExpenseList(@PathVariable String sortType) {
		return expenseService.getSortedListExpense(sortType);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void addExpense(@RequestBody @Valid ExpenseDto expenseDto, HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		AppUser user = tokenService.validateToken(token);
		expenseService.addExpense(expenseDto, user);
	}
	
	@RequestMapping(value = "/{expenseID}", method = RequestMethod.DELETE)
	public void deleteExpense(@PathVariable Long expenseID) {
		expenseService.deleteExpense(expenseID);
	}
	
	@RequestMapping(value = "/{expenseID}", method = RequestMethod.GET)
	public ExpenseDto getExpense(@PathVariable Long expenseID) {
		return expenseService.getExpense(expenseID);
	}
}
