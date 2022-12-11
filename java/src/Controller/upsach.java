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

import bean.sachbean;
import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class upsach
 */
@WebServlet("/upsach")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 *1,
		maxFileSize = 1024 * 1024 * 10,
		maxRequestSize = 1024 * 1024 *100)
public class upsach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upsach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		sachbo sb = new sachbo();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession ss = request.getSession();
		loaibo lb = new loaibo();
		if(ss.getAttribute("dsloai") == null) {
			ss.setAttribute("dsloai", lb.getloai());
		}
		if(request.getContentLength()<=0){
			RequestDispatcher rd = request.getRequestDispatcher("nhapsachAdmin.jsp");
			rd.forward(request, response);
		}else {
			String masach = request.getParameter("txtms");
			String tensach = request.getParameter("txttensach");
			String tacgia = request.getParameter("txttacgia");
			long soluong = Long.parseLong(request.getParameter("txtsl"));
			long gia = Long.parseLong(request.getParameter("txtgia"));
			String maloai = request.getParameter("txtloai");
			String sotap = request.getParameter("txtsotap");//1
			
			
			Part filePart = request.getPart("txtfile");
			String fileName = filePart.getSubmittedFileName();
			for (Part part : request.getParts()) {
				part.write("C:\\Users\\Admin\\eclipse-workspace\\java\\WebContent\\image_sach\\" + fileName);
			}
			String anh = ".\\image_sach\\" + fileName;
			
			sachbean s = new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai);//2
			long millis=System.currentTimeMillis();//
			java.sql.Date date=new java.sql.Date(millis);//3
			sb.them_sach(s, sotap, date);

			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
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
