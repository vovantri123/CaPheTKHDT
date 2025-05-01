<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.SanPham" %>
<%@ page import="model.GioHang" %>
<%@ page import="java.util.List" %>

<%
    int id = Integer.parseInt(request.getParameter("id"));

    SanPham sp = null;
    for (SanPham s : SanPham.getDanhSachSanPham()) {
        if (s.getId() == id) {
            sp = s;
            break;
        }
    }
%>

<%@ include file="header.jsp" %>

<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi tiết sản phẩm: <%= (sp != null ? sp.getTen() : "Không tìm thấy") %></title> 
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

        .product-detail-container {
            width: 90%;
            max-width: 900px;
            margin: 50px auto;
            padding: 40px;
            background-color: #ffffff;
            border-radius: 15px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.15);
            display: flex;
            flex-wrap: wrap;
            gap: 40px;
            align-items: flex-start;
        }

        .product-image {
             flex: 1 1 350px;
             text-align: center;
             min-width: 250px;
         }

        .product-image img {
            max-width: 100%;
            height: auto;
            max-height: 450px;
            border-radius: 10px;
            box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
        }

        .product-info {
            flex: 1 1 450px;
            display: flex;
            flex-direction: column;
            text-align: left;
        }

        .product-info h2 {
            font-family: 'Merriweather', serif;
            font-size: 36px;
            color: #3e2723;
            margin-top: 0;
            margin-bottom: 15px;
            padding-bottom: 10px;
            border-bottom: 2px solid #d7ccc8;
            display: inline-block;
            max-width: 100%;
             box-sizing: border-box;
             line-height: 1.2;
             word-break: break-word;
        }

        .product-info p.description {
            font-size: 18px;
            color: #6d4c41;
            margin-bottom: 20px;
            text-align: justify;
            line-height: 1.8;
             flex-grow: 1;
        }

        .product-info p.price {
            font-size: 26px;
            color: #5d4037;
            margin-bottom: 25px;
            font-weight: 700;
             text-align: left;
        }

        .add-to-cart-form {
            margin-top: 20px;
            padding-top: 20px;
            border-top: 1px solid #d7ccc8;
            display: flex;
            justify-content: flex-start;
            align-items: center;
            flex-wrap: wrap;
            gap: 15px;
        }

        .add-to-cart-form label {
             font-size: 18px;
             color: #4e342e;
             font-weight: 600;
         }

        .add-to-cart-form input[type="number"] {
            padding: 10px 12px;
            font-size: 18px;
            width: 70px;
            text-align: center;
            border: 1px solid #a1887f;
            border-radius: 8px;
            outline: none;
            -moz-appearance: textfield;
        }

        .add-to-cart-form input[type="number"]::-webkit-outer-spin-button,
         .add-to-cart-form input[type="number"]::-webkit-inner-spin-button {
             -webkit-appearance: none;
             margin: 0;
         }

        .add-to-cart-form button[type="submit"] {
            padding: 12px 30px;
            font-size: 18px;
            cursor: pointer;
            background-color: #6d4c41;
            color: white;
            border: none;
            border-radius: 30px;
            transition: background-color 0.3s ease, transform 0.2s ease, box-shadow 0.3s ease;
            font-weight: 600;
            box-shadow: 0 3px 6px rgba(0,0,0,0.2);
        }

        .add-to-cart-form button[type="submit"]:hover {
             background-color: #5d4037;
             transform: translateY(-2px);
             box-shadow: 0 5px 10px rgba(0,0,0,0.3);
        }

         .add-to-cart-form button[type="submit"]:active {
             transform: translateY(0);
             box-shadow: 0 2px 5px rgba(0,0,0,0.2);
         }

        .product-not-found {
            text-align: center;
            margin-top: 50px;
            font-size: 22px;
            color: #c62828;
            font-weight: 600;
        }

        @media (max-width: 768px) {
            .product-detail-container {
                flex-direction: column;
                align-items: center;
                gap: 20px;
                padding: 20px;
            }

            .product-image,
            .product-info {
                flex-basis: auto;
                width: 100%;
            }

             .product-info {
                 text-align: center;
             }

             .product-info h2,
             .product-info p.price {
                 text-align: center;
             }

             .add-to-cart-form {
                 justify-content: center;
             }
        }
    </style>
</head>
<body>

<% if (sp != null) { %>
        <div class="product-detail-container">
            <div class="product-image">
                <img src="<%= sp.getHinhAnh() %>" alt="Đây là ảnh sản phẩm" />
            </div>
            <div class="product-info">
                <h2><%= sp.getTen() %></h2>
                <p class="description"><%= sp.getMoTa() %></p>
                <p class="price"><strong><%= sp.getGia() %></strong> đ</p> 
                <form action="giohang.jsp" method="get" class="add-to-cart-form">
                    <input type="hidden" name="id" value="<%= sp.getId() %>" />
                    <label for="soLuong">Số lượng:</label>
                    <input type="number" id="soLuong" name="soLuong" value="1" min="1" />
                    <button type="submit">Thêm vào giỏ hàng</button>
                </form>
            </div>
        </div>
    <% } else { %>
        <p class="product-not-found">Sản phẩm không tồn tại hoặc đã bị xóa.</p>
    <% } %>

</body>
</html>
