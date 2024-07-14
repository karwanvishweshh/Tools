package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nt.entity.StockInfo;

public interface IStockMgmtService {
	public String registerStock(StockInfo info);
	
	public boolean isStockAvailable(int i);
	
	public long fetchAllStockCount();
	
	public boolean checkStockAvailability(Integer id);
	
	public Iterable<StockInfo> showAllStocks();
	
	public Iterable<StockInfo> showAllStocksByIds(Iterable<Integer> ids);
	
	public StockInfo showStockById(Integer id);
	
	public String registerOrUpdateStock(StockInfo stock);
	
	
	public String deleteStock(StockInfo stock);
	
	public String removeAllStocks();
	
	public String removeStockByIds(Iterable<Integer> ids);
	
	public Iterable<StockInfo> showStocksBySorting(boolean asc,String ...props);
	
	public Page<StockInfo> showStockInfoByPageNo(int pageNo,int pageSize,boolean ascOrder, String props);

	public void showDataThroughPagination(int pageSize);
	public String deleteStockByIdsInBatch(List<Integer>ids);
	
	public List<StockInfo>showStockByExampleData(StockInfo exStock,boolean ascOrder,String ...properties);
	
	public StockInfo findStockById(Integer id);
	
	
}
