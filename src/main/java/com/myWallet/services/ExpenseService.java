package com.myWallet.services;

import java.util.List;

import com.myWallet.dto.ExpenseDto;

public interface ExpenseService {
	
	void addExpense(ExpenseDto expenseDto);
	
	List<ExpenseDto> getListExpense();

}
