package jp.example.domain.jms;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSException;
import jakarta.jms.Topic;
import jp.example.dto.UserDto;

@Stateless
public class Publisher {

	@Inject
	private JMSContext context;
	
//	@Resource(mappedName = "jms/UserTopic")
	private Topic topic;
	
	public void send(String name) throws JMSException {
		
		var user = new UserDto();
		user.setName(name);
		context.createProducer().send(topic, user);
	}
	
}
