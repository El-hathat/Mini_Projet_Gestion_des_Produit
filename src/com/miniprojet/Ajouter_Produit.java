package com.miniprojet;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import javax.swing.JSpinner.DateEditor;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Ajouter_Produit extends JFrame implements ActionListener{
	
//-------------------------------------------Declaration--------------------------------------------------------------------
	Connect cn=Connect.getInstance();
	JTable jt=new JTable();
	
			JPanel pn1,pn2;
			JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
			JTextField t1,t2,t3,t4,t5,t7;
			JComboBox<String> t6;
			JSpinner sp,sp1;
			JButton btn1,btn2,btn3,btn4,btn5,btn7,btn8;;
			 JScrollPane scrollp;
			 SpinnerDateModel model,model1;
			 SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			 
//Constructeur			
	public Ajouter_Produit() {
		setTitle("Ajouter Un Produit");
		setBackground(Color.gray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1100, 600);
		setLocationRelativeTo(null);
		
		setLayout(null);
		
		
//----------------------------------------------Instanciation-------------------------------------------------------------------
		l1=new JLabel("Ajouter Un Produit");
		l2=new JLabel("Id                   :");
		l3=new JLabel("nom                  :");
		l4=new JLabel("Quantite             :");
		l5=new JLabel("Prix d'achat         :");
		l6=new JLabel("Prix de vente        :");
		l7=new JLabel("Unitée               :");
		l8=new JLabel("Date de Production   :");
		l9=new JLabel("Date de Experation   :");
		l10=new JLabel("Rechercher :");
		
		t1=new JTextField(); 
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t7=new JTextField();
	
		
		String ef[]= {"KG","Paquet","Litre","unité"};
		t6=new JComboBox<String>(ef);
		

		
		model=new SpinnerDateModel();
		 sp=new JSpinner(model);
		JComponent editeur=new JSpinner.DateEditor(sp, "dd/MM/yyyy");
		sp.setEditor(editeur);
		
		 model1=new SpinnerDateModel();
		 sp1=new JSpinner(model1);
		JComponent editeur1=new JSpinner.DateEditor(sp1, "dd/MM/yyyy");
		sp1.setEditor(editeur1);
		
		btn1=new JButton("Ajouter");
		btn2=new JButton("vider ");
		btn3=new JButton("Retour ");
		btn4=new JButton("Rechercher ");
		
		jt=new JTable();
		scrollp=new JScrollPane(jt);
		
		btn5=new JButton("Actualiser");
	
		btn7=new JButton("Modifier");
		btn8=new JButton("Supprimer");
		
		//PROPRIETE
		l1.setFont(new Font("Arial",Font.PLAIN,30));
		
		
		
	
		
//--------------------------------------------Localisation----------------------------------------------------------------------
		
		
			l1.setBounds(200,20, 300,40);
			
			
			l2.setBounds(100, 120, 200, 20);
			t1.setBounds(360, 120, 200, 20);
			
			l3.setBounds(100, 160, 200, 20);
			t2.setBounds(360, 160, 200, 20);
			
			l4.setBounds(100,200, 200, 20);
			t3.setBounds(360, 200, 200, 20);
			
			l5.setBounds(100, 240, 200, 20);
			t4.setBounds(360, 240, 200, 20);
			
			l6.setBounds(100, 280, 200, 20);
			t5.setBounds(360, 280, 200, 20);
			
			l7.setBounds(100,320, 200, 20);
			t6.setBounds(360, 320, 200, 20);
			
			l8.setBounds(100, 360, 200, 20);
			sp.setBounds(360, 360, 200, 20);
			
			l9.setBounds(100, 400, 200, 20);
		    sp1.setBounds(360, 400, 200, 20);
			
			l10.setBounds(580, 5, 100, 20);
			t7.setBounds(680, 5, 100, 20);
			btn4.setBounds(780, 5, 110, 20);
			
			scrollp.setBounds(580, 30, 500, 500);
			
			btn3.setBounds(10,10, 100,20);
			
			
			btn1.setBounds(30, 490, 80, 20);
			btn2.setBounds(130, 490, 70, 20);
			btn5.setBounds(230, 490, 100, 20);
			btn7.setBounds(356,490,90,20);
			btn8.setBounds(470, 490, 100, 20);
			
			
		
		
		
//--------------------------------------------------Ajouter a la fenetre--------------------------------------------------------
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(t6);
		add(t7);
		add(sp);
		add(sp1);
		
		add(scrollp);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
	
		add(btn7);
		add(btn8);
		
		
//---------------------------------------------------la boutton ajouter---------------------------------------------------------
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if(t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("") || t5.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"S'il vous plait, Remplir tout les champs", "Un champ vide !",
								JOptionPane.ERROR_MESSAGE);
					}else {
					
						cn.ajouterProduit(new Produit(t1.getText(), t2.getText(),(String) t6.getSelectedItem(),Double.parseDouble(t3.getText()),Double.parseDouble(t4.getText()),Double.parseDouble(t5.getText()),(Date) sp.getValue(),(Date) sp1.getValue()));
						afficherP();
						vider();
					}
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					
				
			}});
		
//------------------------------------------la boutton vider-------------------------------------------------------------------
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			vider();
			}});
		
//--------------------------------------------la boutton retour-----------------------------------------------------------------
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Accueil();
			}});
		
//------------------------------------------------la boutton rechercher----------------------------------------------------------
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				 int n=0;
					ResultSet rs=cn.chercherProduit(t7.getText());
					ResultSet rs1=cn.chercherProduit(t7.getText());
					
					String clmn[]= {"ID","Nom","Unitee","Quantite en Stock","Prix d'achat","Prix de Vendre","Date P","Date E"};
					try {while(rs1.next()){n++;}} catch (Exception e2){}
						
					String data[][]=new String[n][8];
					int i=0;
					
					try {
						while(rs.next()) {
							data[i][0]=rs.getString(1);
							data[i][1]=rs.getString(2);
							data[i][2]=rs.getString(3);
							data[i][3]=rs.getString(4);
							data[i][4]=rs.getString(5);
							data[i][5]=rs.getString(6);
							data[i][6]=rs.getString(7);
							data[i][7]=rs.getString(8);
						
							i++;
							n++;
						}
					}catch (Exception e1) {
						e1.printStackTrace();
					}
					
					DefaultTableModel mod=new DefaultTableModel(data,clmn);
					jt.setModel(mod);
		
				
				
			}});
		
//----------------------------------------la boutton Actualiser---------------------------------------------------------------
				btn5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					afficherP();
					}});
		
				
//------------------------------------------------la boutton modifier---------------------------------------------------------
				btn7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String code="";
						try {
							int sr=jt.getSelectedRow();
							if(sr>=0) {
								 code=(jt.getValueAt(sr, 0).toString());
							}

							cn.modifierProduit(new Produit(t1.getText(), t2.getText(),(String) t6.getSelectedItem(),Double.parseDouble(t3.getText()),Double.parseDouble(t4.getText()),Double.parseDouble(t5.getText()),(Date) sp.getValue(),(Date) sp1.getValue()),code);
							afficherP();
							vider();
							JOptionPane.showMessageDialog(null,"Modifier avec succes", "Info",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception e1) {
						e1.printStackTrace();
							JOptionPane.showMessageDialog(null,"Erreur de modification", "Erreur",
									JOptionPane.ERROR_MESSAGE);
						}
						
						
						
					afficherP();
						
						
						
					}});
				
				
				
//------------------------------------------la boutton Supprimer---------------------------------------------------------------
				btn8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String code="";
						int sr=jt.getSelectedRow();
						if(sr>=0) {
						 code=jt.getValueAt(sr, 0).toString();
						
						}
						int a = JOptionPane.showConfirmDialog(null,"Voulez-vous vraiment supprimer?", 
								"Bonjour", JOptionPane.YES_NO_OPTION);
								if(a == JOptionPane.YES_OPTION) {
									
									cn.supprimerProduit(code);
									afficherP();
									vider();
					}
						
						
					}});
				
				
				
				
				
				
//-----------------------------------------afficher tous les clients quand la fenetre ouvrir------------------------------------
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {

				afficherP();
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
		
//-------------------------------afficher l'element selectionner de JTable dans des TextFields----------------------------------
				jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent e) {
						try {int sr=jt.getSelectedRow();
						if(sr>=0) {
							t1.setText(jt.getValueAt(sr, 0).toString());
							t2.setText(jt.getValueAt(sr, 1).toString());
							t3.setText(jt.getValueAt(sr,3).toString());
							t4.setText(jt.getValueAt(sr,4).toString());
							t5.setText(jt.getValueAt(sr,5).toString());
							t6.setSelectedItem(jt.getValueAt(sr, 2).toString());
							model.setValue(sdf.parse((String) jt.getValueAt(sr,6)));
							model1.setValue(sdf.parse((String) jt.getValueAt(sr,7)));
							
						}}catch (Exception e1) {
							
						}
						
					}
				});
		
		
		setVisible(true);
}


//----------------------------------------------------la methode vider------------------------------------------------------------	
			public void vider() {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setSelectedIndex(0);
				
				
				try {
					model.setValue((sdf.parse(sdf.format(new Date()))));
					model1.setValue((sdf.parse(sdf.format(new Date()))));
				} catch (ParseException e1) {
				}
			}




		

		
//---------------------------------------------la methode Afficher--------------------------------------------------------------
			public void afficherP() {

				 int n=0;
					ResultSet rs=cn.afficherProduit();
					ResultSet rs1=cn.afficherProduit();
					
					String clmn[]= {"ID","Nom","Unitee","Quantite en Stock","Prix d'achat","Prix de Vendre","Date P","Date E"};
					try {while(rs1.next()){n++;}} catch (Exception e2){}
						
					String data[][]=new String[n][8];
					int i=0;
					
					try {
						while(rs.next()) {

							data[i][0]=rs.getString(1);
							data[i][1]=rs.getString(2);
							data[i][2]=rs.getString(3);
							data[i][3]=rs.getString(4);
							data[i][4]=rs.getString(5);
							data[i][5]=rs.getString(6);
							data[i][6]=rs.getString(7);
							data[i][7]=rs.getString(8);
						
							i++;
							n++;
						}
					}catch (Exception e1) {
						e1.printStackTrace();
					}
					
					DefaultTableModel mod=new DefaultTableModel(data,clmn);
					jt.setModel(mod);
		
					
			}


			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
}
