package jp.example.servlet;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.example.domain.ejb.ProfileBean;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	
	@EJB
	private ProfileBean profileBean;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		profileBean.register(10);
		
		response.getOutputStream().print("Hello " + profileBean.findById(10).getName());
		
	}
	

}
