package org.respeso.webapp.todo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.respeso.webapp.todo.TodoService;

/**
 * Servlet implementation class 
 */
@WebServlet("/list-todo.do")
public class ListTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TodoService ts = new TodoService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTodoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("todos", ts.retrieveTodos());
		request.getRequestDispatcher("/WEB-INF/views/todo.jsp").forward(request, response);
	}
	
}
