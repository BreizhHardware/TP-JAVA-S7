package breizhhardware.exercice.abstraites;

public abstract class Transport {
    protected double vitesseMoyenne; // en km/h

    public Transport(double vitesseMoyenne){
        // Initialisation de la vitesse moyenne
        setVitesseMoyenne(vitesseMoyenne);
    }

    public void setVitesseMoyenne(double vitesseMoyenne){
        this.vitesseMoyenne = vitesseMoyenne;
    }

    public double getVitesseMoyenne(){
        return this.vitesseMoyenne;
    }

    public abstract double tempsTrajet(double distance); // distance en km, retourne durée en heures
}
