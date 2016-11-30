package com.myWallet.services;

import com.myWallet.dto.LoginDto;
import com.myWallet.model.AppUser;

public interface TokenService {
	
	String generateToken(LoginDto loginDto);
	
	AppUser validateToken(String token);

}
