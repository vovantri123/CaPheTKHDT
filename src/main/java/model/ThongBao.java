package model;

import java.time.LocalDateTime;

public class ThongBao {
    /**
     * Default constructor
     */
    public ThongBao() {
    }

    private int id;
    private String noiDung;
    public void guiThongBao() {
        System.out.println("Thông báo gửi đến " + nguoiNhan + ": " + noiDung);
    }
    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String nguoiNhan;



    public void guiThongBaoKhongDuSanPham() { 
    	System.out.println("Sản phẩm không đủ");
    }
}