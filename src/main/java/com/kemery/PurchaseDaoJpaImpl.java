package com.kemery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class PurchaseDaoJpaImpl implements PurchaseDao {
		
	@PersistenceContext
	private EntityManager entityManager;	
	
	@Override
	public void save(Purchase purchase) {
			
		entityManager.persist(purchase);
	}
		
}