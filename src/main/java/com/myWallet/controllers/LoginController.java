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
import com.myWallet.dto.LoginResponseDto;
import com.myWallet.model.AppUser;
import com.myWallet.services.LoginService;
import com.myWallet.services.TokenService;


@RequestMapping(value = "/api")
@RestController
public class LoginController {
	
	@Autowired
	public LoginService loginService;
	
	@Autowired
	public TokenService tokenService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes="application/json", produces= "application/json")
	@ResponseBody
	public LoginResponseDto login(@RequestBody @Valid AppUserDto loginDto, HttpServletResponse response) {
		String token = loginService.login(loginDto);
		if (token == null) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return null;
		} else {
			response.setStatus(HttpStatus.OK.value());
			LoginResponseDto loginResponseDto = new LoginResponseDto();
			loginResponseDto.setToken(token);
			AppUser user = tokenService.validateToken(token);
			loginResponseDto.setReportValue(user.isReport());
			return loginResponseDto;
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	public void logout(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		loginService.logout(token);
	}
}
