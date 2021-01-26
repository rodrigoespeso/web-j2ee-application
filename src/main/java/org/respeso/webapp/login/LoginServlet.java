package org.respeso.webapp.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class to log in the WebApp
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginService uvs = new LoginService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * Show the log-in page
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Html code directly writed into the servlet. Bad practice:
		 */
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>The Login Servlet</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("Example body for this servlet");
//		out.println("</body>");
//		out.println("</html>");
		
		/* 
		 *  Html readed from a JSP
		 */
//		String name = request.getParameter("name"); // What is passed through the URL (between the browser and webapp)
//		String password = request.getParameter("password"); // What is passed through the URL (between the browser and webapp)
		
		/*
		 * To give parameters into the URL as a get request is very unsecured because they are in the URL
		 */
//		request.setAttribute("name", name); // Set atributte for the JSP
//		request.setAttribute("password", password); // Set atributte for the JSP
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	/**
	 * Performs 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		if(uvs.isUserValid(user, password)) {
			/*
			 * Redirect to a JSP
			 */
//			request.setAttribute("user", user);
//			request.setAttribute("items", ts.retrieveItems());
//			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
			
			/*
			 * Redirect to another servlet, but "user" parameter is only available in the actual request
			 * "user" is a request variable which does not move into the new request created by the new servlet.
			 * To do that we need a session variable
			 */
			// Request scope variable
//			request.setAttribute("user", user);
			
			/*
			 * We can use "name" session variable to know if anybody is logged in. 
			 * If "name" is not informed nobody is logged in.
			 * For implement the logic we a Filter, a Java EE feature what intercepts calls to the servlets.
			 * -> LoginRequiredFilter: if there is a name in session, we allow the request go through
			 * 	else, redirect to the login page
			 */
			
			// The redirect is other different request so "user" parameter does not reach this one. 
			// We need insted a "user" session variable:
			request.getSession().setAttribute("user", user);
			response.sendRedirect("/list-item.do");	
		}else {
			request.setAttribute("errorMessage", "Invalid user or pass!");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}
		
}
