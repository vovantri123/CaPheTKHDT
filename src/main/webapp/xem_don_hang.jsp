<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.DonHang" %>
<%@ page import="model.ChiTietDonHang" %> <%-- Import inner class đúng cách --%>
<%@ page import="java.net.URLDecoder" %>
<jsp:include page="header.jsp"/>

<%
    // Lấy thông báo từ URL (nếu có)
    String message = request.getParameter("message");
    String messageType = ""; // "success" hoặc "error"
    if (message != null) {
        message = URLDecoder.decode(message, "UTF-8");
        if (request.getParameter("success") != null) {
            messageType = "success";
        } else if (request.getParameter("error") != null) {
            messageType = "error";
        }
    }

    // Lấy *tất cả* đơn hàng, sắp xếp theo ngày tạo mới nhất lên đầu (trong hàm getDanhSachDonHang đã sort)
    List<DonHang> tatCaDonHang = DonHang.getDanhSachDonHang();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản Lý Đơn Hàng</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Merriweather:wght@400;700&family=Open+Sans:wght@300;400;600&display=swap">
    <style>
        body {
            font-family: 'Open Sans', sans-serif;
            margin: 20px;
            background-color: #f9f9f9;
            color: #333;
            line-height: 1.6;
        }
        h1 {
            font-family: 'Merriweather', serif;
            color: #3e2723;
            text-align: center;
            margin-bottom: 30px;
        }
        .order-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 30px;
            background-color: #fff;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        .order-table th, .order-table td {
            border: 1px solid #ddd;
            padding: 10px 12px;
            text-align: left;
            vertical-align: middle; /* Căn giữa theo chiều dọc cho dễ nhìn */
        }
        .order-table th {
            background-color: #efebe9;
            color: #4e342e;
            font-weight: 600;
        }
        .order-table tr:nth-child(even) {
            background-color: #f5f5f5;
        }
        .order-table tr:hover {
            background-color: #e8e2dc;
        }
        .order-details ul {
            list-style: none;
            padding: 0;
            margin: 0;
            font-size: 0.9em;
        }
        .order-details li {
            margin-bottom: 3px;
        }
        .customer-info span {
            display: block;
            font-size: 0.9em;
            line-height: 1.4;
        }

        .action-button {
            padding: 6px 12px;
            font-size: 14px;
            font-weight: 600;
            cursor: pointer;
            color: white;
            border: none;
            border-radius: 4px;
            text-decoration: none;
            display: inline-block;
            text-align: center;
            min-width: 90px; /* Tăng chiều rộng tối thiểu */
            margin-right: 5px;
            margin-bottom: 5px;
            transition: background-color 0.3s, transform 0.2s;
        }
        .btn-accept { background-color: #5cb85c; } /* Green */
        .btn-accept:hover { background-color: #4cae4c; transform: translateY(-1px); }

        .btn-complete { background-color: #337ab7; } /* Blue */
        .btn-complete:hover { background-color: #286090; transform: translateY(-1px); }

        .btn-cancel { background-color: #d9534f; } /* Red */
        .btn-cancel:hover { background-color: #c9302c; transform: translateY(-1px); }

        .message {
            padding: 15px;
            margin-bottom: 20px;
            border-radius: 5px;
            font-weight: bold;
        }
        .message.success {
            background-color: #dff0d8;
            color: #3c763d;
            border: 1px solid #d6e9c6;
        }
        .message.error {
            background-color: #f2dede;
            color: #a94442;
            border: 1px solid #ebccd1;
        }
        .no-orders {
            text-align: center;
            font-style: italic;
            color: #777;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ddd;
        }
        /* Điều chỉnh độ rộng cột nếu cần */
        .col-id { width: 5%; }
        .col-date { width: 12%; }
        .col-customer { width: 20%; }
        .col-details { width: 25%; }
        .col-total { width: 10%; }
        .col-status { width: 10%; }
        .col-action { width: 18%; text-align: center; } /* Căn giữa nút */

        td strong { font-weight: 600; } /* Làm nổi bật trạng thái */

    </style>
</head>
<body>

<h1>Danh Sách Tất Cả Đơn Hàng (<%= tatCaDonHang.size() %>)</h1>

<%-- Hiển thị thông báo (nếu có) --%>
<% if (message != null) { %>
<div class="message <%= messageType %>">
    <%= message %>
</div>
<% } %>

<%-- Bảng hiển thị tất cả đơn hàng --%>
<% if (tatCaDonHang.isEmpty()) { %>
<p class="no-orders">Không có đơn hàng nào trong hệ thống.</p>
<% } else { %>
<table class="order-table">
    <thead>
    <tr>
        <th class="col-id">Mã Đơn</th>
        <th class="col-date">Ngày Tạo</th>
        <th class="col-customer">Khách Hàng</th>
        <th class="col-details">Chi Tiết Sản Phẩm</th>
        <th class="col-total">Tổng Tiền</th>
        <th class="col-status">Trạng Thái</th>
        <th class="col-action">Hành Động</th>
    </tr>
    </thead>
    <tbody>
    <% for (DonHang dh : tatCaDonHang) { %>
    <tr>
        <td class="col-id">#<%= dh.getId() %></td>
        <td class="col-date"><%= dh.getNgayTao() %></td> <%-- Sử dụng hàm định dạng --%>
        <td class="col-customer customer-info">
            <strong><%= dh.getTenKhachHang() %></strong><br>
            <span>SĐT: <%= dh.getSdtKhachHang() %></span>
            <span>Địa chỉ: <%= dh.getDiaChiGiaoHang() %></span>
            <span>TT: <%= dh.getPhuongThucThanhToan() %></span>
        </td>
        <td class="col-details order-details">
            <ul>
                <% for (ChiTietDonHang ct : dh.getChiTietDonHangList()) { %>
                <li><%= ct.toString() %></li>
                <% } %>
            </ul>
        </td>
        <td class="col-total"><%= dh.getThanhTien() %></td> <%-- Sử dụng hàm định dạng --%>
        <td class="col-status"><strong><%= dh.getTrangThai() %></strong></td>

        <%-- Cột Hành động với các nút điều kiện --%>
        <td class="col-action">
            <% if (dh.getTrangThai().equals(DonHang.CHO_XU_LY)) { %>
            <%-- Đơn hàng đang chờ: Hiển thị nút Nhận và Hủy --%>
            <form action="xu_ly_don_hang.jsp" method="post" style="display: inline;">
                <input type="hidden" name="orderId" value="<%= dh.getId() %>">
                <input type="hidden" name="action" value="nhan_don">
                <button type="submit" class="action-button btn-accept">Nhận Đơn</button>
            </form>
            <form action="xu_ly_don_hang.jsp" method="post" style="display: inline;">
                <input type="hidden" name="orderId" value="<%= dh.getId() %>">
                <input type="hidden" name="action" value="huy_don_nv"> <%-- Action riêng cho nhân viên hủy --%>
                <button type="submit" class="action-button btn-cancel" onclick="return confirm('Bạn có chắc muốn hủy đơn hàng #<%= dh.getId() %> không?');">Hủy Đơn</button>
            </form>
            <% } else if (dh.getTrangThai().equals(DonHang.DANG_THUC_HIEN)) { %>
            <%-- Đơn hàng đang thực hiện: Hiển thị nút Hoàn thành và Hủy --%>
            <form action="xu_ly_don_hang.jsp" method="post" style="display: inline;">
                <input type="hidden" name="orderId" value="<%= dh.getId() %>">
                <input type="hidden" name="action" value="hoan_thanh">
                <button type="submit" class="action-button btn-complete">Hoàn Thành</button>
            </form>
            <form action="xu_ly_don_hang.jsp" method="post" style="display: inline;">
                <input type="hidden" name="orderId" value="<%= dh.getId() %>">
                <input type="hidden" name="action" value="huy_don_nv">
                <button type="submit" class="action-button btn-cancel" onclick="return confirm('Bạn có chắc muốn hủy đơn hàng #<%= dh.getId() %> đang thực hiện không?');">Hủy Đơn</button>
            </form>
            <% } else { %>
            <%-- Đơn hàng đã Hoàn thành hoặc Đã hủy: Không có hành động --%>
            <span>---</span>
            <% } %>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
<% } %>

</body>
</html>