<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.GioHang" %>
<%@ page import="model.SanPham" %>
<%@ page import="java.util.*" %>

<%
    GioHang gioHang = (GioHang) session.getAttribute("gioHang");
    if (gioHang == null) {
        gioHang = new GioHang();
        session.setAttribute("gioHang", gioHang);
    }

    if (request.getParameter("id") != null && request.getParameter("soLuong") != null) {
        int id = Integer.parseInt(request.getParameter("id"));
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));

        gioHang.setId(id);
        gioHang.setSoLuong(soLuong);
        gioHang.themSanPhamVaoGioHang();
    }

    gioHang.hienThiTrangGioHang(); // tạo HTML từ sản phẩm trong giỏ
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giỏ hàng của bạn</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Merriweather:wght@400;700&family=Open+Sans:wght@300;400;600&display=swap">

    <style>
        /* Các style CSS cho trang giỏ hàng */
        body {
            font-family: 'Open Sans', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #efebe9;
            color: #4e342e;
            line-height: 1.7;
        }

        .container {
            width: 90%;
            max-width: 900px;
            margin: 50px auto;
            padding: 30px;
            background-color: #ffffff;
            border-radius: 15px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.15);
        }

        .container h2 {
            font-family: 'Merriweather', serif;
            font-size: 32px;
            color: #3e2723;
            margin-top: 0;
            margin-bottom: 30px;
            text-align: center;
            position: relative;
            padding-bottom: 15px;
        }

        .container h2::after {
            content: '';
            position: absolute;
            left: 50%;
            bottom: 0;
            transform: translateX(-50%);
            width: 80px;
            height: 3px;
            background-color: #795548;
            border-radius: 2px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            padding: 15px;
            border-bottom: 1px solid #eee;
            text-align: center;
        }

        th {
            background-color: #795548;
            color: white;
            font-weight: 600;
            font-size: 18px;
        }

        tbody tr:last-child td {
             border-bottom: none;
        }

        tbody tr:hover {
             background-color: #f5f5f5;
        }

        td img {
            width: 70px;
            height: auto;
            border-radius: 5px;
            vertical-align: middle;
        }

        td {
            font-size: 17px;
            color: #4e342e;
        }

        td strong {
            font-weight: 700;
            color: #5d4037;
        }

        .empty-cart-row td {
            text-align: center;
            font-size: 18px;
            color: #6d4c41;
            padding: 30px;
        }
    </style>
</head>
<body>

<jsp:include page="header.jsp"/>

<div class="container">
    <h2>Giỏ hàng của bạn</h2>
    <table>
        <thead>
            <tr>
                <th>Hình ảnh</th>
                <th>Tên sản phẩm</th>
                <th>Số lượng</th> 
            </tr>
        </thead>
        <tbody>
            <%= gioHang.getHtml() %>  <!-- Gọi hàm getHtmlOutput() để lấy HTML giỏ hàng -->
        </tbody>
    </table>
</div>

</body>
</html>
