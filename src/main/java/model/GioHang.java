package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GioHang {
    /**
     * Default constructor
     */
	private StringBuilder htmlOutput;
	
	private int id;
    private int soLuong;
	
	//  Tự thêm
	private List<SanPham> danhSachSanPhamTrongGio; 

    public GioHang() {
    	htmlOutput = new StringBuilder();	
        this.danhSachSanPhamTrongGio = new ArrayList<>();
    } 
    
 // Getter lấy chuỗi HTML đã tạo
    public String getHtmlOutput() {
        return htmlOutput.toString();
    }
     
    public void hienThiTrangGioHang() {
        htmlOutput.setLength(0); // Xóa nội dung cũ trong htmlOutput trước khi tạo lại

        List<SanPham> danhSachSanPham = layDanhSachSanPhamTrongGioHang();

        if (!danhSachSanPham.isEmpty()) {
            for (SanPham sanPham : danhSachSanPham) {
                htmlOutput.append("<tr>");
                htmlOutput.append("<td><img src='" + sanPham.getHinhAnh() + "' alt='" + sanPham.getTen() + "' /></td>");
                htmlOutput.append("<td>" + sanPham.getTen() + "</td>");
                htmlOutput.append("<td>" + sanPham.getGia() + " VND</td>");
                htmlOutput.append("</tr>");
            }
        } else {
            htmlOutput.append("<tr class='empty-cart-row'><td colspan='3'>Giỏ hàng của bạn hiện tại chưa có sản phẩm nào.</td></tr>");
        }
    }

    

    public void themSanPhamVaoGioHang() {
        Kho kho = new Kho();
        ThongBao thongBao = new ThongBao();
        
        boolean ketQua = kho.kiemTraTonKho();
        
        if(ketQua == true) {
            luuSanPhamVaoGioHang();
            thongBao.guiThongBao();
        } else {
            thongBao.guiThongBaoKhongDuSanPham();
        }
    } 

    public void luuSanPhamVaoGioHang() {
        for (SanPham sp : SanPham.getDanhSachSanPham()) {
            if (sp.getId() == this.id) {
                for (int i = 0; i < this.soLuong; i++) {
                    danhSachSanPhamTrongGio.add(sp);
                } 
            }
        } 
    }  
    
    
    
    public List<SanPham> layDanhSachSanPhamTrongGioHang() { 
    	return danhSachSanPhamTrongGio; //
    }  
    
    public SanPham layThongTinSanPham() {
        // TODO implement here
        return null;
    }

//    Getter Setter

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getSoLuong() {
		return soLuong;
	}


	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}


	public List<SanPham> getDanhSachSanPhamTrongGio() {
		return danhSachSanPhamTrongGio;
	}


	public void setDanhSachSanPhamTrongGio(List<SanPham> danhSachSanPhamTrongGio) {
		this.danhSachSanPhamTrongGio = danhSachSanPhamTrongGio;
	}
    
    
}