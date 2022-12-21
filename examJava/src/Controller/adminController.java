package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.adminbean;
import bean.khachhangbean;
import bo.adminbo;
import bo.hangbo;
import bo.sanphambo;

/**
 * Servlet implementation class adminController
 */
@WebServlet("/adminController")
public class adminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminController() {
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
		adminbean ad = new adminbean();
		adminbo adb = new adminbo();
		HttpSession ss= request.getSession();
		request.setAttribute("dshang", hb.gethang());
		
		if(ss.getAttribute("dssanpham") == null) {
			ss.setAttribute("dssanpham", spb.getsanpham());
		}
		
		int trang;
		ss.setAttribute("trang", 1);
		if(request.getContentLength() != 0) {		
			
			if(request.getParameter("all") != null) {
				ss.setAttribute("dssanpham", spb.getsanpham());
			}
			
			if(request.getParameter("trang")!= null) {
				trang = Integer.parseInt(request.getParameter("trang"));
				ss.setAttribute("trang", trang);
			}
			
			if(request.getParameter("tk") != null) {
				String key = (request.getParameter("key") != null)?request.getParameter("key"): request.getParameter("mahang");
				ss.setAttribute("dssanpham", spb.timkiem(key));
			}
			
			String un = request.getParameter("un");
			String pass = request.getParameter("pass");
			if(ss.getAttribute("admin") != null) {
				ad = (adminbean)ss.getAttribute("admin");
				
			}
			if(un != null && pass != null) {
				if(request.getParameter("dn") != null) {
					if(adb.ktdn(un, pass) != null) {
						ss.setAttribute("admin", adb.ktdn(un, pass));
					}else {
						RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp?admin=true&check=false");
						rd.forward(request, response);
					}
				}
			}else {
				if(request.getParameter("dn") != null) {
					RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp?admin=true");
					rd.forward(request, response);
				}
				if(request.getParameter("dx") != null) {
					ss.removeAttribute("admin");
					ss.removeAttribute("trang");
					ss.removeAttribute("dssanpham");
				}
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp?isadmin=true");
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
