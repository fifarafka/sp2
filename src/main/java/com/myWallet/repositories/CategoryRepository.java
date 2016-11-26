package com.myWallet.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.myWallet.model.AppUser;
import com.myWallet.model.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long>{
	
	List<Category> findAllByAppUser(AppUser appUser);

}
