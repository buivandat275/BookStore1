<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1, shrink-to-fit=no">
<title>Thông tin</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
	integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
	crossorigin="anonymous"></script>
<style type="text/css">
#red {
	color: red;
}

.red {
	color: red;
}
</style>
</head>
<jsp:include page="../header.jsp" />
<body>

		<%
				Object obj = session.getAttribute("khachHang");
					KhachHang khachHang = null;
					if (obj != null)
						khachHang = (KhachHang)obj;
					if (khachHang == null) {
		%>
		<h1>Bạn chưa đăng nhập! Vui lòng quay lại trang chủ</h1>
		<%
					}else{
					
		%>
<div class="container">
	<%
	String baoLoi = request.getAttribute("baoLoi")+"";
	baoLoi = (baoLoi.equals("null"))?"":baoLoi;

	String duongDanAnh = khachHang.getDuongdananh();
	
	%>
	<div class="container">
		<h1 style="text-align: center">Đăng Ký Tài Khoản</h1>
		<div class="red" id="baoLoi">
			<%=baoLoi%>

		</div>
		 <%
 String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ request.getContextPath();
 %>	
		<form action="<%=url1 %>/khach-hang-thay-doi-anh" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-md-6">
					
					<h3>Thông Tin Khách Hàng</h3>
					<img alt="Ảnh avatar" src="<%=url1%>/avatar/<%=duongDanAnh%>" />
					<div class="mb-3">
						<label for="duongDanAnh" class="form-label">Đường dẫn ảnh</label> <input
							type="file" class="form-control" id="duongDanAnh" name="duongDanAnh" >
					</div>
					
					<input type="submit" value="Lưu thông tin"
						class="btn btn-primary form-control" name="submit" id="submit">
				</div>
			</div>
		</form>
	</div>
	</div>
	<%} %>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>

<script type="text/javascript">

</script>

</html>