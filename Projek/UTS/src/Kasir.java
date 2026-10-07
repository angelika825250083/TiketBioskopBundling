// Kasir mengimplementasikan interface Login
// Kasir wajib punya method SignIn() (ada di paling bawah)
public class Kasir implements Login {

    // Atribut Kasir
    // username & password pakai String karna isinya teks, private biar cuma bisa diakses lewat getter/setter
    private String username;
    private String password;

    // Constructor dengan parameter
    // constructor buat ngisi username & password waktu object Kasir dibuat (dipanggil di main kode)
    public Kasir(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Constructor kosong
    // constructor kosong, buat bikin object Kasir tanpa isi dulu
    public Kasir() {
    }

    // Setter username
    // setter dipakai untuk ngisi/ngubah nilai atribut. pakai void karna cuma ngisi nilai, bukan ngembaliin nilai
    public void setUsername(String username) {
        this.username = username;
    }

    // Setter password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter username
    // getter dipakai untuk ngambil nilai atribut. return-nya String karna atribut username bertipe String (tipe return ngikutin tipe atributnya)
    public String getUsername() {
        return username;
    }

    // Getter password
    public String getPassword() {
        return password;
    }

    // Method SignIn dari interface Login
    // ini isi method SignIn() dari interface Login. isinya ditentuin di sini oleh Kasir, bukan di interface
    // method ini dipanggil di main kode kalau username & password bener
    public void SignIn() {
        System.out.println("Login berhasil.");
    }
}