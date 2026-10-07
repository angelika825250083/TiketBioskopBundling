// Membuat interface Login
// interface isinya cuma daftar method tanpa isi. class yang "implements Login" wajib bikin isi dari method SignIn(). interface nggak bisa dibuat object-nya
public interface Login {

    // otomatis public abstract, jadi cuma nulis judul method tanpa isi (isinya ditulis di class Kasir)
    void SignIn();
}