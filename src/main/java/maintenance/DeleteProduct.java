package maintenance;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import data.*;
/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productCode = "";

		productCode = (String) request.getParameter("code");
		Product product = DBConnect.selectProduct(productCode);
		DBConnect.deleteProduct(product);
		
		request.getRequestDispatcher("/DisplayProducts").forward(request, response);
	}
}
