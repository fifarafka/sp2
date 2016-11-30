package com.myWallet.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myWallet.dto.LoginDto;
import com.myWallet.dto.TokenDto;
import com.myWallet.services.LoginService;


@RequestMapping(value = "/api")
@RestController
public class LoginController {
	
	@Autowired
	public LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes="application/json", produces= "application/json")
	@ResponseBody
	public TokenDto login(@RequestBody @Valid LoginDto loginDto, HttpServletResponse response) {
		String token = loginService.login(loginDto);
		if (token == null) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return null;
		} else {
			response.setStatus(HttpStatus.OK.value());
			TokenDto tokenDto = new TokenDto();
			tokenDto.setToken(token);
			return tokenDto;
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	public void logout(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		loginService.logout(token);
	}
}
