import java.util.Objects;

public class Client {

    private int code;
    private String nom;
    private String prenom;

    public Client(int code, String nom, String prenom) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String
                                  prenom) {
        this.prenom = prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;

        if (code != client.code) return false;
        if (!Objects.equals(nom, client.nom)) return false;
        return Objects.equals(prenom, client.prenom);
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

}
