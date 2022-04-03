package com.univsavoie.tp.eric;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// On rappelle ici l’algorithme de Kruskal : L’algorithme construit un arbre en
// s´electionnant des arêtes par poids croissant. Plus précisément, l’algorithme
// considère toutes les arêtes du graphe par poids croissant (en pratique, on trie
// d’abord les arêtes du graphe par poids croissant) et pour chacune d’elles, il
// la sélectionne si elle ne crée pas un cycle.
public class Kurskal {


    // L’algorithme considère toutes les arêtes du graphe
    private static List<Arete> creationGrapheConnexe(List<Coordonnees> coordonneesList){
        List<Arete> toutesLesAretes = new ArrayList<>();
        for (int i = 0; i < coordonneesList.size()-1; i++) {
            for (int j = i + 1; j < coordonneesList.size(); j++) {
                toutesLesAretes.add(new Arete(coordonneesList.get(i), coordonneesList.get(j)));
            }
        }
        return toutesLesAretes;
    }

    // On trie d’abord les arêtes du graphe par poids croissant
    private static void trierAretes(List<Arete> areteList){
        areteList.sort(Comparator.comparingDouble(Arete::getPoids));
    }


    public static List<Arete>  algo(List<Coordonnees> coordonneesList) {

        // Création d'une graphe connexe
        List<Arete> toutesLesAretes = creationGrapheConnexe(coordonneesList);

        // Trie des arretes
        trierAretes(toutesLesAretes);

        // Application de l'algo de Kruskal
        List<Arete> arbreCouvrantPoidsMinimal = new ArrayList<>();


        Arete arete;
        int n = coordonneesList.size();
        for (int i = 0; i < n; i++){
            coordonneesList.get(i).setEnsemble(i);
        }

        int i = 0;
        while (arbreCouvrantPoidsMinimal.size() < n - 1) {
            arete = toutesLesAretes.get(i);
            int ensembleA = arete.getA().getEnsemble();
            int ensembleB = arete.getB().getEnsemble();
            if (ensembleA != ensembleB) {
                arbreCouvrantPoidsMinimal.add(arete);
                for (Coordonnees s : coordonneesList) {
                    if (s.getEnsemble() == ensembleB) {
                        s.setEnsemble(ensembleA);
                    }
                }
            }
            i++;
        }

        return arbreCouvrantPoidsMinimal;
    }

}
