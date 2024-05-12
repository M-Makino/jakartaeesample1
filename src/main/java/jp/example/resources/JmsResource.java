package jp.example.resources;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.jms.JMSException;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jp.example.domain.jms.Publisher;

@RequestScoped
@Path("jms")
public class JmsResource {

	@Inject
	private Publisher publisher;
	
	@POST
	public void send(@FormParam("name") String name) {
		
		try {
			publisher.send(name);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
