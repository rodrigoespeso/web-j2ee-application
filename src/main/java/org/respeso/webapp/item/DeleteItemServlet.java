package org.respeso.webapp.item;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class to delete an item from the list
 *  @author Rodrigo Espeso
 */
@WebServlet("/delete-item.do")
public class DeleteItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ItemService is = new ItemService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteItemServlet() {
        super();
    }

	/**
	 * Delete the item from the list and redirect to the item list page
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		is.deleteItem(new Item(request.getParameter("item"), request.getParameter("category")));
		response.sendRedirect("/list-item.do");
	}
	
}
