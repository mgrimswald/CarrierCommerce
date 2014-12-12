package com.carrierinfo.carriercommerce.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.carrierinfo.carriercommerce.dao.PictureDao;
import com.carrierinfo.carriercommerce.exception.UnknownProductException;

public class JpaPictureDao implements PictureDao {

	private EntityManagerFactory emf;

	public JpaPictureDao(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public byte[] findPictureByProductId(Long productId) {		
		EntityManager em = emf.createEntityManager();
		try { 
			Query query = em.createQuery("SELECT p.picture FROM Product p WHERE p.id = :id");
			query = query.setParameter("id", productId);
			return (byte[]) query.getSingleResult();
		} catch (NoResultException e) {
			throw new UnknownProductException(productId, e);
		} finally { 
			em.close(); 
		}
	}

}
