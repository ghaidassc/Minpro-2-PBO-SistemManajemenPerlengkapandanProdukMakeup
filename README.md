Nama: Ghaida Suci Nahiza      
NIM: 2509116077     

# Sistem Manajemen Perlengkapan dan Produk Makeup💄💅🛍️

## 1. Deskripsi Singkat
Sistem Manajemen Perlengkapan dan Produk Makeup merupakan program berbasis konsol yang digunakan untuk mencatat dan mengelola data inventaris barang rias secara terstruktur. Program ini dapat menangani dua jenis barang utama, yaitu kosmetik (Produk Makeup) dan alat atau aplikator (Perlengkapan Makeup). Setiap data barang memiliki informasi berupa ID Barang, Nama Barang, Merk, Harga, dan Stok. Program dilengkapi dengan sistem penanganan input (defensive programming) untuk mencegah program terhenti tiba-tiba (crash) akibat kesalahan format masukan pengguna.  

Program membedakan barang inventaris menjadi dua jenis berdasarkan fungsinya: Produk Makeup yang menyimpan informasi khusus berupa varian atau shade warna riasan, serta Perlengkapan Makeup yang menyimpan informasi khusus berupa material atau bahan baku alat. Pengguna dapat menjalankan beberapa fitur utama melalui menu interaktif, yaitu Tambah Data Barang, Tampilkan Semua Barang, Ubah Data Barang, Hapus Data Barang, dan Keluar. Data selama program berjalan disimpan secara dinamis menggunakan ArrayList.  

## 2. Tujuan Program  
Program ini dibuat sebagai pemenuhan tugas Mini Project 2 pada mata kuliah Pemrograman Berorientasi Objek melalui penerapan arsitektur perangkat lunak dan konsep PBO murni.

Tujuan program adalah:  
* Mencatat data barang rias secara terorganisasi dan dinamis.
* Memisahkan data barang inventaris berdasarkan kategori kosmetik dan perlengkapan rias.
* Menampilkan daftar koleksi barang yang tersimpan beserta detail spesifikasinya.
* Memperbarui atribut nama, merk, harga, stok, maupun atribut kategori barang.
* Menghapus catatan inventaris barang berdasarkan ID dengan sistem konfirmasi persetujuan.  

## 3. Struktur Program  
Program terdiri dari beberapa class yang dikelompokkan ke dalam beberapa package berdasarkan tanggung jawab fungsionalnya.   

| Package | Class | Peran |
| --- | --- | --- |
| `main` | `Main` | Menjadi *entry point* program dan mengatur perulangan jalannya menu utama. |
| `controller` | `MakeupController` | Menghubungkan View dan Model, mengelola `ArrayList<Makeup>`, memproses logika CRUD, inisialisasi dummy data, serta menangani validasi masukan pengguna. |
| `model` | `Makeup` | Menjadi superclass yang menyimpan atribut umum barang serta menyediakan metode cetak dasar dan method overloading. |
| `model` | `ProdukMakeup` | Subclass dari `Makeup` untuk data barang jenis kosmetik dengan atribut khusus varian atau shade riasan. |
| `model` | `PerlengkapanMakeup` | Subclass dari `Makeup` untuk data barang jenis aplikator/alat rias dengan atribut khusus material bahan. |
| `view` | `MakeupView` | Mengatur tampilan terminal konsol, menampilkan format menu/pesan, serta menangani input teks pengguna lewat `Scanner`. |

### Struktur package

```text
src/
└── main/
    └── java/
        ├── main/
        │   └── Main.java
        │
        ├── controller/
        │   └── MakeupController.java
        │
        ├── model/
        │   ├── Makeup.java
        │   ├── ProdukMakeup.java
        │   └── PerlengkapanMakeup.java
        │
        └── view/
            └── MakeupView.java
```

## 4. Menu Program   
Menu utama yang tersedia pada sistem adalah:

```text
=============================================
 SISTEM MANAJEMEN PERLENGKAPAN & PRODUK MAKEUP
=============================================
1. Tambah Data Barang
2. Tampilkan Semua Barang
3. Ubah Data Barang
4. Hapus Data Barang
5. Keluar
Pilih menu (1-5):
```
### Rincian Fungsi Menu:

**1. Tambah Data Barang**  
   Digunakan untuk memasukkan data barang baru ke dalam inventaris. Pengguna memilih kategori terlebih dahulu (Produk Makeup atau Perlengkapan Makeup), kemudian mengisikan ID barang, nama, merk, harga, stok, serta data spesifik kategori (shade/varian untuk produk kosmetik, atau material bahan untuk perlengkapan alat). Seluruh input dilengkapi validasi dengan toleransi maksimal 3 kali kesalahan.

**2. Tampilkan Semua Barang**  
   Digunakan untuk menampilkan seluruh data barang yang tersimpan di dalam `ArrayList<Makeup>`. Fitur ini langsung memunculkan data bawaan (*dummy data*) sejak awal program dijalankan dan secara polimorfik mencetak detail barang sesuai kategorinya masing-masing.

**3. Ubah Data Barang**  
   Digunakan untuk memperbarui data barang berdasarkan ID yang dipilih. Pengguna dapat mengubah nama, merk, harga, stok, maupun atribut spesifik kategori barang (shade atau material). Pengguna juga dapat mengosongkan input jika tidak ingin mengubah atribut tertentu.

**4. Hapus Data Barang**  
   Digunakan untuk menghapus data barang dari inventaris berdasarkan ID barang yang dipilih. Sistem menampilkan detail barang terlebih dahulu dan meminta konfirmasi persetujuan `(y/n)` sebelum data benar-benar dihapus dari `ArrayList`.

**5. Keluar**  
   Digunakan untuk menghentikan jalannya perulangan menu utama dan menutup program dengan menampilkan pesan penutup.

# 5. Alur Program

## 5.1 Alur Sistem

Secara umum, sistem dimulai dengan menginisialisasi controller dan langsung memuat dua data bawaan (*dummy data*) ke dalam `ArrayList<Makeup>`. Pengguna memilih fitur yang tersedia melalui menu utama. Setiap fitur bekerja melalui menu utama dan setelah proses selesai pengguna akan kembali ke menu. Program akan berhenti saat pengguna memasukkan angka `5`.

```text
                          ┌──────────────┐
                          │    MULAI     │
                          └──────┬───────┘
                                 │
                                 ▼
                       Inisialisasi Controller
                                 │
                                 ▼
                       Muat Dummy Data Awal
                                 │
            ┌────────────────────┴────────────────────┐
            │                                         │
            ▼                                         │
┌────────────────────┐                                │
│   Tampilkan Menu   │◄───────────────────────────┐   │
└─────────┬──────────┘                            │   │
          │                                       │   │
          ▼                                       │   │
┌────────────────────┐                            │   │
│   Input Pilihan    │                            │   │
│       Menu         │                            │   │
└─────────┬──────────┘                            │   │
          │                                       │   │
          ▼                                       │   │
  ┌───────────────┐                               │   │
  │ Pilihan Menu? │                               │   │
  └───────┬───────┘                               │   │
          │                                       │   │
  ┌───────┼─────────────┬─────────────┬───────────┤   │
  │       │             │             │           │   │
  ▼       ▼             ▼             ▼           ▼   │
 [1]     [2]           [3]           [4]         [5]  │
Tambah  Lihat         Ubah          Hapus       Keluar│
  │       │             │             │           │   │
  ▼       ▼             ▼             ▼           ▼   │
Proses  Proses        Proses        Proses     Selesai│
  │       │             │             │               │
  └───────┴──────┬──────┴─────────────┘               │
                 │                                    │
                 ▼                                    │
          Kembali ke Menu ────────────────────────────┘
```

## 5.1 Alur Tambah Barang  
Fitur Tambah Data Barang digunakan untuk membuat entitas data barang baru, baik berupa produk kosmetik maupun perlengkapan alat.

Urutan prosesnya adalah:  
```text
Pilih Menu Tambah Data Barang
                       │
                       ▼
            Pilih Kategori Barang?
                 ┌─────┴─────┐
                 │           │
                 ▼           ▼
           Produk Makeup  Perlengkapan Makeup
                 │           │
                 └─────┬─────┘
                       │
                       ▼
              Input ID Barang
         (Cek Kosong & Cek Duplikat)
                       │
                       ▼
             Input Nama & Merk
                       │
                       ▼
           Input Harga (Harus > 0)
                       │
                       ▼
           Input Stok (Bulat & > 0)
                       │
                       ▼
           Kategori yang Dipilih?
                 ┌─────┴─────┐
                 │           │
                 ▼           ▼
           Produk Makeup  Perlengkapan Makeup
                 │           │
                 ▼           ▼
            Input Shade  Input Material
                 │           │
                 ▼           ▼
            Buat Object  Buat Object
           ProdukMakeup  PerlengkapanMakeup
                 │           │
                 └─────┬─────┘
                       │
                       ▼
              Simpan ke ArrayList
                       │
                       ▼
            Tampilkan Pesan Berhasil
                       │
                       ▼
                Kembali ke Menu
```

Setiap input teks dan angka memiliki validasi ketat dengan batas maksimal 3 kali percobaan salah:
* ID tidak boleh kosong dan tidak boleh sama dengan ID yang sudah ada di list.  
* Harga harus berupa bilangan desimal/angka riil lebih dari 0.
* Stok harus berupa bilangan bulat minimal 1.  

Pilihan kategori menentukan pembuatan objek subclass:
1. Produk Makeup menghasilkan objek ProdukMakeup dan meminta masukan data varian/shade.  
2. Perlengkapan Makeup menghasilkan objek PerlengkapanMakeup dan meminta masukan data material bahan.  
