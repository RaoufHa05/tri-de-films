package fr.pantheonsorbonne.ufr27.miashs.poo;

import java.lang.String;
import java.util.ArrayList;



public final class ItemsScrapper{
  
  ArrayList<Item> parseSource(String pageSource) {
    ArrayList<Item> itemList = new ArrayList<>();
    int indexTitre = pageSource.indexOf("meta-title-link");

    while (true){
    Item item = new Item();

    String pageRecherche = pageSource.substring(indexTitre);
    int indexDateDeSortie = pageRecherche.indexOf("date");
    int indexDureeFilm = pageRecherche.indexOf("|</span");
    int indexGenre = pageRecherche.indexOf("== dark-grey-link");
    int indexRealisateur = pageRecherche.indexOf("De</span> <span");
    int indexAvisPresse = pageRecherche.indexOf("Presse");
    int indexAvisSpectateurs = pageRecherche.indexOf("Spectateurs");
    int indexNombreSeances = pageRecherche.indexOf("Séances");

    if (indexTitre == -1 || indexDateDeSortie == -1 || indexDureeFilm == -1 || indexGenre == -1 || indexRealisateur == -1 || indexAvisPresse == -1 || indexAvisSpectateurs == -1 || indexNombreSeances == -1){
      break;
    }

    String titre = extractItem(pageRecherche, ">", "<", null);
    item.setTitre(titre);

    String pageRechercheDate = pageRecherche.substring(indexDateDeSortie);
    String date = extractItem(pageRechercheDate, ">", "<", null);
    item.setDateDeSortie(date);

    String pageRechercheDuree = pageRecherche.substring(indexDureeFilm);
    String duree = extractItem(pageRechercheDuree, ">", "<", null);
    String heures = duree.substring(1, duree.indexOf("h"));
    String minutes = duree.substring(duree.indexOf("h ") + 2, duree.indexOf("min"));
    int dureeMinute = Integer.parseInt(heures)*60 + Integer.parseInt(minutes);
    item.setDureeFilm(dureeMinute);
  
    String pageRechercheGenre = pageRecherche.substring(indexGenre, indexRealisateur);
    ArrayList<String> genreFilm = new ArrayList<>();
    while (pageRechercheGenre.contains("== dark-grey-link")){
      String nomGenreFilm = extractItem(pageRechercheGenre, ">", "<", "== dark-grey-link\"");
      genreFilm.add(nomGenreFilm);
      int indexFinNomGenreFilm = pageRechercheGenre.indexOf(nomGenreFilm) + nomGenreFilm.length();
      pageRechercheGenre = pageRechercheGenre.substring(indexFinNomGenreFilm);
    }
    item.setGenreFilm(genreFilm);

    int indexFinPageRealisateur = pageRecherche.indexOf("</div>", indexRealisateur);
    String pageRechercheRealisateur = pageRecherche.substring(indexRealisateur, indexFinPageRealisateur);
    ArrayList<String> realisateur = new ArrayList<>();
    while (pageRechercheRealisateur.contains("dark-grey-link")){
      String nomRealisateur = extractItem(pageRechercheRealisateur, ">", "<", "dark-grey-link\"");
      realisateur.add(nomRealisateur);
      int indexFinNomRealisateur = pageRechercheRealisateur.indexOf(nomRealisateur) + nomRealisateur.length();
      pageRechercheRealisateur = pageRechercheRealisateur.substring(indexFinNomRealisateur);
    }
    item.setRealisateur(realisateur);
    
    String pageRechercheAvisPresse = pageRecherche.substring(indexAvisPresse);
    String avisPresse = extractItem(pageRechercheAvisPresse, ">", "<", "stareval-note");
    String avisPresseAvecPoint = avisPresse.substring(0,1) +"."+ avisPresse.substring(2);
    double avisPresseNombre = Double.parseDouble(avisPresseAvecPoint);
    item.setAvisPresse(avisPresseNombre);
    
    String pageRechercheAvisSpectateurs = pageRecherche.substring(indexAvisSpectateurs);
    String avisSpectateurs = extractItem(pageRechercheAvisSpectateurs, ">", "<", "stareval-note");
    String avisSpectateursAvecPoint = avisSpectateurs.substring(0,1) +"."+ avisSpectateurs.substring(2);
    double avisSpectateursNombre = Double.parseDouble(avisSpectateursAvecPoint);
    item.setAvisSpectateurs(avisSpectateursNombre);
    
    String pageRechercheNombreSeances = pageRecherche.substring(indexNombreSeances);
    String nombreSeances = extractItem(pageRechercheNombreSeances, "(", ")", null);
    int nombreSeancesNombre= Integer.parseInt(nombreSeances);
    item.setNombreSeance(nombreSeancesNombre);
    
    itemList.add(item);
    indexTitre = pageSource.indexOf("meta-title-link", indexTitre + 1);
    
  }

   return itemList;
 }

 public String extractItem(String page, String debutDonnee, String finDonnee, String indexCharacter){
  int indexDebutPageRecherche;
  if (indexCharacter == null){
    indexDebutPageRecherche = 0;
  }
  else {
    indexDebutPageRecherche = page.indexOf(indexCharacter);
  }

  int indexDebutDonnee = page.indexOf(debutDonnee, indexDebutPageRecherche);
  int indexFinDonnee = page.indexOf(finDonnee, indexDebutDonnee);

  return page.substring(indexDebutDonnee + 1, indexFinDonnee);

  }
}

