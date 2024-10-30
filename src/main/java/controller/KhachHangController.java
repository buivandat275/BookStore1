package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.KhachHangDao;

import model.KhachHang;
import util.Email;
import util.MaHoa;
import util.MaRandom;

/**
 * Servlet implementation class KhachHangController
 */
@WebServlet("/khach-hang")
public class KhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
String hanhDong = request.getParameter("hanhDong");
		
		if(hanhDong.equals("dang-nhap")) {
			dangNhap(request, response);
			
		}else if(hanhDong.equals("dang-xuat")) {
			dangXuat(request, response);
		}else if(hanhDong.equals("dang-ky")) {
			dangKy(request, response);
		}else if(hanhDong.equals("doi-mat-khau")) {
			doimatkhau(request, response);
		}else if(hanhDong.equals("doi-thong-tin")) {
			doithongtin(request, response);
		}else if(hanhDong.equals("xac-thuc")) {
			xacThuc(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void xacThuc(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String maKhachHang = request.getParameter("maKhachHang");
			String maXacThuc = request.getParameter("maXacThuc");

			
			KhachHangDao khanhHangDao = new KhachHangDao();
			
			KhachHang kh = new KhachHang();
			kh.setMaKhacHang(maKhachHang);
			KhachHang khachHang = khanhHangDao.selectById(kh);
			
			String msg = "";
			if (khachHang != null) {
				if(khachHang.getMaxacthuc().equals(maXacThuc)) {
					// thanh cong
					khachHang.setTrangthaixacthuc(true);
					khanhHangDao.updateVerifyInformation(khachHang);
					 msg ="Xac thuc thanh cong";
					}else {
				// that bai
				 msg ="Xac thuc khong thanh cong:";
					}
			}else {
				 msg ="Tài khoản không tồn tại";
			}
			
			String url = "/khachhang/thongbao.jsp";
			
			request.setAttribute("baoLoi", msg);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void doithongtin(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String hoVaTen = request.getParameter("hoVaTen");
			String gioiTinh = request.getParameter("gioiTinh");
			String ngaySinh = request.getParameter("ngaySinh");
			String diaChiKhachHang = request.getParameter("diaChiKhachHang");
			String diaChiMuaHang = request.getParameter("diaChimh");
			String diaChiNhanHang = request.getParameter("diaChinh");
			String dienThoai = request.getParameter("dienThoai");
			String email = request.getParameter("email");
			String dongYNhanE = request.getParameter("DongYNhanE");
			
			request.setAttribute("hoVaTen", hoVaTen);
			request.setAttribute("gioiTinh", gioiTinh);
			request.setAttribute("ngaySinh", ngaySinh);
			request.setAttribute("diaChiKhachHang", diaChiKhachHang);
			request.setAttribute("diaChiMuaHang", diaChiMuaHang);
			request.setAttribute("diaChiNhanHang", diaChiNhanHang);
			request.setAttribute("dienThoai", dienThoai);
			request.setAttribute("email", email);
			request.setAttribute("dongYNhanE", dongYNhanE);
			String url ="";
			String baoLoi ="";
			KhachHangDao khanhHangDao = new KhachHangDao();
			
			
			request.setAttribute("baoLoi", baoLoi);
			if(baoLoi.length()>0) {
				url ="/khachhang/doithongtin.jsp";
			}else {
				Object obj = request.getSession().getAttribute("khachHang");
				KhachHang khachHang = null;
				if (obj != null)
					khachHang = (KhachHang)obj;
				if (khachHang != null) {
				
				String maKhachHang = khachHang.getMaKhacHang();
				KhachHang kh = new KhachHang(maKhachHang, "", "", hoVaTen, gioiTinh, diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), dienThoai, email, dongYNhanE!=null);
				khanhHangDao.updateInfo(kh); 
				//load lai khachHang vao session
				KhachHang kh2 = khanhHangDao.selectById(kh);
				request.getSession().setAttribute("khachHang", kh2);
				
				url = "/khachhang/thanhcong.jsp";
			}
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void dangNhap(HttpServletRequest request, HttpServletResponse response)  {
		// TODO Auto-generated method stub
		try {
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			matKhau = MaHoa.toSHA1(matKhau);
			
			KhachHang kh = new KhachHang();
			kh.setTenDangNhap(tenDangNhap);
			kh.setMatKhau(matKhau);
			
			KhachHangDao khd = new KhachHangDao();
			KhachHang khachHang = khd.selectByUserNameAndPassWord(kh);
			String url="";
			if(khachHang!=null&&khachHang.isTrangthaixacthuc()) {
				HttpSession session= request.getSession();
				session.setAttribute("khachHang", khachHang);
				url ="/index.jsp";
			}else {
				request.setAttribute("baoLoi", "Tên đăng nhập hoặc mật khẩu không đúng!");
				url="/khachhang/dangnhap.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	private void doimatkhau(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String matKhauHienTai = request.getParameter("matKhauHienTai"); 
			String matKhauMoi = request.getParameter("matKhauMoi"); 
			String matKhauNhapLai = request.getParameter("matKhauNhapLai"); 
//kiểm tra mật khẩu có giống hay không		
			String matKhauHienTaiSha1 = MaHoa.toSHA1(matKhauHienTai);
			String baoLoi = "";
			String url="";
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("khachHang");
			KhachHang khachHang = null;
			
			if(obj!= null) 
				khachHang = (KhachHang)obj;
			if(khachHang==null) {
				baoLoi="Bạn chưa đăng nhập vào hệ thống!";
				url= "/khachhang/doimatkhau.jsp";
				
			}else {//nếu khách hàng đã đăng nhập
				if(!matKhauHienTaiSha1.equals(khachHang.getMatKhau())) {
					baoLoi="Mật khẩu hiện tại không chính xác!";
					url="/khachhang/doimatkhau.jsp";
				}else {
					if(!matKhauMoi.equals(matKhauNhapLai)) {
						baoLoi="Mật khẩu nhập lại không khớp!";
						url="/khachhang/doimatkhau.jsp";
					}else if(matKhauMoi.equals(matKhauHienTai)) {
						baoLoi="Mật khẩu vừa tạo giống mật khẩu cũ";
						url="/khachhang/doimatkhau.jsp";
						
					}else {
						String matKhauMoi_Sha1 =MaHoa.toSHA1(matKhauMoi);
						khachHang.setMatKhau(matKhauMoi_Sha1);
						KhachHangDao khd = new KhachHangDao();
						if(khd.doiPass(khachHang)) {
							baoLoi="Mật khẩu đã thay đổi thành công";
							url="/khachhang/doimatkhau.jsp";
						}else {
							baoLoi="Qúa trình đổi mật khẩu không thành côngg!";
							
							url="/khachhang/doimatkhau.jsp";
							
						}
						
					}
				}
			}
			request.setAttribute("baoLoi", baoLoi);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private void dangXuat(HttpServletRequest request, HttpServletResponse response)  {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				//response.getWriter().append("Served at: ").append(request.getContextPath());
				try {
					HttpSession session = request.getSession();
					session.invalidate();//huy bo session
					String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();
					response.sendRedirect(url+"/index.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}
	private void dangKy(HttpServletRequest request, HttpServletResponse response)  {
		try {
			String tenDangNhap = request.getParameter("user");
			String matKhau = request.getParameter("pass");
			String matKhauNhapLai = request.getParameter("passnn");
			String hoVaTen = request.getParameter("hoVaTen");
			String gioiTinh = request.getParameter("gioiTinh");
			String ngaySinh = request.getParameter("ngaySinh");
			String diaChiKhachHang = request.getParameter("diaChiKhachHang");
			String diaChiMuaHang = request.getParameter("diaChimh");
			String diaChiNhanHang = request.getParameter("diaChinh");
			String dienThoai = request.getParameter("dienThoai");
			String email = request.getParameter("email");
			String dongYNhanE = request.getParameter("DongYNhanE");
			request.setAttribute("tenDangNhap", tenDangNhap);
			request.setAttribute("hoVaTen", hoVaTen);
			request.setAttribute("gioiTinh", gioiTinh);
			request.setAttribute("ngaySinh", ngaySinh);
			request.setAttribute("diaChiKhachHang", diaChiKhachHang);
			request.setAttribute("diaChiMuaHang", diaChiMuaHang);
			request.setAttribute("diaChiNhanHang", diaChiNhanHang);
			request.setAttribute("dienThoai", dienThoai);
			request.setAttribute("email", email);
			request.setAttribute("dongYNhanE", dongYNhanE);
			String url ="";
			String baoLoi ="";
			KhachHangDao khanhHangDao = new KhachHangDao();
			if(khanhHangDao.kiemTraTenDangNhap(tenDangNhap)) {
				baoLoi+="Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác .<br/>";
			}
			if(!matKhau.equals(matKhauNhapLai)) {
				baoLoi+="Mật khẩu không Khớp.<br/>";
			}else {
				matKhau = MaHoa.toSHA1(matKhau);
			}
			
			request.setAttribute("baoLoi", baoLoi);
			if(baoLoi.length()>0) {
				url ="/khachhang/dangky.jsp";
			}else {
				Random rd = new Random();
				String maKhachHang =rd.nextInt(1000)+"";
				KhachHang kh = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), dienThoai, email, dongYNhanE!=null);
				if(khanhHangDao.insert(kh)>0) {
					//day so xac thuc
					String soNgauNhien = MaRandom.getSoNgauNhien();
					// Quy dinh thoi gian 
					Date todaysDate = new Date(new java.util.Date().getTime());
					Calendar c = Calendar.getInstance(); 
					c.setTime(todaysDate); 
					c.add(Calendar.DATE, 1); // hieu luc 1 ngay
					//c.add(Calendar.MINUTE, 10); hieu luc sau 10p
					Date thoiGianHieuLucXacThuc = new Date(c.getTimeInMillis());
					
					boolean trangThaiXacThuc= false;
					
					kh.setMaxacthuc(soNgauNhien);
					kh.setThoigianhieuluccuamaxacthuc(thoiGianHieuLucXacThuc);
					kh.setTrangthaixacthuc(trangThaiXacThuc);
					
					if(khanhHangDao.updateVerifyInformation(kh)>0) {
						// gui mail cho khach
						Email.sendEmail(kh.getEmail(), "Xác thực tài khoản tại DVB", getNoiDung(kh));
						
					}	
				}
				
				url = "/khachhang/thanhcong.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public static String getNoiDung(KhachHang kh) {
		String link ="http://localhost:8080/BookStore1/khach-hang?hanhDong=xac-thuc&maKhachHang="+kh.getMaKhacHang()+"&maXacThuc="+kh.getMaxacthuc();
		String noiDung = "<p>DVB.vn Xin ch&agrave;o anh <strong>"+kh.getHoVaTen()+"</strong>.</p>\r\n"
				+ "<p>Vui l&ograve;ng x&aacute;c thực t&agrave;i khoản của bạn bằng c&aacute;c nhập m&atilde; <strong>"+kh.getMaxacthuc()+"</strong>&nbsp; &nbsp;, hoặc k&iacute;ch v&agrave;o đường linh sau :</p>\r\n"
				+ "<p><a href=\""+link+"\">"+link+"</a></p>\r\n"
				+ "<p>Đ&acirc;y l&agrave; Email tự động , vui l&ograve;ng kh&ocirc;ng phản hồi email n&agrave;y.</p>\r\n"
				+ "<p>Tr&acirc;n trọng cảm ơn.</p>\r\n"
				+ "<p>&nbsp;</p>";
		
		return noiDung;
	}
	

}
