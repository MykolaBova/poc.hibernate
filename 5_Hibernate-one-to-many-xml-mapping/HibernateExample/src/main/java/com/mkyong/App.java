package com.mkyong;

import java.util.Date;

import org.hibernate.Session;

import com.mkyong.stock.Stock;
import com.mkyong.stock.StockDailyRecord;
import com.mkyong.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate one to many (XML Mapping)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();
        stock.setStockCode("7054");
        stock.setStockName("PADINI2");
        session.save(stock);

///
        StockDailyRecord stockDailyRecords = new StockDailyRecord();
        stockDailyRecords.setPriceOpen(new Float("1.2"));
        stockDailyRecords.setPriceClose(new Float("1.1"));
        stockDailyRecords.setPriceChange(new Float("10.0"));
        stockDailyRecords.setVolume(3000000L);
        stockDailyRecords.setDate(new Date());
        stockDailyRecords.setStock(stock);

///
        StockDailyRecord stockDailyRecords1 = new StockDailyRecord();
        stockDailyRecords1.setPriceOpen(new Float("1.2"));
        stockDailyRecords1.setPriceClose(new Float("1.1"));
        stockDailyRecords1.setPriceChange(new Float("10.0"));
        stockDailyRecords1.setVolume(3000000L);
        stockDailyRecords1.setDate(new Date());
        stockDailyRecords1.setStock(stock);

        session.save(stockDailyRecords);
        session.save(stockDailyRecords1);
        stock.getStockDailyRecords().add(stockDailyRecords);
        stock.getStockDailyRecords().add(stockDailyRecords1);

		session.getTransaction().commit();
		System.out.println("Done");
	}
}
