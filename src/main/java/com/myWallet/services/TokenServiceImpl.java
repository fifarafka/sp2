package com.myWallet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myWallet.dto.LoginDto;
import com.myWallet.model.AppUser;
import com.myWallet.repositories.UserRepository;

@Service
public class TokenServiceImpl implements TokenService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String generateToken(LoginDto loginDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppUser validateToken(String token) {
		return userRepository.findOneByToken(token);
	}

}
