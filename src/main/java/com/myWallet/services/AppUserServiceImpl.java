package com.myWallet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myWallet.dto.AppUserDto;
import com.myWallet.dto.CategoryDto;
import com.myWallet.model.AppUser;
import com.myWallet.repositories.AppUserRepository;
import com.myWallet.transformers.AppUserTransformer;

@Service
public class AppUserServiceImpl implements AppUserService {
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private AppUserTransformer appUserTransformer;

	@Override
	public boolean addUser(AppUserDto appUserDto) {
		AppUser appUser = appUserRepository.findOneByLogin(appUserDto.getLogin());
		if (appUser!=null) {
			return false;
		} else {
			AppUser user = appUserRepository.save(appUserTransformer.transformFromDto(new AppUser(), appUserDto));
			if (user!=null) {
				CategoryDto food = new CategoryDto();
				food.setCategoryName("Food");
				categoryService.addCategory(food, user);
				
				CategoryDto clothing = new CategoryDto();
				clothing.setCategoryName("Clothing");
				categoryService.addCategory(clothing, user);
				
				CategoryDto education = new CategoryDto();
				education.setCategoryName("Education");
				categoryService.addCategory(education, user);
				
				CategoryDto hobbies = new CategoryDto();
				hobbies.setCategoryName("Hobbies");
				categoryService.addCategory(hobbies, user);
				
				CategoryDto household = new CategoryDto();
				household.setCategoryName("Household");
				categoryService.addCategory(household, user);
				
				CategoryDto taxes = new CategoryDto();
				taxes.setCategoryName("Taxes");
				categoryService.addCategory(taxes, user);
				
				CategoryDto other = new CategoryDto();
				other.setCategoryName("Other");
				categoryService.addCategory(other, user);
				return true;
			} else {
				return false;
			}
		}
	}
	
	@Override
	public void changePassword(AppUser user, String newPassword) {
		user.setPassword(newPassword);
		appUserRepository.save(user);
		
	}
	
	@Override
	public	void changeReport(AppUser user, boolean newReport) {
		user.setReport(newReport);
		appUserRepository.save(user);
	}
}
