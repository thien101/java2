package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.chitietxnhdbo;
import bo.cthoadonbo;
import bo.hoadonbo;
import bo.xacnhanhdbo;

/**
 * Servlet implementation class xacnhanController
 */
@WebServlet("/xacnhanController")
public class xacnhanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacnhanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		xacnhanhdbo xnbo = new xacnhanhdbo();
		chitietxnhdbo ctxnbo = new chitietxnhdbo();

		hoadonbo hdb = new hoadonbo();
		cthoadonbo cthdbo = new cthoadonbo();
		long millis=System.currentTimeMillis();
		java.sql.Date ngayduyet=new java.sql.Date(millis);
		hdb.capnhap(Long.parseLong(request.getParameter("mahdxn")), ngayduyet);
		request.setAttribute("dsxnhd", xnbo.getdshd());
		RequestDispatcher rd = request.getRequestDispatcher("xacnhanHoaDon.jsp");
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
