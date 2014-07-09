package com.mkyong;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.mkyong.stock.Category;
import com.mkyong.stock.Stock;
import com.mkyong.util.HibernateUtil;

public class App1 {
	public static void main(String[] args) {
		System.out.println("Hibernate many to many (XML Mapping)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

//		Stock stock = new Stock();
//      stock.setStockCode("7052");
//      stock.setStockName("PADINI");
        Stock stock = new Stock();
        stock = stock.getUserById(36);

        Category category1 = new Category("ONSUMER2", "CONSUMER COMPANY2");
        Category category2 = new Category("NVESTMENT2", "INVESTMENT COMPANY2");
    
        Set<Category> categories = new HashSet<Category>();
        categories.add(category1);
        categories.add(category2);
        
        stock.setCategories(categories);
        
        //session.save(stock);
       session.update(stock);
        //session.save(categories);

		session.getTransaction().commit();
		System.out.println("Done");
	}
}
