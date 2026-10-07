// buat interface Cetak
// class penjualan wajib punya method cetakStruk()
public interface Cetak {
    // nyimpan nama bioskop yang digunakan pada cetakan
    // variabel di interface nilainya nggak bisa diubah
    String Nama_Bioskop = "BIOSKOP III";

    // Method untuk mencetak struk
    // otomatis public abstract, jadi cuma judul method tanpa isi. isinya ditulis di class Penjualan
    void cetakStruk();
}