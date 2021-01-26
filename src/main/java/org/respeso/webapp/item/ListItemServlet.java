package org.respeso.webapp.item;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class to list all the items
 */
@WebServlet("/list-item.do")
public class ListItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ItemService is = new ItemService();   
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListItemServlet() {
        super();
    }

	/**
	 * Shows the list item page, receiving the items from the service class
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("items", is.retrieveItems());
		request.getRequestDispatcher("/WEB-INF/views/list-item.jsp").forward(request, response);
	}
	
}
