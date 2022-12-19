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

/**
 * Servlet implementation class addUser
 */
@WebServlet("/addUser")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 *1,
		maxFileSize = 1024 * 1024 * 10,
		maxRequestSize = 1024 * 1024 *100)
public class addUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		if(request.getContentLength() <= 0){
			RequestDispatcher rd = request.getRequestDispatcher("upfile.jsp");
			rd.forward(request, response);
		}else {

			Part filePart = request.getPart("txtfile");
			String fileName = filePart.getSubmittedFileName();
			for (Part part : request.getParts()) {
				part.write("C:\\Users\\Admin\\eclipse-workspace\\examJava\\WebContent\\images\\" + fileName);
			}
			String anh = ".\\images\\" + fileName;
					
			RequestDispatcher rd = request.getRequestDispatcher("upfile.jsp");
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
