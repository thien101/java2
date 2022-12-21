package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachhangbean;
import bo.khachhangbo;

/**
 * Servlet implementation class khachhangController
 */
@WebServlet("/khachhangController")
public class khachhangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public khachhangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession ss = request.getSession();
		khachhangbo khb = new khachhangbo();
		khachhangbean kh = new khachhangbean();
		String un = request.getParameter("un");
		String pass = request.getParameter("pass");
		if(ss.getAttribute("khachhang") != null) {
			kh = (khachhangbean)ss.getAttribute("khachhang");
		}
		if(un != null && pass != null) {
			if(request.getParameter("dn") != null) {
				if(khb.ktdn(un, pass) != null) {
					ss.setAttribute("khachhang", khb.ktdn(un, pass));
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp?check=false");
					rd.forward(request, response);
				}
			}
			
			if(request.getParameter("dk") != null) {
				String hoten = request.getParameter("hoten");
				String diachi = request.getParameter("diachi");
				String sodt = request.getParameter("sodt");
				String email = request.getParameter("email");
				khachhangbean k = new khachhangbean(0, un, pass, hoten, diachi, sodt, email);
				khb.them_kh(k);
				ss.setAttribute("khachhang", khb.ktdn(k.getTendn(), k.getPass()));
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("trangchuController");
			rd.forward(request, response);
		}
		else {
			if(request.getParameter("capnhapkh") != null) {
				String hoten = request.getParameter("hoten");
				String diachi = request.getParameter("diachi");
				String sodt = request.getParameter("sodt");
				String email = request.getParameter("email");
				khb.capnhap_kh(hoten, diachi, sodt, email, (khachhangbean)ss.getAttribute("khachhang"));
				ss.setAttribute("khachhang", khb.ktdn(kh.getTendn(), kh.getPass()));
				RequestDispatcher rd = request.getRequestDispatcher("thongtinKH.jsp");
				rd.forward(request, response);
			}
			if(request.getParameter("thongtin") != null) {
				RequestDispatcher rd = request.getRequestDispatcher("thongtinKH.jsp");
				rd.forward(request, response);
			}
				
			if(request.getParameter("dn") != null) {
				RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp?");
				rd.forward(request, response);
			}
			if(request.getParameter("dk") != null) {
				RequestDispatcher rd = request.getRequestDispatcher("dangky.jsp");
				rd.forward(request, response);
			}
			if(request.getParameter("dx") != null) {
				ss.removeAttribute("khachhang");
				ss.removeAttribute("trang");
				ss.removeAttribute("slhang");
				ss.removeAttribute("dshoadon");
				ss.removeAttribute("chitietsp");
				ss.removeAttribute("gh");
				RequestDispatcher rd = request.getRequestDispatcher("trangchuController");
				rd.forward(request, response);
			}
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
