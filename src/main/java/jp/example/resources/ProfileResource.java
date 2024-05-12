package jp.example.resources;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jp.example.domain.ejb.ProfileBean;
import jp.example.dto.ProfileDto;
import lombok.extern.slf4j.Slf4j;

/**
 * プロフィールリソースクラス.
 */
@Slf4j
@ApplicationScoped
@Path("/hello")
public class ProfileResource {

	/** プロフィールBean.*/
	@EJB
	private ProfileBean profileBean;

	/**
	 * プロフィール情報を登録する.
	 * @param profile プロフィール情報
	 * @return 登録結果
	 */
	@POST
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response post(ProfileDto profile) {

		log.info("requestBody:{}", profile);

		return Response.ok(profileBean.register(profile)).build();

	}

	/**
	 * 指定したIDでプロフィール情報を検索する.
	 * 
	 * @param id ID 
	 * @return 検索結果
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam(value = "id") int id) {

		return Response.ok(profileBean.findBy(id)).build();

	}

}
