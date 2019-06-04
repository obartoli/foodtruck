package com.formation.foodtruck.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.formation.foodtruck.entities.Product;
import com.formation.foodtruck.utils.HibernateUtils;

public class ProductDAO {
	
	public List<Product> getAllProducts() {
		Session session = HibernateUtils.getSession();
		Query<Product> query = session.createNamedQuery(
				"Product.findAll", Product.class);
		
		List<Product> listProducts = query.list();
		session.close();
		
		return listProducts;
	}

	public List<Product> getProductsByFamily(Integer familyId) {
		Session session = HibernateUtils.getSession();
		Query<Product> query = session.createNamedQuery(
				"Product.findByFamily", Product.class)
				.setParameter("familyId", familyId);
		
		List<Product> listProducts = query.list();
		session.close();
		
		return listProducts;
	}
}
