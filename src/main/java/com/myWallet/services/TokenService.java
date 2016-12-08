package com.myWallet.services;

import com.myWallet.dto.AppUserDto;
import com.myWallet.model.AppUser;

public interface TokenService {
	
	String generateToken(AppUserDto loginDto);
	
	AppUser validateToken(String token);
	
}
