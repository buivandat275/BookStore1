<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%
 String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ request.getContextPath();
 %>	
	
<!-- Navbar -->
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="https://titv.vn/wp-content/uploads/2023/10/Screenshot-2023-01-29-230321.png"
				alt="Bootstrap" height="44">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">ComBoGiamGia</a>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Thể Loại </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Quần Jean</a></li>
							<li><a class="dropdown-item" href="#">Áo THun</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Váy</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link disabled"
						aria-disabled="true">Hết Hàng</a></li>
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search"
						placeholder="Nội dung tìm kiếm" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Tìm</button>
					<%
					Object obj = session.getAttribute("khachHang");
					KhachHang khachHang = null;
					if (obj != null)
						khachHang = (KhachHang) obj;
					if (khachHang == null) {
					%>
					<a class="btn btn-primary"
						style="white-space: nowrap; margin-left: 12px" href="khachhang/dangnhap.jsp">
						Đăng nhập </a>
					<%
					} else {
					%>
					<div class="btn-group dropstart">
						<button type="button" class="btn btn-secondary dropdown-toggle"
							data-bs-toggle="dropdown" aria-expanded="false">
							Tài khoản <%=khachHang.getTenDangNhap() %></button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Đơn hàng của tôi</a></li>
							<li><a class="dropdown-item" href="#">Thông báo</a></li>
							<li><a class="dropdown-item" href="<%=url%>/khachhang/thaydoianh.jsp">Thay đổi ảnh avarta</a></li>
							<li><a class="dropdown-item" href="<%=url%>/khachhang/doithongtin.jsp">Thay đổi thông tin</a></li>
							<li><a class="dropdown-item" href="<%=url%>/khachhang/doimatkhau.jsp">Đổi mật khẩu</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="<%=url%>/khach-hang?hanhDong=dang-xuat&">Thoát tài khoản</a></li>
						</ul>
					</div>

					<%-- <div class="row text-center" style="margin-left: 0.20em;">
							<div class="row"><b>Chào <%=khachHang.getTenDangNhap() %></b></div>
							<div class="row" ><a style="white-space: nowrap;display: inline-block;background-color: #007bff;color: white; text-decoration: none; border-radius: 5px; text-align: center;" href="dang-xuat">
								Đăng xuất
							</a>
							</div>
						</div> --%>
					<%
					}
					%>
				</form>
			</div>
		</div>
	</nav>
	<!-- End -->