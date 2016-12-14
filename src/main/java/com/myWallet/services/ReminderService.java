package com.myWallet.services;

import com.myWallet.dto.ReminderDto;
import com.myWallet.model.AppUser;

public interface ReminderService {
	
	void sendReminder();
	
	void sendReport();
	
	void addReminder(ReminderDto reminderDto, AppUser user);

	ReminderDto getReminderDay(AppUser user);

	void deleteReminder(AppUser user);

}
