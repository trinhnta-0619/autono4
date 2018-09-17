package Dahinh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float chieudai = 0;
        float chieurong = 0;
        float bankinh = 0;
        int k;
        String ktra = "";

        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);

        do {

            System.out.println("Bạn muốn tính diện tích, chu vi của hình nào?");
            System.out.println("(1) Hình Chữ Nhật    (2) Hình Vuông    (3) Hình Tròn");
            k = scan.nextInt();
            switch (k) {
                case 1:
                    call_hinhchunhat(chieudai, chieurong);
                    break;
                case 2:
                    call_hinhvuong(chieudai);
                    break;
                case 3:
                    call_hinhtron(bankinh);
                    break;

            }
            System.out.println("Bạn có muốn tiếp tục không? Yes(Y) or No(N)");
            ktra = scan1.nextLine();
        }
        while (ktra.equals("Y") || (ktra.equals("y")) || (ktra.equals("Yes")) || (ktra.equals("yes")) || (ktra.equals("YES")));
    }

    public static void call_hinhchunhat(float chieudai, float chieurong) {

        HinhChuNhat hcn = new HinhChuNhat(chieudai, chieurong);
        System.out.print("*Nhập chiều dài: ");
        chieudai = hcn.nhapdulieu();
        System.out.print("*Nhập chiều rộng: ");
        chieurong = hcn.nhapdulieu();
        System.out.format("%.2f%n", hcn.dienTich(chieudai, chieurong));
        System.out.format("%.2f%n", hcn.chuvi(chieudai, chieurong));

    }


    public static void call_hinhvuong(float chieudai) {

        HinhVuong hv = new HinhVuong(chieudai, chieudai);
        System.out.print("*Nhập chiều dài: ");
        chieudai = hv.nhapdulieu();
        System.out.format("%.2f%n", hv.dienTich(chieudai, chieudai));
        System.out.format("%.2f%n", hv.chuvi(chieudai, chieudai));

    }

    public static void call_hinhtron(float bankinh) {

        HinhTron ht = new HinhTron(bankinh);
        System.out.print("*Nhập bán kính: ");
        bankinh = ht.nhapdulieu();
        System.out.format("%.2f%n", ht.dienTich(bankinh));
        System.out.format("%.2f%n", ht.chuvi(bankinh));

    }

}
