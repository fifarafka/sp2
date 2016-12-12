package com.myWallet.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myWallet.dto.CategoryStatisticDto;
import com.myWallet.dto.DayStatisticDto;
import com.myWallet.dto.MonthStatisticDto;
import com.myWallet.model.AppUser;
import com.myWallet.services.ReminderService;
import com.myWallet.services.StatisticService;
import com.myWallet.services.TokenService;

@RequestMapping(value = "/api/statistic")
@RestController
public class StatisticController {

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private StatisticService statisticService;
	
	@Autowired
	private ReminderService reminderService;
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	@ResponseBody
	public List<CategoryStatisticDto> getStatisticByCategory(HttpServletRequest request, HttpServletResponse response) {
		String token = request.getHeader("Authorization");
		AppUser user = tokenService.validateToken(token);
 		if (user == null) {
 			response.setStatus(HttpStatus.UNAUTHORIZED.value());
 			return null;
 		} else {
 			response.setStatus(HttpStatus.OK.value());
 			return statisticService.getStatisticByCategory(user);
 		}
	}
	
	@RequestMapping(value = "/month", method = RequestMethod.GET)
	@ResponseBody
	public List<MonthStatisticDto> getStatisticByMonth(HttpServletRequest request, HttpServletResponse response) {
		String token = request.getHeader("Authorization");
		AppUser user = tokenService.validateToken(token);
 		if (user == null) {
 			response.setStatus(HttpStatus.UNAUTHORIZED.value());
 			return null;
 		} else {
 			response.setStatus(HttpStatus.OK.value());
 			return statisticService.getStatisticByMonth(user);
 		}
	}
	
	@RequestMapping(value = "/day", method = RequestMethod.GET)
	@ResponseBody
	public List<DayStatisticDto> getStatisticByDay(HttpServletRequest request, HttpServletResponse response) {
		String token = request.getHeader("Authorization");
		AppUser user = tokenService.validateToken(token);
 		if (user == null) {
 			response.setStatus(HttpStatus.UNAUTHORIZED.value());
 			return null;
 		} else {
 			response.setStatus(HttpStatus.OK.value());
 			return statisticService.getStatisticByDay(user);
 		}
	}
	
	@RequestMapping(value = "/mailTest", method = RequestMethod.GET)
	public void sendEmail(HttpServletRequest request, HttpServletResponse response) {
		reminderService.sendReport();
	}
}
