package com.Square.jeuDeCarte.Model;

public class Carte {
	private String couleur ;
	private String  order ;
	public Carte(String couleur, String order) {
	
		this.couleur = couleur;
		this.order = order;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}

	
	 	

}
