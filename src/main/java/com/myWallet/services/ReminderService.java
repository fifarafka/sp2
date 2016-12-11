package com.myWallet.services;

import com.myWallet.dto.ReminderDto;
import com.myWallet.model.AppUser;

public interface ReminderService {
	
	void sendReport();
	
	void addReminder(ReminderDto reminderDto, AppUser user);

}
