package com.myWallet.services;

import java.util.List;

import com.myWallet.dto.CategoryStatisticDto;
import com.myWallet.dto.MonthStatisticDto;
import com.myWallet.model.AppUser;

public interface StatisticService {
	
	List<CategoryStatisticDto> getStatisticByCategory(AppUser appUser);
	
	List<MonthStatisticDto> getStatisticByMonth(AppUser appUser);

}
