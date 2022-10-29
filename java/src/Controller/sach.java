package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.loaibean;
import bean.sachbean;
import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class sach
 */
@WebServlet("/sach")
public class sach extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public sach() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		loaibo lbo = new loaibo();
		ArrayList<loaibean> dsloai = lbo.getloai();
		request.setAttribute("dsloai", dsloai);

		sachbo sbo = new sachbo();
		ArrayList<sachbean> dssach = sbo.getsach();
		String mls = request.getParameter("ml");
		String tk = request.getParameter("timkiem");
		if (mls != null) {
			dssach = sbo.timkiem(dssach, mls);
		} else if (tk != null) {
			dssach = sbo.timkiem(dssach, tk);
		}
		request.setAttribute("dssach", dssach);

		
		RequestDispatcher rd = request.getRequestDispatcher("htsach.jsp");
		rd.forward(request, response);
		 
		//response.sendRedirect("htsach");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}