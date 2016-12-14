package com.myWallet.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myWallet.dto.ReminderDto;
import com.myWallet.model.AppUser;
import com.myWallet.repositories.AppUserRepository;

@Service
public class ReminderServiceImpl implements ReminderService {
	
	private static String USER_NAME = "hajsApplication";
    private static String PASSWORD = "";
    
    @Autowired
    private AppUserRepository appUserRepository;

    private static void sendFromGMail(List<String> to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", USER_NAME);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(USER_NAME));
            InternetAddress[] toAddress = new InternetAddress[to.size()];

            for( int i = 0; i < to.size(); i++ ) {
                toAddress[i] = new InternetAddress(to.get(i));
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, USER_NAME, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }

	@Override
	public void sendReport(AppUser user) {
		List<String> to = new ArrayList<>();
		int day = LocalDate.now().getDayOfMonth();
		/*List<Reminder> reminders = (List<Reminder>) reminderRepository.findAll();
		for (Reminder reminder : reminders) {
			int reminderDay = reminder.getReminderDay();
			if (reminderDay == day) {
				to.add(reminder.getAppUser().getLogin());
			}
		}*/
		sendFromGMail(to, "Przypominamy o płatnościach!", "Pamiętaj, aby dokonać wszystkich płatności w terminie oraz zanotować je w aplikacji Zarządzanie Hajsem. Miłego dnia, życzy Zespół HajsApplication");
	}

	@Override
	public void addReminder(ReminderDto reminderDto, AppUser user) {
		AppUser appUser = appUserRepository.findOneByLogin(user.getLogin());
		appUser.setReminder(reminderDto.getReminderDay());
		appUserRepository.save(appUser);
		
	}

	@Override
	public ReminderDto getReminderDay(AppUser user) {
		AppUser appUser = appUserRepository.findOneByLogin(user.getLogin());
		ReminderDto dto = new ReminderDto();
		dto.setReminderDay(appUser.getReminder());
		return dto;
	}

	@Override
	public void deleteReminder(AppUser user) {
		// TODO Auto-generated method stub
		
	}

}
