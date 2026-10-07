// Tiket merupakan turunan dari Item
// extends Item = Tiket ini childnya Item (inheritance / pewarisan)
// jadi Tiket otomatis punya idItem, nama, harga + setter getternya dari Item, nggak perlu nulis ulang
// di sini tinggal nambah atribut yang khusus buat tiket aja
public class Tiket extends Item {

    // Atribut khusus Tiket
    // atribut khusus tiket pakai String karna isinya teks, dan private biar cuma bisa diakses lewat getter/setter
    private String judulFilm;
    private String studio;
    private String jamTayang;
    private String noKursi;

    // Constructor dengan parameter
    // constructor Tiket parameternya banyak karna ngisi data dari Item (idItem, nama, harga) + data khusus Tiket (judulFilm, studio, jamTayang, noKursi)
    public Tiket(String idItem, String nama, double harga,
                 String judulFilm, String studio,
                 String jamTayang, String noKursi) {

        // Memanggil constructor dari class Item
        // super= manggil constructor Item buat ngisi idItem, nama, harga. wajib ditulis paling atas di constructor
        super(idItem, nama, harga);

        this.judulFilm = judulFilm;
        this.studio = studio;
        this.jamTayang = jamTayang;
        this.noKursi = noKursi;
    }

    // Constructor kosong
    // constructor kosong, buat bikin object Tiket tanpa isi dulu (nanti diisi pakai setter)
    public Tiket() {
    }

    // Setter judul film
    // setter dipakai untuk ngisi/ngubah nilai atribut. pakai void karna cuma ngisi nilai, bukan ngembaliin nilai
    public void setJudulFilm(String judulFilm) {
        this.judulFilm = judulFilm;
    }

    // Setter studio
    public void setStudio(String studio) {
        this.studio = studio;
    }

    // Setter jam tayang
    public void setJamTayang(String jamTayang) {
        this.jamTayang = jamTayang;
    }

    // Setter nomor kursi
    public void setNoKursi(String noKursi) {
        this.noKursi = noKursi;
    }

    // Getter judul film
    // getter dipakai untuk ngambil nilai atribut. return-nya String karna atribut judulFilm bertipe String (tipe return ngikutin tipe atributnya)
    public String getJudulFilm() {
        return judulFilm;
    }

    // Getter studio
    public String getStudio() {
        return studio;
    }

    // Getter jam tayang
    public String getJamTayang() {
        return jamTayang;
    }

    // Getter nomor kursi
    public String getNoKursi() {
        return noKursi;
    }

    // Implementasi abstract method dari Item
    // ini isi dari abstract method hitungHarga() milik Item. wajib ditulis di sini karna Tiket childnya Item
    // harga tiketharga yang disimpan di Item, jadi return getHarga() (getHarga() diwarisin dari Item)
    // return-nya double karna harus sama kayak yang ditulis di Item
    public double hitungHarga() {
        return getHarga();
    }
}