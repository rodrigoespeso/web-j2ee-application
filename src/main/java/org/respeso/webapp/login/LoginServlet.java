package org.respeso.webapp.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.respeso.webapp.todo.TodoService;

/**
 * Servlet implementation class LoginNewServlet
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Html code directly writed into the servlet:
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
		 * To give parameters into the URL as a get request is very unsecured 
		 */
//		request.setAttribute("name", name); // Set atributte for the JSP
//		request.setAttribute("password", password); // Set atributte for the JSP
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		if(uvs.isUserValid(user, password)) {
			/*
			 * Redirect to a JSP
			 */
//			request.setAttribute("user", user);
//			request.setAttribute("todos", ts.retrieveTodos());
//			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
			
			/*
			 * Redirect to another servlet, but "user" param is only available in the actual request
			 * "user" is a request variable which does not move into the new request created by the new servlet.
			 * To do that we need a session variable
			 */
//			request.setAttribute("user", user); // request scope var
			request.getSession().setAttribute("user", user);	// session scope var
			response.sendRedirect("/list-todo.do");	// The redirect is other diferens request, "user" param does not reach this one. We need insted a session variable
		}else {
			request.setAttribute("errorMessage", "Invalid user or pass!");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}
		
}