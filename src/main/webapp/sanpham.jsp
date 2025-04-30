<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.SanPham" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <title>Danh sách sản phẩm</title>
</head>
<body>
    <h1>Danh sách sản phẩm</h1>
    <%
        // Giả sử danh sách sản phẩm đang hard-code
        List<SanPham> danhSach = new ArrayList<>();
        SanPham sp1 = new SanPham(); // giả định bạn có constructor set thông tin
        // set dữ liệu cho sp1 thông qua setter hoặc gán trực tiếp (nếu public)
        sp1.setTen("Cafe Arabica");
        danhSach.add(sp1);

        session.setAttribute("danhSachSanPham", danhSach);
    %>

    <form method="post" action="giohang.jsp">
        <%
            for (int i = 0; i < danhSach.size(); i++) {
        %>
            <div class="sanpham">
                <p>Tên: <%= danhSach.get(i).layTenSanPham() %></p>
                <input type="hidden" name="id" value="<%= danhSach.get(i).hashCode() %>">
                <input type="submit" name="action" value="Thêm vào giỏ hàng">
            </div>
        <%
            }
        %>
    </form>
</body>
</html>