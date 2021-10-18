package com.Square.jeuDeCarte.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.Square.jeuDeCarte.Model.Carte;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CarteServiceTest {

	CarteService carteService;

	@Test
	void test_initialisationDeJeu() {

		List<String> couleursTest = Arrays.asList("col1", "col2");
		List<String> orderTest = Arrays.asList("4", "5", "3", "6", "YES");
		List<Carte> jeuTest = new ArrayList<>();
		CarteService.initialisationDeJeu(jeuTest, couleursTest, orderTest);
		assertEquals(jeuTest.size(), 10);

	}

	@Test
	void test_distributionDeCartes() {

		List<Carte> jeu = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			jeu.add(new Carte("test" + i, "test" + i));
		}
		Carte[] tab = new Carte[10];
		CarteService.distributionDeCartes(tab, jeu);
		assertNotNull(tab[9].getCouleur());
		assertTrue(tab[9].getCouleur().contains("test"));
	}
/**
 * reste à faire ..
 */


}
