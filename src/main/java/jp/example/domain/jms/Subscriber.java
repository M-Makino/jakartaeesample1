package jp.example.domain.jms;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jp.example.dto.UserDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@MessageDriven(activationConfig = {
//		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/UserTopic"),
//		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
//})
public class Subscriber implements MessageListener {

	@Override
	public void onMessage(Message message) {
		
		try {
			UserDto userDto = message.getBody(UserDto.class);
			System.out.println(userDto);
			log.info("subscriber: userName: {}" , userDto.getName());
		} catch (JMSException e) {
			log.error("subscriber error");
		}

	}

}
