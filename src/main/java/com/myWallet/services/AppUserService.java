package com.myWallet.services;

import com.myWallet.dto.AppUserDto;
import com.myWallet.model.AppUser;

public interface AppUserService {
	
	boolean addUser(AppUserDto appUserDto);

	void changePassword(AppUser user, String newPassword);

}
