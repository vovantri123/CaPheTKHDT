<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.SanPham, model.GioHang" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <title>Giỏ hàng</title>
</head>
<body>
    <h1>Giỏ hàng</h1>

    <%
        List<SanPham> gioHang = (List<SanPham>) session.getAttribute("gioHang");
        if (gioHang == null) {
            gioHang = new ArrayList<>();
        }

        String action = request.getParameter("action");
        String id = request.getParameter("id");

        if ("Thêm vào giỏ hàng".equals(action)) {
            List<SanPham> danhSach = (List<SanPham>) session.getAttribute("danhSachSanPham");
            for (SanPham sp : danhSach) {
                if (String.valueOf(sp.hashCode()).equals(id)) {
                    gioHang.add(sp);
                    break;
                }
            }
        } else if ("Xóa".equals(action)) {
            gioHang.removeIf(sp -> String.valueOf(sp.hashCode()).equals(id));
        }

        session.setAttribute("gioHang", gioHang);
    %>

    <form method="post" action="giohang.jsp">
        <%
            for (SanPham sp : gioHang) {
        %>
            <div class="sanpham">
                <p><%= sp.layTenSanPham() %></p>
                <input type="hidden" name="id" value="<%= sp.hashCode() %>">
                <input type="submit" name="action" value="Xóa">
            </div>
        <%
            }
        %>
    </form>

    <a href="sanpham.jsp">Quay lại danh sách sản phẩm</a>
</body>
</html>