package com.myWallet.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myWallet.dto.CategoryStatisticDto;
import com.myWallet.model.AppUser;
import com.myWallet.model.Category;
import com.myWallet.model.Expense;
import com.myWallet.repositories.CategoryRepository;
import com.myWallet.repositories.ExpenseRepository;

@Service
public class StatisticServiceImpl implements StatisticService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public List<CategoryStatisticDto> getStatisticByCategory(AppUser appUser) {
		List<Category> categories = categoryRepository.findAllByAppUser(appUser);
		List<CategoryStatisticDto> statistics = new ArrayList<>();
		for (Category category : categories) {
			statistics.add(countValuesForCategory(appUser, category));
		}
		return statistics;
	}
	
	private CategoryStatisticDto countValuesForCategory(AppUser appUser, Category category) {
		CategoryStatisticDto statistic = new CategoryStatisticDto();
		statistic.setCategoryName(category.getCategoryName());
		List<Expense> expenses = expenseRepository.findAllByAppUserAndCategory(appUser, category);
		BigDecimal value = BigDecimal.ZERO;
		for (Expense expense : expenses) {
			value = value.add(expense.getValue());
		}
		statistic.setValue(value);
		return statistic;
	}

}
