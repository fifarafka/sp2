package com.myWallet.services;


import com.myWallet.dto.AppUserDto;

public interface LoginService {
	
	String login(AppUserDto loginDto);
	
	void logout(String token);

}
