package com.myWallet.transformers;

import java.util.List;

import com.myWallet.dto.ReminderDto;
import com.myWallet.model.Reminder;

public interface ReminderTransformer extends AbstractTransformer<Reminder, ReminderDto>
{

	public List<Reminder> transformFromDto(List<ReminderDto> dtos);

	public Reminder transformFromDto(Reminder entity, ReminderDto dto);

	public List<ReminderDto> transformFromEntity(List<Reminder> entity);

	public ReminderDto transformFromEntity(Reminder entity);

}
 