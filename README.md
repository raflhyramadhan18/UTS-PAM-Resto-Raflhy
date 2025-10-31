# UTS-PAM-Resto-Raflhy
# Resto App (Aplikasi Pemesanan Makanan)

Sebuah aplikasi demo pemesanan makanan sederhana yang dibangun menggunakan Kotlin dan Android XML (Views). Aplikasi ini mencakup alur pengguna lengkap mulai dari otentikasi (login & register), melihat daftar menu, "memesan" (checkout flow), hingga sign out.

## 📸 Screenshot Aplikasi
1.HALAMAN UTAMA:
![7189b65b-a4e2-4a78-b88e-95c257b3ef58](https://github.com/user-attachments/assets/1e8f383d-e9aa-42f4-a6ee-0e96616bede6)

Disini adalah tampilan halaman utama saat kita pertama kali masuk ke dalam apliikasi resto pak kumis

2.Halaman Sign Up
![132e2f57-ce31-4013-9340-1c613d205e10](https://github.com/user-attachments/assets/8de7ee66-f144-42bd-8df7-afcd18dc7053)

Setelah kita klik mulai sekarang nanti akan diarahkan ketampilan sign up dimana kita bisa register dan juga login jika memang belum mempunyai akun

3.Halaman Register
![ddcfd675-583b-4530-bdf2-dcd813059919](https://github.com/user-attachments/assets/1243c1ca-6065-4f5a-90f4-610d924609fc)

Disini kita masukkan nama lengkap username dan juga password untuk nantinya kita bisa melakukan login

4.Halaman Login
![9dca7d67-564a-4348-b68f-c448f559a121](https://github.com/user-attachments/assets/c6ed030a-da6a-480b-ac2f-c79c75fdacd6)

Disini kita masukkan username dan juga password yang sebelumnya sudah kita buat di halaman register.

5.Halaman Home
![4d647c2c-16bb-42bf-b9e3-8eb1655801c7](https://github.com/user-attachments/assets/4e08c9b2-c996-4c11-b15a-98b565c14339)
![e2541dbd-b83c-42c5-a0ac-6ffb6404c9f5](https://github.com/user-attachments/assets/d58fb5de-982e-4994-9b10-ae39690f0474)

Disini adalah tampilan menu menu makanan yang tersedia sekitar 10 macam menu masakan di halama home ini

6.Halaman Order
![b207bcae-f434-43a9-ba7a-e4f39717718b](https://github.com/user-attachments/assets/ae52b137-769e-46bd-bc6a-f92febbfd1e0)

Nah setelah kita memilih salah satu makanan nanti kita akan langsung masuk ke halaman order

7.Halaman pengiriman
![6e182e83-91f5-469b-ae05-ac4f1337eecd](https://github.com/user-attachments/assets/55c7f752-8279-463d-b3a4-68d1d09708d7)

setelah kita klik pesan maka akan masuk ke halaman pengiriman ini dan diminta untuk mengisi data sesuai kebutuhan yang disediakan.

8.Halaman Pesanan Diterima
![ba0e983a-6342-4b71-8417-c9de1b20b8d1](https://github.com/user-attachments/assets/1b08449e-cb12-4a88-818f-daa1003e6e42)

Setelah kita klik order dan kirim maka akan masuk ke halaman ini pesanan diterima dan order berhasil terkirim.

9.Halaman Profile
![03d068bf-22a9-46f7-9889-5fd80582263f](https://github.com/user-attachments/assets/6a44ee77-f1cd-4a64-96e0-e4550c600c7e)

ini adalah halaman profile dan disini juga kita bisa untuk sign out dan kembali kehalaman login


Teknologi yang Digunakan
* **Bahasa:** Kotlin
* **Arsitektur UI:** Android Views (XML Layouts)
* **Komponen Utama:**
    * `AppCompatActivity`
    * `Fragment`
    * `ConstraintLayout` (untuk layout yang kompleks)
    * `RecyclerView` (untuk daftar menu)
    * `BottomNavigationView` (untuk navigasi utama)
    * `MaterialButton`
    * `TextInputLayout` & `TextInputEditText` (untuk formulir)
    * `MaterialCardView` (untuk item menu dan info profile)
    * `ImageView` & `TextView`
* **Navigasi:** `Intent` (untuk perpindahan antar Activity) dan `FragmentManager` (untuk perpindahan antar Fragment).
* **Grafis:** `Vector Assets` (untuk ikon) dan Animasi XML Bawaan (`res/anim`).

 Cara Menjalankan Proyek

1.  **Clone** repositori ini:
    ```bash
    git clone https://github.com/raflhyramadhan18/UTS-PAM-Resto-Raflhy
2.  Buka proyek di **Android Studio**.
3.  Pastikan Anda memiliki Android SDK (API 27 atau lebih baru) yang terinstal.
4.  **Sync** Gradle dependencies (jika diperlukan).
5.  Pastikan Anda sudah menambahkan semua ikon (`ic_...`) ke `res/drawable` dan gambar makanan ke `res/drawable` sesuai dengan yang direferensikan di `HomeFragment.kt`.
6.  **Build** dan **Run** proyek di emulator atau perangkat Android fisik.
