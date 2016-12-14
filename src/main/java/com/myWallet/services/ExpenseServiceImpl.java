package com.myWallet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myWallet.dto.ExpenseDto;
import com.myWallet.model.AppUser;
import com.myWallet.model.Category;
import com.myWallet.model.Expense;
import com.myWallet.repositories.CategoryRepository;
import com.myWallet.repositories.ExpenseRepository;
import com.myWallet.transformers.ExpenseTransformer;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ExpenseTransformer expenseTransformer;

	@Override
	public void addExpense(ExpenseDto expenseDto, AppUser appUser) {
		Expense expense = new Expense();
		appUser.setMonthExpenses(appUser.getMonthExpenses().add(expenseDto.getValue()));
		expense.setAppUser(appUser);
		expense.setCategory(categoryRepository.findOneByAppUserAndCategoryName(appUser, expenseDto.getCategory().getCategoryName()));
		expenseRepository.save(expenseTransformer.transformFromDto(expense, expenseDto));
	}

	@Override
	public List<ExpenseDto> getListExpense(AppUser appUser) {
		return expenseTransformer.transformFromEntity((List<Expense>)expenseRepository.findAllByAppUser(appUser));
	}
	
	@Override
	public List<ExpenseDto> getSortedListExpense(AppUser appUser, String sortType) {
		switch(sortType) {
			case "priceDesc":
				return expenseTransformer.transformFromEntity((List<Expense>)expenseRepository.findAllByAppUserOrderByValueDesc(appUser));
				
			case "priceAsc":
				return expenseTransformer.transformFromEntity((List<Expense>)expenseRepository.findAllByAppUserOrderByValueAsc(appUser));
				
			case "dateDesc":
				return expenseTransformer.transformFromEntity((List<Expense>)expenseRepository.findAllByAppUserOrderByDateOfExpenseDesc(appUser));
				
			case "dateAsc":
				return expenseTransformer.transformFromEntity((List<Expense>)expenseRepository.findAllByAppUserOrderByDateOfExpenseAsc(appUser));
				
			default:
				return expenseTransformer.transformFromEntity((List<Expense>)expenseRepository.findAllByAppUser(appUser));
		}
	}

	@Override
	public ExpenseDto getExpense(Long id) {
		return expenseTransformer.transformFromEntity(expenseRepository.findOne(id));
	}

	@Override
	public void deleteExpense(Long id) {
		expenseRepository.delete(id);
	}

	@Override
	public List<ExpenseDto> getListExpenseByCategoryName(AppUser appUser, String categoryName) {
		Category category = categoryRepository.findOneByAppUserAndCategoryName(appUser, categoryName);
		return expenseTransformer.transformFromEntity((List<Expense>)expenseRepository.findAllByAppUserAndCategory(appUser, category));
	}

}
