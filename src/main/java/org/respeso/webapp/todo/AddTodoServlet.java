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
@WebServlet("/add-todo.do")
public class AddTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TodoService ts = new TodoService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTodoServlet() {
        super();
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Get "todo" param from the form
		 */
		String newTodo = request.getParameter("todo");
		ts.addTodo(new Todo(newTodo));
		/*
		 * This causes the repetitive values in the list in case of refresh.
		 * If you refresh the page, the last request is executed (this post) and is re-send the todo item, 
		 * but if is redirected to another servlet, the last request changes (/todo.do GET) and refresh goes to todo.jsp
		 */
//		request.setAttribute("todos", ts.retrieveTodos());
//		request.getRequestDispatcher("/WEB-INF/views/todo.jsp").forward(request, response);
		response.sendRedirect("/list-todo.do");
	}

}
