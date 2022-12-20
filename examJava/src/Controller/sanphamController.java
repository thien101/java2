package Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.adminbean;

import bean.sanphambean;
import bo.adminbo;
import bo.hangbo;
import bo.sanphambo;

/**
 * Servlet implementation class sanphamController
 */
@WebServlet("/sanphamController")
public class sanphamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sanphamController() {
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
		sanphambo spb = new sanphambo();
		hangbo hb = new hangbo();
		HttpSession ss= request.getSession();

		if(request.getParameter("xoa") != null || request.getParameter("sua") != null) {
			sanphambean sp = (sanphambean)ss.getAttribute("sanpham");
			String tensach = request.getParameter("txttensp");
			String mahang = request.getParameter("txtmh");
			long soluong = Long.parseLong(request.getParameter("txtsl"));
			long gia = Long.parseLong(request.getParameter("txtgia"));
			if(request.getParameter("xoa") != null) {
				spb.xoa_sach(sp.getMasp());
				ss.removeAttribute("sanpham");
			}
			else {
				spb.sua_sach(new sanphambean(sp.getMasp(), tensach, mahang, soluong, gia, ""));
				ss.setAttribute("sanpham", spb.timkiem_msp(sp.getMasp()));
			}
			ss.setAttribute("dssanpham", spb.getsanpham());
		}else {
			ss.setAttribute("dshang", hb.gethang());
			ss.setAttribute("dssanpham", spb.getsanpham());
			if(request.getParameter("tk") != null) {
				String key = (request.getParameter("key") != null)?request.getParameter("key"): request.getParameter("mahang");
				ss.setAttribute("dssanpham", spb.timkiem(key));
			}
				
			if(request.getParameter("chonsach") != null) {
				ss.setAttribute("sanpham", spb.timkiem_msp(Long.parseLong(request.getParameter("masp").toString())));
				RequestDispatcher rd = request.getRequestDispatcher("sanphamChange.jsp");
				rd.forward(request, response);
			}
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("sanphamAdmin.jsp");
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
