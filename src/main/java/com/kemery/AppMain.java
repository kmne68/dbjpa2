package com.kemery;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ClubJPAConfig.class);
		
		MemberDaoImpl dao = applicationContext.getBean(MemberDaoImpl.class);
		
		List<Member> members = dao.getMembers();
		System.out.println("Members: ");
		
		for(Member x : members) {
			System.out.println(x.toString());
		}
		
		Member m = members.get(0);
		System.out.println("Changing status of " + m.getMemid());
		m.setStatus("T");
		dao.update(m);
		System.out.println("Change completed.");
		
		Date newMemberDate = new Date(2018-01-20);

		Member m2 = new Member();
		m2.setMemid("K237");		
		m2.setFirstname("Karl");
		m2.setLastname("Menger");
		m2.setMiddlename("Joseph");
		m2.setMemdt(newMemberDate);
		m2.setPassword(1234);
		m2.setStatus("A");
		
		dao.add(m2);
		
		// Set up first Purchase
		PurchaseService purchaseService = applicationContext.getBean(PurchaseService.class);
		
		Date dt = new Date(2018-03-20);
		
		Purchase firstPurchase = new Purchase();
		firstPurchase.seteMemid("G305");
		firstPurchase.setPurchdt(dt);
		firstPurchase.setTranstype("C");
		firstPurchase.setTranscd("22");
		firstPurchase.setAmt(37.00);
		
		purchaseService.save(firstPurchase);	
				
		// Set up second Purchase		
		Date secondDate = new Date(2016-03-20);
		
		Purchase secondPurchase = new Purchase();
		secondPurchase.seteMemid("Z005");
		secondPurchase.setPurchdt(dt);
		secondPurchase.setTranstype("C");
		secondPurchase.setTranscd("NS");
		secondPurchase.setAmt(37.00);
		
		purchaseService.save(secondPurchase);
		
	}

}
