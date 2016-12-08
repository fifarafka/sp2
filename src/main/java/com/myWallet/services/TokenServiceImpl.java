package com.myWallet.services;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.myWallet.dto.AppUserDto;
import com.myWallet.model.AppUser;
import com.myWallet.repositories.AppUserRepository;

@Service
public class TokenServiceImpl implements TokenService{
	
	@Autowired
	private AppUserRepository userRepository;

	@Override
	public String generateToken(AppUserDto loginDto) {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}

	@Override
	public AppUser validateToken(String token) {
		return userRepository.findOneByToken(token);
	}
	
	public int getStatusAuthorization(String token) {
		AppUser appUser = validateToken(token);
		if (appUser == null) {
			return HttpStatus.UNAUTHORIZED.value();
		} else {
			return HttpStatus.OK.value();
		}
	}

}
