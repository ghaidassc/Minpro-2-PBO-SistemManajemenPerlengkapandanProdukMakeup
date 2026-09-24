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

## 5.2 Alur Tambah Barang  
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

**Bukti output proses tambah produk makeup**  
<img width="290" height="204" alt="image" src="https://github.com/user-attachments/assets/006320a3-27b8-460d-b06c-387eb97bc844" />     
Proses penambahan produk rias kosmetik (ProdukMakeup) hingga data berhasil disimpan.

**Bukti output proses tambah perlengkapan makeup**  
<img width="287" height="206" alt="image" src="https://github.com/user-attachments/assets/2eac8902-1570-4fcc-b8d7-57343007dcad" />    
Proses penambahan perlengkapan alat rias (PerlengkapanMakeup) hingga data berhasil disimpan.      

## 5.3 Tampilkan Semua Barang  
Fitur Tampilkan Semua Barang digunakan untuk mencetak seluruh barang inventaris yang tersimpan di dalam ArrayList<Makeup>.  
<img width="143" height="329" alt="image" src="https://github.com/user-attachments/assets/f442fd38-7ba0-44cc-9f0d-9037516dfe5a" />    
Tampilan inventaris pada fitur Tampilkan Semua Barang, termasuk data dummy yang tersedia sejak awal.  

Data dummy dimuat saat controller pertama kali diinisialisasi sehingga saat fitur ini dipilih pertama kali, data langsung tersaji rapi.  
```text
Pilih Menu Tampilkan Semua Barang
              ↓
Controller mengakses ArrayList
              ↓
View menerima koleksi ArrayList<Makeup>
              ↓
Perulangan membaca tiap objek
              ↓
Method polimorfik tampilkanData()
              ↓
Rincian barang tampil pada terminal
```
## 5.4 Alur Ubah Data Barang  
Fitur Ubah Data Barang digunakan untuk memperbarui rincian barang berdasarkan ID yang dimasukkan pengguna.  
<img width="185" height="200" alt="image" src="https://github.com/user-attachments/assets/c66135e8-45f5-4346-86a4-337e5177070b" />    
Proses pembaruan data barang berdasarkan ID dengan pemanggilan method overloading saat menampilkan data lama.  

```text   
Pilih Ubah Data Barang. 
                         │
                         ▼
        ┌► Input ID Barang yang Dicari ◄────────┐
        │                │                      │
        │                ▼                      │
        │      Cari Barang via ID               │
        │                │                      │
        │                ▼                      │
        │        Data ditemukan?                │
        │          ┌─────┴─────┐                │
        │        Tidak        Ya                │
        │          │           │                │
        │          ▼           ▼                │
        └── Data Tidak Ada   Tampilkan Detail   │
                             Data Saat Ini      │
                               │                │
                               ▼                │
                        Input Data Baru         │
                    (Kosongkan jika skip)       │
                               │                │
                               ▼                │
                         Update Nilai           │
                       via Method Setter        │
                               │                │
                               ▼                │
                    Pembaruan Data Berhasil     │
                               │                │
                               ▼                │
                        Kembali ke Menu ────────┘
```     
Pengguna dapat memilih atribut mana saja yang ingin diubah (nama, merk, harga, stok, atau atribut subclass). Masukan dapat dikosongkan jika pengguna tidak ingin mengubah nilai atribut tersebut.   

## 5.5 Alur Hapus Data Barang    
Fitur Hapus Data Barang digunakan untuk menghapus data inventaris dari ArrayList berdasarkan ID.  
<img width="205" height="68" alt="image" src="https://github.com/user-attachments/assets/b1136ce4-8902-45cc-b61b-a6e4b4048e63" />     
Proses penghapusan data barang berdasarkan ID dengan konfirmasi pengguna.    

Sebelum data dihapus, sistem menampilkan nama barang dan meminta konfirmasi persetujuan (y/n) agar barang tidak terhapus tanpa sengaja. 

```text   
Pilih Hapus Data Barang
                         │
                         ▼
        ┌► Input ID Barang yang Dicari
        │                │
        │                ▼
        │        Cari Barang via ID
        │                │
        │                ▼
        │        Data ditemukan?
        │          ┌─────┴─────┐
        │        Tidak        Ya
        │          │           │
        │          ▼           ▼
        └── Data Tidak Ada   Tampilkan Konfirmasi
                             Penghapusan Barang
                               │
                               ▼
                       Konfirmasi (y/n)?
                         ┌─────┴─────┐
                         │           │
                         ▼           ▼
                        'y'         'n'
                         │           │
                         ▼           ▼
                    Hapus dari     Batal
                    ArrayList        │
                         │           │
                         └─────┬─────┘
                               │
                               ▼
                        Kembali ke Menu
```

## 5.6 Alur Keluar Program  
Ketika pengguna memasukkan opsi 5 pada menu utama, sistem mengubah status perulangan menjadi false, menampilkan pesan penutup program, dan mengakhiri sesi terminal.       
<img width="200" height="34" alt="image" src="https://github.com/user-attachments/assets/57a4c0fd-0722-465d-a2a1-8f805dfd9230" />      
Tampilan saat program selesai dan keluar dari sistem.     

# 6. Penerapan Ketentuan OOP    
## 6.1 Access Modifier  
Access modifier digunakan untuk membatasi dan mengatur hak akses pada atribut maupun method di dalam class.     
Pada superclass Makeup, seluruh atribut inti menggunakan kata kunci private:   
<img width="157" height="71" alt="image" src="https://github.com/user-attachments/assets/622261fa-771c-4b41-ad70-816561279236" />        
Atribut private tersebut menjamin bahwa variabel tidak dapat diakses atau diubah secara langsung dari luar class. Akses data hanya dapat dilakukan melalui method resmi yang disediakan.  

## 6.2 Encapsulation   
Encapsulation diwujudkan dengan menyembunyikan variabel menggunakan modifier private dan membukanya secara aman lewat perantara method getter serta setter.     
<img width="218" height="157" alt="image" src="https://github.com/user-attachments/assets/2ce8706b-a239-448d-9fde-e1857f123e3b" />      
Penerapan encapsulation melalui method getter dan setter pada class Makeup.   

Atribut `id` dideklarasikan menggunakan kata kunci `final` dan hanya dilengkapi method getter `getId()`. Method `setId()` sengaja ditiadakan karena ID berperan sebagai nomor pengenal permanen yang tidak boleh dimodifikasi setelah barang dibuat. Hal ini sekaligus menyelesaikan catatan evaluasi mengenai peniadaan kode mubazir (*dead code*). Atribut lainnya (`nama`, `merk`, `harga`, `stok`, `shade`, dan `material`) memiliki pasangan *getter* dan *setter* yang aktif digunakan dalam operasi controller saat fitur ubah dan cetak data dijalankan. Dengan demikian, data tidak diberikan akses langsung dari luar class, melainkan melalui method yang disediakan secara terkontrol oleh class tersebut.             

## 6.3 Inheritance    
Inheritance digunakan dengan membuat class `Makeup` sebagai superclass yang memiliki atribut dan method umum untuk seluruh kategori barang rias.     


**1. Penerapan inheritance pada class ProdukMakeup**  
<img width="256" height="13" alt="image" src="https://github.com/user-attachments/assets/336f7251-f32a-4ae7-8c97-20e069ced08a" />         
Penerapan inheritance pada class `ProdukMakeup` melalui keyword `extends` dan penggunaan `super()` untuk memanggil constructor superclass `Makeup`.        


**2. Penerapan inheritance pada class PerlengkapanMakeup**     
<img width="295" height="12" alt="image" src="https://github.com/user-attachments/assets/7aacf6d7-73d9-417e-94eb-8d24adfdf8bf" />        
Penerapan inheritance pada class `PerlengkapanMakeup` sebagai subclass kedua dari superclass `Makeup`.    

Pada constructor subclass digunakan `super()` untuk menginisialisasi atribut dasar (`id`, `nama`, `merk`, `harga`, `stok`) yang berasal dari superclass `Makeup`.         


**3. Inisialisasi constructor superclass menggunakan super()**
<img width="638" height="58" alt="image" src="https://github.com/user-attachments/assets/7138617b-6731-4a5b-96a4-9fa074aad9bf" />         
Inisialisasi constructor superclass menggunakan `super()` pada subclass.    

Dengan inheritance, atribut dan perilaku umum tidak perlu ditulis berulang pada masing-masing subclass, sehingga struktur kode menjadi lebih modular dan efisien.    

# 7. Penerapan Nilai Tambah    
Nilai tambah yang diterapkan dalam program adalah:     

### 1. Struktur MVC

Program menggunakan konsep **Model-View-Controller (MVC)** untuk memisahkan tanggung jawab setiap bagian program (*separation of concerns*):
* **Model** (`Makeup`, `ProdukMakeup`, `PerlengkapanMakeup`) berisi representasi data, relasi pewarisan (inheritance), dan enkapsulasi entitas barang.   
* **View** (`MakeupView`) menangani tampilan antarmuka pada terminal konsol, mencetak menu, serta membaca input pengguna menggunakan `Scanner`.    
* **Controller** (`MakeupController`) menangani pengelolaan koleksi data dalam `ArrayList`, logika operasi CRUD, inisialisasi dummy data, serta validasi kesalahan input.     
* **Main** (`Main`) menjadi *entry point* yang menginisialisasi View dan Controller serta mengontrol perulangan menu utama program.

Pemisahan ini membuat kode lebih terstruktur, mudah dikembangkan, dan mencegah penumpukan logika di satu file.  
<img width="240" height="165" alt="image" src="https://github.com/user-attachments/assets/409a7491-88db-4645-a841-e5cc8313f5fa" />       
Struktur package program yang menunjukkan pemisahan class menjadi package `main`, `model`, `controller`, dan `view` sebagai penerapan arsitektur MVC.      

### 2. Polymorphism

**Polymorphism** diterapkan melalui dua teknik, yaitu **Method Overriding** dan **Method Overloading**, serta pemanfaatan koleksi polimorfik.

#### A. Method Overriding (Dynamic Polymorphism)

Superclass `Makeup` memiliki method dasar:   



