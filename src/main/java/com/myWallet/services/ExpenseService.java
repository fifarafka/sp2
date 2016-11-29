package com.myWallet.services;

import java.util.List;

import com.myWallet.dto.ExpenseDto;

public interface ExpenseService {
	
	void addExpense(ExpenseDto expenseDto);
	
	List<ExpenseDto> getListExpense();
	
	ExpenseDto getExpense(Long id);
	
	void deleteExpense(Long id);

	List<ExpenseDto> getSortedListExpense(String sortType);
	
	List<ExpenseDto> getListExpenseByCategoryName(String categoryName);

}
