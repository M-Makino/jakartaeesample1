package jp.example.domain.service;

import java.time.DayOfWeek;
import java.util.Objects;

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

	public String getTime(DayOfWeek dayOfWeek) {
		
		if(Objects.isNull(dayOfWeek)) {
			throw new IllegalArgumentException("dayOfWeekに値が設定されていません");
		}

		return switch (dayOfWeek) {

		case MONDAY, FRIDAY -> "10:00-18:00";
		case TUESDAY, THURSDAY -> "10:00-14:00";
		default -> "休日";
		};

	}

}
