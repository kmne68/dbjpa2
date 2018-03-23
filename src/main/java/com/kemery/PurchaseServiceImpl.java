package com.kemery;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PurchaseServiceImpl implements PurchaseService {

	private PurchaseDao purchaseDao;
	

	public void setPurchaseDao(PurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}
	
	
	@Override
	public void save(Purchase purchase) {
		purchaseDao.save(purchase);
	}
	
	
}