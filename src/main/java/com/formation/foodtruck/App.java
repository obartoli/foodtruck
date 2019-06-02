package com.formation.foodtruck;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.formation.foodtruck.entities.Family;
import com.formation.foodtruck.entities.Meal;
import com.formation.foodtruck.entities.Product;
import com.formation.foodtruck.utils.HibernateUtils;


public class App 
{
	private static Session 	   session 	   = null;
	private static Transaction transaction = null;
	
	public static void main( String[] args )
	{
		session = HibernateUtils.getSession();
		
		try {
		
			transaction = session.beginTransaction();
			
			populateDB();
			
			transaction.commit();
		
		} catch (HibernateException he) {
			
			System.out.println(he.getMessage());
			
			if(transaction != null) {
				try {
					
					transaction.rollback();
					
				} catch (IllegalStateException ie) {
					
					System.out.println(ie.getMessage());
					ie.printStackTrace();
					
				} catch (PersistenceException pe) {
					
					System.out.println(pe.getMessage());
					pe.printStackTrace();
					
				}
			}
			
		} finally {
			session.close();
		}
	}
	
	private static void populateDB() {
		
		populateProduct();
		
	}
	
	private static void populateProduct() {
		
		// --- création des repas 
		Meal breakfast = new Meal();
		Meal lunch = new Meal();
		Meal dinner = new Meal();
		
		breakfast.setStart(Time.valueOf(LocalTime.of(7, 0)));
		breakfast.setEnd(Time.valueOf(LocalTime.of(9, 30)));
		breakfast.setType("breakfast");
		
		lunch.setStart(Time.valueOf(LocalTime.of(11, 30)));
		lunch.setEnd(Time.valueOf(LocalTime.of(14, 0)));
		lunch.setType("lunch");
		
		dinner.setStart(Time.valueOf(LocalTime.of(18, 30)));
		dinner.setEnd(Time.valueOf(LocalTime.of(23, 0)));
		dinner.setType("dinner");
		
		// --- création des familles de produits
		Family starter = new Family();
		Family main = new Family();
		Family dessert = new Family();
		
		starter.setType("starter");
		main.setType("main");
		dessert.setType("dessert");
		
		
		// --- Liaison Meal --> Family ---
		List<Family> lstFamForBreakfast = new ArrayList<Family>();
		lstFamForBreakfast.add(dessert);
		
		breakfast.setFamilies(lstFamForBreakfast);
		
		
		List<Family> lstFamForLunchDinner = new ArrayList<Family>();
		lstFamForLunchDinner.add(starter);
		lstFamForLunchDinner.add(main);
		lstFamForLunchDinner.add(dessert);
		
		lunch.setFamilies(lstFamForLunchDinner);
		dinner.setFamilies(lstFamForLunchDinner);
		
		
		// --- Liaison Family --> Meal ---
		List<Meal> lstMealForStarterMain = new ArrayList<Meal>();
		lstMealForStarterMain.add(lunch);
		lstMealForStarterMain.add(dinner);
		
		starter.setMeals(lstMealForStarterMain);
		main.setMeals(lstMealForStarterMain);
		
		List<Meal> lstMealForDessert = new ArrayList<Meal>();
		lstMealForDessert.add(breakfast);
		lstMealForDessert.add(lunch);
		lstMealForDessert.add(dinner);
		
		dessert.setMeals(lstMealForDessert);
		
		// --- création des produits ---
		Product salad = new Product();
		Product lasagna = new Product();
		Product croissant = new Product();
		
		salad.setAvailability("LMX");
		salad.setDescription("super salade");
		salad.setName("salade");
		salad.setPrice(7.3f);
		salad.setStock(25);
		salad.setFamily(starter);
		
		lasagna.setAvailability("LMJV");
		lasagna.setDescription("super lasagne");
		lasagna.setName("lasagne");
		lasagna.setPrice(15.8f);
		lasagna.setStock(55);
		lasagna.setFamily(main);
		
		croissant.setAvailability("LMXJVSD");
		croissant.setDescription("super croissant");
		croissant.setName("croissant");
		croissant.setPrice(1.2f);
		croissant.setStock(100);
		croissant.setFamily(dessert);
		
		
		// --- persistence ---
		session.persist(breakfast);
		session.persist(lunch);
		session.persist(dinner);
		
		session.persist(starter);
		session.persist(main);
		session.persist(dessert);
		
		session.persist(salad);
		session.persist(lasagna);
		session.persist(croissant);
	}
	
}
