# 🎬 Tri de Films en Java

Ce projet Java implémente un algorithme de tri permettant d'organiser une liste de films selon différents critères : titre, année de sortie, ou note.

## 📚 Description

L’objectif est de manipuler une collection de films à partir du texte HTML du site allociné
Ce projet a été réalisé dans le cadre d’un cours universitaire en algorithmique ou en programmation orientée objet.

## 🧰 Technologies utilisées

- Java 8+
- IDE : Eclipse / IntelliJ / VS Code

## 📂 Structure du projet
- `src/main/resources/scrapped0.txt`  
  → Fichier contenant le HTML scrappé depuis AlloCiné.

- `src/main/java/fr/pantheonsorbonne/ufr27/miashs/poo/Item.java`  
  → Classe représentant un film (titre, note, etc.) et initialisant les objets résultats.

- `src/main/java/fr/pantheonsorbonne/ufr27/miashs/poo/ItemAnalyzer.java`  
  → Classe principale d’analyse :
  - extraction des films depuis le HTML,
  - traitements statistiques supplémentaires (ex : tri, moyenne, top N, etc.).

## 🔄 Fonctionnalités

- Tri des films par :
  - Titre
  - Année de sortie
  - Durée
  - Genre
  - Réalisateurs
  - Note presse
  - Note public
  - Nombre de séances

- Calcul de statistiques :
  - Moyenne de la durée des films
  - Genre de film le plus commun
  - Moyenne avis spectateurs
  - Moyenne avis presse
  - Ecart moyenne avis presse et moyenne avis spectateurs
  - Nombre maximum de séances
  
- Affichage des résultats dans la console


