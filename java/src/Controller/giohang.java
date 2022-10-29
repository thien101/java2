package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bo.giohangbo;

/**
 * Servlet implementation class giohang
 */
@WebServlet("/giohang")
public class giohang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public giohang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * PrintWriter out = response.getWriter();
		 * out.print(request.getParameter("ms")); out.print(request.getParameter("ts"));
		 * out.print(request.getParameter("gia"));
		 * out.print(request.getParameter("sl"));
		 */
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		//tao 1 ss gio hang
		giohangbo gh = new giohangbo();
		HttpSession session = request.getSession();
		if(session.getAttribute("slhang") == null)session.setAttribute("slhang", 0);
		if(session.getAttribute("gh") == null) {
			session.setAttribute("gh", new giohangbo());
		}
		gh = (giohangbo)session.getAttribute("gh");
		String ms = request.getParameter("ms");
		String ts = request.getParameter("ts");
		String img = request.getParameter("anh");
		long sl = Long.parseLong(request.getParameter("sl"));
		long gia = Long.parseLong(request.getParameter("gia"));
		gh.Them(ms, ts, gia, sl, img);
		session.setAttribute("gh", gh);
		session.setAttribute("slhang", gh.ds.size());
		response.sendRedirect("htgio");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}