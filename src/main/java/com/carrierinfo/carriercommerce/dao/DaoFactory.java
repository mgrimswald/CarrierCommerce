package com.carrierinfo.carriercommerce.dao;

import com.carrierinfo.carriercommerce.dao.jpa.JpaDaoFactory;

public abstract class DaoFactory {
		
	public static DaoFactory getDaoFactory() {
		return new JpaDaoFactory();
	}
	
	public abstract CategoryDao getCategoryDao();
	public abstract ProductDao getProductDao();
	public abstract UserDao getUserDao();
	public abstract PictureDao getPictureDao();

}
