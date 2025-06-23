package fr.pantheonsorbonne.ufr27.miashs.poo;

import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;

public final class Item {
  private String titre;

  private Integer dureeFilm;

  private ArrayList<String> realisateur;

  private ArrayList<String> genreFilm;

  private Double avisSpectateurs;

  private Double avisPresse;

  private Integer nombreSeance;

  private String dateDeSortie;

  public String getTitre() {
    return this.titre;
  }

  public void setTitre(String titre) {
    this.titre=titre;
  }

  public Integer getDureeFilm() {
    return this.dureeFilm;
  }

  public void setDureeFilm(Integer dureeFilm) {
    this.dureeFilm=dureeFilm;
  }

  public ArrayList<String> getRealisateur() {
    return this.realisateur;
  }

  public void setRealisateur(ArrayList<String> realisateur) {
    this.realisateur=realisateur;
  }

  public ArrayList<String> getGenreFilm() {
    return this.genreFilm;
  }

  public void setGenreFilm(ArrayList<String> genreFilm) {
    this.genreFilm=genreFilm;
  }

  public Double getAvisSpectateurs() {
    return this.avisSpectateurs;
  }

  public void setAvisSpectateurs(Double avisSpectateurs) {
    this.avisSpectateurs=avisSpectateurs;
  }

  public Double getAvisPresse() {
    return this.avisPresse;
  }

  public void setAvisPresse(Double avisPresse) {
    this.avisPresse=avisPresse;
  }

  public Integer getNombreSeance() {
    return this.nombreSeance;
  }

  public void setNombreSeance(Integer nombreSeance) {
    this.nombreSeance=nombreSeance;
  }

  public String getDateDeSortie() {
    return this.dateDeSortie;
  }

  public void setDateDeSortie(String dateDeSortie) {
    this.dateDeSortie=dateDeSortie;
  }
}
