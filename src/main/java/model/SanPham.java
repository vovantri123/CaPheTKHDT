package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class SanPham {
	
	private static List<SanPham> danhSachSanPham = new ArrayList<>();
	 
    public SanPham() {
    }
    
    public SanPham(int id, String ten, String hinhAnh, float gia, String moTa) {
        this.id = id;
        this.ten = ten;
        this.hinhAnh = hinhAnh;
        this.gia = gia;
        this.moTa = moTa;
    }
    
    private int id;
    private String ten;
    private String moTa;
    private float gia;
    private String hinhAnh;
    public void capNhatSanPham() {
        Optional<SanPham> sanPhamCapNhat = danhSachSanPham.stream()
                .filter(sp -> sp.getId() == id)
                .findFirst();
        if (sanPhamCapNhat.isPresent()) {
            SanPham existingSanPham = sanPhamCapNhat.get();
            existingSanPham.setTen(ten);
            existingSanPham.setHinhAnh(hinhAnh);
            existingSanPham.setGia(gia);
            existingSanPham.setMoTa(moTa);
            System.out.println("Đã cập nhật SP ID " + id + ": " + existingSanPham);
        } else {
            System.out.println("Không tìm thấy SP với ID " + id + " để cập nhật.");
        }
//        LoaiSanPham loaiSanPham = new LoaiSanPham();
//        boolean ketQua = loaiSanPham.kiemTraLoaiSanPham();
//        if(ketQua == true) {
//            luuThongTinSanPham();
//        }
    }
    public void luuThongTinSanPham() {
        // TODO implement here
    }
    public void layThongTinSanPham() {
        // TODO implement here
    }
    public void themSanPham() {
        SanPham newSanPham = new SanPham(danhSachSanPham.get(danhSachSanPham.size() - 1).getId() + 1, ten, hinhAnh, gia, moTa);
        danhSachSanPham.add(newSanPham);
        System.out.println("Đã thêm SP: " + newSanPham);
    }
    public void luuSanPham() {
        LoaiSanPham loaiSanPham = new LoaiSanPham();
        boolean ketQua = loaiSanPham.kiemTraLoaiSanPham();
        if(ketQua == true) {
            luuThongTinSanPham();
            Kho kho = new Kho();
            kho.capNhatKho(id, 1);
        }
    }    
    public void nhapTuKhoaTimKiem(String tuKhoa) {
        List<SanPham> danhSachSanPham = new ArrayList<SanPham>();
        String tenSanPham;
        for(SanPham sanPham : danhSachSanPham) {   
            tenSanPham = sanPham.layTenSanPham();
            if(tenSanPham == tuKhoa) {
                themDanhSachSanPham();
            }
        }  
    } 

    public void themDanhSachSanPham() {
        // TODO implement here
    }
    
    public String layTenSanPham() { // Hàm này giống getter bên dưới
        return ten;
    }
    
    
//    
     
    public int getId() {
        return id;
    } 

    public void setId(int id) {
        this.id = id;
    } 
    
    public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
        this.ten = ten;
    }
    
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}

	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
	public static List<SanPham> getDanhSachSanPham() {
		return danhSachSanPham;
	}
	public static void setDanhSachSanPham(List<SanPham> danhSachSanPham) {
		SanPham.danhSachSanPham = danhSachSanPham;
	}
	public static List<SanPham> timKiemSanPham(String tuKhoa) {
	    List<SanPham> ketQuaTimKiem = new ArrayList<>();
	    for (SanPham sanPham : danhSachSanPham) {
	        if (sanPham.getTen().toLowerCase().contains(tuKhoa.toLowerCase())) {
	            ketQuaTimKiem.add(sanPham);
	        }
	    }
	    return ketQuaTimKiem;
	}
	
	static {
	    danhSachSanPham.add(new SanPham(1, "Cà phê Đắk Lắk", "https://upload.wikimedia.org/wikipedia/commons/4/45/A_small_cup_of_coffee.JPG", 59000f, "Hương vị mạnh mẽ, đậm đà từ vùng đất đỏ bazan Đắk Lắk, nơi nổi tiếng với những vườn cà phê xanh mướt. Sản phẩm mang đến một cảm giác tươi mới, đầy năng lượng, lý tưởng cho những ai yêu thích sự mạnh mẽ và sâu sắc trong mỗi tách cà phê."));
	    danhSachSanPham.add(new SanPham(2, "Cà phê sữa đá", "https://product.hstatic.net/200000399631/product/cafe_sua_da_538f1cb5c8ca482e940a03121ab0975c_master.jpg", 49000f, "Cà phê sữa đá truyền thống, đậm chất Sài Gòn, với sự kết hợp hoàn hảo giữa cà phê đen đậm và sữa đặc thơm ngọt. Một thức uống phổ biến, mang đến cảm giác mát lạnh, sảng khoái, nhất là trong những ngày hè oi ả."));
	    danhSachSanPham.add(new SanPham(3, "Cà phê Arabica", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpa_KOD9iykPxiBtAOdH5dtQ5q9OJnXOog2A&s", 72000f, "Cà phê hạt Arabica nhẹ nhàng, thơm nồng, với vị chua thanh và hậu vị ngọt ngào. Đây là lựa chọn tuyệt vời cho những ai yêu thích sự tinh tế và hương thơm tự nhiên của cà phê, thích hợp để thưởng thức vào buổi sáng hoặc trong các dịp thư giãn."));
	    danhSachSanPham.add(new SanPham(4, "Cà phê phin truyền thống", "https://vinbarista.com/uploads/news/cach-pha-ca-phe-phin-nho-va-lon-ngon-dam-da-202409201151.jpg", 55000f, "Thưởng thức hương vị Việt từ ly cà phê phin nhỏ giọt, một nét đặc trưng trong văn hóa cà phê Việt. Cà phê phin truyền thống mang lại sự hòa quyện tuyệt vời giữa vị đắng nhẹ và mùi thơm ngất ngây, làm say đắm lòng người thưởng thức."));
	    danhSachSanPham.add(new SanPham(5, "Cà phê Espresso", "https://www.shutterstock.com/image-vector/coming-soon-speechbubble-advertising-megaphone-600nw-2511768889.jpg", 65000f, "Cà phê Espresso đậm đặc, nguyên chất, mang đến hương vị mạnh mẽ, lý tưởng cho những ai yêu thích sự tinh khiết và mạnh mẽ trong mỗi tách cà phê."));
	    danhSachSanPham.add(new SanPham(6, "Cà phê Latte", "https://www.shutterstock.com/image-vector/coming-soon-speechbubble-advertising-megaphone-600nw-2511768889.jpg", 70000f, "Cà phê Latte kết hợp giữa cà phê Espresso và sữa nóng, tạo nên hương vị nhẹ nhàng, mượt mà, thích hợp cho những ai yêu thích sự mềm mại trong mỗi tách cà phê."));

	    danhSachSanPham.add(new SanPham(7, "Cà phê Mocha", "https://www.shutterstock.com/image-vector/coming-soon-speechbubble-advertising-megaphone-600nw-2511768889.jpg", 75000f, "Cà phê Mocha kết hợp giữa cà phê Espresso, sữa và sô cô la, mang đến hương vị ngọt ngào, lôi cuốn, lý tưởng cho những ai yêu thích sự kết hợp giữa cà phê và sô cô la."));
	    danhSachSanPham.add(new SanPham(8, "Cà phê Cappuccino", "https://www.shutterstock.com/image-vector/coming-soon-speechbubble-advertising-megaphone-600nw-2511768889.jpg", 70000f, "Cà phê Cappuccino với lớp bọt sữa mịn màng, kết hợp cùng cà phê Espresso, tạo nên hương vị cân bằng, thích hợp cho những ai yêu thích sự nhẹ nhàng và tinh tế."));
	    danhSachSanPham.add(new SanPham(9, "Cà phê Americano", "https://www.shutterstock.com/image-vector/coming-soon-speechbubble-advertising-megaphone-600nw-2511768889.jpg", 65000f, "Cà phê Americano được pha chế từ cà phê Espresso và nước nóng, mang đến hương vị đậm đà, phù hợp cho những ai yêu thích cà phê nguyên chất."));
	    danhSachSanPham.add(new SanPham(10, "Cà phê Cold Brew", "https://www.shutterstock.com/image-vector/coming-soon-speechbubble-advertising-megaphone-600nw-2511768889.jpg", 80000f, "Cà phê Cold Brew được chiết xuất từ cà phê xay nhuyễn ngâm trong nước lạnh trong 12-24 giờ, mang đến hương vị mượt mà, ít chua, thích hợp cho những ai yêu thích cà phê lạnh."));
	    danhSachSanPham.add(new SanPham(11, "Cà phê Dalgona", "https://www.shutterstock.com/image-vector/coming-soon-speechbubble-advertising-megaphone-600nw-2511768889.jpg", 75000f, "Cà phê Dalgona là món cà phê nổi tiếng Hàn Quốc với lớp kem sữa đánh bông trên nền cà phê đen, mang đến hương vị ngọt ngào, hấp dẫn."));
	    danhSachSanPham.add(new SanPham(12, "Cà phê Vietnam Egg Coffee", "https://www.shutterstock.com/image-vector/coming-soon-speechbubble-advertising-megaphone-600nw-2511768889.jpg", 85000f, "Cà phê Trứng Việt Nam với lớp kem trứng béo ngậy trên nền cà phê đen, mang đến hương vị độc đáo, hấp dẫn."));
	    danhSachSanPham.add(new SanPham(13, "Cà phê Irish Coffee", "https://www.shutterstock.com/image-vector/coming-soon-speechbubble-advertising-megaphone-600nw-2511768889.jpg", 90000f, "Cà phê Irish kết hợp giữa cà phê đen, rượu whiskey và kem tươi, mang đến hương vị mạnh mẽ, ấm áp, thích hợp cho những ai yêu thích sự kết hợp giữa cà phê và rượu."));
	    danhSachSanPham.add(new SanPham(14, "Cà phê Turkish Coffee", "https://www.shutterstock.com/image-vector/coming-soon-speechbubble-advertising-megaphone-600nw-2511768889.jpg", 95000f, "Cà phê Thổ Nhĩ Kỳ được pha chế từ cà phê xay mịn, nước và đường, nấu trong ấm nhỏ trên lửa nhỏ, mang đến hương vị đậm đà, đặc trưng."));
	    danhSachSanPham.add(new SanPham(15, "Cà phê Vietnamese Iced Coffee", "https://www.shutterstock.com/image-vector/coming-soon-speechbubble-advertising-megaphone-600nw-2511768889.jpg", 70000f, "Cà phê đá Việt Nam với cà phê đen pha phin, kết hợp cùng sữa đặc, mang đến hương vị ngọt ngào, đậm đà, thích hợp cho những ai yêu thích cà phê đá."));
	    danhSachSanPham.add(new SanPham(16, "Cà phê Nitro Cold Brew", "https://www.shutterstock.com/image-vector/coming-soon-speechbubble-advertising-megaphone-600nw-2511768889.jpg", 95000f, "Cà phê Nitro Cold Brew là cà phê lạnh được chiết xuất từ cà phê xay nhuyễn, kết hợp với khí nitơ tạo ra một lớp bọt mịn màng, mang đến hương vị mượt mà và tinh tế."));
	    danhSachSanPham.add(new SanPham(17, "Cà phê Macchiato", "https://www.shutterstock.com/image-vector/coming-soon-speechbubble-advertising-megaphone-600nw-2511768889.jpg", 65000f, "Cà phê Macchiato là sự kết hợp giữa cà phê Espresso đậm đặc và một lớp bọt sữa nhẹ, mang đến hương vị đậm đà nhưng không quá mạnh mẽ."));
	    danhSachSanPham.add(new SanPham(18, "Cà phê Flat White", "https://www.shutterstock.com/image-vector/coming-soon-speechbubble-advertising-megaphone-600nw-2511768889.jpg", 70000f, "Cà phê Flat White là sự kết hợp giữa cà phê Espresso và sữa hơi nở, mang đến một hương vị mượt mà, cân bằng giữa cà phê và sữa."));
	}
}