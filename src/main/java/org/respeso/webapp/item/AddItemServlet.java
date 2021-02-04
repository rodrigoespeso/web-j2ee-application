package org.respeso.webapp.item;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class to add a new item to the list.
 * 
 * @author Rodrigo Espeso
 */
@WebServlet("/add-item.do")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ItemService is = new ItemService();   
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet() {
        super();
    }
	
    /**
     * Add new item and redirect to the list of items page
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Get "item" param of the form
		 */
		String newItem = request.getParameter("item");
		String category = request.getParameter("category");
		is.addItem(new Item(newItem, category));
		/*
		 * This (comented code) causes the repetitive values in the list in case of refresh.
		 * If you refresh the page, the last request is executed (this post) and it re-send the item, 
		 * but if is redirected to another servlet, the last request changes (/list-item.do GET) and refresh goes to todo.jsp
		 */
//		request.setAttribute("items", ts.retrieveItems());
//		request.getRequestDispatcher("/WEB-INF/views/item.jsp").forward(request, response);
		response.sendRedirect("/list-item.do");
	}
	
	/**
	 * Show the view for the item addition
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/add-item.jsp").forward(request, response);
	}

}
