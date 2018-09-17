package Dahinh;

import java.util.Scanner;

public class HinhHoc {


    void hienthidientich() {

        System.out.print("*Dien Tich la : ");
    }

    void hienthichuvi() {

        System.out.print("*Chu vi la : ");
    }

    float nhapdulieu() {

        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextFloat();
        } catch (Exception e) {
            System.out.println("Canh bao: Gia tri nhap vao phai la chu so");
            System.exit(0);
            return 0;
        }
    }
}
