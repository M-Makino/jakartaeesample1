package jp.example.domain.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jp.example.dataaccess.entity.Message;
import jp.example.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Stateless
public class MessageBean {

	@PersistenceContext
	private EntityManager entityManager;

	public MessageDto findBy(Long id) {

		Message entityMessage = entityManager.find(Message.class, id);
		return convertTo(entityMessage);

	}

	public Message convertTo(MessageDto messageDto) {

		Message message = new Message();
		message.setId(messageDto.getId());
		message.setMessage(messageDto.getMessage());
		return message;
	}

	public MessageDto convertTo(Message entity) {

		MessageDto messageDto = new MessageDto();
		messageDto.setId(entity.getId());
		messageDto.setMessage(entity.getMessage());
		return messageDto;
	}

}
