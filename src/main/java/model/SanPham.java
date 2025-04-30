package model;

import java.util.ArrayList;
import java.util.List;


public class SanPham {
    public SanPham() {
    }
    private int id;
    private String ten;
    private String moTa;
    private float gia;
    private String hinhAnh;
    public void capNhatSanPham() {
        LoaiSanPham loaiSanPham = new LoaiSanPham();
        boolean ketQua = loaiSanPham.kiemTraLoaiSanPham();
        if(ketQua == true) {
            luuThongTinSanPham();
        }
    }
    public void luuThongTinSanPham() {
        // TODO implement here
    }
    public void layThongTinSanPham() {
        // TODO implement here
    }
    public void themSanPham() {
        // TODO implement here
    }
    public void luuSanPham() {
        LoaiSanPham loaiSanPham = new LoaiSanPham();
        boolean ketQua = loaiSanPham.kiemTraLoaiSanPham();
        if(ketQua == true) {
            luuThongTinSanPham();
            Kho kho = new Kho();
            kho.capNhatKho(id, 1);
        }
    }    
    public void nhapTuKhoaTimKiem(String tuKhoa) {
        List<SanPham> danhSachSanPham = new ArrayList<SanPham>();
        String tenSanPham;
        for(SanPham sanPham : danhSachSanPham) {   
            tenSanPham = sanPham.layTenSanPham();
            if(tenSanPham == tuKhoa) {
                themDanhSachSanPham();
            }
        }  
    } 
    public String layTenSanPham() {
        // TODO implement here
        return "";
    }
    public void themDanhSachSanPham() {
        // TODO implement here
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
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	} 
    
    
}