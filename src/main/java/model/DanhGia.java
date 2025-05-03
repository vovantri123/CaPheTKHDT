package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DanhGia {
    private int soSao;
    private String binhLuan;
    private LocalDateTime ngayDanhGia;
    public DanhGia() {
    }
    public DanhGia(int soSao, String binhLuan, LocalDateTime ngayDanhGia) {
        this.soSao = soSao;
        this.binhLuan = binhLuan;
        this.ngayDanhGia = ngayDanhGia;
    }
    public boolean kiemTraDanhGia() {
        return soSao >= 1 && soSao <= 5 && binhLuan != null && !binhLuan.isEmpty();
    }
}
