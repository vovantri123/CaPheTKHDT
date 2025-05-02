<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.DonHang" %>
<%@ page import="java.util.Optional" %>
<%@ page import="model.SanPham" %>

<%
    request.setCharacterEncoding("UTF-8");
    // 2. Lấy tham số
    String orderIdParam = request.getParameter("orderId");
    String action = request.getParameter("action");

    int orderId = Integer.parseInt(orderIdParam.trim());

    Optional<DonHang> donHangOpt = DonHang.getDanhSachDonHang().stream()
            .filter(sp -> sp.getId() == orderId)
            .findFirst();
    DonHang donHang = donHangOpt.get();

    if ("nhan_don".equals(action)) {
        DonHang dh = donHang.xuLyDon();
        System.out.println("Đơn hàng ID " + dh.getId() + " đã xử lý");
    }
    else if ("huy_don_nv".equals(action)) {
        donHang.capNhatTrangThaiDaHuy();
    }

    response.sendRedirect("xem_don_hang.jsp");
%>
