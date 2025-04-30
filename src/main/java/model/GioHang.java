package model;

import java.util.List;

public class GioHang {
    /**
     * Default constructor
     */
    public GioHang() {
    }
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
    public void luuSanPhamVaoGioHang() {
        // TODO implement here
    }
    public void hienThiTrangGioHang() {
        List<SanPham> danhSachSanPham = layDanhSachSanPhamTrongGioHang();
        for(SanPham sanPham : danhSachSanPham) {   
            sanPham.layThongTinSanPham();
        }
    } 
    public List<SanPham> layDanhSachSanPhamTrongGioHang() {
        // TODO implement here
        return null;
    }  
    public SanPham layThongTinSanPham() {
        // TODO implement here
        return null;
    }
}