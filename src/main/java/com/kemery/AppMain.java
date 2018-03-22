package com.kemery;

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
		
		Member m2 = new Member();
		m2.setMemid("G312");		
		m2.setFirstname("Frederic");
		m2.setLastname("Bastiat");
		m2.setMiddlename("Claude");
//		m2.setMemdt(1998-01-01);
		m2.setPassword(1234);
		m2.setStatus("A");
		
	}

}
