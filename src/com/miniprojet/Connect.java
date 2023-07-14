package com.miniprojet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Connect {
private Connection cn;
private static Connect con=null;
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
private Connect() {
	try {
		String URL = "jdbc:mysql://localhost:3306/miniprojet_elkhaldi";
			String	User="root";
			String	Password="";
		cn=DriverManager.getConnection(URL, User, Password);
	}catch(Exception e) {
		e.printStackTrace();
	}
}

public static Connect getInstance(){
if(con==null) {
	con=new Connect();
}
return con;
}


//**********************************************************Client**************************************************************

//---------------------------------------------------------Afficher-------------------------------------------------------------
public ResultSet afficherClient() {
	try {

	Statement st=cn.createStatement();
 return st.executeQuery("select * from client");
 }catch (Exception e){
	 return null;
 }
 }
//----------------------------------------Chercher-----------------------------------------------------------------------

public ResultSet chercherClient(String element) {
	try {

	Statement st=cn.createStatement();
 return st.executeQuery("select * from client where id like '"+element+"%' or nom like'"+element+"%' or prenom like'"+element+"%' or adresse like'"
	+element+"%' or ville like'"+element+"%' or email like'"+element+"%' or sexe like'"+element+"%' or tClient like'"+
		 element+"%' or tel like'"+element+"%' or datenaissance like'"+element+"%'");
 }catch (Exception e){
	 return null;
 }
 }



//----------------------------------------------------Supprission-----------------------------------------------------------
public boolean supprimerClient(String id) {
	 try {
		Statement st=cn.createStatement();
	 st.executeUpdate("delete from client where id='"+id+"'");
	 return true;
	 }catch (Exception e){
		 return false;
	 }
	 }




//--------------------------------------------------Insertion----------------------------------------------------------------
public boolean ajouterClient(Client c)
{
 try {
	 
	 Statement st=cn.createStatement();
	 st.executeUpdate("INSERT INTO client values('"+c.getId()+"','"+c.getNom()+"','" +c.getPrenom()
	 +"','"+c.getAdresse()+"','"+c.getVille()+"','" +c.getEmail()+"','" +c.getSexe()+"','"+c.getTCient()+
	 "','" +c.getTel()+"','"+ c.getDatenaissance()+"')");
 return true;
 }catch (Exception e) {
	 e.printStackTrace();
	return false;
	
 }

}




//--------------------------------------------------------Modification--------------------------------------------------------
public boolean modifierClient(Client c,String code)
{
 try {
	 Statement st=cn.createStatement();
	 st.executeUpdate("update client set nom='"+ c.getNom()+"',prenom='"+ 
			 c.getPrenom()+"',adresse='"+ c.getAdresse()+"',ville='"+ c.getVille()+"',email='"+ c.getEmail()+"',sexe='"+ 
			 c.getSexe()+"',tClient='"+c.getTCient()+"',tel='"+ c.getTel()+"',datenaissance='"+ c.getDatenaissance()+
			 "' where id='" +code +"'");

 return true;
 }catch (Exception e) {
	return false;
 }

}

//---------------------------------------pour recuperer le nom et le prenom d'un Client------------------------------------------
public ResultSet infoClient(String code)throws Exception {
	

	Statement st=cn.createStatement();
 return st.executeQuery("select nom,prenom from client where id='"+code+"'");

	
}
//**************************************************PRODUIT*******************************************************************
//---------------------------------------------Afficher tout les produit------------------------------------------------------
public ResultSet afficherProduit() {
	try {

	Statement st=cn.createStatement();
 return st.executeQuery("select * from produit");
 }catch (Exception e){
	 return null;
 }
 }

//---------------------------------------------Afficher  les produit Experer------------------------------------------------------
public ArrayList<Produit> afficherProduitExpirer() {
	ArrayList<Produit> al=new ArrayList<Produit>();
	try {
Date d=new Date();
	Statement st=cn.createStatement();
ResultSet rs= st.executeQuery("select * from produit ");
while(rs.next()) {
	if(sdf.parse(rs.getString(8)).before(d)) {
		al.add(new Produit(rs.getString(1), rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getDouble(6),sdf.parse(rs.getString(7)),sdf.parse(rs.getString(8))));
		}
}
return al;
}catch (Exception e){
	 return null;
}
}
//--------------------------------------------------Chercher-------------------------------------------------------------------

public ResultSet chercherProduit(String element) {
	try {

	Statement st=cn.createStatement();
 return st.executeQuery("select * from produit where idP like '"+element+"%' or nom like '"+element+"%' or QteP like '"+element+"%' or prixAchat like '" 
	+element+"%' or prixVendre like '"+element+"%' or unitee like '"+element+"%' or dateP like '"+element+"%' or dateE like '"+
		 element+"%'");
 }catch (Exception e){
	 return null;
 }
 }



//--------------------------------------------------------Supprission----------------------------------------------------------
public boolean supprimerProduit(String id) {
	 try {
		Statement st=cn.createStatement();
	 st.executeUpdate("delete from produit where idP='"+id+"'");
	 return true;
	 }catch (Exception e){
		 return false;
	 }
	 }




//---------------------------------------------------------------Insertion-----------------------------------------------------
public boolean ajouterProduit(Produit p)
{
 try {
	
	 Statement st=cn.createStatement();
	 st.executeUpdate("INSERT INTO produit values('"+p.getIdP()+"','"+p.getNom()+"','" +p.getUnitee()
	 +"',"+p.getQteP()+","+p.getPrixAchat()+"," +p.getPrixVendre()+",'" +sdf.format(p.getDateP())+"','"+sdf.format(p.getDateE())+"')");
	 
 return true;
 }catch (Exception e) {
	 e.printStackTrace();
	return false;
	
 }

}

//-----------------------------------------------------deminuer la quantite---------------------------------------------------------
public boolean deminuerQuantite(String nom,double qte)
{  	 //(`idP`, `nom`, `unitee`, `QteP`, `prixAchat`, `prixVendre`, `dateP`, `dateE`)
	
try {
	 Statement st1=cn.createStatement();
	 ResultSet rs= st1.executeQuery("select QteP from produit where nom='"+nom+"'");
	 double q=0;
	 while(rs.next()) {
		 q=rs.getDouble(1);
	 }

	 q=q-qte;
	
	 Statement st=cn.createStatement();
	 st.executeUpdate("update Produit set QteP="+ q+" where nom='"+nom+"'");

return true;
}catch (Exception e) {
	 e.printStackTrace();
	return false;
}

}


//-----------------------------------------------------Modification---------------------------------------------------------
public boolean modifierProduit(Produit p,String code)
{  	 //(`idP`, `nom`, `unitee`, `QteP`, `prixAchat`, `prixVendre`, `dateP`, `dateE`)
 try {
	 Statement st=cn.createStatement();
	 st.executeUpdate("update Produit set idP='"+ p.getIdP()+"',nom='"+ 
			p.getNom()+"',unitee='"+ p.getUnitee()+"',QteP="+ p.getQteP()+",prixAchat="+ p.getPrixAchat()+",prixVendre="+ 
			 p.getPrixVendre()+",dateP='"+sdf.format(p.getDateP())+"',dateE='"+ sdf.format(p.getDateE())+"' where idP='"+code+"'");

 return true;
 }catch (Exception e) {
	 e.printStackTrace();
	return false;
 }

}


//-----------------------------------------tableau des noms de produit------------------------------------------------------
public String[] lesNomsProduit() {
	String[] t;
	int n=0,i=0;
	try {
		Statement st=cn.createStatement();
		Statement st1=cn.createStatement();
		ResultSet rs1= st.executeQuery("select nom from produit");
		ResultSet rs= st1.executeQuery("select nom from produit");
		while(rs1.next()){n++;}
		t=new String[n];
		while(rs.next()){
			t[i]=rs.getString(1);
			i++;}
return t;
 }catch (Exception e){
	 return null;
 }
 }


//-----------------------------------------------Retourner le prix d'achat-----------------------------------------------------
public double prixVendre(String nom) {
	
	
	try {
		Statement st=cn.createStatement();
	
		ResultSet rs= st.executeQuery("select prixVendre from produit where nom='"+nom+"'");
		rs.next();

		return rs.getDouble(1);
	

}catch (Exception e){
	 return 0;
}
}

//------------------------------------------------Retourner la quantite----------------------------------------------------
public double QuantiteDB(String nom) throws Exception{
	double q=0;
	

		Statement st=cn.createStatement();
	
		ResultSet rs= st.executeQuery("select QteP from produit where nom='"+nom+"'");
		while(rs.next()) {
			q= rs.getDouble(1);
		
		}
		return q;
}
//**********************************************FACTURE***********************************************************************


public ResultSet afficherFacture() {
	try {

	Statement st=cn.createStatement();
 return st.executeQuery("select * from facture");
 }catch (Exception e){
	 return null;
 }
 }
//----------------------------------------------Chercher------------------------------------------------------------------

public ResultSet chercherFacture(String element) {
	try {

	Statement st=cn.createStatement();
	return st.executeQuery("select * from facture where nomcplt like '"+element+"%' or qteV like '"+element+"%' or nomP like '" 
	+element+"%' or idCl like '"+element+"%' or montant like '"+element+"%' or dateVendre like '"+element+"%' or numf like '"+
		 element+"%'");
 }catch (Exception e){
	 return null;
 }
 }



//--------------------------------------------------------Supprission-----------------------------------------------------------
public boolean supprimerFacture(int id) {
	 try {
		Statement st=cn.createStatement();
	 st.executeUpdate("delete from facture where numf="+id);
	 return true;
	 }catch (Exception e){
		 return false;
	 }
	 }




//---------------------------------------------------Insertion-----------------------------------------------------------------
public boolean ajouterFacture(Facture f)
{
 try {
	
	 Statement st=cn.createStatement();
	
	
	 st.executeUpdate("INSERT INTO facture values("+f.getNumF()+",'"+f.getIdcl()+"','" +f.getNomcplt()
	 +"','"+f.getNomP()+"',"+f.getQteV()+",'" +sdf.format(new Date())+"'," +f.getMontant()+",'"+sdf.format(f.getDateGarantie())+"')");
	 
 return true;
 }catch (Exception e) {
	 e.printStackTrace();
	return false;
	
 }

}




//---------------------------------------------------------Modification--------------------------------------------------------
public boolean modifierFacture(Facture f,String code)
{  
 try {
	 Statement st=cn.createStatement();
	 st.executeUpdate("update Facture set idCl='"
			 +f.getIdcl()+"',nomcplt='"+ f.getNomcplt()+"',nomP='"+ f.getNomP()+"',qteV="+ f.getQteV()+",montant="+ 
			 f.getMontant()+",dateGarantie='"+ sdf.format(f.getDateGarantie())+"' where numf='"+code+"'");

 return true;
 }catch (Exception e) {
	 e.printStackTrace();
	return false;
 }

}


//------------------------------------pour recuperer le derniere num de facture-------------------------------------------------
public int numFacture() throws SQLException {
	 Statement st=cn.createStatement();
	 ResultSet rs=st.executeQuery("select max(numf) from facture");
	 while(rs.next()) {
		return rs.getInt(1); 
	 }
	 return 0;
}



}
