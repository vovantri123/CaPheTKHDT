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
    private LocalDateTime thoiGianGui;
    private String nguoiNhan;

    public void guiThongBao() { 
    	System.out.println("Đây là thông báo");
    }

    public void guiThongBaoKhongDuSanPham() { 
    	System.out.println("Sản phẩm không đủ");
    }
}