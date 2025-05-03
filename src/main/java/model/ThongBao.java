package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ThongBao {
    private int id;
    private String nguoiNhan;
    private String noiDung;
    public ThongBao() {
    }
    public void guiThongBao() {
        System.out.println("Thông báo gửi đến " + nguoiNhan + ": " + noiDung);
    }
}