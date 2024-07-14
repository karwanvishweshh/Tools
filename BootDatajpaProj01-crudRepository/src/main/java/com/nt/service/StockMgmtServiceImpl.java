package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.StockInfo;
import com.nt.repository.IStockDetailsRepository;

@Service("stockMgmtService")
public class StockMgmtServiceImpl implements IStockMgmtService {
	
	@Autowired
	private IStockDetailsRepository stockRepo;
	
	
	public String registerStock(StockInfo info) {
	StockInfo info1=	stockRepo.save(info);
		return "Object is saved with the id Value:"+info1.getStockId();
	}
	



	@Override
	public boolean isStockAvailable(int i) {
		boolean flag=stockRepo.existsById(i);
		return flag;
	}



	@Override
	public long fetchAllStockCount() {
		
		return stockRepo.count();
	}



	public boolean checkStockAvailability(Integer id) {
		
		return stockRepo.existsById(id);
	}



	@Override
	public Iterable<StockInfo> showAllStocks() {
		
		return stockRepo.findAll();
	}



	@Override
	public Iterable<StockInfo> showAllStocksByIds(Iterable<Integer> ids) {
	
		return stockRepo.findAllById(ids);
	}




	@Override
	public StockInfo showStockById(Integer id) {
		StockInfo stockinfo=new StockInfo();
		stockinfo.setExchangeName("NSE");
		StockInfo stock=stockRepo.findById(id).orElse(stockinfo);
		return stock;
	}




	public String registerOrUpdateStock(StockInfo stock) {
		Optional<StockInfo> opt=stockRepo.findById(stock.getStockId());
		if(opt.isPresent()) {
			stockRepo.save(stock);
			return stock.getStockId()+"Stock details are found and updated";
		}else {
			
	
		return "Stock is saved with id value:"+stockRepo.save(stock).getStockId();
		}
	}




	public String deleteStockById(Integer id) {
		Optional<StockInfo> opt=stockRepo.findById(id);
		if(opt.isPresent()) {
			stockRepo.deleteById(id);
			return id+" doctor is deleted";
		}
		else {
			return id+" doctor not found for deletion";
		}
	}




	@Override
	public String deleteStock(StockInfo stock) {
		Optional<StockInfo> opt=stockRepo.findById(stock.getStockId());
		if(opt.isEmpty()) {
			return stock.getStockId()+" stock is not Found";
		}
		else {
			stockRepo.delete(opt.get());
			return stock.getStockId()+" doctor found and deleted";
		}
	}




	public String removeAllStocks() {
		long count=stockRepo.count();
		if(count>0) {
			stockRepo.deleteAll();
			return count+"no.of records are deleted";
		}
		return "no records found delete";
	}




	@Override
	public String removeStockByIds(Iterable<Integer> ids) {
		List<StockInfo> list=(List<StockInfo>) stockRepo.findAllById(ids);
		stockRepo.deleteAllById(ids);
		return list.size()+"no.of records are deleted";
	}




	public Iterable<StockInfo> showStocksBySorting(boolean asc, String... props) {
		Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC,props);
		Iterable<StockInfo> it=stockRepo.findAll(sort);		return it;
	}




	@Override
	public Page<StockInfo> showStockInfoByPageNo(int pageNo, int pageSize, boolean ascOrder, String props) {
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,props);
		
		Pageable pageable=PageRequest.of(pageNo, pageSize,sort);
		
		Page<StockInfo>page=stockRepo.findAll(pageable);
		return page;
	}




	@Override
	public void showDataThroughPagination(int pageSize) {
		long count=stockRepo.count();
		long pagesCount=count/pageSize;
		
		if(count%pagesCount!=0)
			pagesCount++;
		
		for(int i=0;i<pagesCount;++i) {
			Pageable pageable=PageRequest.of(i, pageSize);
			
			Page<StockInfo> page=stockRepo.findAll(pageable);
			
			System.out.println("page::"+(page.getNumber()+1)+" records of"+page.getTotalPages());
			page.getContent().forEach(System.out::println);
			System.out.println("-------------------------");
		}
		
	}




	public String deleteStockByIdsInBatch(List<Integer> ids) {
		List<StockInfo>list=stockRepo.findAllById(ids);
		stockRepo.deleteAllByIdInBatch(ids);
		return list.size()+"records are deleted";
	}




	@Override
	public List<StockInfo> showStockByExampleData(StockInfo exStock, boolean ascOrder, String... properties) {
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,properties);
		Example example=Example.of(exStock);
		List<StockInfo> list=stockRepo.findAll(example,sort);
		return list;
	}




	@Override
	public StockInfo findStockById(Integer id) {
		StockInfo stock=stockRepo.getReferenceById(id);
		return stock;
	}




	



	

}
