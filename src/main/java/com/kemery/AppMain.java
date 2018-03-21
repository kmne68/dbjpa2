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
		System.out.println("Changing stgtus of " + m.getMemid());
		m.setStatus("T");
		dao.update(m);
		System.out.println("Change completed.");
	}

}
