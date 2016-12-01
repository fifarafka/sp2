package com.myWallet.services;

import java.util.List;

import com.myWallet.dto.ExpenseDto;
import com.myWallet.model.AppUser;

public interface ExpenseService {
	
	void addExpense(ExpenseDto expenseDto, AppUser appUser);
	
	List<ExpenseDto> getListExpense(AppUser user);
	
	ExpenseDto getExpense(Long id);
	
	void deleteExpense(Long id);

	List<ExpenseDto> getSortedListExpense(AppUser appUser, String sortType);
	
	List<ExpenseDto> getListExpenseByCategoryName(AppUser appUser, String categoryName);

}
