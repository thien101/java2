package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.danhsachxnbo;
import bo.giohangbo;
import bo.hoadonbo;
import bo.xacnhanHDbo;


/**
 * Servlet implementation class xacnhanHD
 */
@WebServlet("/xacnhanHD")
public class xacnhanHD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacnhanHD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ss = request.getSession();
		xacnhanHDbo xnbo = new xacnhanHDbo();
		danhsachxnbo dsxnbo = new danhsachxnbo();
		hoadonbo hdbo = new hoadonbo();
		if(ss.getAttribute("xndshd") == null) {
			ss.setAttribute("xndshd", "");
		}
		if(request.getParameter("mahdxn")!="" && request.getParameter("mahdxn")!=null) {
			hdbo.update_hd(Long.parseLong(request.getParameter("mahdxn")));
			ss.setAttribute("xndshd", xnbo.getdshd());
			RequestDispatcher rd = request.getRequestDispatcher("xacnhanHD.jsp");
			rd.forward(request, response);
		}
		ss.setAttribute("xndshd", xnbo.getdshd());
		
		if(request.getParameter("mahd") != "" && request.getParameter("mahd") != null) {
			ss.setAttribute("sachmua", dsxnbo.getdsxn(Long.parseLong(request.getParameter("mahd"))));
			RequestDispatcher rd = request.getRequestDispatcher("chitietxnhd.jsp");
			rd.forward(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher("xacnhanHD.jsp");
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
