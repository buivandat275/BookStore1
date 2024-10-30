<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
<body>
<jsp:include page="../header.jsp"/>
  
  <div class="container">
<h1>Thao tác thành công! Vui lòng quay lại trang đăng nhập!</h1>
 <h3>Tự động quay lại sau: <span id="countdown" style="color: red">5</span> giây.</h3></div>

 

 <jsp:include page="../footer.jsp"/>
<script>
    let countdownTime = 5;

    function updateCountdown() {
        countdownTime--;
        document.getElementById("countdown").textContent = countdownTime;
        
        if (countdownTime <= 0) {
            window.location.href = 'index.jsp';
        }
    }
    setInterval(updateCountdown, 1000);
</script>

</body>
</html>