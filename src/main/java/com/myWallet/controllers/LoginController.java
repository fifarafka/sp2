package com.myWallet.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myWallet.dto.LoginDto;
import com.myWallet.services.LoginService;


@RequestMapping(value = "/api/login")
@RestController
public class LoginController {
	
	@Autowired
	public LoginService loginService;
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public String login(@RequestBody @Valid LoginDto loginDto, HttpServletResponse response) {
		String token = loginService.login(loginDto);
		if (token == null) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return "BADTOKEN";
		} else {
			response.setStatus(HttpStatus.OK.value());
			return token;
		}
	}

}
