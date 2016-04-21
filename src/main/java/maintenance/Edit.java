package maintenance;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productCode = (String) request.getParameter("code");
		
		Product product = ProductIO.selectProduct(productCode);
		String description = (String) request.getParameter("description");
		Double price = Double.parseDouble(request.getParameter("price"));
		product.setDescription(description);
		product.setPrice(price);
		ProductIO.updateProduct(product);
		
		request.getRequestDispatcher("/DisplayProducts").forward(request, response);
	}

}
