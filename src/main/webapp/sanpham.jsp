<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.SanPham" %>
<%@ page import="model.GioHang" %>
<%
    // Lấy danh sách sản phẩm mẫu
    List<SanPham> danhSachSanPham = (List<SanPham>) session.getAttribute("danhSachSanPham");
    if (danhSachSanPham == null) {
        danhSachSanPham = new ArrayList<>();
        SanPham sp1 = new SanPham();
        sp1.setId(1);
        sp1.setTen("Cà phê đen");
        sp1.setGia(20000);
        danhSachSanPham.add(sp1);

        SanPham sp2 = new SanPham();
        sp2.setId(2);
        sp2.setTen("Cà phê sữa");
        sp2.setGia(25000);
        danhSachSanPham.add(sp2);

        session.setAttribute("danhSachSanPham", danhSachSanPham);
    }

    // Xử lý thêm sản phẩm vào giỏ nếu có param id
    String idParam = request.getParameter("id");
    if (idParam != null) {
        int id = Integer.parseInt(idParam);
        SanPham sanPhamChon = null;
        for (SanPham sp : danhSachSanPham) {
            if (sp.getId() == id) {
                sanPhamChon = sp;
                break;
            }
        }

        if (sanPhamChon != null) {
            GioHang gioHang = (GioHang) session.getAttribute("gioHang");
            if (gioHang == null) {
                gioHang = new GioHang();
                session.setAttribute("gioHang", gioHang);
            }
            gioHang.setSanPhamDangThem(sanPhamChon);
            gioHang.themSanPhamVaoGioHang();
        }
    }
%>

<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
    <h2>🛒 Danh sách sản phẩm</h2>
    <table border="1">
        <tr>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th>Hành động</th>
        </tr>
        <%
            for (SanPham sp : danhSachSanPham) {
        %>
        <tr>
            <td><%= sp.getTen() %></td>
            <td><%= sp.getGia() %></td>
            <td>
                <form method="get" action="sanpham.jsp">
                    <input type="hidden" name="id" value="<%= sp.getId() %>" />
                    <input type="submit" value="Thêm vào giỏ hàng" />
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <br/>
    <a href="giohang.jsp">Xem giỏ hàng</a>
</body>
</html>