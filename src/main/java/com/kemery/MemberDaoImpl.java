package com.kemery;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

public class MemberDaoImpl implements MemberDao {
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	public List<Member> getMembers() {
		
		List<Member> mems;
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createQuery("SELECT m from Member m");
		mems = query.getResultList();
		
		entityManager.close(); // should do this in try-catch-close
		return mems;
	}
	
	public void update(Member m) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction trans = entityManager.getTransaction();
		
		trans.begin();
		entityManager.merge(m);
		trans.commit();
		entityManager.close();
	}

}
