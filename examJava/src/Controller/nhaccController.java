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
import bean.hangbean;
import bo.adminbo;
import bo.hangbo;

/**
 * Servlet implementation class nhaccController
 */
@WebServlet("/nhaccController")
public class nhaccController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nhaccController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		hangbo hb = new hangbo();
		
		if(request.getParameter("tk") != null) {
			String mh = request.getParameter("mahang");
			String th = request.getParameter("tenhang");
			request.setAttribute("mahangtk", mh);
			request.setAttribute("tenhangtk", th);
			request.setAttribute("dshang", hb.gethang());
			RequestDispatcher rd = request.getRequestDispatcher("nhacungcap.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("them") != null) {
			hb.them_loai(new hangbean(request.getParameter("mahang"), request.getParameter("tenhang")));
		}
		
		if(request.getParameter("xoa") != null) {
			hb.xoa_loai(request.getParameter("mahang"));
		}
		
		if(request.getParameter("sua") != null) {
			hb.sua_loai(request.getParameter("mahang"), request.getParameter("tenhang"));
		}
		
		request.setAttribute("dshang", hb.gethang());
		
		
		RequestDispatcher rd = request.getRequestDispatcher("nhacungcap.jsp");
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
