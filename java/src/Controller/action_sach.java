package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.sachbean;
import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class action_sach
 */
@WebServlet("/action_sach")
public class action_sach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public action_sach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		sachbo sb = new sachbo();
		ArrayList<sachbean> ds = sb.getsach();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession ss = request.getSession();
		if(ss.getAttribute("dssach") == null) {
			ss.setAttribute("dssach", "");
		}
		if(request.getParameter("ml") != null) {
			ss.setAttribute("dssach", sb.timkiemsach(request.getParameter("ml")));
		}
		
		if(request.getParameter("opt")!= null) {
			request.setAttribute("addsach", sb.timkiem_sach(ds, request.getParameter("ms")));
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("nhapsachAdmin.jsp");
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
