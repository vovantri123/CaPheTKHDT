package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DonHang {
    public DonHang() {
    }
    // --- Trạng thái đơn hàng ---
    public static final String CHO_XU_LY = "Chờ xử lý";
    public static final String DANG_THUC_HIEN = "Đang thực hiện";
    public static final String DA_HOAN_THANH = "Đã hoàn thành";
    public static final String DA_HUY = "Đã hủy";
    // --- Thuộc tính của đơn hàng ---
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

    public DonHang(String tenKhachHang, String sdtKhachHang, String diaChiGiaoHang,
                   String phuongThucThanhToan, List<ChiTietDonHang> chiTietItems) {
        this.id = idCounter++;
        this.ngayTao = LocalDateTime.now();
        this.trangThai = CHO_XU_LY;
        this.tenKhachHang = tenKhachHang;
        this.sdtKhachHang = sdtKhachHang;
        this.diaChiGiaoHang = diaChiGiaoHang;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.danhSachChiTietDonHang = chiTietItems;
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
    public static List<DonHang> getDanhSachDonHang(){ return danhSachDonHang; }
    public void luuDanhGiaVaoDonHang() {
        // TODO implement here
    }

    public int getId() { return id; } public void setId(int id) { this.id = id; }
    public LocalDateTime getNgayTao() { return ngayTao; } public void setNgayTao(LocalDateTime ngayTao) { this.ngayTao = ngayTao; }
    public String getTrangThai() { return trangThai; } public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
    public float getThanhTien() { return thanhTien; } public void setThanhTien(float thanhTien) { this.thanhTien = thanhTien; }
    public String getTenKhachHang() { return tenKhachHang; } public void setTenKhachHang(String tenKhachHang) { this.tenKhachHang = tenKhachHang; }
    public String getSdtKhachHang() { return sdtKhachHang; } public void setSdtKhachHang(String sdtKhachHang) { this.sdtKhachHang = sdtKhachHang; }
    public String getDiaChiGiaoHang() { return diaChiGiaoHang; } public void setDiaChiGiaoHang(String diaChiGiaoHang) { this.diaChiGiaoHang = diaChiGiaoHang; }
    public String getPhuongThucThanhToan() { return phuongThucThanhToan; } public void setPhuongThucThanhToan(String phuongThucThanhToan) { this.phuongThucThanhToan = phuongThucThanhToan; }
    public List<ChiTietDonHang> getChiTietDonHangList() { return danhSachChiTietDonHang; } public void setChiTietDonHangList(List<ChiTietDonHang> chiTietDonHangList) { this.danhSachChiTietDonHang = chiTietDonHangList; }

    static {
        List<SanPham> spList = SanPham.getDanhSachSanPham();
        SanPham sp1 = spList.get(0); // Tương ứng ID 1: Cà phê Đắk Lắk
        SanPham sp2 = spList.get(1); // Tương ứng ID 2: Cà phê sữa đá
        SanPham sp3 = spList.get(2); // Tương ứng ID 3: Cà phê Arabica
        SanPham sp4 = spList.get(3); // Tương ứng ID 4: Cà phê phin truyền thống
        List<ChiTietDonHang> ct1 = List.of(
                new ChiTietDonHang(sp1.getId(), 2, sp1.getGia() * 2),
                new ChiTietDonHang(sp2.getId(), 1, sp2.getGia())
        );

        List<ChiTietDonHang> ct2 = List.of(
                new ChiTietDonHang(sp3.getId(), 3, sp3.getGia() * 3)
        );

        List<ChiTietDonHang> ct3 = List.of(
                new ChiTietDonHang(sp4.getId(), 1, sp4.getGia())
        );

        List<ChiTietDonHang> ct4 = List.of(
                new ChiTietDonHang(sp1.getId(), 1, sp1.getGia()),
                new ChiTietDonHang(sp3.getId(), 1, sp3.getGia())
        );

        // Tạo các đơn hàng mẫu với chi tiết đã tạo
        DonHang dh1 = new DonHang("Nguyễn Văn A", "0901234567", "123 Đường ABC, Quận 1, TP.HCM", "COD", ct1);
        DonHang dh2 = new DonHang("Trần Thị B", "0918765432", "456 Đường XYZ, Quận 3, TP.HCM", "Chuyển khoản", ct2);
        DonHang dh3 = new DonHang("Lê Văn C", "0988888888", "789 Đường KLM, Quận 7, TP.HCM", "COD", ct3);
        DonHang dh4 = new DonHang("Phạm Thị D", "0912345678", "111 Đường DEF, Quận Bình Thạnh, TP.HCM", "COD", ct4);

        // Thêm vào danh sách tĩnh sử dụng phương thức addDonHang
        danhSachDonHang.add(dh1);
        danhSachDonHang.add(dh2);
        danhSachDonHang.add(dh3);
        danhSachDonHang.add(dh4);
    }
}