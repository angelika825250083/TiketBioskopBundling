import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    // throws Exception dipakai karna baca/tulis file bisa error (misal file nggak ketemu), jadi nggak perlu try-catch
    public static void main(String[] args) throws Exception {

        // ==========================================
        // MEMBUAT INPUT
        // ==========================================

        // Scanner = alat buat baca ketikan dari keyboard. nextLine() baca satu baris penuh (boleh ada spasi), nextInt() baca angka
        Scanner input = new Scanner(System.in);


        // ==========================================
        // LOGIN KASIR
        // ==========================================

        System.out.println("========================================");
        System.out.println("             LOGIN KASIR");
        System.out.println("========================================");

        System.out.print("Username = ");
        // nyimpan username yang diketik kasir (String karna teks)
        String username = input.nextLine();

        System.out.print("Password = ");
        String password = input.nextLine();


        // buat object Kasir
        // bikin object Kasir dengan username "kasir" & password "123" (ini data login yang bener)
        Kasir kasir = new Kasir(
            "cika",
            "123"
        );


        // ngecek username dan password
        // nyocokin ketikan sama data kasir. equals() dipakai buat bandingin teks (String), bukan pakai ==
        if (username.equals(kasir.getUsername())
                && password.equals(kasir.getPassword())) {

            // SignIn() ini method dari interface Login yang isinya ditulis di class Kasir (nampilin "Login berhasil.")
            kasir.SignIn();

        } else {

            System.out.println("Username atau password salah.");

            input.close();
            // return di main = program berhenti (karna login gagal)
            return;
        }


        // ==========================================
        // MEMBUAT PENJUALAN
        // ==========================================

        System.out.print("ID Penjualan = ");
        String saleID = input.nextLine();

        System.out.print("Tanggal/Waktu = ");
        String tanggalWaktu = input.nextLine();


        // buat object Penjualan
        // bikin object Penjualan SEKALI di sini, terus dipakai terus selama program jalan. dikasih ID, tanggal/waktu, dan kasir yang login
        Penjualan penjualan = new Penjualan(
            saleID, tanggalWaktu, kasir);

            
        // pilihan bertipe int karna pilihan menu berupa angka
        int pilihan;


        // ==========================================
        // MENU UTAMA
        // ==========================================

        // do-while: menu kasir ditampilin terus sampai kasir pilih 4 (lihat "while (pilihan != 4)" di paling bawah)
        do {

            System.out.println();
            System.out.println("========================================");
            System.out.println("             MENU KASIR");
            System.out.println("========================================");
            System.out.println("1. Proses Penjualan");
            System.out.println("2. Cetak Struk");
            System.out.println("3. Simpan Penjualan");
            System.out.println("4. Keluar");
            System.out.println("========================================");

            System.out.print("Pilih = ");
            // nextInt() buat baca angka, hasilnya disimpan di variabel pilihan
            pilihan = input.nextInt();

            // nextLine() kosong ini buat "buang" Enter sisa dari nextInt(), biar nextLine() berikutnya nggak ke-skip. pola ini diulang tiap habis nextInt()
            input.nextLine();


            // ==========================================
            // PROSES PENJUALAN
            // ==========================================

            // menu 1: proses penjualan. data film, studio, dan kursi dibaca dari file .txt
            if (pilihan == 1) {

                System.out.println();
                System.out.println("========================================");
                System.out.println("          PROSES PENJUALAN");
                System.out.println("========================================");


                // ==========================================
                // MEMBACA FILM DARI film.txt
                // ==========================================

                // File = nunjuk ke file film.txt
                File fileFilm = new File("film.txt");

                // Scanner yang ini buat baca isi file (beda sama input yang baca keyboard)
                Scanner inputFilm =
                    new Scanner(fileFilm);

                // ArrayList buat nampung semua baris film dari file, ukurannya nambah otomatis
                ArrayList<String> listFilm =
                    new ArrayList<String>();

                // ngulang selama di file masih ada baris berikutnya (hasNextLine()), tiap baris dimasukin ke listFilm
                while (inputFilm.hasNextLine()) {

                    String dataFilm =
                        inputFilm.nextLine();

                    listFilm.add(dataFilm);
                }

                // file ditutup kalau udah selesai dibaca
                inputFilm.close();


                // nampilkan pilihan film
                System.out.println();
                System.out.println("PILIH FILM");

                // loop nampilin film bernomor. i mulai dari 0, jadi nomornya ditulis (i + 1) biar tampil mulai dari 1
                for (int i = 0; i < listFilm.size(); i++) {

                    System.out.println(
                        (i + 1) + ". " + listFilm.get(i)
                    );
                }

                System.out.print("Pilih = ");
                int pilihFilm = input.nextInt();

                input.nextLine();

                // nomor pilihan kasir dikurangi 1 karna index list mulai dari 0, hasilnya judul film yang dipilih
                String judulFilm =
                    listFilm.get(pilihFilm - 1);


                // ==========================================
                // MEMBACA STUDIO DARI studio.txt
                // ==========================================

                // studio dibaca dari studio.txt, caranya sama persis kayak film: dibaca ke list, ditampilin bernomor, terus dipilih
                File fileStudio =
                    new File("studio.txt");

                Scanner inputStudio =
                    new Scanner(fileStudio);

                ArrayList<String> listStudio =
                    new ArrayList<String>();

                while (inputStudio.hasNextLine()) {

                    String dataStudio =
                        inputStudio.nextLine();

                    listStudio.add(dataStudio);
                }

                inputStudio.close();


                // nampilkan pilihan studio
                System.out.println();
                System.out.println("PILIH STUDIO");

                for (int i = 0; i < listStudio.size(); i++) {

                    System.out.println(
                        (i + 1) + ". " +
                        listStudio.get(i)
                    );
                }

                System.out.print("Pilih = ");
                int pilihStudio = input.nextInt();

                input.nextLine();

                String studio =
                    listStudio.get(pilihStudio - 1);


                // ==========================================
                // JAM TAYANG
                // ==========================================

                System.out.print("Jam Tayang = ");
                String jamTayang = input.nextLine();


                // ==========================================
                // MEMBACA KURSI DARI kursi.txt
                // ==========================================

                // kursi dibaca dari kursi.txt
                File fileKursi =
                    new File("kursi.txt");

                Scanner inputKursi =
                    new Scanner(fileKursi);

                ArrayList<String> listKursi =
                    new ArrayList<String>();

                while (inputKursi.hasNextLine()) {

                    String dataKursi =
                        inputKursi.nextLine();

                    listKursi.add(dataKursi);
                }

                inputKursi.close();


                // nampilkan pilihan kursi
                System.out.println();
                System.out.println("PILIH KURSI");

                for (int i = 0; i < listKursi.size(); i++) {

                    System.out.print(
                        (i + 1) + ". " + listKursi.get(i) + "\t"
                    );

                    // Setiap 4 kursi pindah ke baris berikutnya
                    // % = sisa bagi. tiap kelipatan 4 pindah baris, jadi kursi tampil 4 per baris
                    if ((i + 1) % 4 == 0) {
                        System.out.println();
                    }
                }

                System.out.print("Pilih = ");
                int pilihKursi = input.nextInt();

                input.nextLine();

                String noKursi =
                    listKursi.get(pilihKursi - 1);


                // ==========================================
                // TANYA BUNDLING
                // ==========================================

                System.out.println();
                System.out.println("Tambah Bundling?");
                System.out.println("1. Ya");
                System.out.println("2. Tidak");

                System.out.print("Pilih = ");
                // 1 = pakai bundling, 2 = nggak
                int tambahBundling = input.nextInt();

                input.nextLine();


                // ==========================================
                // JIKA TIDAK PAKAI BUNDLING
                // ==========================================

                // kalau nggak pakai bundling, tiket dibeli satuan: bikin object Tiket terus dimasukin ke penjualan
                if (tambahBundling == 2) {

                    // bikin object Tiket: id "T01", nama "Tiket", harga 40000, sisanya dari pilihan kasir. 3 data pertama diteruskan ke Item lewat super()
                    Tiket tiket = new Tiket(
                        "T01", "Tiket", 40000, judulFilm, studio, jamTayang, noKursi);

                    // masukin tiket ke daftar item di penjualan (addItem nerima tipe Item, Tiket boleh karna anaknya Item)
                    penjualan.addItem(tiket);

                    System.out.println(
                        "Tiket berhasil ditambahkan.");
                }


                // ==========================================
                // JIKA PAKAI BUNDLING
                // ==========================================

                // kalau pakai bundling: tampil daftar paket, kasir milih salah satu
                else if (tambahBundling == 1) {

                    System.out.println();
                    System.out.println("========================================");
                    System.out.println("              BUNDLING");
                    System.out.println("========================================");

                    System.out.println(
                        "1. Paket Single       Rp100.000");

                    System.out.println(
                        "   1 Tiket + 1 Popcorn + " +
                        "1 Medium Soft Drink");

                    System.out.println();

                    System.out.println(
                        "2. Paket Couple       Rp200.000");

                    System.out.println(
                        "   2 Tiket + 1 Popcorn + " +
                        "2 Medium Soft Drink");

                    System.out.println();

                    System.out.println(
                        "3. Paket Makanan Berat Rp120.000");

                    System.out.println(
                        "   1 Tiket + 1 Hotdog/French Fries + " +
                        "1 Medium Milo Dinosaurs");

                    System.out.println();

                    System.out.println("4. Keluar");

                    System.out.println(
                        "========================================");

                    System.out.print("Pilih = ");
                    // 1 = Paket Single, 2 = Paket Couple, 3 = Paket Makanan Berat, 4 = Keluar (batal bundling)
                    int pilihBundling =
                        input.nextInt();

                    input.nextLine();


                    // ==========================================
                    // PAKET SINGLE
                    // ==========================================

                    // PAKET SINGLE: 1 tiket + popcorn + 1 minuman, harga paket Rp100.000
                    if (pilihBundling == 1) {

                        System.out.println();
                        System.out.println(
                            "PILIH MEDIUM SOFT DRINK" );

                        System.out.println(
                            "1. Coca-Cola" );

                        System.out.println(
                            "2. Sprite" );

                        System.out.println(
                            "3. Fanta" );

                        System.out.print("Pilih = ");
                        int pilihMinuman =
                            input.nextInt();

                        input.nextLine();


                        // penampung nama minuman, awalnya kosong, diisi sesuai pilihan di if-else bawahnya
                        String softDrink = "";


                        // if-else ini ngubah nomor pilihan jadi nama minumannya
                        if (pilihMinuman == 1) {
                            softDrink = "Coca-Cola";

                        } else if (pilihMinuman == 2) {
                            softDrink = "Sprite";

                        } else if (pilihMinuman == 3) {
                            softDrink = "Fanta";
                        }


                        // buat object Tiket
                        Tiket tiket = new Tiket(
                            "T01", "Tiket", 40000, judulFilm, studio, jamTayang, noKursi);


                        // buat object bundling
                        Bundling bundling =
                            new Bundling( "B01", "Paket Single", 100000, "Paket Single", 100000);


                        // nambahkan tiket ke bundling
                        // getDaftarItem() ngambil list isi paket, .add() nambahin tiket ke dalam paket
                        bundling.getDaftarItem().add(tiket);


                        // buat object untuk isi bundling
                        // popcorn & minuman juga dibuat pakai class Bundling (karna Bundling anak Item, jadi boleh masuk daftarItem)
                        // harganya cuma buat catatan isi paket, yang kehitung di total tetap harga paketnya
                        Bundling popcorn =
                            new Bundling("P02", "Popcorn", 50000, "Popcorn", 50000);


                        Bundling minuman =
                            new Bundling("D01", softDrink, 35000, "Medium " + softDrink, 35000);


                        // nambahkan isi bundling
                        bundling.getDaftarItem().add(
                            popcorn);

                        bundling.getDaftarItem().add(
                            minuman);


                        // nambahkan bundling ke penjualan
                        // satu paket (isinya udah lengkap) dimasukin ke penjualan sebagai satu item
                        penjualan.addItem(
                            bundling);


                        System.out.println(
                            "Paket Single berhasil ditambahkan.");
                    }


                    // ==========================================
                    // PAKET COUPLE
                    // ==========================================

                    // PAKET COUPLE: 2 tiket + popcorn + 2 minuman, harga paket Rp200.000. makanya nanya kursi kedua & 2 minuman
                    else if (pilihBundling == 2) {

                        System.out.println();
                        System.out.println(
                            "PILIH KURSI KEDUA");

                        for (int i = 0;
                             i < listKursi.size(); i++) {

                            System.out.println(
                                (i + 1) + ". " + listKursi.get(i) );
                        }

                        System.out.print("Pilih = ");
                        int pilihKursi2 =
                            input.nextInt();

                        input.nextLine();

                        String noKursi2 =
                            listKursi.get(pilihKursi2 - 1);


                        // Minuman pertama
                        System.out.println();
                        System.out.println(
                            "PILIH SOFT DRINK PERTAMA");

                        System.out.println(
                            "1. Coca-Cola");

                        System.out.println(
                            "2. Sprite");

                        System.out.println(
                            "3. Fanta");

                        System.out.print("Pilih = ");
                        int pilihMinuman1 =
                            input.nextInt();

                        input.nextLine();


                        String softDrink1 = "";


                        if (pilihMinuman1 == 1) {
                            softDrink1 = "Coca-Cola";

                        } else if (pilihMinuman1 == 2) {
                            softDrink1 = "Sprite";

                        } else if (pilihMinuman1 == 3) {
                            softDrink1 = "Fanta";
                        }


                        // Minuman kedua
                        System.out.println();
                        System.out.println(
                            "PILIH SOFT DRINK KEDUA");

                        System.out.println(
                            "1. Coca-Cola");

                        System.out.println(
                            "2. Sprite");

                        System.out.println(
                            "3. Fanta");

                        System.out.print("Pilih = ");
                        int pilihMinuman2 =
                            input.nextInt();

                        input.nextLine();


                        String softDrink2 = "";


                        if (pilihMinuman2 == 1) {
                            softDrink2 = "Coca-Cola";

                        } else if (pilihMinuman2 == 2) {
                            softDrink2 = "Sprite";

                        } else if (pilihMinuman2 == 3) {
                            softDrink2 = "Fanta";
                        }


                        // Tiket pertama
                        Tiket tiket1 =
                            new Tiket(
                                "T01", "Tiket", 40000, judulFilm, studio, jamTayang, noKursi);


                        // Tiket kedua
                        // tiket kedua buat pasangan, id "T02", kursinya noKursi2
                        Tiket tiket2 =
                            new Tiket(
                                "T02", "Tiket", 40000, judulFilm, studio, jamTayang, noKursi2);


                        // buat bundling Couple
                        Bundling bundling =
                            new Bundling(
                                "B02", "Paket Couple", 200000, "Paket Couple", 200000);


                        // nambahkan tiket
                        bundling.getDaftarItem().add(
                            tiket1);

                        bundling.getDaftarItem().add(
                            tiket2);


                        // Popcorn
                        Bundling popcorn =
                            new Bundling(
                                "P02", "Popcorn", 50000, "Popcorn", 50000);


                        // Minuman pertama
                        Bundling minuman1 =
                            new Bundling(
                                "D01", softDrink1, 35000, "Medium " + softDrink1, 35000);


                        // Minuman kedua
                        Bundling minuman2 =
                            new Bundling(
                                "D02", softDrink2, 35000, "Medium " + softDrink2, 35000);


                        bundling.getDaftarItem().add(
                            popcorn);

                        bundling.getDaftarItem().add(
                            minuman1);

                        bundling.getDaftarItem().add(
                            minuman2);


                        penjualan.addItem(
                            bundling);


                        System.out.println(
                            "Paket Couple berhasil ditambahkan.");
                    }


                    // ==========================================
                    // PAKET MAKANAN BERAT
                    // ==========================================

                    // PAKET MAKANAN BERAT: 1 tiket + makanan (Hotdog / French Fries) + Milo Dinosaurs, harga paket Rp120.000
                    else if (pilihBundling == 3) {

                        System.out.println();
                        System.out.println(
                            "PILIH MAKANAN");

                        System.out.println(
                            "1. Hotdog");

                        System.out.println(
                            "2. French Fries");

                        System.out.print("Pilih = ");
                        int pilihMakanan =
                            input.nextInt();

                        input.nextLine();


                        // penampung nama makanan, diisi sesuai pilihan di if-else bawahnya
                        String makanan = "";


                        if (pilihMakanan == 1) {

                            makanan = "Hotdog";

                        } else if (pilihMakanan == 2) {

                            makanan = "French Fries";
                        }


                        // Tiket
                        Tiket tiket =
                            new Tiket(
                                "T01", "Tiket", 40000, judulFilm, studio, jamTayang, noKursi);


                        // Bundling
                        Bundling bundling =
                            new Bundling(
                                "B03", "Paket Makanan Berat", 120000, "Paket Makanan Berat", 120000);


                        // Menambahkan tiket
                        bundling.getDaftarItem().add(
                            tiket);


                        // Menambahkan makanan
                        Bundling makananBerat =
                            new Bundling(
                                "M01", makanan, 55000, makanan, 55000);


                        // Menambahkan Milo
                        Bundling milo =
                            new Bundling(
                                "D03", "Milo Dinosaurs", 45000, "Medium Milo Dinosaurs", 45000);


                        bundling.getDaftarItem().add(
                            makananBerat);

                        bundling.getDaftarItem().add(
                            milo);


                        penjualan.addItem(
                            bundling);


                        System.out.println(
                            "Paket Makanan Berat berhasil ditambahkan.");
                    }


                    // ==========================================
                    // KELUAR DARI MENU BUNDLING
                    // ==========================================

                    // keluar dari menu bundling = batal bundling, tapi tiketnya tetap dibeli sebagai tiket biasa
                    else if (pilihBundling == 4) {

                        // Kalau keluar dari bundling,
                        // tiket tetap menjadi tiket biasa.
                        Tiket tiket =
                            new Tiket(
                                "T01", "Tiket", 40000, judulFilm, studio, jamTayang, noKursi);

                        penjualan.addItem(tiket);

                        System.out.println(
                            "Bundling dibatalkan.");

                        System.out.println(
                            "Tiket tetap ditambahkan.");
                    }
                }
            }


            // ==========================================
            // CETAK STRUK
            // ==========================================

            // menu 2: cetak struk. cetakStruk() itu method dari interface Cetak, isinya ditulis di class Penjualan
            else if (pilihan == 2) {

                penjualan.cetakStruk();
            }


            // ==========================================
            // SIMPAN PENJUALAN
            // ==========================================

            // menu 3: nyimpan penjualan ke file penjualan.txt (penyimpanan data pakai file)
            else if (pilihan == 3) {

                // Membuat file penjualan.txt
                // FileWriter = alat buat nulis ke file. kalau penjualan.txt belum ada dibuat, kalau udah ada isinya ditimpa
                FileWriter output =
                    new FileWriter(
                        "penjualan.txt");


                // output.write() = nulis teks ke file. "\n" artinya pindah baris
                output.write(
                    "========================================\n");

                output.write(
                    "              " +
                    // Nama_Bioskop itu konstanta dari interface Cetak, bisa dipanggil langsung lewat nama interface-nya
                    Cetak.Nama_Bioskop +
                    "\n");

                output.write(
                    "========================================\n");

                output.write(
                    "SALE ID   : " + penjualan.getSaleID() + "\n");

                output.write(
                    "DATE/TIME : " + penjualan.getTanggalWaktu() + "\n");

                output.write(
                    "KASIR     : " + penjualan.getKasir().getUsername() + "\n");

                output.write("\n");


                // Menulis semua item
                // ngulang semua item di penjualan buat ditulis ke file. polanya sama kayak di cetakStruk(): dicek tipenya pakai instanceof
                for (Item item :
                     penjualan.getListItem()) {

                    if (item instanceof Tiket) {

                        Tiket tiket =
                            (Tiket) item;

                        output.write(
                            "Film   : " + tiket.getJudulFilm() + "\n");

                        output.write(
                            "Studio : " + tiket.getStudio() + "\n");

                        output.write(
                            "Jam    : " + tiket.getJamTayang() + "\n");

                        output.write(
                            "Seat   : " + tiket.getNoKursi() + "\n");

                        output.write("\n");
                    }

                    else if (item instanceof Bundling) {

                        Bundling bundling =
                            (Bundling) item;

                        output.write(
                            bundling.getNamaBundling() + "\n");

                        output.write(
                            "Harga : Rp" + (int) bundling.hitungHarga() + "\n");

                        output.write(
                            "Isi Bundling:\n");


                        for (Item isi :
                             bundling.getDaftarItem()) {

                            if (isi instanceof Tiket) {

                                Tiket tiket =
                                    (Tiket) isi;

                                output.write(
                                    "Seat " + tiket.getNoKursi() + "\n");

                            } else if (
                                isi instanceof Bundling) {

                                Bundling isiBundling =
                                    (Bundling) isi;

                                output.write(
                                    isiBundling .getNamaBundling() + "\n");
                            }
                        }

                        output.write("\n");
                    }
                }


                output.write(
                    "TOTAL : Rp" + (int) penjualan.hitungTotal() + "\n");

                output.write(
                    "========================================\n");


                // Menutup file
                // file wajib ditutup biar isinya bener-bener kesimpen
                output.close();


                System.out.println();
                System.out.println(
                    "Penjualan berhasil disimpan.");
            }


            // ==========================================
            // KELUAR
            // ==========================================

            // menu 4: cuma nampilin pesan. program berhenti karna kondisi "while (pilihan != 4)" jadi salah
            else if (pilihan == 4) {

                System.out.println();
                System.out.println(
                    "Program selesai.");
            }


        } while (pilihan != 4);


        // Menutup input
        input.close();
    }
}