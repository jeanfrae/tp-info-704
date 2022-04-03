package com.univsavoie.tp.eric;

public class Coordonnees {

    private int x;

    private int y;

    private int numero;

    private int ensemble;

    public Coordonnees(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getEnsemble() {
        return ensemble;
    }

    public void setEnsemble(int ensemble) {
        this.ensemble = ensemble;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
