import java.util.ArrayList;

// Penjualan mengimplementasikan interface Cetak
// Penjualan = class buat nyimpan satu transaksi
// class penjualan mengimplementasikan interface cetak, sehingga harus menyediakan method cetakStruk()
public class Penjualan implements Cetak {

    // Atribut Penjualan
    // saleID & tanggalWaktu pakai String karna isinya teks
    private String saleID;
    private String tanggalWaktu;

    // nyimpan semua item dalam penjualan
    // ArrayList = daftar yang ukurannya bisa nambah terus
    // tipe isinya Item (class parent), jadi bisa nampung Tiket dan Bundling sekaligus karna dua-duanya child Item
    private ArrayList<Item> listItem;

    // nyimpan kasir yang melakukan penjualan
    // tipenya class Kasir, jadi yang disimpan satu object Kasir (kasir yang lagi login)
    private Kasir kasir;

    // Constructor dengan parameter
    // constructor ini dipanggil di main kode sekali, setelah login. ngisi ID penjualan, tanggal/waktu, dan kasir
    public Penjualan(String saleID,
                     String tanggalWaktu,
                     Kasir kasir) {

        this.saleID = saleID;
        this.tanggalWaktu = tanggalWaktu;
        this.kasir = kasir;

        // buat ArrayList
        // list-nya dibuat dulu pakai new biar siap dipakai (kalau nggak dibuat bakal error pas dipakai)
        listItem = new ArrayList<Item>();
    }

    // Constructor kosong
    // constructor kosong, list tetap dibuat biar nggak error kalau langsung dipakai
    public Penjualan() {
        listItem = new ArrayList<Item>();
    }

    // Setter saleID
    // setter dipakai untuk ngisi/ngubah nilai atribut. pakai void karna cuma ngisi nilai, bukan ngembaliin nilai
    public void setSaleID(String saleID) {
        this.saleID = saleID;
    }

    // Setter tanggal dan waktu
    public void setTanggalWaktu(String tanggalWaktu) {
        this.tanggalWaktu = tanggalWaktu;
    }

    // Setter kasir
    public void setKasir(Kasir kasir) {
        this.kasir = kasir;
    }

    // Getter saleID
    // getter dipakai untuk ngambil nilai atribut. return-nya String karna atribut saleID bertipe String (tipe return ngikutin tipe atributnya)
    public String getSaleID() {
        return saleID;
    }

    // Getter tanggal dan waktu
    public String getTanggalWaktu() {
        return tanggalWaktu;
    }

    // Getter kasir
    public Kasir getKasir() {
        return kasir;
    }

    // Getter list item
    // return-nya ArrayList<Item> karna atribut listItem bertipe ArrayList<Item> (tipe return ngikutin atribut)
    public ArrayList<Item> getListItem() {
        return listItem;
    }

    // nambahkan item ke dalam penjualan
    // parameternya bertipe Item, jadi boleh dikasih object Tiket maupun Bundling (karna dua-duanya childnya Item)
    // dipanggil di main kode tiap kasir selesai milih tiket atau paket bundling
    public void addItem(Item item) {
        listItem.add(item);
    }

    // hitung total harga semua item
    // ngitung total harga semua item di penjualan. return-nya double karna hasilnya angka
    public double hitungTotal() {

        // variabel penampung total, awalnya 0
        double total = 0;

        // ngambil setiap item dari listItem
        // for-each = ngulang semua isi listItem, satu-satu ditaruh di variabel item
        for (Item item : listItem) {

            // pakai method hitungHarga()
            // item.hitungHarga() otomatis ngikutin tipe aslinya (polymorphism): kalau Tiket jadi harga tiket, kalau Bundling jadi harga paketnya
            // jadi di sini nggak perlu ngecek satu-satu tipenya
            total = total + item.hitungHarga();
        }

        // return = ngembaliin hasil total ke yang manggil method ini
        return total;
    }

    // Method dari interface Cetak
    // ini isi method dari interface Cetak
    // urutan struk: (1) header, (2) info penjualan, (3) daftar tiket / bundling, (4) total
    public void cetakStruk() {

        System.out.println();
        System.out.println("========================================");
        // Nama_Bioskop diambil dari interface Cetak. bisa langsung dipakai karna Penjualan implements Cetak
        System.out.println("              " + Nama_Bioskop);
        System.out.println("========================================");

        System.out.println();
        System.out.println("SALE ID    : " + saleID);
        System.out.println("DATE/TIME  : " + tanggalWaktu);
        System.out.println("KASIR      : " + kasir.getUsername());

        System.out.println();
        System.out.println("TICKET");
        System.out.println("----------------------------------------");

        // nampilkan item yang ada di penjualan
        for (Item item : listItem) {

            // ngecek apakah item merupakan Tiket
            // instanceof = ngecek "object ini sebenarnya Tiket atau bukan?"
            // perlu dicek karna listItem isinya campur (Tiket dan Bundling)
            if (item instanceof Tiket) {

                // casting: item bertipe Item, diubah jadi Tiket biar bisa pakai method khusus Tiket (getJudulFilm dll) yang nggak ada di Item
                Tiket tiket = (Tiket) item;

                System.out.println(tiket.getJudulFilm());
                System.out.println("Studio " + tiket.getStudio());
                System.out.println("Jam " + tiket.getJamTayang());
                System.out.println("Seat " + tiket.getNoKursi());

                System.out.println();
            }

            // ngecek apakah item merupakan Bundling
            // kalau bukan Tiket, dicek lagi apakah dia Bundling
            else if (item instanceof Bundling) {

                // casting jadi Bundling biar bisa pakai method khusus Bundling (getNamaBundling, getDaftarItem)
                Bundling bundling = (Bundling) item;

                System.out.println(
                    bundling.getNamaBundling() );

                System.out.println(
                    "Rp" + (int) bundling.hitungHarga() );

                System.out.println();
                System.out.println("Isi Bundling:");

                // nampilkan item di dalam bundling
                // ngulang semua isi di dalam paket bundling (daftarItem) buat ditampilin
                for (Item isi : bundling.getDaftarItem()) {

                    // isi paket dicek tipenya juga, karna isinya bisa Tiket atau Bundling (popcorn & minuman dibuat pakai class Bundling di main kode)
                    if (isi instanceof Tiket) {

                        Tiket tiket = (Tiket) isi;

                        System.out.println(
                            "Seat " + tiket.getNoKursi() );

                    } else if (isi instanceof Bundling) {

                        Bundling isiBundling =
                            (Bundling) isi;

                        System.out.println(
                            isiBundling.getNamaBundling() );
                    }
                }

                System.out.println();
            }
        }

        System.out.println("----------------------------------------");
        System.out.println(
            "TOTAL                  Rp" +
            // (int) = casting double jadi bilangan bulat, biar di struk nggak muncul angka desimal (.0)
            (int) hitungTotal()
        );

        System.out.println("========================================");
        System.out.println("              THANK YOU");
        System.out.println("========================================");
    }
}