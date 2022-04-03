package com.univsavoie.tp.eric;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LecteurDonnees {

    public static final String SEPARATEUR = " ";

    public static List<Coordonnees> lire(String nomFichier) throws IOException {
        List<Coordonnees> coordonneesList = new ArrayList<>();
        BufferedReader br = null;
        try {
            int  numero = 0;
            // Lecture d'un fichier dans ressources
            InputStream ressource = Main.class.getClassLoader().getResourceAsStream(nomFichier);
            InputStreamReader streamReader = new InputStreamReader(ressource);
            br = new BufferedReader(streamReader);

            // Lecture de la première ligne
            String line = br.readLine();
            Coordonnees base = convertirLine(line);
            base.setNumero(numero++);
            coordonneesList.add(base);

            System.out.println("Coordonnées de la base : ");
            System.out.println("Base X : " + base.getX());
            System.out.println("Base Y : " + base.getY());
            System.out.println("Base Numero : " + base.getNumero());
            System.out.println("----");

            System.out.println("Coordonnées des adresses à livrer : ");
            while (line != null) {
                line = br.readLine();
                if (line != null) {
                    Coordonnees adresse =  convertirLine(line);
                    adresse.setNumero(numero++);
                    coordonneesList.add(adresse);
                    System.out.println("Adresse X : " + adresse.getX());
                    System.out.println("Adresse Y : " + adresse.getY());
                    System.out.println("Adresse Numero : " + adresse.getNumero());
                    System.out.println("----");
                }
            }
        } finally {
            br.close();
        }
        return coordonneesList;
    }

    private static Coordonnees convertirLine(String line){
        String[] lineTxt = line.trim().split(SEPARATEUR);
        int lineX = Integer.parseInt(lineTxt[0]);
        int lineY = Integer.parseInt(lineTxt[1]);
        Coordonnees coordonnees = new Coordonnees(lineX, lineY);
        return coordonnees;
    }
}
