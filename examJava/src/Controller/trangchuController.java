package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.sanphambean;
import bo.hangbo;
import bo.sanphambo;

/**
 * Servlet implementation class trangchuController
 */
@WebServlet("/trangchuController")
public class trangchuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public trangchuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		sanphambo spb = new sanphambo();
		hangbo hb = new hangbo();
		request.setAttribute("dshang", hb.gethang());
		//request.setAttribute("dssanpham", spb.getsanpham());
		HttpSession ss = request.getSession();
		
		if(ss.getAttribute("dssanpham") == null) {
			ss.setAttribute("dssanpham", spb.getsanpham());
		}
		
		//phan trang
		int trang;
		ss.setAttribute("trang", 1);
		if(request.getContentLength() != 0) {		
			
			if(request.getParameter("trang")!= null) {
				trang = Integer.parseInt(request.getParameter("trang"));
				ss.setAttribute("trang", trang);
			}
			
			if(request.getParameter("tk") != null) {
				String key = (request.getParameter("key") != null)?request.getParameter("key"): request.getParameter("mahang");
				ss.setAttribute("dssanpham", spb.timkiem(key));
				ss.setAttribute("trang", 1);
			}
			
			if(request.getParameter("all") != null) {
				ss.setAttribute("dssanpham", spb.getsanpham());
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("TrangChu.jsp");
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
