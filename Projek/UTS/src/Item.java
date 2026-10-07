// Class Item dibuat abstract karena menjadi parent class untuk class Tiket dan Bundling
public abstract class Item {

    // private = cuma bisa diakses dari dalam class Item, kalau class lain mau ngakses harus lewat getter/setter
    // idItem & nama pakai String karna isinya teks, harga pakai double karna isinya angka
    private String idItem;
    private String nama;
    private double harga;

    // Constructor dengan parameter
    // constructor ini nanti dipanggil sama Tiket & Bundling lewat super(idItem, nama, harga)
    public Item(String idItem, String nama, double harga) {
        this.idItem = idItem;
        this.nama = nama;
        this.harga = harga;
    }

    // Constructor kosong
    // constructor kosong, buat bikin object dulu tanpa isi (nanti diisi pakai setter)
    public Item() {
    }

    // Setter untuk idItem
    // setter dipakai untuk ngisi/ngubah nilai atribut. pakai void karna cuma ngisi nilai, bukan ngembaliin nilai
    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    // Setter untuk nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Setter untuk harga
    public void setHarga(double harga) {
        this.harga = harga;
    }

    // Getter untuk idItem
    // getter dipakai untuk ngambil nilai atribut. return-nya String karna atribut idItem bertipe String (tipe return ngikutin tipe atributnya), beda sama getHarga() yang return double karna harga bertipe double
    public String getIdItem() {
        return idItem;
    }

    // Getter untuk nama
    public String getNama() {
        return nama;
    }

    // Getter untuk harga
    public double getHarga() {
        return harga;
    }

    // Abstract method
    // Class turunan wajib mempunyai method ini
    // abstract method = method yang cuma ditulis judulnya aja, nggak ada isinya (makanya langsung titik koma, nggak ada kurung kurawal)
    // Tiket & Bundling WAJIB nulis isi hitungHarga() sendiri-sendiri, karna cara ngitung harga tiap child bisa beda. kalau lupa, error pas compile
    public abstract double hitungHarga();
}