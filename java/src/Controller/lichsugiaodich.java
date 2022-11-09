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

import bean.hoadonbean;
import bean.khachhangbean;
import bo.hoadonbo;

/**
 * Servlet implementation class lichsugiaodich
 */
@WebServlet("/lichsugiaodich")
public class lichsugiaodich extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lichsugiaodich() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("dshd") == null) {
			session.setAttribute("dshd", "");
		}
		khachhangbean kh = new khachhangbean();
		hoadonbo hd = new hoadonbo();
		ArrayList<hoadonbean> dshd;
		if(session.getAttribute("dn") != null) {
			kh = (khachhangbean)session.getAttribute("dn");
			dshd = hd.get_dshd(kh.getMakh());
			session.setAttribute("dshd", dshd);
			RequestDispatcher rd = request.getRequestDispatcher("Lichsu.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("ktdn");
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
