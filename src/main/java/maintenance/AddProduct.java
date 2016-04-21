package maintenance;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		String code = request.getParameter("code");
		String description = request.getParameter("description");
		Double price = Double.parseDouble(request.getParameter("price"));
		product.setCode(code);
		product.setDescription(description);
		product.setPrice(price);
		if(!ProductIO.exists(product.getCode()))
			ProductIO.insertProduct(product);
		else{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("The product with the code: " + code + " already exists.");
			out.println("<a href='Views/AddProduct.jsp'>Try again</a><br/>");
			out.println("<a href='products'>Cancel</a>");
			out.close();
		}
			
		request.getRequestDispatcher("/DisplayProducts").forward(request, response);
	}

}
