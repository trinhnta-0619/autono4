package Dahinh;

import java.util.Scanner;

public class HinhChuNhat extends HinhHoc {

    float chieudai;
    float chieurong;

    public HinhChuNhat() {

    }

    public HinhChuNhat(float chieudai, float chieurong) {
        this.chieudai = chieudai;
        this.chieurong = chieurong;
    }

    public HinhChuNhat(float chieudai) {
        this.chieudai = chieudai;
    }

    public float getChieudai() {
        return chieudai;
    }

    public void setChieudai(int chieudai) {
        this.chieudai = chieudai;
    }

    public float getChieurong() {
        return chieurong;
    }

    public void setChieurong(int chieurong) {
        this.chieurong = chieurong;
    }

    float dienTich(float chieudai, float chieurong) {
        super.hienthidientich();
        return chieudai * chieurong;
    }

    float chuvi(float chieudai, float chieurong) {
        super.hienthichuvi();
        return (chieudai + chieurong) * 2;
    }
}
