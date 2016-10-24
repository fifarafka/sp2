package com.myWallet.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.myWallet.model.Expense;

public interface ExpenseRepository extends PagingAndSortingRepository<Expense, Long>{

}
