package com.myWallet.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.myWallet.services.ReminderService;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private ReminderService reminderService;
    
    @Scheduled(cron = "0 0 8 * * *", zone = "Europe/Warsaw")
    public void reportCurrentTime() {
        log.info(dateFormat.format(new Date())+ "Sending reminders to users.");
        reminderService.sendReport();
    }
}
