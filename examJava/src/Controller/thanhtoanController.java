package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.cthoadonbean;
import bean.giohangbean;
import bean.hoadonbean;
import bean.khachhangbean;
import bean.sanphambean;
import bo.cthoadonbo;
import bo.giohangbo;
import bo.hoadonbo;

/**
 * Servlet implementation class thanhtoanController
 */
@WebServlet("/thanhtoanController")
public class thanhtoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thanhtoanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		giohangbo ghb = (giohangbo)session.getAttribute("gh");
		if(request.getParameter("tt") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("thanhtoan.jsp");
			rd.forward(request, response);
		}
		else {
			int mahd;
			hoadonbo hd = new hoadonbo();
			cthoadonbo cthdb = new cthoadonbo();
			long millis=System.currentTimeMillis();
			java.sql.Date ngaydat=new java.sql.Date(millis);
			khachhangbean kh = (khachhangbean)session.getAttribute("khachhang");
			if(request.getParameter("tt").toString().equals("yes")) {
				hoadonbo hdb = new hoadonbo();
				hdb.them_hd(new hoadonbean(0, kh.getMakh(), false, ghb.tongtien(), ngaydat, null));
				mahd = hdb.get_hd(kh.getMakh());
				for(giohangbean sp : ghb.dssp) {
					cthdb.them_cthd(new cthoadonbean(0, mahd, sp.getMasp(), sp.getSlmua(), sp.getThanhtien(), false));
				}
				session.removeAttribute("gh");
				session.removeAttribute("slhang");
			}
			RequestDispatcher rd = request.getRequestDispatcher("trangchuController");
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
