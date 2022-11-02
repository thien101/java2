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

import bean.loaibean;
import bean.sachbean;
import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class htsach
 */
@WebServlet("/htsach")
public class htsach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public htsach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		loaibo lbo = new loaibo();
		ArrayList<loaibean> dsloai = lbo.getloai();
		request.setAttribute("dsloai", dsloai);
		
		sachbo sbo = new sachbo();
		ArrayList<sachbean> dssach = new ArrayList<sachbean>();
		
		HttpSession session = request.getSession();
		if(session.getAttribute("dssach") == null || request.getParameter("all") != null) {
			dssach = sbo.getsach();
			session.setAttribute("dssach", dssach);
		}
		String mls = request.getParameter("ml");
		String tk =request.getParameter("timkiem");
		if (mls != null) {
			  dssach =sbo.timkiem(dssach, mls);
			  session.setAttribute("dssach", dssach);
		} else if (tk != null) { 
			  dssach =sbo.timkiem(dssach, tk);
			  session.setAttribute("dssach", dssach);
		}
		//session.setAttribute("dssach", dssach);
		
		
		
		
//		  String mls = request.getParameter("ml");
//		  String tk =request.getParameter("timkiem");
//		  if (mls != null) {
//			  dssach =sbo.timkiem(dssach, mls); 
//		  } else if (tk != null) { 
//			  dssach =sbo.timkiem(dssach, tk);
//		  };
		  
//		  if(request.getAttribute("dssach") == null)request.setAttribute("dssach", dssach);
		 

		int trang;
		if(request.getParameter("trang")!= null) {
			trang = Integer.parseInt(request.getParameter("trang"));
		}else trang = 1;
		request.setAttribute("trang", trang);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("htsach.jsp");
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