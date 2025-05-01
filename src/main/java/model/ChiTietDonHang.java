package model;

public class ChiTietDonHang {
    /**
     * Default constructor
     */ 
    public ChiTietDonHang() {
    }
    private int soLuong;
    private int sanPhamId;
    private float thanhTien;

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public ChiTietDonHang(int sanPhamId, int soLuong, float thanhTien) {
        this.soLuong = soLuong;
        this.sanPhamId = sanPhamId;
        this.thanhTien = thanhTien;
    }

    public void khauTruKho() {
        System.out.println("Khấu trừ " + soLuong + " sản phẩm (ID: " + sanPhamId + ")");
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setSanPhamId(int sanPhamId) {
        this.sanPhamId = sanPhamId;
    }
    @Override
    public String toString() {
        return "(ID: " + sanPhamId + ", số lượng: " + soLuong + ") - " + String.format("%.0f", thanhTien) + "đ";
    }
}