package com.nt.runners;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.StockInfo;
import com.nt.service.IStockMgmtService;

@Component
public class CrudRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IStockMgmtService stockService;
	@Override
	public void run(String... args) throws Exception {
		try {
//			StockInfo info=new StockInfo("wue","it", "NSE","wueR",096326.0,90000.0);
//			StockInfo info1= new StockInfo();
//			String msg=stockService.registerStock(info);
//			boolean msg1=stockService.isStockAvailable(1000);
//			System.out.println(msg1);
//			System.out.println("Count of Stock Registered::"+stockService.fetchAllStockCount());
//			System.out.println("100 Id Stock exists  ?::"+stockService.checkStockAvailability(100));
//			Iterable<StockInfo> it=stockService.showAllStocks();
//			it.forEach(stock->{
//				System.out.println(stock);
//			});
//			
//			stockService.showAllStocksByIds(List.of(1000,1002,1003,1006,1007)).forEach(System.out::println);
//			StockInfo stock=stockService.showStockById(1001);
//			System.out.println(stock);
//			StockInfo stockinfo=new StockInfo();
//			stockinfo.setStockId(1001);;
//			stockinfo.setStockName("Kaar");
//			stockinfo.setStockType("Delivery");
//			stockinfo.setExchangeName("NSE");
//			stockinfo.setCompany("KaarTech");
//			stockinfo.setPrice(2393.0);
//			stockinfo.setAvaiableUnits(88778.0);
//			System.out.println(stockService.registerOrUpdateStock(stockinfo));
//			System.out.println(stockService.deleteStockById(1001));
//			StockInfo stock=new StockInfo();
//			stock.setStockId(1009);stock.setStockName("karan");
//			System.out.println(stockService.deleteStock(stock));
//			System.out.println(stockService.removeStockByIds(List.of(1010,1011)));
			
			
//			stockService.showStocksBySorting(true,"stockName").forEach(System.out::println);
//
//			System.out.println("------------------------");
//			stockService.showStocksBySorting(false,"price","stockName").forEach(System.out::println);
//			Page<StockInfo> page=	stockService.showStockInfoByPageNo(1,3, true,"stockName");
//			System.out.println("page number::"+page.getNumber());
//			System.out.println("pages count::"+page.getTotalPages());
//			System.out.println("is it first page"+page.isFirst());
//			System.out.println("is it last page"+page.isLast());
//			System.out.println("page elments count"+page.getNumberOfElements());
//			if(!page.isEmpty()) {
//				List<StockInfo> list=page.getContent();
//				list.forEach(System.out::println);
//			}else {
//				System.out.println("no page found");
//			}
//			stockService.showDataThroughPagination(2);
//			System.out.println(stockService.deleteStockByIdsInBatch(List.of(1012,1013)));
//			System.out.println(stockService.deleteStockByIdsInBatch(List.of(1014,null)));
//			System.out.println(stockService.deleteStockByIdsInBatch(Arrays.asList(1016,null)));
			
//			StockInfo stock=new StockInfo();
//			stock.setExchangeName("NSE");
//			stock.setAvaiableUnits(90000.0);
//			stockService.showStockByExampleData(stock, true, "avaiableUnits").forEach(System.out::println);
			System.out.println(stockService.findStockById(1017));
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
