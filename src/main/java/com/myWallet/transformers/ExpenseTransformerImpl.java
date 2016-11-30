package com.myWallet.transformers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myWallet.dto.ExpenseDto;
import com.myWallet.model.AppUser;
import com.myWallet.model.Category;
import com.myWallet.model.Expense;

@Service
public class ExpenseTransformerImpl implements ExpenseTransformer {
	
	@Autowired
	private CategoryTransformer categoryTransformer;

	@Override
	public List<Expense> transformFromDto(List<ExpenseDto> dtos) {
		List<Expense> entities = new ArrayList<>();
		for(ExpenseDto dto: dtos) {
			entities.add(transformFromDto(new Expense(), dto));
		}
		return entities;
	}

	@Override
	public Expense transformFromDto(Expense entity, ExpenseDto dto) {
		//entity.setAppUser(appUser);
		entity.setDateOfExpense(dto.getDateOfExpense());
		entity.setValue(dto.getValue());
		entity.setName(dto.getName());
		entity.setCategory(categoryTransformer.transformFromDto(new Category(), dto.getCategory()));
		return entity;
	}

	@Override
	public List<ExpenseDto> transformFromEntity(List<Expense> entities) {
		List<ExpenseDto> dtos = new ArrayList<>();
		for(Expense entity: entities) {
			dtos.add(transformFromEntity(entity));
		}
		return dtos;
	}

	@Override
	public ExpenseDto transformFromEntity(Expense entity) {
		ExpenseDto dto = new ExpenseDto();
		dto.setDateOfExpense(entity.getDateOfExpense());
		dto.setValue(entity.getValue());
		dto.setName(entity.getName());
		dto.setCategory(categoryTransformer.transformFromEntity(entity.getCategory()));
		return dto;
	}
}
