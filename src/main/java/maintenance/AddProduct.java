package maintenance;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import data.DBConnect;

@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		//retrieve info about the new product
		String code = request.getParameter("code");
		String description = request.getParameter("description");
        Double price = null;
        try {
            price = Double.parseDouble(request.getParameter("price"));
        }catch (Exception e){
            price = 0.0;
        }
		//set new properties to the product
		product.setCode(code);
		product.setDescription(description);
		product.setPrice(price);
		//if any of those were empty send it back
		if(code.length() == 0 || description.length() == 0 || price.toString().length() == 0){
            request.setAttribute("message", "<h3>You must fill out all three fields</h3>");
			request.setAttribute("product", product);
			request.getRequestDispatcher("Views/AddProduct.jsp").forward(request, response);
		}

		if(!DBConnect.exists(product.getCode()))
			DBConnect.insertProduct(product);
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
