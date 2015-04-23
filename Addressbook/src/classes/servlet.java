package classes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet extends HttpServlet {
	Address address = new Address();
	
	protected void doGet (HttpServletRequest request,
			HttpServletResponse response){
				String task = request.getParameter("task");
				int id = Integer.parseInt(request.getParameter("id"));
				
				
			}

}
