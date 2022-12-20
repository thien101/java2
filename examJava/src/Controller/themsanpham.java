package Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.sanphambean;
import bo.sanphambo;

/**
 * Servlet implementation class themsanpham
 */
@WebServlet("/themsanpham")
public class themsanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public themsanpham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		sanphambo spb = new sanphambo();
		HttpSession ss= request.getSession();
//		if(request.getParameter("them") != null) {
//			String anh = "./images/";
//		}
		
		
		
		if(request.getContentLength()<=0){
			RequestDispatcher rd = request.getRequestDispatcher("sanphamAdmin.jsp");
			rd.forward(request, response);
		}else {
			String tensach="";
			String mahang="";
			long soluong = 0;
			long gia = 0;
			String anh = "./images/";
			DiskFileItemFactory factory = new DiskFileItemFactory();
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			String dirUrl1 = request.getServletContext().getRealPath("") +  File.separator + "images";
			//response.getWriter().println("Vao Roi");
			//response.getWriter().println(dirUrl1);
			try {
				List<FileItem> fileItems = upload.parseRequest(request);//Lấy về các đối tượng gửi lên
				//duyệt qua các đối tượng gửi lên từ client gồm file và các control
				for (FileItem fileItem : fileItems) {
					if (!fileItem.isFormField()) {//Nếu ko phải các control=>upfile lên
					// xử lý file
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
				        //Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("") +  File.separator + "images";
						File dir = new File(dirUrl);
						if (!dir.exists()) {//nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
					    String fileImg = dirUrl + File.separator + nameimg;
					    File file = new File(fileImg);//tạo file
					    try {
					    	fileItem.write(file);//lưu file
					    	 anh += nameimg;
					    	 response.getWriter().println(anh);
					    	} 
					    catch (Exception e) {
					    	e.printStackTrace();
					    	}
						}
					}
					else//Neu la control
					{
						String tentk=fileItem.getFieldName();
						if(tentk.equals("txttensp")) {
							//response.getWriter().println(fileItem.getString());
							tensach = fileItem.getString();
						}
							
							
						if(tentk.equals("txtmh")) {
							//response.getWriter().println(fileItem.getString());
							mahang = fileItem.getString();
						}
							
						if(tentk.equals("txtsl")) {
							//response.getWriter().println(fileItem.getString());
							soluong = Long.parseLong(fileItem.getString());
						}
							
						if(tentk.equals("txtgia")) {
							//response.getWriter().println(fileItem.getString());
							gia = Long.parseLong(fileItem.getString());
						}
							
						
				    	
					}
				}
				spb.them_sp(new sanphambean(0, tensach, mahang, soluong, gia, anh));
			} 
			catch (FileUploadException e) {
				e.printStackTrace();
			}
			
		
	}
	ss.setAttribute("dssanpham", spb.getsanpham());
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
