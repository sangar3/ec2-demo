package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		value="/another-test",
		initParams = {@WebInitParam(name="anotherParam", value="anotherValue")},
		loadOnStartup=1
		)

public class AnotherServlet extends HttpServlet {

	private static final long serialVersionUID = 458090214689031254L;
	
	@Override
	public void init() throws ServletException {
		System.out.println(" init() invoked!");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AnthoerServlet doGet() invoked");
		System.out.println(this.getServletConfig().getInitParameter("someParam"));
		System.out.println(this.getServletConfig().getInitParameter("anotherParam"));
		System.out.println(this.getServletContext().getInitParameter("contectParam"));
		
		// manpluate the req to show that the same one is used when forwarding this servlet to testServlet
		req.setAttribute("request-state", "came through AnotherServlet doGet()");
		req.getRequestDispatcher("/test").forward(req, resp);
	}

}
