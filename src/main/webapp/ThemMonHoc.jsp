<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
	uri="jakarta.tags.core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		form > *
		{
			margin: 4px;
		}
	</style>
</head>
<body>
	<form action="ThemMonHoc_servlet" method="post" onsubmit="return validateInput()">
        <label for="maMH">Mã môn học</label>
        <input id="maMH" name="maMH" type="text"><br>
        
        <label for="tenMH">Tên môn học</label>
        <input id="tenMH" name="tenMH" type="text"><br>
        
        <label for="stc">Số tín chỉ</label>
        <input id="stc" name="stc" type="number" step="1"><br>
        
        <label for="khoaQL">Mã khoa quản lý</label>
        <input id="khoaQL" name="khoaQL" type="number" step="1">
        
        <input type="submit" value="Submit">
    </form>

	
	
	<%-- <c:if test="${not empty sessionScope.message}">
    <div class="alert alert-success">
        ${sessionScope.message}
    </div>
    <!-- Sau khi hiển thị, bạn có thể xóa thông báo khỏi session nếu không muốn hiển thị lại sau khi làm mới trang -->
    <c:set var="message" value="${sessionScope.message}" scope="session" />
    <c:remove var="message" scope="session" />
</c:if> --%>
	<script>
    // Hàm hiển thị thông báo khi trang được tải
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
	<script type="text/javascript">
	function validateInput() {
        // Lấy các giá trị từ form
        var maMH = document.getElementById('maMH').value;
        var tenMH = document.getElementById('tenMH').value;
        var stc = document.getElementById('stc').value;
        var khoaQL = document.getElementById('khoaQL').value;
        
        // Kiểm tra xem có trường nào trống không
        if (maMH === "" || tenMH === "" || stc === "" || khoaQL === "") {
            // Nếu có trường trống, hiển thị thông báo và trả về false (ngừng submit form)
            alert("Vui lòng điền đầy đủ tất cả các trường!");
            return false; // Ngừng gửi form
        }
        
        // Nếu tất cả các trường đều có dữ liệu, gửi form
        return true;
    }
	</script>
</body>	
	
</html>