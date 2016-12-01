package com.myWallet.transformers;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myWallet.dto.AppUserDto;
import com.myWallet.model.AppUser;

@Service
public class AppUserTransformerImpl implements AppUserTransformer {

	@Override
	public List<AppUser> transformFromDto(List<AppUserDto> dtos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppUser transformFromDto(AppUser entity, AppUserDto dto) {
		entity.setLogin(dto.getLogin());
		entity.setPassword(dto.getPassword());
		return entity;
	}

	@Override
	public List<AppUserDto> transformFromEntity(List<AppUser> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppUserDto transformFromEntity(AppUser entity) {
		AppUserDto dto = new AppUserDto();
		dto.setLogin(entity.getLogin());
		dto.setPassword(entity.getPassword());
		return dto;
	}

}
