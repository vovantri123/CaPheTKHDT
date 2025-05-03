package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Kho {
    private int id;
    private int soLuongTonKho;
    private static List<Kho> danhSachKho = new ArrayList<>();
    public Kho() {
    }
    public Kho(int id, int soLuongTonKho) {
        this.id = id;
        this.soLuongTonKho = soLuongTonKho;
    }
    public boolean kiemTraTonKho() {
        return true;
    }
    public void themKho(int id, int soLuong) {
        danhSachKho.add(new Kho(id, soLuong));
    }
    public static int timSoLuongTonKho(int id) {
        return danhSachKho.stream()
                .filter(kho -> kho.getId() == id)
                .map(Kho::getSoLuongTonKho)
                .findFirst()
                .orElse(0);
    }

    static {
        danhSachKho.add(new Kho(1, 100));
        danhSachKho.add(new Kho(2, 100));
        danhSachKho.add(new Kho(3, 100));
        danhSachKho.add(new Kho(4, 100));
        danhSachKho.add(new Kho(5, 100));
        danhSachKho.add(new Kho(6, 100));
        danhSachKho.add(new Kho(7, 100));
        danhSachKho.add(new Kho(8, 100));
        danhSachKho.add(new Kho(9, 100));
        danhSachKho.add(new Kho(10, 100));
        danhSachKho.add(new Kho(11, 100));
        danhSachKho.add(new Kho(12, 100));
        danhSachKho.add(new Kho(13, 100));
        danhSachKho.add(new Kho(14, 100));
        danhSachKho.add(new Kho(15, 100));
        danhSachKho.add(new Kho(16, 100));
        danhSachKho.add(new Kho(17, 100));
        danhSachKho.add(new Kho(18, 100));
    }

    public static List<Kho> getDanhSachKho() {
        return danhSachKho;
    }

    public static void setDanhSachKho(List<Kho> danhSachKho) {
        Kho.danhSachKho = danhSachKho;
    }
}