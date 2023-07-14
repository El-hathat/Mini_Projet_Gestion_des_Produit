package com.miniprojet;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class Produit {
private String idP,nom,unitee;
private double QteP,prixAchat,prixVendre;
private Date dateP,dateE;
public Produit(String idP, String nom, String unitee, double qteP, double prixAchat, double prixVendre, Date dateP,
		Date dateE) throws DateinvalideException{
	if(dateP.after(dateE)) {
		throw new DateinvalideException("Ereur de Date,Date de Production est apres La date d'experation");
	}else {
	this.idP = idP;
	this.nom = nom;
	this.unitee = unitee;
	QteP = qteP;
	this.prixAchat = prixAchat;
	this.prixVendre = prixVendre;
	this.dateP = dateP;
	this.dateE = dateE;
	}
}
public String getIdP() {
	return idP;
}
public void setIdP(String idP) {
	this.idP = idP;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getUnitee() {
	return unitee;
}
public void setUnitee(String unitee) {
	this.unitee = unitee;
}
public double getQteP() {
	return QteP;
}
public void setQteP(double qteP) {
	QteP = qteP;
}
public double getPrixAchat() {
	return prixAchat;
}
public void setPrixAchat(double prixAchat) {
	this.prixAchat = prixAchat;
}
public double getPrixVendre() {
	return prixVendre;
}
public void setPrixVendre(double prixVendre) {
	this.prixVendre = prixVendre;
}
public Date getDateP() {
	return dateP;
}
public void setDateP(Date dateP) {
	this.dateP = dateP;
}
public Date getDateE() {
	return dateE;
}
public void setDateE(Date dateE) {
	this.dateE = dateE;
}
@Override
public String toString() {
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	return "Produit [idP=" + idP + ", nom=" + nom + ", unitee=" + unitee + ", QteP=" + QteP + ", prixAchat=" + prixAchat
			+ ", prixVendre=" + prixVendre + ", dateP=" +sdf.format(dateP) + ", dateE=" + sdf.format(dateE) + "]";
}


}
