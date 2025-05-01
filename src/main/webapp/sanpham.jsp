<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.SanPham" %>

<html>
<head>
    <title>Danh sách sản phẩm</title> 
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Merriweather:wght@400;700&family=Open+Sans:wght@300;400;600&display=swap">

    <style>
    body {
        font-family: 'Open Sans', sans-serif;
        margin: 0;
        padding: 0;
        background-color: #efebe9;
        color: #4e342e;
        line-height: 1.7;
    
    }

    .search-bar {
        margin: 20px auto;
        text-align: center;
        max-width: 600px;
        padding: 0 20px;
    }

    .search-bar form {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .search-bar input[type="text"] {
        padding: 8px 12px;
        width: 100%;
        max-width: 300px;
        font-size: 16px;
        border: 1px solid #a1887f;
        border-radius: 5px 0 0 5px;
        outline: none;
    }

    .search-bar button {
        padding: 8px 16px;
        font-size: 16px;
        cursor: pointer;
        background-color: #795548;
        color: white;
        border: 1px solid #795548;
        border-radius: 0 5px 5px 0;
        transition: background-color 0.3s, border-color 0.3s;
    }

    .search-bar button:hover {
        background-color: #6d4c41;
        border-color: #6d4c41;
    }

    .product-container {
        display: flex;
        flex-wrap: wrap; 
        justify-content: flex-start;
        padding: 20px;
        margin-left: 40px; 
    }

    .product-card {
        width: 200px;
        border: 1px solid #d7ccc8;
        border-radius: 10px;
        padding: 10px;
        margin: 10px;
        text-align: center;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        background-color: #ffffff;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        height: 290px;
        transition: transform 0.3s, box-shadow 0.3s;
    }

    .product-card:hover {
        transform: translateY(-5px);
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
    }

    .product-card img {
        max-width: 100%;
        height: 140px;
        object-fit: cover;
        border-radius: 8px;
        margin-bottom: 10px;
    }

    .product-card h3 {
        font-family: 'Merriweather', serif;
        font-size: 16px;
        margin: 0 0 5px;
        color: #3e2723;
        width: 100%;
        height: 2.2em;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
        line-height: 1.3;
        text-align: left;
        padding: 0 5px;
    }

    .product-card p {
        margin: 0 0 10px;
        font-size: 16px;
        color: #5d4037;
        flex-grow: 1;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .product-card p strong {
        font-weight: 700;
    }

     .product-card a {
        padding: 6px 6px;
        background-color: #6d4c41;
        color: white;
        text-decoration: none;
        border-radius: 10px;
        transition: background-color 0.3s, transform 0.2s, box-shadow 0.3s;
        font-weight: 600;
        font-size: 14px;
        cursor: pointer;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
    }

    .product-card a:hover {
        background-color: #5d4037;
        transform: translateY(-2px);
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
    }

    .product-card a:active {
        transform: translateY(0);
        box-shadow: 0 1px 3px rgba(0, 0, 0, 0.2);
    }
</style>
</head>
<body>

<jsp:include page="header.jsp"/>

<div class="search-bar">
    <form action="#" method="get">
        <input type="text" placeholder="Tìm kiếm sản phẩm..." name="search" />
        <button type="submit">Tìm kiếm</button>
    </form>
</div>

                <% String tuKhoa=request.getParameter("search"); List<SanPham> danhSachTimKiem =
                    SanPham.getDanhSachSanPham();
                    if (tuKhoa != null && !tuKhoa.isEmpty()) {
                    danhSachTimKiem = SanPham.timKiemSanPham(tuKhoa);
                    }
                    %>
                    <div class="product-container">
                        <% for (SanPham sp : danhSachTimKiem) { %>
                            <div class="product-card">
                                <img src="<%= sp.getHinhAnh() %>" alt="Đây là ảnh sản phẩm" />
                                <h3>
                                    <%= sp.getTen() %>
                                </h3>
                                <p><strong>
                                        <%= sp.getGia() %>
                                    </strong> đ</p>
                                <a href="chitietsanpham.jsp?id=<%= sp.getId() %>">Xem chi tiết</a>
                                <a href="sanpham_form.jsp?id=<%= sp.getId() %>" style="margin-top: 4px">Cập nhật</a>
                            </div>
                            <% } %>
                    </div>

</body>
</html>
