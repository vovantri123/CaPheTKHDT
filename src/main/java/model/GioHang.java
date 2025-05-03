package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class GioHang {
	private int id;
    private int soLuong;

	private StringBuilder html;
	public static List<SanPham> danhSachSanPhamTrongGioHang = new ArrayList<>();
    public GioHang() {
    	html = new StringBuilder();	 
    }
    public void hienThiTrangGioHang() {
    	html.setLength(0);
        List<SanPham> danhSachSanPham = layDanhSachSanPhamTrongGioHang();
        String giaoDien = "";
        for (SanPham sanPham : danhSachSanPham) {
        	giaoDien += SanPham.layThongTinSanPham(sanPham); 
        }
        html.append(giaoDien);
    }
    public String themSanPhamVaoGioHang() {
    	SanPham sanPham = new SanPham();
		sanPham.laySanPhamDeThemVaoGioHang(id, soLuong);
		return "ThemSanPhamThanhCong";
    }
    public void luuSanPhamVaoGioHang(SanPham sanPham, int soLuong) {
    	danhSachSanPhamTrongGioHang.addAll(Collections.nCopies(soLuong, sanPham)); 
    }
    public List<SanPham> layDanhSachSanPhamTrongGioHang() {
    	return danhSachSanPhamTrongGioHang; //
    }
}