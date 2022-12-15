package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class giohangController
 */
@WebServlet("/giohangController")
public class giohangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public giohangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		giohangbo ghb = new giohangbo();
		HttpSession session = request.getSession();
		if(session.getAttribute("slhang") == null)session.setAttribute("slhang", 0);
		if(session.getAttribute("gh") == null) {
			session.setAttribute("gh", new giohangbo());
		}
		ghb = (giohangbo)session.getAttribute("gh");
		Long masp = Long.parseLong(request.getParameter("masp"));
		String tensp = request.getParameter("tensp");
		long sl = 1;
		long gia = Long.parseLong(request.getParameter("gia"));
		ghb.them(masp, tensp, gia, sl, "", false);
		session.setAttribute("gh", ghb);
		session.setAttribute("slhang", ghb.dssp.size());
		RequestDispatcher rd = request.getRequestDispatcher("htgio");
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
