package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChiTietDonHang {
    private int soLuong;
    private int sanPhamId;
    private float thanhTien;
    public ChiTietDonHang() {
    }
    public ChiTietDonHang(int sanPhamId, int soLuong, float thanhTien) {
        this.soLuong = soLuong;
        this.sanPhamId = sanPhamId;
        this.thanhTien = thanhTien;
    }
    public void khauTruKho() {
        System.out.println("Khấu trừ " + soLuong + " sản phẩm (ID: " + sanPhamId + ")");
    }

    @Override
    public String toString() {
        return "(ID: " + sanPhamId + ", số lượng: " + soLuong + ") - " + String.format("%.0f", thanhTien) + "đ";
    }
}