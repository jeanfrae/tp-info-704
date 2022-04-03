package com.univsavoie.tp.eric;

public class Arete {

    private Coordonnees a;

    private Coordonnees b;

    // Distance
    private double poids;

    public Arete(Coordonnees a, Coordonnees b) {
        this.a = a;
        this.b = b;

        // On rappelle que la distance que la distance entre une ville A aux coordonnéees (xA, yA) et  une ville B aux coordonnéees (xB, yB) est :
        // racineCarree(carre(xB − xA) + carre(yB − yA))
        poids = Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    }

    public Coordonnees getA() {
        return a;
    }

    public void setA(Coordonnees a) {
        this.a = a;
    }

    public Coordonnees getB() {
        return b;
    }

    public void setB(Coordonnees b) {
        this.b = b;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }
}
