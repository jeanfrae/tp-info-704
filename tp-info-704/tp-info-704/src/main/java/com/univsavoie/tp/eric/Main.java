package com.univsavoie.tp.eric;

import java.io.*;
import java.util.List;

public class Main {

    // Placer les donnees dans le repertoire ressources
    public static final String DONNEES = "donnees.txt";

    public static void main(String[] args) {
        System.out.println("Bienvenue !");
        try {
            // Lecture des données
            List<Coordonnees> coordonneesList = LecteurDonnees.lire(DONNEES);

            List<Arete>  arbreCouvrantPoidsMinimal = Kurskal.algo(coordonneesList);

            System.out.println("Resultat de l'algo de Kurskal (arbre couvrant de poids minimal ):");

            for(Arete arete : arbreCouvrantPoidsMinimal)  {
                System.out.println("Arrete  : Num#" +  arete.getA().getNumero() + "(" + arete.getA().getX() + "," + arete.getA().getY() + ") --> Num#" + arete.getB().getNumero() + "(" + arete.getB().getX() + "," + arete.getB().getY() + ")"  );
            }



        } catch (IOException e) {
            System.out.println("Impossible de lire les données");
        }
    }
}
