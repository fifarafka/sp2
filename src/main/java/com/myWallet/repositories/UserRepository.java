package com.myWallet.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.myWallet.model.AppUser;

public interface UserRepository extends PagingAndSortingRepository<AppUser, Long>{
	
	AppUser findOneByLogin(String login);

}
