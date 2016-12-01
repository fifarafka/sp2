package com.myWallet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myWallet.dto.AppUserDto;
import com.myWallet.model.AppUser;
import com.myWallet.repositories.AppUserRepository;
import com.myWallet.transformers.AppUserTransformer;

@Service
public class AppUserServiceImpl implements AppUserService {
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private AppUserTransformer appUserTransformer;

	@Override
	public boolean addUser(AppUserDto appUserDto) {
		AppUser appUser = appUserRepository.findOneByLoginAndPassword(appUserDto.getLogin(), appUserDto.getPassword());
		if (appUser!=null) {
			return false;
		} else {
			AppUser user = appUserRepository.save(appUserTransformer.transformFromDto(new AppUser(), appUserDto));
			if (user!=null) {
			return true;
			} else {
				return false;
			}
		}
	}
}
