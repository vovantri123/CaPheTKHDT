<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<nav>
    <div class="nav-container">
        <div class="site-title">
            <a href="index.jsp">Trang chủ</a>
        </div>
        <ul>
            <li><a href="sanpham.jsp">Sản phẩm</a></li>
            <li><a href="giohang.jsp">Giỏ hàng</a></li>
        </ul>
    </div>
</nav>

<style>
    nav {
        background-color: #5d4037;
        padding: 15px 20px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
        font-family: 'Open Sans', sans-serif;
    }

    .nav-container {
        max-width: 1200px;
        margin: 0 auto;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .site-title a {
        color: #ffffff;
        text-decoration: none;
        font-size: 24px;
        font-weight: 700;
        font-family: 'Merriweather', serif;
        letter-spacing: 1px;
        transition: color 0.3s ease;
    }

    .site-title a:hover {
        color: #a1887f;
    }

    nav ul {
        list-style-type: none;
        padding: 0;
        margin: 0;
        display: flex;
    }

    nav ul li {
        margin-left: 30px;
        margin-right: 0;
    }

    nav ul li:first-child {
         margin-left: 0;
    }

    nav ul li a {
        color: #ffffff;
        text-decoration: none;
        font-size: 18px;
        padding: 10px 15px;
        background-color: transparent;
        border-radius: 5px;
        transition: background-color 0.3s ease, color 0.3s ease;
        font-weight: 400;
    }

    nav ul li a:hover {
        background-color: #795548;
        color: #ffffff;
    }
</style>
