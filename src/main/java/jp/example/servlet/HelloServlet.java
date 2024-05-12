package jp.example.servlet;

import java.io.IOException;
import java.util.Optional;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.example.dataaccess.entity.Profile;
import jp.example.domain.ejb.ProfileBean;

/**
 * サーブレットのサンプル.
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	@EJB
	private ProfileBean profileBean;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		profileBean.register(10);

		Optional<Profile> profileOpt = profileBean.findById(10);
		if (profileOpt.isPresent()) {
			response.getOutputStream().print("Hello " + profileOpt.get().getName());
		}

	}

}
