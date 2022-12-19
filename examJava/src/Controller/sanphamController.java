package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import bean.adminbean;
import bean.sanphambean;
import bo.adminbo;
import bo.hangbo;
import bo.sanphambo;

/**
 * Servlet implementation class sanphamController
 */
@WebServlet("/sanphamController")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 *1,
		maxFileSize = 1024 * 1024 * 10,
		maxRequestSize = 1024 * 1024 *100)
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

		if(request.getParameter("sua") != null || request.getParameter("xoa") != null || request.getParameter("them") != null) {
			sanphambean sp = (sanphambean)ss.getAttribute("sanpham");
			String tensach = request.getParameter("txttensp");
			String mahang = request.getParameter("txtmh");
			long soluong = Long.parseLong(request.getParameter("txtsl"));
			long gia = Long.parseLong(request.getParameter("txtgia"));
			if(request.getParameter("them") != null) {
				
				
				Part filePart = request.getPart("txtfile");
				String fileName = filePart.getSubmittedFileName();
				for (Part part : request.getParts()) {
					part.write("C:\\Users\\Admin\\eclipse-workspace\\examJava\\WebContent\\images\\" + fileName);
				}
				String anh = ".\\images\\" + fileName;
				spb.them_sach(new sanphambean(0, tensach, mahang, soluong, gia, anh));
				
			}
			else if(request.getParameter("xoa") != null) {
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
