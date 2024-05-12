package jp.example.domain.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jp.example.dataaccess.entity.Message;

@ApplicationScoped
public class SampleService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void select() {
		
		var message = new Message();
		entityManager.persist(message);
		entityManager.flush();
		
		
	}

}
