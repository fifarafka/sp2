package com.myWallet.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.myWallet.model.Reminder;

public interface ReminderRepository extends PagingAndSortingRepository<Reminder, Long> {

}
