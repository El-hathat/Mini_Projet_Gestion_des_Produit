package com.miniprojet;

import java.sql.SQLException;
import java.util.Date;

import javax.swing.JLabel;

public class Facture {
	Connect cn=Connect.getInstance();
	private static int numF;
	private String idcl,nomcplt,nomP;
	private double qteV,montant;
	private Date dateV,dateGarantie;
	public Facture(String idcl, String nomcplt, String nomP, double qteV,double montant,Date dateGarantie) {
		
		try {
			this.numF=cn.numFacture()+1;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		this.idcl = idcl;
		this.nomcplt = nomcplt;
		this.nomP = nomP;
		this.qteV = qteV;
		this.dateV = new Date(System.currentTimeMillis());
		this.dateGarantie=dateGarantie;
		this.montant=montant;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDateGarantie() {
		return dateGarantie;
	}
	public void setDateGarantie(Date dateGarantie) {
		this.dateGarantie = dateGarantie;
	}
	public int getNumF() {
		return numF;
	}
	public void setNumF(int numF) {
		this.numF = numF;
	}
	public String getIdcl() {
		return idcl;
	}
	public void setIdcl(String idcl) {
		this.idcl = idcl;
	}
	public String getNomcplt() {
		return nomcplt;
	}
	public void setNomcplt(String nomcplt) {
		this.nomcplt = nomcplt;
	}
	public String getNomP() {
		return nomP;
	}
	public void setNomP(String nomP) {
		this.nomP = nomP;
	}
	public double getQteV() {
		return qteV;
	}
	public void setQteV(double qteV) {
		this.qteV = qteV;
	}
	public Date getDateV() {
		return dateV;
	}
	public void setDateV(Date dateV) {
		this.dateV = dateV;
	}
	
	

}
