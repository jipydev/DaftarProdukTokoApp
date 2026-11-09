# 🛒 Aplikasi Daftar Produk Toko (DaftarProdukTokoApp)

Aplikasi desktop berbasis **JavaFX** dan **Maven** untuk mengelola data inventaris produk toko sederhana. Proyek ini menerapkan arsitektur pemisahan antara tampilan antarmuka (**FXML**), logika pengendali (**Controller**), model objek (**Model**), dan penyimpanan data sementara di memori (**In-Memory Data**).

---

## 📌 Tentang Proyek Ini
**DaftarProdukTokoApp** dirancang untuk mempermudah pencatatan dan pencarian produk toko (seperti kategori Makanan dan Minuman). Aplikasi ini mendemonstrasikan konsep dasar Pemrograman Berorientasi Objek (OOP) dan pengembangan GUI modern menggunakan JavaFX:
* **Manajemen State & Navigasi Multi-Halaman:** Berpindah antar halaman (*Form*, *Daftar*, dan *Detail*) menggunakan kelas `Navigator` terpusat.
* **Validasi Input:** Memastikan data yang dimasukkan valid (tidak boleh ada kolom kosong dan harga harus berupa angka lebih dari 0) menggunakan dialog peringatan (`Alert`).
* **Pencarian Real-Time/Filter:** Memfilter daftar produk pada `TableView` berdasarkan kata kunci nama produk menggunakan `ObservableList`.
* **Passing Data Antar Controller:** Mengirim objek `Produk` yang dipilih dari tabel ke halaman detail.

---

## ✨ Fitur Utama
1. **Tambah Produk (`form.fxml`):**
   * Input Kode Produk, Nama Produk, Kategori (`ChoiceBox`: Makanan/Minuman), dan Harga.
   * Validasi input otomatis sebelum data disimpan.
2. **Daftar & Pencarian Produk (`daftar.fxml`):**
   * Menampilkan seluruh produk di dalam `TableView`.
   * Fitur pencarian produk berdasarkan nama.
3. **Detail Produk (`detail.fxml`):**
   * Menampilkan informasi lengkap dari item produk yang dipilih pada tabel dengan format mata uang Rupiah.

---

## 📂 Struktur Folder Proyek

```text
DaftarProdukTokoApp/
├── src/
│   └── main/
│       ├── java/
│       │   └── kelas/
│       │       ├── MainApp.java               # Entry point aplikasi JavaFX
│       │       ├── Navigator.java             # Pengatur perpindahan halaman (Scene) & CSS
│       │       ├── controller/
│       │       │   ├── FormController.java    # Controller halaman input produk
│       │       │   ├── DaftarController.java  # Controller halaman tabel & pencarian
│       │       │   └── DetailController.java  # Controller halaman detail produk
│       │       ├── data/
│       │       │   └── DataProduk.java        # Penyimpanan list produk (ArrayList statis)
│       │       └── model/
│       │           └── Produk.java            # Model/Blueprint objek Produk
│       └── resources/
│           └── kelas/
│               ├── form.fxml                  # UI halaman form input
│               ├── daftar.fxml                # UI halaman tabel daftar produk
│               ├── detail.fxml                # UI halaman detail produk
│               └── styles/
│                   └── app.css                # Styling tampilan aplikasi
└── pom.xml                                    # Konfigurasi Maven & dependensi JavaFX
