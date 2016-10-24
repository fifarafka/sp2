package com.myWallet.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myWallet.dto.ExpenseDto;
import com.myWallet.services.ExpenseService;

@RequestMapping(value = "/api/expense")
@RestController
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<ExpenseDto> getExpenseList() {
		return expenseService.getListExpense();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void addExpense(@RequestBody @Valid ExpenseDto expenseDto) {
		expenseService.addExpense(expenseDto);
	}
}
