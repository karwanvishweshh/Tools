package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.StockInfo;

public interface IStockDetailsRepository extends CrudRepository<StockInfo, Integer>,PagingAndSortingRepository<StockInfo, Integer> ,JpaRepository<StockInfo,Integer>
{
	
	
	

}
