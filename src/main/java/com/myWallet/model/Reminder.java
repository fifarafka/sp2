package com.myWallet.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Reminder extends AbstractEntity {

	private static final long serialVersionUID = 1525401561613577003L;
	
	private int reminderDay;
	
	private AppUser appUser;

	@ManyToOne
	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public int getReminderDay() {
		return reminderDay;
	}

	public void setReminderDay(int reminderDay) {
		this.reminderDay = reminderDay;
	}
}
