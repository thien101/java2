package Controller;

import java.io.IOException;

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
import dao.loaidao;

/**
 * Servlet implementation class htloaiController
 */
@WebServlet("/htloaiController")
public class htloaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public htloaiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession ss = request.getSession();
		loaibo lb = new loaibo();
		if(request.getParameter("txttenloai")!= null && request.getParameter("txtmaloai") != null) {
			String maloai = request.getParameter("txtmaloai");
			String tenloai = request.getParameter("txttenloai");
			lb.them_loai(new loaibean(maloai, tenloai));
		}
		
		if(request.getParameter("xoa") != null) {
			lb.xoa_loai(request.getParameter("txtmaloai"));
		}
		
		if(request.getParameter("sua") != null) {
			lb.sua_loai(request.getParameter("txtmaloai"), request.getParameter("txttenloai"));
		}
		
		if(request.getParameter("html") != null) {
			for(loaibean s : lb.getloai()) {
				if(s.getMaloai().equals(request.getParameter("html"))){
					response.sendRedirect("loai.jsp?ml=" + request.getParameter("html") + "&tl=" + s.getTenloai());
					return ;
				}
			}
		}
		ss.setAttribute("dsloai", lb.getloai());
		
		RequestDispatcher rd = request.getRequestDispatcher("loai.jsp");
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
