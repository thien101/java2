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
 * Servlet implementation class action_gh
 */
@WebServlet("/action_gh")
public class action_gh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public action_gh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		giohangbo ghb = (giohangbo)session.getAttribute("gh"); 
		
		if(request.getParameter("xoaAll") != null) {
			session.removeAttribute("gh");
			session.removeAttribute("slhang");
			RequestDispatcher rd = request.getRequestDispatcher("trangchuController");
			rd.forward(request, response);
		}
		else{
			if(request.getParameter("sua") != null) {
				long sl = 0;
				if(Long.parseLong(request.getParameter("soluong")) > 0)sl =  Long.parseLong(request.getParameter("soluong"));
				ghb.suasl(Long.parseLong(request.getParameter("masp")), sl);
			}
			if(request.getParameter("xoa") != null) {
				ghb.Xoa(Long.parseLong(request.getParameter("masp")));
			}	
			if(request.getParameter("xoaNsach") != null) {
				String[] arr = request.getParameterValues("xoacheck");
				for(int i=0; i<arr.length; i++){
					for(int j=0; j<ghb.dssp.size(); j++){
						if(String.valueOf(ghb.dssp.get(j).getMasp()).equals(arr[i])){
							ghb.dssp.remove(j);
							break;
						}
					}
				}
			}
			session.setAttribute("slhang", ghb.dssp.size());
			session.setAttribute("gh", ghb);
			RequestDispatcher rd = request.getRequestDispatcher("htgio");
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
