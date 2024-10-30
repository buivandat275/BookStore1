package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import database.KhachHangDao;
import model.KhachHang;

/**
 * Servlet implementation class KhachHangThayDoiAnh
 */
@WebServlet("/khach-hang-thay-doi-anh")
public class KhachHangThayDoiAnh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachHangThayDoiAnh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("123");
		 Object obj = request.getSession().getAttribute("khachHang");
		    KhachHang khachHang = null;
		    if (obj != null) khachHang = (KhachHang) obj;
		    
		    if (khachHang != null) {
		        try {
		            String folder = getServletContext().getRealPath("avatar");
		            System.out.println("Upload folder: " + folder);
		            File file;
		            int maxFileSize = 5000 * 1024;
		            int maxMemorySize = 5000 * 1024;

		            String contentType = request.getContentType();
		            
		            // Kiểm tra kiểu nội dung
		            if (contentType != null && contentType.contains("multipart/form-data")) {
		                DiskFileItemFactory factory = new DiskFileItemFactory();
		                factory.setSizeThreshold(maxMemorySize);

		                ServletFileUpload upload = new ServletFileUpload(factory);
		                upload.setSizeMax(maxFileSize);

		                List<FileItem> files = upload.parseRequest(request);
		                for (FileItem fileItem : files) {
		                    if (!fileItem.isFormField()) {
		                        String fileName = fileItem.getName();
		                        
		                        // Kiểm tra nếu có tên file
		                        if (fileName != null && !fileName.isEmpty()) {
		                            String path = Paths.get(folder, fileName).toString();
		                            file = new File(path);

		                            fileItem.write(file);

		                            khachHang.setDuongdananh(fileName);
		                            KhachHangDao khd = new KhachHangDao();
		                            khd.updateImage(khachHang);
		                            khachHang = khd.selectById(khachHang); // Tải lại đối tượng sau khi cập nhật
		                        }
		                    } else {
		                        String name = fileItem.getFieldName();
		                        String value = fileItem.getString();
		                        System.out.println(name + " : " + value);
		                    }
		                }
		            }

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
}
}
