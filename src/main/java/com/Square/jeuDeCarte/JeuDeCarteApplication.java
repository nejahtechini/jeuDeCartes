package com.Square.jeuDeCarte;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Square.jeuDeCarte.Service.CarteService;

@SpringBootApplication
public class JeuDeCarteApplication {

	public static void main(String[] args) {
		SpringApplication.run(JeuDeCarteApplication.class, args);

		List<String> couleurs = CarteService.intialisatonDesEntrés("Couleurs");

		List<String> orders = CarteService.intialisatonDesEntrés("Orders");

		System.out.println("debut de programme");

		if (couleurs.size() * orders.size() >= 10) {

			CarteService.processDuTirage(couleurs, orders);

		} else {
			System.out.println("on peut pas faire un tirage de 10 cartes, le nombre total de cartes est: "
					+ couleurs.size() * orders.size());
			System.out.println("Au revoir !");
		}

	}

}
