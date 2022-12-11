package Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import bean.giohangbean;
import bean.hoadonbean;
import bean.khachhangbean;
import bo.giohangbo;
import bo.hoadonbo;
import dao.hoadondao;

/**
 * Servlet implementation class hoadon
 */
@WebServlet("/hoadon")
public class hoadon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hoadon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		giohangbo gh = (giohangbo)session.getAttribute("gh");
		if(request.getParameter("tt") == null) {
			if(session.getAttribute("gh") == null || gh.ds.size() ==0) {
				RequestDispatcher rd = request.getRequestDispatcher("tbhoadon.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("htthanhtoan.jsp");
				rd.forward(request, response);
			}
		}else{
			int mahd;
			hoadonbo hd = new hoadonbo();
//			Date d = new Date();
//			SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
//			dd.format(d);
			long millis=System.currentTimeMillis();
			java.sql.Date date=new java.sql.Date(millis);
			khachhangbean kh = (khachhangbean)session.getAttribute("dn");
			if(request.getParameter("tt").equals("yes")) {
				//them hoa don vao sql trang thai thanh toan
				hd.them_hd(new hoadonbean(0, kh.getMakh(), date, true));
				mahd = hd.get_hd(kh.getMakh());
				for(giohangbean g : gh.ds) {
					hd.them_dshd(g.getMasach(), g.getSoluong(), mahd, true);
				}
				
			}else {
				//them hoa don vao sql trang thai chua thanh toan
				hd.them_hd(new hoadonbean(0, kh.getMakh(), date, false));
				mahd = hd.get_hd(kh.getMakh());
				for(giohangbean g : gh.ds) {
					hd.them_dshd(g.getMasach(), g.getSoluong(), mahd, false);
				}
			}
			session.removeAttribute("slhang");
			session.removeAttribute("gh");
			RequestDispatcher rd = request.getRequestDispatcher("htsach");
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
