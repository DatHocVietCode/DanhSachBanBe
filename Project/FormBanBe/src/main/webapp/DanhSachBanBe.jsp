<%@page import="database.dbutils"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./assets/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1 class="title">Danh sách bạn bè của tôi</h1>
	</div>
	<div class="container">
		 <table class="table table-bordered">
			 <thead>
                <tr>
                    <th>Tên</th>
                    <th>Tuổi</th>
                    <th>Số Điện Thoại</th>
                    <th>Trường Đại Học</th>
                    <th>Địa Chỉ</th>
                </tr>
            </thead>
			<%
				ResultSet rs = null;
				String cmd = "select * from BanBe";
				rs = (ResultSet)dbutils.ExecPreparedStatement(cmd, null, true);
				while (rs.next())
				{
					%>
						<tr>
							<td><%= rs.getNString("name") %></td>
							<td><%= rs.getInt("age")%></td>
							<td><%= rs.getString("phonenum") %></td>
							<td><%= rs.getNString("university") %></td>
							<td><%= rs.getNString("address") %></td>
						</tr>
					<%
				}
				
			%>
		</table>
		
	</div>
	
	
	<!-- Button mở lớp phủ -->
	<div class="container mt-5">
	  <button class="btn btn-primary" onclick="openForm()">Thêm Bạn Bè</button>
	</div>
	
	<!-- Lớp phủ form -->
	<div class="overlay" id="overlay">
	  <div class="form-popup">
	    <h4 class="text-center mb-4">Thêm Bạn Bè</h4>
	    <form id="friendForm" action="ThemBanBe_servlet" method="post">
	      <div class="mb-3">
	        <label for="name" class="form-label">Tên</label>
	        <input type="text" class="form-control" id="name" placeholder="Nhập tên" name="name">
	      </div>
	      <div class="mb-3">
	        <label for="age" class="form-label">Tuổi</label>
	        <input type="number" class="form-control" id="age" placeholder="Nhập tuổi" name="age">
	      </div>
	      <div class="mb-3">
	        <label for="phone" class="form-label">Số Điện Thoại</label>
	        <input type="text" class="form-control" id="phone" placeholder="Nhập số điện thoại" name="phone">
	      </div>
	      <div class="mb-3">
	        <label for="university" class="form-label">Trường Đại Học</label>
	        <input type="text" class="form-control" id="university" placeholder="Nhập trường đại học" name="university">
	      </div>
	       <div class="mb-3">
	        <label for="address" class="form-label">Địa chỉ nhà</label>
	        <input type="text" class="form-control" id="address" placeholder="Nhập địa chỉ nhà" name="address">
	      </div>
	      <div class="d-flex justify-content-between">
	        <button type="button" class="btn btn-secondary" onclick="closeForm()">Đóng</button>
	        <button type="submit" class="btn btn-primary">Lưu</button>
	      </div>
	    </form>
	  </div>
	</div>
	
	<script type="text/javascript" src="./javaScripts/script.js"></script>
	<script type="text/javascript">
	window.onload = function() {
	       // Lấy thông báo từ session (nếu có)
	       var message = '<%= session.getAttribute("message") != null ? session.getAttribute("message") : "" %>';
	       if (message !== "") {
	           alert(message); // Hiển thị thông báo từ session
	           <%
	           session.removeAttribute("message");
	       		%>
	       }
	   }
	</script>
</body>
</html>