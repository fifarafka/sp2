package com.myWallet.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myWallet.dto.AppUserDto;
<<<<<<< HEAD
import com.myWallet.dto.ExpenseDto;
import com.myWallet.dto.PasswordDto;
import com.myWallet.model.AppUser;
import com.myWallet.repositories.AppUserRepository;
import com.myWallet.services.AppUserService;
=======
import com.myWallet.dto.ReminderDto;
import com.myWallet.model.AppUser;
import com.myWallet.services.AppUserService;
import com.myWallet.services.ReminderService;
>>>>>>> a2915a09e00c3f2b1b93699aae54a7262ce68a14
import com.myWallet.services.TokenService;

@RequestMapping(value = "/api/user")
@RestController
public class UserController {
	
	@Autowired
	private AppUserService appUserService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
<<<<<<< HEAD
	private AppUserRepository appUserRepository;
=======
	private ReminderService reminderService;
>>>>>>> a2915a09e00c3f2b1b93699aae54a7262ce68a14
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public void register(@RequestBody @Valid AppUserDto appUserDto, HttpServletResponse response) {
		if (appUserDto.getLogin().isEmpty() || appUserDto.getPassword().isEmpty()) {
			response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		} else {
			if (appUserService.addUser(appUserDto)) {
				response.setStatus(HttpStatus.CREATED.value());
			} else {
				response.setStatus(HttpStatus.CONFLICT.value());
			}
		}
	}
	
<<<<<<< HEAD
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public void changePassword(@RequestBody @Valid PasswordDto passwordDto, HttpServletRequest request, HttpServletResponse response) {
		String token = request.getHeader("Authorization");
		AppUser user = tokenService.validateToken(token);
		if (user == null) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
		
		} else if (!passwordDto.getNewPassword().equals(passwordDto.getConfirmedPassword()) || 
				!passwordDto.getOldPassword().equals(user.getPassword())) {
		 	response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		
		} else {
			response.setStatus(HttpStatus.OK.value());
			appUserService.changePassword(user, passwordDto.getNewPassword());
		}
	}
	
=======
	@RequestMapping(value = "/reminder", method = RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public void register(@RequestBody @Valid ReminderDto reminderDto, HttpServletResponse response, HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		AppUser user = tokenService.validateToken(token);
 		if (user == null) {
 			response.setStatus(HttpStatus.UNAUTHORIZED.value());
 		} else {
 			response.setStatus(HttpStatus.CREATED.value());
 			reminderService.addReminder(reminderDto, user);
 		}
	}
	
	
>>>>>>> a2915a09e00c3f2b1b93699aae54a7262ce68a14
}
