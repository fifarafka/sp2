package com.myWallet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myWallet.dto.ExpenseDto;
import com.myWallet.model.AppUser;
import com.myWallet.model.Expense;
import com.myWallet.repositories.ExpenseRepository;
import com.myWallet.transformers.ExpenseTransformer;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private ExpenseTransformer expenseTransformer;
	
	@Autowired
	private UserSessionService userSessionService;

	@Override
	public void addExpense(ExpenseDto expenseDto) {
		expenseRepository.save(expenseTransformer.transformFromDto(new Expense(), expenseDto));
	}

	@Override
	public List<ExpenseDto> getListExpense() {
		AppUser appUser = userSessionService.getLoggedUser();
		return expenseTransformer.transformFromEntity((List<Expense>)expenseRepository.findAllByAppUser(appUser));
	}

	@Override
	public ExpenseDto getExpense(Long id) {
		return expenseTransformer.transformFromEntity(expenseRepository.findOne(id));
	}

	@Override
	public void deleteExpense(Long id) {
		expenseRepository.delete(id);
	}

}
