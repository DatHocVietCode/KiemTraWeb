<%@page import="beans.Khoa"%>
<%@page import="beans.MonHoc"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="dbutil.dbutils"%>
<%@page import="java.sql.Connection"%>
<%@page import="connection.sqlConnection"%>
<%@ taglib prefix="c" 
	uri="jakarta.tags.core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hien Thi Mon Hoc</title>
	<style type="text/css">
		.container > input
		{
			background: none;
		    border: none;
		    color: blue; 
		    text-decoration: underline; 
		    cursor: pointer;
		}
	</style>
</head>
<body>
	<form name="" class="container" action="ThemMonHoc.jsp" >
		<input type="submit" style="" value="Thêm môn học">
	</form>
	<table name = "bang_mon_hoc" border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th>Mã môn học</th>
			<th>Tên môn học</th>
			<th>Khoa phụ trách</th>
			<th>Số tín chỉ</th>
			<th>Action</th>
		</tr>
			<%
				String query = "select MonHoc.*, Khoa.TenKhoa from MonHoc join Khoa on MonHoc.KhoaQuanLy = Khoa.MaKhoa";
				ResultSet rs = dbutils.ExecuteQuery(query);
				while (rs.next())
				{
					MonHoc mh = new MonHoc(rs.getNString("MaMH").toString(), rs.getNString("TenMH").toString(), rs.getInt("SoTinChi"),
							new Khoa(rs.getInt("KhoaQuanLy"), rs.getNString("TenKhoa")));
					%>
						<tr>
							<td><%= mh.getMaMonHoc() %>
							
							</td>
							<td><%= mh.getTenMonHoc() %>
							
							</td>
							<td><%= mh.getKhoaPhuTrach().getTenKhoa() %>
							
							</td>
							<td><%= mh.getSoTinChi() %>
								
							</td>
							<td>
								<div style="display: flex; flex-direction: row;">
									<form class ="container" action="SuaMonHoc.jsp">
										<input type="hidden" value="<%= mh.getMaMonHoc() %>" name="maMH">
										<input type="hidden" value="<%= mh.getTenMonHoc() %>" name="tenMH">
										<input type="hidden" value="<%= mh.getKhoaPhuTrach().getMaKhoa() %>" name="maKhoaPhuTrach">
										<input type="hidden" value="<%= mh.getSoTinChi() %>" name="stc">
										<input type="submit" style="" value="Sửa">
									</form>
									/
									<form class ="container" action="XoaMonHoc_servlet">
										<input type="hidden" value="<%= mh.getMaMonHoc() %>" name="maMH">
										<input type="hidden" value="<%= mh.getTenMonHoc() %>" name="tenMH">
										<input type="hidden" value="<%= mh.getKhoaPhuTrach().getMaKhoa() %>" name="maKhoaPhuTrach">
										<input type="hidden" value="<%= mh.getSoTinChi() %>" name="stc">
										<input type="submit" style="" value="Xóa" onclick="return confirmDelete()">
									</form>
								</div>
							</td>
						</tr>
					<%
				}
				//dbutil.CloseResultset(rs);
			%>
	</table>
	
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
    function confirmDelete() {
        // Hiển thị hộp thoại xác nhận
        var result = confirm("Bạn có chắc chắn muốn xóa môn học này?");
        
        // Nếu nhấn "Yes" (result = true), chuyển hướng đến servlet XoaMonHoc_servlet
        if (result) {
            // Bạn có thể gửi thêm tham số (ví dụ: mã môn học) nếu cần
            return true;
        } else {
            // Nếu nhấn "No", không làm gì và giữ nguyên trang hiện tại
            return false;
        }
    }
	</script>
</body>
</html>