import java.util.Objects;

public class Voiture {
    private int immariculation;
    private String marque;
    private float prixLocation;

    public Voiture(int immariculation, String marque, float prixLocation) {
        this.immariculation= immariculation;
        this.marque= marque;
        this.prixLocation= prixLocation;
// à compléter
    }
    public int getImmariculation() {
        return immariculation;
    }
    public void setImmariculation(int immariculation) {
        this.immariculation = immariculation;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public float getPrixLocation() {
        return prixLocation;
    }
    public void setPrixLocation(float prixLocation) {
        this.prixLocation = prixLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voiture voiture)) return false;

        if (immariculation != voiture.immariculation) return false;
        if (Float.compare(prixLocation, voiture.prixLocation) != 0) return false;
        return Objects.equals(marque, voiture.marque);
    }

    @Override
    public int hashCode() {
        int result = immariculation;
        result = 31 * result + (marque != null ? marque.hashCode() : 0);
        result = 31 * result + (prixLocation != 0.0f ? Float.floatToIntBits(prixLocation) : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Voiture{" +
                "immariculation=" + immariculation +
                ", marque='" + marque + '\'' +
                ", prixLocation=" + prixLocation +
                '}';
    }


}
