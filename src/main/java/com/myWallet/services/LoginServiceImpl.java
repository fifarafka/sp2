package com.myWallet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myWallet.dto.AppUserDto;
import com.myWallet.model.AppUser;
import com.myWallet.repositories.AppUserRepository;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private AppUserRepository userRepository;
	
	@Autowired
	private TokenService tokenService;

	@Override
	public String login(AppUserDto loginDto) {
		AppUser appUser = userRepository.findOneByLoginAndPassword(loginDto.getLogin(), loginDto.getPassword());
		if (appUser == null) {
			return null;
		} else {
			String token = tokenService.generateToken(loginDto);
			//String token = "TOKEN";
			appUser.setToken(token);
			userRepository.save(appUser);
			return token;
		}
	}

	@Override
	public void logout(String token) {
		AppUser appUser = userRepository.findOneByToken(token);
		appUser.setToken(null);
		userRepository.save(appUser);
	}

}
