package com.myWallet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myWallet.dto.LoginDto;
import com.myWallet.model.AppUser;
import com.myWallet.repositories.UserRepository;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String login(LoginDto loginDto) {
		AppUser appUser = userRepository.findOneByLoginAndPassword(loginDto.getLogin(), loginDto.getPassword());
		if (appUser == null) {
			return null;
		} else {
			return "TOKENYOLO";
		}
	}

}
