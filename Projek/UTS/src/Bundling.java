// import = manggil ArrayList dari library Java supaya bisa dipakai di sini
import java.util.ArrayList;

// Bundling merupakan turunan dari Item
// Bundling = satu paket (Paket Single / Couple / Makanan Berat) yang isinya beberapa item
// extends Item = Bundling juga anaknya Item, jadi punya idItem, nama, harga dari Item
// karna anak Item, Bundling WAJIB nulis isi hitungHarga() (ada di paling bawah)
public class Bundling extends Item {

    // Nama paket bundling
    // atribut khusus Bundling: namaBundling (String karna teks) dan hargaBundling (double karna angka)
    private String namaBundling;

    // nyimpan item-item yang ada di dalam bundling
    // ArrayList = daftar yang ukurannya bisa nambah terus (beda sama array biasa yang ukurannya tetap)
    // daftarItem ini isi paketnya, contohnya tiket + popcorn + minuman
    private ArrayList<Item> daftarItem;

    // Harga paket bundling
    private double hargaBundling;

    // Constructor dengan parameter
    // constructor ngisi data dari Item (idItem, nama, harga) + data bundling (namaBundling, hargaBundling)
    public Bundling(String idItem, String nama,
                    double harga, String namaBundling,
                    double hargaBundling) {

        // super= manggil constructor Item buat ngisi idItem, nama, harga
        super(idItem, nama, harga);

        this.namaBundling = namaBundling;
        this.hargaBundling = hargaBundling;

        // buat ArrayList untuk menyimpan item
        // ArrayList harus dibuat dulu pakai new, kalau nggak bakal error pas dipakai (NullPointerException)
        daftarItem = new ArrayList<Item>();
    }

    // Constructor kosong
    // constructor kosong, list-nya tetap dibuat biar nggak error kalau langsung dipakai
    public Bundling() {
        daftarItem = new ArrayList<Item>();
    }

    // Setter nama bundling
    // setter dipakai untuk ngisi/ngubah nilai atribut. pakai void karna cuma ngisi nilai, bukan ngembaliin nilai
    public void setNamaBundling(String namaBundling) {
        this.namaBundling = namaBundling;
    }

    // Setter harga bundling
    public void setHargaBundling(double hargaBundling) {
        this.hargaBundling = hargaBundling;
    }

    // Getter nama bundling
    // getter dipakai untuk ngambil nilai atribut. return-nya String karna atribut namaBundling bertipe String (tipe return ngikutin tipe atributnya)
    public String getNamaBundling() {
        return namaBundling;
    }

    // Getter daftar item
    // return-nya ArrayList<Item> karna atribut daftarItem bertipe ArrayList<Item>
    // dipakai di App.java buat nambahin isi paket
    public ArrayList<Item> getDaftarItem() {
        return daftarItem;
    }

    // Implementasi abstract method dari Item
    // ini isi dari abstract method hitungHarga() milik Item. wajib ditulis di sini karna Bundling anaknya Item
    // harga bundling = harga paketnya (hargaBundling), bukan jumlah harga isinya satu-satu
    // contohnya Paket Single tetap Rp100.000 walau isinya tiket 40000 + popcorn 50000 + minuman 35000
    public double hitungHarga() {
        return hargaBundling;
    }
}