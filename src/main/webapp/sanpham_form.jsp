<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.SanPham" %>
<%@ page import="model.LoaiSanPham" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page import="model.Kho" %>
<%
    request.setCharacterEncoding("UTF-8");
    String method = request.getMethod();
    if ("POST".equalsIgnoreCase(method)) {
        String idStr = request.getParameter("id");
        String ten = request.getParameter("ten");
        String giaStr = request.getParameter("gia");
        String soLuongTonKho = request.getParameter("soLuongTonKho");
        String hinhAnh = request.getParameter("hinhAnh");
        String moTa = request.getParameter("moTa");

        double gia = giaStr != null && !giaStr.isEmpty() ? Double.parseDouble(giaStr) : 0;

        if (idStr == null || idStr.isEmpty()) {
            SanPham spMoi = new SanPham();
            spMoi.setGia(Float.valueOf(giaStr));
            spMoi.setTen(ten);
            spMoi.setHinhAnh(hinhAnh);
            spMoi.setMoTa(moTa);
            spMoi.themSanPham(Integer.valueOf(soLuongTonKho));
        } else {
            SanPham spCapNhat = new SanPham();
            spCapNhat.setId(Integer.parseInt(idStr));
            spCapNhat.setGia(Float.valueOf(giaStr));
            spCapNhat.setTen(ten);
            spCapNhat.setHinhAnh(hinhAnh);
            spCapNhat.setMoTa(moTa);
            spCapNhat.capNhatSanPham();
        }

        // Sau khi xử lý xong, chuyển hướng về trang danh sách
        response.sendRedirect("sanpham.jsp");
        return;
    }
%>

<%
    // --- Logic xác định chế độ Tạo mới hay Cập nhật ---
    String productIdParam = request.getParameter("id");
    SanPham sanPhamToEdit = null;
    boolean isUpdateMode = false;
    int productId = 0;

    if (productIdParam != null && !productIdParam.isEmpty()) {
        try {
            productId = Integer.parseInt(productIdParam);
            List<SanPham> danhSach = SanPham.getDanhSachSanPham();
            for (SanPham sp : danhSach) {
                if (sp.getId() == productId) {
                    sanPhamToEdit = sp;
                    break;
                }
            }
            if (sanPhamToEdit != null) {
                isUpdateMode = true;
            }
        } catch (NumberFormatException e) {
            // ID không hợp lệ, coi như tạo mới
            System.err.println("Invalid product ID format: " + productIdParam);
        }
    }

    // --- Đặt tiêu đề và nút bấm dựa trên chế độ ---
    String pageTitle = isUpdateMode ? "Cập Nhật Sản Phẩm" : "Thêm Sản Phẩm Mới";
    String buttonText = isUpdateMode ? "Lưu Thay Đổi" : "Thêm Sản Phẩm";
    List<LoaiSanPham> loaiSanPhamList = LoaiSanPham.getDanhSachLoaiSanPham();
    int loaiSanPhamId = 0;

    // --- Lấy giá trị cho form (từ sản phẩm cần sửa hoặc để trống) ---
    String tenValue = isUpdateMode ? sanPhamToEdit.getTen() : "";
    // Định dạng lại giá để hiển thị trong input number
    String giaValue = isUpdateMode ? String.format(Locale.US, "%.0f", sanPhamToEdit.getGia()) : "";
    String soLuongTonKho = isUpdateMode ? String.format(Locale.US, "%d", Kho.timSoLuongTonKho(sanPhamToEdit.getId())) : "0";
    String hinhAnhValue = isUpdateMode ? sanPhamToEdit.getHinhAnh() : "";
    String moTaValue = isUpdateMode ? sanPhamToEdit.getMoTa() : "";

    // Định dạng tiền tệ để hiển thị (nếu cần)
    // NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
%>
<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%= pageTitle %></title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Merriweather:wght@400;700&family=Open+Sans:wght@300;400;600&display=swap">
    <style>
        body {
            font-family: 'Open Sans', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #efebe9; /* Màu nền giống trang danh sách */
            color: #4e342e; /* Màu chữ giống trang danh sách */
            line-height: 1.6;
        }

        .form-container {
            max-width: 600px;
            margin: 40px auto;
            padding: 30px;
            background-color: #ffffff;
            border: 1px solid #d7ccc8;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
        }

        .form-container h2 {
            font-family: 'Merriweather', serif;
            color: #3e2723;
            text-align: center;
            margin-bottom: 25px;
            border-bottom: 2px solid #a1887f;
            padding-bottom: 10px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
            color: #5d4037;
        }

        .form-group input[type="text"],
        .form-group input[type="number"],
        .form-group input[type="url"],
        .form-group textarea {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #a1887f;
            border-radius: 5px;
            font-size: 16px;
            box-sizing: border-box; /* Đảm bảo padding không làm tăng kích thước tổng */
            background-color: #f5f5f5;
            transition: border-color 0.3s, box-shadow 0.3s;
        }
        .form-group input:focus,
        .form-group textarea:focus {
            border-color: #795548;
            box-shadow: 0 0 5px rgba(121, 85, 72, 0.3);
            outline: none;
            background-color: #fff;
        }

        .form-group textarea {
            min-height: 100px;
            resize: vertical; /* Cho phép thay đổi chiều cao */
        }

        .form-actions {
            text-align: center;
            margin-top: 30px;
        }

        .form-actions button {
            padding: 12px 25px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            background-color: #795548; /* Màu nút giống trang danh sách */
            color: white;
            border: none;
            border-radius: 5px;
            transition: background-color 0.3s, transform 0.2s;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
        }

        .form-actions button:hover {
            background-color: #6d4c41;
            transform: translateY(-2px);
        }
        .form-actions button:active {
            transform: translateY(0);
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.2);
        }

        .back-link {
            display: inline-block;
            margin-top: 20px;
            margin-left: 10px; /* Khoảng cách với nút */
            color: #6d4c41;
            text-decoration: none;
            font-weight: 600;
        }
        .back-link:hover {
            text-decoration: underline;
        }

    </style>
</head>
<body>

<%-- Có thể include header nếu bạn có file header.jsp --%>
<%-- <jsp:include page="header.jsp"/> --%>

<div class="form-container">
    <h2><%= pageTitle %></h2>

    <%-- Form sẽ gửi dữ liệu đến trang xu_ly_san_pham.jsp bằng phương thức POST --%>
    <%-- Bạn cần tạo trang xu_ly_san_pham.jsp để nhận và xử lý dữ liệu này --%>
    <form action="" method="post">

        <%-- Trường ẩn để lưu ID sản phẩm khi ở chế độ cập nhật --%>
        <% if (isUpdateMode) { %>
        <input type="hidden" name="id" value="<%= sanPhamToEdit.getId() %>">
        <% } %>

        <div class="form-group">
            <label for="tenSanPham">Tên Sản Phẩm:</label>
            <input type="text" id="tenSanPham" name="ten" value="<%= tenValue %>" required placeholder="Nhập tên sản phẩm">
        </div>
            <div class="form-group">
                <label for="loaiSanPham">Loại Sản Phẩm:</label>
                <select id="loaiSanPham" name="loaiSanPhamId" required>
                    <option value="">-- Chọn loại sản phẩm --</option>
                    <% for (LoaiSanPham lsp : loaiSanPhamList) { %>
                    <option value="<%= lsp.getId() %>" <%= (lsp.getId() == loaiSanPhamId) ? "selected" : "" %>><%= lsp.getTen() %></option>
                    <% } %>
                </select>
            </div>
        <div class="form-group">
            <label for="giaSanPham">Giá (VNĐ):</label>
            <%-- Sử dụng type="number" để dễ nhập số, step="1" cho số nguyên --%>
            <input type="number" id="giaSanPham" name="gia" value="<%= giaValue %>" required min="0" step="1" placeholder="Nhập giá sản phẩm">
        </div>
        <div class="form-group">
            <label for="soLuongTonKho">Số lượng tồn kho:</label>
            <input type="number" id="soLuongTonKho" name="soLuongTonKho"
                   value="<%= soLuongTonKho %>" required min="0" step="1"
                   placeholder="Nhập giá sản phẩm"
                <%= isUpdateMode ? "disabled" : "" %> >
        </div>
        <div class="form-group">
            <label for="hinhAnhSanPham">URL Hình Ảnh:</label>
            <%-- Sử dụng type="url" hoặc "text" --%>
            <input type="url" id="hinhAnhSanPham" name="hinhAnh" value="<%= hinhAnhValue %>" placeholder="http://example.com/image.jpg">
        </div>

        <div class="form-group">
            <label for="moTaSanPham">Mô Tả:</label>
            <textarea id="moTaSanPham" name="moTa" rows="4" placeholder="Nhập mô tả chi tiết cho sản phẩm"><%= moTaValue %></textarea>
        </div>

        <div class="form-actions">
            <button type="submit"><%= buttonText %></button>
            <a href="sanpham.jsp" class="back-link">Quay lại danh sách</a> <%-- Link quay lại trang danh sách --%>
        </div>
    </form>
</div>

</body>
</html>