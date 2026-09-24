package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gedascc
 */
public class ProdukMakeup extends Makeup {
    private String shade;

    public ProdukMakeup(String id, String nama, String merk, double harga, int stok, String shade) {
        super(id, nama, merk, harga, stok);
        this.shade = shade;
    }

    public String getShade() {
        return shade;
    }

    public void setShade(String shade) {
        this.shade = shade;
    }

    // Polymorphism: Method Overriding
    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("Kategori: Produk Makeup");
        System.out.println("Shade / Varian: " + shade);
    }
}
