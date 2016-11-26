package com.myWallet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.myWallet.model.AppUser;
import com.myWallet.repositories.UserRepository;

@Service
public class UserSessionService {
	
	@Autowired
	UserRepository userRepository;
	
	public AppUser getLoggedUser(){	 
		  User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		  String login = user.getUsername();

		  return userRepository.findOneByLogin(login);
		}

}
