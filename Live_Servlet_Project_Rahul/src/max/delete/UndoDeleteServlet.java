package max.delete;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.reg.RegisDAO;

@WebServlet("/UndoDeleteServlet")
public class UndoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
		if(RegisDAO.undoDelete())
		{
			out.println("Recovered Successfully...");
		}else
		{
			out.println("Already Recovered All Records");
		}
		request.getRequestDispatcher("WelcomeServlet").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
