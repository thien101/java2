package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ktdn
 */
@WebServlet("/ktdn")
public class ktdn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ktdn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String un = request.getParameter("txtun");
		String pass = request.getParameter("txtpass");
		/*ArrayList<String> arr = new ArrayList<>();
		arr.add(un);
		arr.add(pass);*/
		
		if(un != null && un != null) {
			//Tao doi tuong session
			HttpSession ss = request.getSession();
			
			//Neu chua tao session
			if(ss.getAttribute("dn") == null ) {
				ss.setAttribute("dn", "");
			}
			ss.setAttribute("dn", un);
			//Chuyen tiep ve trang htsach.jsp
			RequestDispatcher rd = request.getRequestDispatcher("htsach");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("baitap12_09.jsp");
			rd.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}