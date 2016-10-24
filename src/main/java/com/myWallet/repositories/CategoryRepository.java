package com.myWallet.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.myWallet.model.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long>{

}
