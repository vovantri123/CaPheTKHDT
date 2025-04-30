package model;

import java.util.ArrayList;
import java.util.List;

public class GioHang {
    /**
     * Default constructor
     */
	
	//  Tự thêm
	private List<SanPham> danhSachSanPhamTrongGio;
	
	private SanPham sanPhamDangThem;

    public GioHang() {
        this.danhSachSanPhamTrongGio = new ArrayList<>();
    }
    
    // Getter và Setter cho sanPhamDangThem
    public SanPham getSanPhamDangThem() {
        return sanPhamDangThem;
    }

    public void setSanPhamDangThem(SanPham sanPhamDangThem) {
        this.sanPhamDangThem = sanPhamDangThem;
    }
     
    
    //  
    
    
    private int id;
    private int soLuong;

    public void themSanPhamVaoGioHang() {
        Kho kho = new Kho();
        boolean ketQua = kho.kiemTraTonKho();
        ThongBao thongBao = new ThongBao();
        if(ketQua == true) {
            luuSanPhamVaoGioHang();
            thongBao.guiThongBao();
        } else {
            thongBao.guiThongBaoKhongDuSanPham();
        }
    }
 
    public void luuSanPhamVaoGioHang() { // 
    	if (sanPhamDangThem != null) { //
            danhSachSanPhamTrongGio.add(sanPhamDangThem);
        }
    }
    public void hienThiTrangGioHang() {
        List<SanPham> danhSachSanPham = layDanhSachSanPhamTrongGioHang();
        for(SanPham sanPham : danhSachSanPham) {   
            sanPham.layThongTinSanPham();
        }
    } 
    public List<SanPham> layDanhSachSanPhamTrongGioHang() { 
    	return danhSachSanPhamTrongGio; //
    }  
    
    public SanPham layThongTinSanPham() {
        // TODO implement here
        return null;
    }
}