package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DonHang {
    public DonHang() {
    }
    private int id;
    private LocalDateTime ngayTao;
    private String trangThai;
    private float thanhTien;
    public void xuLyDon() {
        Kho kho = new Kho();
        boolean ketQua = kho.kiemTraTonKho();
        ThongBao thongBao = new ThongBao();
        List<ChiTietDonHang> chiTietSP = new ArrayList<ChiTietDonHang>();
        if(ketQua == false) {
            capNhatTrangThaiDaHuy();
            thongBao.guiThongBao();
        } else {
            capNhatTrangThaiDangThucHien();
            for(ChiTietDonHang chiTiet : chiTietSP){
                chiTiet.khauTruKho();
            }
            thongBao.guiThongBao();
        }    
    }
    public void capNhatTrangThai() {
        // TODO implement here
    }
    public void danhGiaSanPham() {
        DanhGia danhGia = new DanhGia();
        ThongBao thongBao = new ThongBao();
 
        boolean ketQua = danhGia.kiemTraKetQua();
        if(ketQua == true) {
            luuDanhGiaVaoDonHang();
            thongBao.guiThongBao();
        } else {
            thongBao.guiThongBao();
        }
    }
    public void luuDanhGiaVaoDonHang() {
        // TODO implement here
    }
    public void capNhatTrangThaiDaHuy() {
        // TODO implement here
    }
    public void capNhatTrangThaiDangThucHien() {
        // TODO implement here
    }
}