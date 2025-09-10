package bzh.breizhhardware.exercice.training.parcautomobile;

public abstract class Vehicule {
    protected String marque;
    protected String modele;
    protected Integer annee;
    protected Double kilometrage;

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(Double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public Vehicule(String marque, String modele, Integer annee, Double kilometrage) {
        setMarque(marque);
        setModele(modele);
        setAnnee(annee);
        setKilometrage(kilometrage);
    }

    public abstract void afficherCaracteristiques();

    public void rouler(double km) {
        double nouveauKm = getKilometrage() + km;
        setKilometrage(nouveauKm);
    }
}
