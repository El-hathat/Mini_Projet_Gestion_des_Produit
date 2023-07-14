package com.miniprojet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JLabel;

public class Client {
private String id,nom,prenom,adresse,ville,email,sexe,tClient,tel;
private Date datenaissance;


private static int cpt=0;
public Client(String nom, String prenom, String adresse, String ville, String email,String sexe,String sf,String tel,
		Date datenaissance) throws DateinvalideException {
	
	
	if(datenaissance.after(new Date(System.currentTimeMillis()))){
		throw new DateinvalideException("La date Entre : ("+datenaissance+") est invalide");
	}else {
	this.cpt++;
	this.nom = nom;
	this.prenom = prenom;
	this.adresse = adresse;
	this.ville = ville;
	this.email = email;
	this.sexe=sexe;
	this.tClient=sf;
	this.tel = tel;
	id=genId(this)+this.cpt;
	id=id.toUpperCase();
	this.datenaissance = datenaissance;
	}
}

private String genId(Client c) {

	String np2="";
	Random r=new Random();

		np2="C"+c.getTCient().charAt(0);
		np2=np2.toUpperCase()+r.nextInt(11111, 999999);
	
	
	return np2;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getSexe() {
	return sexe;
}

public void setSexe(String sexe) {
	this.nom = sexe;
}

public String getTCient() {
	return tClient;
}

public void setSituationF(String sf) {
	this.tClient = sf;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) {
	this.adresse = adresse;
}

public String getVille() {
	return ville;
}

public void setVille(String ville) {
	this.ville = ville;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
}

public String getDatenaissance() {
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	return sdf.format(datenaissance);
}

public void setDatenaissance(Date datenaissance) {
	this.datenaissance = datenaissance;
}

@Override
public String toString() {
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	return "Bienvenue " + nom + " " + prenom + ", votre adresse est " + adresse + ",et votre ville est" + ville
			+ ", tu es né le " + sdf.format(datenaissance)+ ", E-mail : " + email + ", telephone : " + tel;
}



}
