package com.myWallet.transformers;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myWallet.dto.ReminderDto;
import com.myWallet.model.Reminder;

@Service
public class ReminderTransformer implements AbstractTransformer<Reminder, ReminderDto>
{

	@Override
	public List<Reminder> transformFromDto(List<ReminderDto> dtos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reminder transformFromDto(Reminder entity, ReminderDto dto) {
		dto.setReminderDay(entity.getReminderDay());
		return entity;
	}

	@Override
	public List<ReminderDto> transformFromEntity(List<Reminder> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReminderDto transformFromEntity(Reminder entity) {
		ReminderDto dto = new ReminderDto();
		dto.setReminderDay(entity.getReminderDay());
		return dto;
	}

}
 