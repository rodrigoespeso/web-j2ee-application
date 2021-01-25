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
@WebServlet("/delete-todo.do")
public class DeleteTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TodoService ts = new TodoService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTodoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ts.deleteTodo(new Todo(request.getParameter("todo")));
		response.sendRedirect("/list-todo.do");
	}
	
}