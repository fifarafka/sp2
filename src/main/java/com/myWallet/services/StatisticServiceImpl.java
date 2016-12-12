package com.myWallet.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myWallet.dto.CategoryStatisticDto;
import com.myWallet.dto.DayStatisticDto;
import com.myWallet.dto.MonthStatisticDto;
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

	@Override
	public List<MonthStatisticDto> getStatisticByMonth(AppUser appUser) {
		List<Expense> expenses = expenseRepository.findAllByAppUserOrderByDateOfExpenseAsc(appUser);
		List<MonthStatisticDto> statistics = new ArrayList<>();
		for (Expense expense : expenses) {
				countMonthValue(expense, statistics);
		}
		return statistics;
	}
	
	private void countMonthValue(Expense expense, List<MonthStatisticDto> statistics) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(expense.getDateOfExpense());
		MonthStatisticDto dto;
		if (statistics.size() != 0) {
			dto = statistics.get(statistics.size()-1);
			if (dto.getYear() == cal.get(Calendar.YEAR) && dto.getMonth() == (cal.get(Calendar.MONTH))+1) {
				dto.setValue(dto.getValue().add(expense.getValue()));
			} else {
				dto = new MonthStatisticDto();
				dto.setMonth(cal.get(Calendar.MONTH)+1);
				dto.setYear(cal.get(Calendar.YEAR));
				dto.setValue(expense.getValue());
				statistics.add(dto);
			}
		} else {
			dto = new MonthStatisticDto();
			dto.setMonth(cal.get(Calendar.MONTH)+1);
			dto.setYear(cal.get(Calendar.YEAR));
			dto.setValue(expense.getValue());
			statistics.add(dto);
		}
	}

	@Override
	public List<DayStatisticDto> getStatisticByDay(AppUser appUser) {
		List<Expense> expenses = expenseRepository.findAllByAppUserOrderByDateOfExpenseAsc(appUser);
		List<DayStatisticDto> statistics = new ArrayList<>();
		for (Expense expense : expenses) {
				countDayValue(expense, statistics);
		}
		return statistics;
	}
	
	private void countDayValue(Expense expense, List<DayStatisticDto> statistics) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(expense.getDateOfExpense());
		DayStatisticDto dto;
		if (statistics.size() != 0) {
			dto = statistics.get(statistics.size()-1);
			if (dto.getYear() == cal.get(Calendar.YEAR) && dto.getMonth() == (cal.get(Calendar.MONTH))+1 && dto.getDay() == cal.get(Calendar.DAY_OF_MONTH)) {
				dto.setValue(dto.getValue().add(expense.getValue()));
			} else {
				dto = new DayStatisticDto();
				dto.setDay(cal.get(Calendar.DAY_OF_MONTH));
				dto.setMonth(cal.get(Calendar.MONTH)+1);
				dto.setYear(cal.get(Calendar.YEAR));
				dto.setValue(expense.getValue());
				statistics.add(dto);
			}
		} else {
			dto = new DayStatisticDto();
			dto.setDay(cal.get(Calendar.DAY_OF_MONTH));
			dto.setMonth(cal.get(Calendar.MONTH)+1);
			dto.setYear(cal.get(Calendar.YEAR));
			dto.setValue(expense.getValue());
			statistics.add(dto);
		}
	}
}
