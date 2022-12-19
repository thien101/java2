package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.chitietsanpham;
import bean.hoadonbean;
import bean.khachhangbean;
import bo.ctsanphambo;
import bo.hoadonbo;

/**
 * Servlet implementation class lichsuController
 */
@WebServlet("/lichsuController")
public class lichsuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lichsuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ss = request.getSession();
		hoadonbo hdb = new hoadonbo();
		ctsanphambo ctspb = new ctsanphambo();
		khachhangbean kh = (khachhangbean)ss.getAttribute("khachhang");
		if(request.getParameter("chitiet") != null) {
			if(ss.getAttribute("chitietsp") == null) {
				ss.setAttribute("chitietsp", new chitietsanpham());
			}
			ss.setAttribute("chitietsp", ctspb.get_dssp(Long.parseLong(request.getParameter("mahd"))));
			RequestDispatcher rd = request.getRequestDispatcher("cthdMuahang.jsp");
			rd.forward(request, response);
		}else {
			if(ss.getAttribute("dshoadon") == null) {
				ss.setAttribute("dshoadon", new hoadonbean());
			}
			ss.setAttribute("dshoadon", hdb.get_dshd(kh.getMakh()));
			RequestDispatcher rd = request.getRequestDispatcher("hoadonMuahang.jsp");
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
