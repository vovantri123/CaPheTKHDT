package model;

import java.time.LocalDateTime;

public class DanhGia {
    private int soSao;
    private String binhLuan;
    private LocalDateTime ngayDanhGia;

    /**
     * Default constructor
     */
    public DanhGia() {
    }

    /**
     * Constructor with parameters
     */
    public DanhGia(int soSao, String binhLuan, LocalDateTime ngayDanhGia) {
        this.soSao = soSao;
        this.binhLuan = binhLuan;
        this.ngayDanhGia = ngayDanhGia;
    }

    // Getter and Setter methods
    public int getSoSao() {
        return soSao;
    }

    public void setSoSao(int soSao) {
        this.soSao = soSao;
    }

    public String getBinhLuan() {
        return binhLuan;
    }

    public void setBinhLuan(String binhLuan) {
        this.binhLuan = binhLuan;
    }

    public LocalDateTime getNgayDanhGia() {
        return ngayDanhGia;
    }

    public void setNgayDanhGia(LocalDateTime ngayDanhGia) {
        this.ngayDanhGia = ngayDanhGia;
    }

    /**
     * Kiểm tra kết quả đánh giá
     */
    public boolean kiemTraKetQua() {
        if (soSao < 1 || soSao > 5) {
            return false;  // Số sao không hợp lệ
        }
        if (binhLuan == null || binhLuan.isEmpty()) {
            return false;  // Bình luận không hợp lệ
        }
        return true;  // Kết quả hợp lệ
    }
}
