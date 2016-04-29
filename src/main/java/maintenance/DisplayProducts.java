package maintenance;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import data.*;
@WebServlet("/DisplayProducts")
public class DisplayProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Product> products1 = DBConnect.selectProducts();
		request.setAttribute("products", products1);

		request.getRequestDispatcher("/Views/Products.jsp").forward(request, response);
		
	}

}
