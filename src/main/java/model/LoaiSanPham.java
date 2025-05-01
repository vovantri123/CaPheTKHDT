package model;

import java.util.ArrayList;
import java.util.List;

public class LoaiSanPham {
    /**
     * Default constructor
     */
    private static List<LoaiSanPham> danhSachLoaiSanPham = new ArrayList<>();
    public LoaiSanPham() {
    }
    private int id;
    private String ten;

    public LoaiSanPham(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean kiemTraLoaiSanPham() {
        return true;
    }

    public static List<LoaiSanPham> getDanhSachLoaiSanPham() {
        return danhSachLoaiSanPham;
    }

    static {
        danhSachLoaiSanPham.add(new LoaiSanPham(1, "Coffee"));
        danhSachLoaiSanPham.add(new LoaiSanPham(2, "Nước ngọt"));
        danhSachLoaiSanPham.add(new LoaiSanPham(3, "Khác"));
    }
}