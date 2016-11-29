package com.myWallet.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.myWallet.model.AppUser;
import com.myWallet.model.Category;
import com.myWallet.model.Expense;

public interface ExpenseRepository extends PagingAndSortingRepository<Expense, Long>{
	
	List<Expense> findAllByAppUser(AppUser appUser);

	List<Expense> findAllByAppUserOrderByDateOfExpenseAsc(AppUser appUser);

	List<Expense> findAllByAppUserOrderByDateOfExpenseDesc(AppUser appUser);

	List<Expense> findAllByAppUserOrderByValueAsc(AppUser appUser);

	List<Expense> findAllByAppUserOrderByValueDesc(AppUser appUser);
	
	List<Expense> findAllByAppUserAndCategory(AppUser appUser, Category category);

}
