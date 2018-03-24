package com.kemery;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PurchaseServiceImpl implements PurchaseService {

	private PurchaseDao purchaseDao;
	

	public void setPurchaseDao(PurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}
	
	
	@Override
	public void save(Purchase purchase) {
		
		try {
			purchaseDao.save(purchase);
		} catch (DataAccessException ex) {
			System.out.println("Data access error: " + ex.getStackTrace());
		}
	}
	
	
}