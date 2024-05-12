package jp.example.resources;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jp.example.domain.ejb.MessageBean;
import lombok.extern.slf4j.Slf4j;

/**
 * メッセージリソース.
 */
@Slf4j
@ApplicationScoped
@Path("/message")
public class MessageResource {

	@EJB
	private MessageBean messageBean;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessage(@PathParam(value = "id") Long id) {

		log.info("パスパラメータ ID:{}", id);

		return Response.ok(messageBean.findBy(id)).build();

	}

}
