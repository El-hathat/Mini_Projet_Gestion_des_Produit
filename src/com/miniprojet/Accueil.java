package com.miniprojet;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.JSpinner.DateEditor;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public  class Accueil extends JFrame implements ActionListener{
	Connect cn=Connect.getInstance();
	public Accueil() {
		setTitle("Acceuil");
		setBackground(Color.gray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1100, 600);
		setLocationRelativeTo(null);
		
		setLayout(null);
		
//----------------------------------------Declaration--------------------------------------------------------------
		JLabel l1,l2,l3,l4,l5;

		JButton btn1,btn2,btn3,btn4;
		 JScrollPane scrollp;
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		
//----------------------------------------------------------------Instanciation-------------------------------------------------
		l1=new JLabel("El-hathat mohamed");
		l2=new JLabel("_______________________________________________________________________________________");
		l3=new JLabel("Liste des produits expirer");
		l4=new JLabel("Accueil");
		l5=new JLabel("____________________");


		btn1=new JButton("Ajouter un Client");
		btn2=new JButton("Ajouter un Produit ");
		btn3=new JButton("Ajouter une Vente");
		btn4=new JButton("Deconnecter");
		
		JTable jt=new JTable();
		scrollp=new JScrollPane(jt);
		
		
//-------------------------------------------PROPRIETE---------------------------------------------------------------------------
		l4.setFont(new Font("Arial",Font.PLAIN,40));
		l4.setFont(new Font("Arial",Font.PLAIN,50));
		
		
	
		
//-------------------------------------------------Localisation-----------------------------------------------------------------
		
		
			l1.setBounds(10,5, 300,20);
			l2.setBounds(0, 14, 680, 20);
			l3.setBounds(800,1, 300,40);
			l4.setBounds(270, 50, 200, 50);
			l5.setBounds(270, 80, 200, 20);

			btn4.setBounds(780, 5, 110, 20);
		
			
			scrollp.setBounds(580, 30, 500, 500);
			btn1.setBounds(150, 150, 400, 30);
			
			btn2.setBounds(150, 200, 400, 30);
			btn3.setBounds(150,250, 400,30);
			btn4.setBounds(150,450, 400,30);
			
			
			
			
	
		
//-----------------------------------------------------Ajouter a la fenetre-----------------------------------------------------
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(scrollp);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
	
//-----------------------------------------les actions------------------------------------------------------------------		
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new Ajouter_Client();
			}});
		
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new Ajouter_Produit();
			}});
		
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new Ajouter_Vente();
			}});
		
		
		
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login();
			}});
		
		
		
		
		
		
//-----------table
		
this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {


				 int n=0;
				
					
					String clmn[]= {"ID","Nom","Unitee","Quantite en Stock","Prix d'achat","Prix de Vendre","Date P","Date E"};
					n=cn.afficherProduitExpirer().size();
						
					String data[][]=new String[n][8];
					int i=0;
					
					for(Produit p:cn.afficherProduitExpirer()) {
							data[i][0]=p.getIdP();
							data[i][1]=p.getNom();
							data[i][2]=p.getUnitee();
							data[i][3]=p.getQteP()+"";
							data[i][4]=p.getPrixAchat()+"";
							data[i][5]=p.getPrixVendre()+"";
							data[i][6]=sdf.format(p.getDateP())+"";
							data[i][7]=sdf.format(p.getDateE())+"";
							i++;
						}
					
					
					DefaultTableModel mod=new DefaultTableModel(data,clmn);
					jt.setModel(mod);
		
				

					
					
				
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
			
		});
		
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
