package com.carrierinfo.carriercommerce.dao.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.carrierinfo.carriercommerce.dao.CategoryDao;
import com.carrierinfo.carriercommerce.dao.PictureDao;
import com.carrierinfo.carriercommerce.dao.ProductDao;
import com.carrierinfo.carriercommerce.dao.DaoFactory;
import com.carrierinfo.carriercommerce.dao.UserDao;

public class JpaDaoFactory extends DaoFactory {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("carriercommerce");
	
	private JpaCategoryDao categoryDao;
	private JpaProductDao productDao;
	private JpaUserDao userDao;
	private JpaPictureDao pictureDao;
	
	@Override
	public CategoryDao getCategoryDao() {
		if(categoryDao == null) {
			categoryDao = new JpaCategoryDao(emf);
		}
		return categoryDao;
	}

	@Override
	public ProductDao getProductDao() {
		if(productDao == null) {
			productDao = new JpaProductDao(emf);
		}
		return productDao;
	}

	@Override
	public UserDao getUserDao() {
		if(userDao == null) {
			userDao = new JpaUserDao(emf);
		}
		return userDao;
	}

	@Override
	public PictureDao getPictureDao() {
		if(pictureDao == null) {
			pictureDao = new JpaPictureDao(emf);
		}
		return pictureDao;
	}

}
