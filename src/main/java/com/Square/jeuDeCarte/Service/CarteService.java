package com.Square.jeuDeCarte.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.Square.jeuDeCarte.Model.Carte;

public class CarteService {
	
	
	public static List<String> intialisatonDesEntrés(String nomList) {
		int sizeList;
		Scanner scan = new Scanner(System.in);
		System.out.print("Bonjour, entrez stp la taille de la liste " + nomList);
		sizeList = scan.nextInt();
		List<String> list = new ArrayList();
		System.out.println("Enterez stp les elements de la liste : ");
		for (int i = 0; i < sizeList; i++) {
			list.add(scan.next());
		}

		return list;
	}

	public static void processDuTirage(List<String> couleurs, List<String> orders) {
		 List<Carte> jeu = new ArrayList<>();
		  Carte[] tirageTab = new Carte[10];
		
		initialisationDeJeu(jeu, couleurs, orders);

		distributionDeCartes(tirageTab, jeu);

		System.out.println("******Tirage  aléatoire de 10 cartes*********** ");

		affichageDeCartes(tirageTab);

		triParCouleur(couleurs, tirageTab);

		triParOrder(orders, tirageTab);
	}

	public static void triParOrder(List<String> orders , Carte[] tab) {
		System.out.println("**********Tirage  de 10 cartes trié par order*********** ");
		Arrays.sort(tab, Ordercomparator(orders));
		affichageDeCartes(tab);
	}

	public static void triParCouleur(List<String> couleurs, Carte[] tab) {
		System.out.println("********* Tirage de 10 cartes trié par couleur*********** ");
		Arrays.sort(tab, Couleurcomparator(couleurs));
		affichageDeCartes(tab);
	}

	public static void initialisationDeJeu(List<Carte> jeu, List<String> listCol, List<String> listOrder) {
		listCol.forEach(CouleurItem -> {

			listOrder.forEach(orderItem -> {
				jeu.add(new Carte(CouleurItem, orderItem));

			});

		});

	}

	public static void distributionDeCartes(Carte[] tab ,List<Carte>jeu) {

		for (int i = 0; i < 10; i++) {
			int rnd = new Random().nextInt(jeu.size());
			tab[i] = jeu.get(rnd);

			jeu.remove(rnd);
		}

	}

	public static void affichageDeCartes(Carte[] tab) {
		for (Carte item : tab) {
			System.out.println(item.getCouleur() + " " + item.getOrder());
		}
	}

	public static Comparator<Carte> Couleurcomparator(List<String> listCol) {
		Comparator<Carte> colorComparator = Comparator.comparingInt(carte -> listCol.indexOf(carte.getCouleur()));
		return colorComparator.thenComparing(colorComparator);
	}

	public static Comparator<Carte> Ordercomparator(List<String> listOrder) {
		Comparator<Carte> orderComparator = Comparator.comparingInt(carte -> listOrder.indexOf(carte.getOrder()));
		return orderComparator.thenComparing(orderComparator);
	}

}
