package com.wildcodeschool.example.queteSpring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String couleur;

	public Animal(String s, String s2) {
		this.name = s;
		this.couleur = s2;
	}
	
	public Animal() {
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", couleur=" + couleur + "]";
	}
	


}
