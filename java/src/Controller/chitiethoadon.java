package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachhangbean;
import bo.giohangbo;

/**
 * Servlet implementation class chitiethoadon
 */
@WebServlet("/chitiethoadon")
public class chitiethoadon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chitiethoadon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("cthd") == null) {
			session.setAttribute("cthd", "");
		}
		khachhangbean kh = (khachhangbean)session.getAttribute("dn");
		giohangbo cthd = new giohangbo();
		session.setAttribute("cthd", cthd.get_dssp(kh.getMakh(), Long.parseLong(request.getParameter("mahd"))));
		RequestDispatcher rd = request.getRequestDispatcher("chitiethoadon.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
