<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.SanPham" %>
<%@ page import="model.GioHang" %>
<%@ page import="java.util.List" %>
<%
    GioHang gioHang = (GioHang) session.getAttribute("gioHang");
    List<SanPham> danhSachSanPhamTrongGio = null;
    if (gioHang != null) {
        danhSachSanPhamTrongGio = gioHang.layDanhSachSanPhamTrongGioHang();
    }
%>
<html>
<head>
    <title>Giỏ hàng</title>
</head>
<body>
    <h2>🛍️ Giỏ hàng của bạn</h2>
    <%
        if (danhSachSanPhamTrongGio == null || danhSachSanPhamTrongGio.isEmpty()) {
    %>
        <p>Giỏ hàng đang trống.</p>
    <%
        } else {
    %>
        <table border="1">
            <tr>
                <th>Tên sản phẩm</th>
                <th>Giá</th>
            </tr>
            <%
                for (SanPham sp : danhSachSanPhamTrongGio) {
            %>
            <tr>
                <td><%= sp.getTen() %></td>
                <td><%= sp.getGia() %></td>
            </tr>
            <%
                }
            %>
        </table>
    <%
        }
    %>
    <br/>
    <a href="sanpham.jsp">⬅️ Quay lại mua hàng</a>
</body>
</html>