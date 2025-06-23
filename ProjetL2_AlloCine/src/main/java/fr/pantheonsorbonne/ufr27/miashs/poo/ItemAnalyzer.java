package fr.pantheonsorbonne.ufr27.miashs.poo;

import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public final class ItemAnalyzer {
    private ArrayList<Item> items = new ArrayList<>();

    public ItemAnalyzer(ArrayList<Item> items) {
        this.items = items;
    }

    public Double getMoyenneDureeFilms() {

        double totalDuree = 0;
        for (Item item : items) {
            totalDuree += item.getDureeFilm();
        }

        return totalDuree / items.size();
    }

    public String getGenreFilmLePlusCommun() {
      
      HashMap<String, Integer> dico = new HashMap<>();
      
      for (Item item : items) {
          for (String genre : item.getGenreFilm()) {
              if (!dico.containsKey(genre)) {
                  dico.put(genre, 1);
              } else {
                  dico.put(genre, dico.get(genre) + 1);
              }
          }
      }

      String genreLePlusCommun = "";
      int maxOccurenceGenre = 0;

      for (Map.Entry<String, Integer> occurenceGenre : dico.entrySet()){
        if (occurenceGenre.getValue() > maxOccurenceGenre){
          genreLePlusCommun = occurenceGenre.getKey();
          maxOccurenceGenre = occurenceGenre.getValue();
        }
      }

      return genreLePlusCommun;
    }

    public Double getMoyenneAvisSpectateurs() {

        double totalAvisSpectateurs = 0;
        for (Item item : items) {
            totalAvisSpectateurs += item.getAvisSpectateurs();
        }

        return totalAvisSpectateurs / items.size();
    }

    public Double getMoyenneAvisPresse() {

        double totalAvisPresse = 0;
        for (Item item : items) {
            totalAvisPresse += item.getAvisPresse();
        }

        return totalAvisPresse / items.size();
    }

    public Double getEcartMoyennePresseMoyenneSpectateurs() {
        double moyennePresse = getMoyenneAvisPresse();
        double moyenneSpectateurs = getMoyenneAvisSpectateurs();

        return Math.abs(moyennePresse - moyenneSpectateurs);
    }

    public Integer getMaximumSeances() {

        int maxSeances = 0;
        for (Item item : items) {
            if (item.getNombreSeance() > maxSeances) {
                maxSeances = item.getNombreSeance();
            }
        }

        return maxSeances;
    }
}