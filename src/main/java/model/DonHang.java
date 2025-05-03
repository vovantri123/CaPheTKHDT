package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class DonHang {
    private static List<DonHang> danhSachDonHang = new ArrayList<>();
    private static int idCounter = 0;
    private int id;
    private LocalDateTime ngayTao;
    private String trangThai;
    private float thanhTien;
    private String tenKhachHang;
    private String sdtKhachHang;
    private String diaChiGiaoHang;
    private String phuongThucThanhToan;
    private List<ChiTietDonHang> danhSachChiTietDonHang;

    public DonHang() {
    }
    public DonHang(String tenKhachHang, String sdtKhachHang, String diaChiGiaoHang,
                   String phuongThucThanhToan, List<ChiTietDonHang> danhSachChiTietDonHang) {
        this.id = idCounter++;
        this.ngayTao = LocalDateTime.now();
        this.trangThai = CHO_XU_LY;
        this.tenKhachHang = tenKhachHang;
        this.sdtKhachHang = sdtKhachHang;
        this.diaChiGiaoHang = diaChiGiaoHang;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.danhSachChiTietDonHang = danhSachChiTietDonHang;
    }

    public DonHang xuLyDon() {
        Kho kho = new Kho();
        boolean ketQua = kho.kiemTraTonKho();
        if (!ketQua) {
            capNhatTrangThaiDaHuy();
        } else {
            capNhatTrangThaiDaHoanThanh();
        }
        return this;
    }
    public void capNhatTrangThaiDaHuy() {
        setTrangThai(DA_HUY);

        ThongBao thongBao = new ThongBao();
        thongBao.setNguoiNhan("Khách hàng");
        thongBao.setNoiDung("Không đủ nguyên liệu. Đơn hàng đã hủy!");
        thongBao.guiThongBao();
    }
    public void capNhatTrangThaiDaHoanThanh() {
        setTrangThai(DA_HOAN_THANH);

        System.out.println("Thực hiện khấu trừ kho cho đơn hàng ID: " + this.id);
        for (ChiTietDonHang chiTiet : this.danhSachChiTietDonHang) {
            chiTiet.khauTruKho();
        }

        ThongBao thongBao = new ThongBao();
        thongBao.setNguoiNhan("Khách hàng");
        thongBao.setNoiDung("Đơn hàng #" + this.id + " của bạn đã thực hiện.");
        thongBao.guiThongBao();
    }

    public String danhGiaDonHang(int idDonHang, DanhGia danhGia) {
        ThongBao thongBao = new ThongBao();

        boolean ketQua = danhGia.kiemTraDanhGia();
        if(ketQua == true) {
            luuDanhGiaVaoDonHang();
            return danhGia.getSoSao() + " sao\nBinh luan: " + danhGia.getBinhLuan();
        }
        return "Don hang #" + idDonHang + " danh gia that bai";
    }

    public void luuDanhGiaVaoDonHang() {
        // Code lưu đánh giá ở đây
        ThongBao thongBao = new ThongBao();
        thongBao.setNguoiNhan("Khach hang");
        thongBao.setNoiDung("Don hang #" + this.id + " da duoc danh gia: ");
        thongBao.guiThongBao();
    }

    static {
        List<SanPham> spList = SanPham.getDanhSachSanPham();

        List<ChiTietDonHang> ct1 = List.of(
                new ChiTietDonHang(spList.get(0).getId(), 2, spList.get(0).getGia() * 2),
                new ChiTietDonHang(spList.get(1).getId(), 1, spList.get(1).getGia())
        );
        List<ChiTietDonHang> ct2 = List.of(
                new ChiTietDonHang(spList.get(2).getId(), 3, spList.get(2).getGia() * 3)
        );
        List<ChiTietDonHang> ct3 = List.of(
                new ChiTietDonHang(spList.get(3).getId(), 1, spList.get(3).getGia())
        );
        List<ChiTietDonHang> ct4 = List.of(
                new ChiTietDonHang(spList.get(0).getId(), 1, spList.get(0).getGia()),
                new ChiTietDonHang(spList.get(2).getId(), 1, spList.get(2).getGia())
        );
        Collections.addAll(danhSachDonHang,
                new DonHang("Nguyễn Văn A", "0901234567", "123 Đường ABC, Quận 1, TP.HCM", "COD", ct1),
                new DonHang("Trần Thị B", "0918765432", "456 Đường XYZ, Quận 3, TP.HCM", "Chuyển khoản", ct2),
                new DonHang("Lê Văn C", "0988888888", "789 Đường KLM, Quận 7, TP.HCM", "COD", ct3),
                new DonHang("Phạm Thị D", "0912345678", "111 Đường DEF, Quận Bình Thạnh, TP.HCM", "COD", ct4)
        );
    }

    public static final String CHO_XU_LY = "Chờ xử lý";
    public static final String DA_HOAN_THANH = "Đã hoàn thành";
    public static final String DA_HUY = "Đã hủy";


    public static List<DonHang> getDanhSachDonHang() {
        return danhSachDonHang;
    }

    public static void setDanhSachDonHang(List<DonHang> danhSachDonHang) {
        DonHang.danhSachDonHang = danhSachDonHang;
    }
}