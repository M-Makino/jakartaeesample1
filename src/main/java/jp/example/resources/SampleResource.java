package jp.example.resources;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/sample")
public class SampleResource {

	@GET
	@Path("get")
	@Produces(MediaType.TEXT_HTML)
	public String hello() {

		return """
				<html>
				 <head>
				  <title>Hello, JAX-RS</title>
				 </head>
				 <body>
				  <p>hello,JAX-RS</p>
				 </body>
				 </html>
				""";

	}
	
	

//	@GET
//	@Path("hello/{id}/{trailing:>.*}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Sample hello(@QueryParam("q") String param1, @QueryParam("q2") String param2,
//			@PathParam("id") String id,
//			@PathParam("trailing") String trail, @MatrixParam("m") String matrix,
//			@HeaderParam("User-Agent") String userAgent,
//			@CookieParam("JSESSIONID") String jsessionId) {
//		
//		var sample = new Sample();
//		sample.setId(id);
//		sample.setQ(param1);
//		sample.setQ2(param2);
//		sample.setTrailingString(trail);
//		sample.setUserAgentString(userAgent);
//		sample.setJssessionId(jsessionId);
//		sample.setMatrix(matrix);
//		return sample;
//
//	}
}
