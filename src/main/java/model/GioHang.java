package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GioHang {
    /**
     * Default constructor
     */
	private StringBuilder html;
	
	private int id;
    private int soLuong;
	
	//  Tự thêm
	public static List<SanPham> danhSachSanPhamTrongGioHang = new ArrayList<>();; 

    public GioHang() {
    	html = new StringBuilder();	 
    } 
     
    
    public void hienThiTrangGioHang() {
    	html.setLength(0); // Xóa nội dung cũ trong htmlOutput trước khi tạo lại

        List<SanPham> danhSachSanPham = layDanhSachSanPhamTrongGioHang();

        String giaoDien = "";
        for (SanPham sanPham : danhSachSanPham) {
        	giaoDien += SanPham.layThongTinSanPham(sanPham); 
        }
        
        html.append(giaoDien);
    }


    public String themSanPhamVaoGioHang() {
    	SanPham sanPham = new SanPham();
		sanPham.laySanPhamDeThemVaoGioHang(id, soLuong);
		return "ThemSanPhamThanhCong";
    } 

    public void luuSanPhamVaoGioHang(SanPham sanPham, int soLuong) {
    	danhSachSanPhamTrongGioHang.addAll(Collections.nCopies(soLuong, sanPham)); 
    }   
        
    public List<SanPham> layDanhSachSanPhamTrongGioHang() { 
    	return danhSachSanPhamTrongGioHang; //
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


	public static List<SanPham> getDanhSachSanPhamTrongGio() {
		return danhSachSanPhamTrongGioHang;
	}

	public static void setDanhSachSanPhamTrongGio(List<SanPham> danhSachSanPhamTrongGio) {
		GioHang.danhSachSanPhamTrongGioHang = danhSachSanPhamTrongGio;
	}
	

	public StringBuilder getHtml() {
		return html;
	}


	public void setHtml(StringBuilder html) {
		this.html = html;
	}



	
    
}