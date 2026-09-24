package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gedascc
 */
public class Makeup {
    private final String id;
    private String nama;
    private String merk;
    private double harga;
    private int stok;

    public Makeup(String id, String nama, String merk, double harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.merk = merk;
        this.harga = harga;
        this.stok = stok;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void tampilkanData() {
        System.out.println("ID Barang: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Merk: " + merk);
        System.out.printf("Harga: Rp%,.2f\n", harga);
        System.out.println("Stok: " + stok + " pcs");
    }

    // Polymorphism: Method Overloading
    public void tampilkanData(String header) {
        System.out.println(header);
        tampilkanData();
    }
}
