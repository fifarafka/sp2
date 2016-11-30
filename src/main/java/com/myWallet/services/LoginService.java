package com.myWallet.services;


import com.myWallet.dto.LoginDto;

public interface LoginService {
	
	String login(LoginDto loginDto);
	
	void logout(String token);

}
