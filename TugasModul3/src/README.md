# Kalkulator Sederhana

Proyek ini adalah implementasi kalkulator sederhana menggunakan Java yang dapat melakukan operasi aritmatika dasar melalui antarmuka konsol (Command Line Interface).

## Deskripsi

Program kalkulator ini memungkinkan pengguna untuk:
- Melakukan operasi penjumlahan (+)
- Melakukan operasi pengurangan (-)
- Melakukan operasi perkalian (*)
- Melakukan operasi pembagian (/)

Program ini juga dilengkapi dengan penanganan error untuk:
- Pembagian dengan nol
- Input operator yang tidak valid

## Persyaratan Sistem

Untuk menjalankan program ini, Anda memerlukan:
- Java Development Kit (JDK) versi 8 atau lebih tinggi
- Java Runtime Environment (JRE)
- Command line terminal atau IDE Java

## Cara Menjalankan Program



### Menggunakan IDE

1. Buka IDE Java (seperti IntelliJ IDEA, Eclipse, atau NetBeans)
2. Import atau buat project baru
3. Jalankan program melalui IDE

## Cara Penggunaan

1. Saat program dijalankan, ikuti instruksi yang muncul di layar:
   ```
   Kalkulator Sederhana
   Masukkan angka pertama: [masukkan angka]
   Masukkan operasi (+, -, *, /): [masukkan operator]
   Masukkan angka kedua: [masukkan angka]
   ```
2. Program akan menampilkan hasil perhitungan
3. Jika terjadi error (pembagian dengan nol atau operator tidak valid), program akan menampilkan pesan error yang sesuai

## Struktur Program

Program terdiri dari beberapa method utama:
- `main()`: Method utama yang menjalankan program
- `inputAngka()`: Method untuk membaca input angka dari pengguna
- `inputOperator()`: Method untuk membaca input operator dari pengguna
- `hasilAKhir()`: Method untuk menampilkan hasil perhitungan
- `errorBagiNol()`: Method untuk menangani error pembagian dengan nol
- `exception()`: Method untuk menangani operator tidak valid



## Penanganan Masalah

Beberapa masalah umum yang mungkin terjadi:

1. Program tidak menerima input
    - Pastikan Anda memasukkan angka menggunakan format yang benar (gunakan titik untuk desimal)
    - Pastikan operator yang dimasukkan adalah salah satu dari: +, -, *, /


---
