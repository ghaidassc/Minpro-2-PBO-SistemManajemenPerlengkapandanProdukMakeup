package main;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import controller.MakeupController;
import view.MakeupView;

/**
 *
 * @author gedascc
 */
public class Main {
    public static void main(String[] args) {
        MakeupView view = new MakeupView();
        MakeupController controller = new MakeupController(view);
        boolean berjalan = true;

        while (berjalan) {
            view.tampilkanMenuUtama();
            String pilihan = view.inputString("");

            switch (pilihan) {
                case "1":
                    controller.tambahBarang();
                    break;
                case "2":
                    controller.tampilkanSemua();
                    break;
                case "3":
                    controller.ubahBarang();
                    break;
                case "4":
                    controller.hapusBarang();
                    break;
                case "5":
                    berjalan = false;
                    view.tampilkanPesan("\nTerima kasih telah menggunakan program ini:)");
                    break;
                default:
                    view.tampilkanPesan("Pilihan tidak valid, masukkan angka 1 sampai 5.");
            }
        }
    }
}
