package Dahinh;

import java.util.Scanner;

public class HinhTron extends HinhHoc {
    final float Pi = 3.14f;
    float bankinh;

    public HinhTron(float bankinh) {
        this.bankinh = bankinh;

    }

    public float getBankinh() {
        return bankinh;
    }

    public void setBankinh(float bankinh) {
        this.bankinh = bankinh;
    }

    float dienTich(float bankinh) {
        super.hienthidientich();
        return Pi * bankinh * bankinh;
    }

    float chuvi(float bankinh) {
        super.hienthichuvi();
        return bankinh * 2 * Pi;
    }
}
