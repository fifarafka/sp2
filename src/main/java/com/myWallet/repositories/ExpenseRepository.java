package com.myWallet.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.myWallet.model.AppUser;
import com.myWallet.model.Expense;

public interface ExpenseRepository extends PagingAndSortingRepository<Expense, Long>{
	
	List<Expense> findAllByAppUser(AppUser appUser);

}
