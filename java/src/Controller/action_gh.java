
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

import org.apache.jasper.tagplugins.jstl.core.Out;

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
		giohangbo gh = (giohangbo)session.getAttribute("gh"); 
		
		if(request.getParameter("xoaAll") != null) {
			session.removeAttribute("gh");
			session.removeAttribute("slhang");
			session.removeAttribute("dn");
			response.sendRedirect("htsach");
		}
		else{
			if(request.getParameter("sua") != null) {
				long sl = 0;
				if(Long.parseLong(request.getParameter("soluong")) > 0)sl =  Long.parseLong(request.getParameter("soluong"));
				gh.Sua(request.getParameter("masach"), sl);
			}
			if(request.getParameter("xoa") != null) {
				gh.Xoa(request.getParameter("msx"));
			}	
			if(request.getParameter("xoaNsach") != null) {
				String[] arr = request.getParameterValues("xoacheck");
				for(int i=0; i<arr.length; i++){
					for(int j=0; j<gh.ds.size(); j++){
						if(arr[i].equals(gh.ds.get(j).getMasach())){
							gh.ds.remove(j);
							break;
						}
					}
				}
			}
			session.setAttribute("slhang", gh.ds.size());
			session.setAttribute("gh", gh);
			response.sendRedirect("htgio");
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