package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		request.setAttribute("dssanpham", spb.getsanpham());
		if(request.getContentLength() != 0) {			
			
			if(request.getParameter("tk") != null) {
				String key = (request.getParameter("key") != null)?request.getParameter("key"): request.getParameter("mahang");
				request.setAttribute("dssanpham", spb.timkiem(key));
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
