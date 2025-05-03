package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LoaiSanPham {
    private int id;
    private String ten;
    private static List<LoaiSanPham> danhSachLoaiSanPham = new ArrayList<>();
    public LoaiSanPham() {
    }
    public LoaiSanPham(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }
    public boolean kiemTraLoaiSanPham() {
        return true;
    }
    static {
        danhSachLoaiSanPham.add(new LoaiSanPham(1, "Coffee"));
        danhSachLoaiSanPham.add(new LoaiSanPham(2, "Nước ngọt"));
        danhSachLoaiSanPham.add(new LoaiSanPham(3, "Khác"));
    }

    public static List<LoaiSanPham> getDanhSachLoaiSanPham() {
        return danhSachLoaiSanPham;
    }

    public static void setDanhSachLoaiSanPham(List<LoaiSanPham> danhSachLoaiSanPham) {
        LoaiSanPham.danhSachLoaiSanPham = danhSachLoaiSanPham;
    }
}