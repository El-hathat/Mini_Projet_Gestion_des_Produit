package com.miniprojet;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import javax.swing.JSpinner.DateEditor;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Ajouter_Vente extends JFrame implements ActionListener{
	
//--------------------------------------------Declaration--------------------------------------------------------------
	
	Connect cn=Connect.getInstance();
	JTable jt=new JTable();
	DefaultTableModel mod;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JTextField t1,t2,t5,t6;
	JComboBox<String> t3;
	SpinnerModel model;
	JSpinner sp;
	JButton btn1,btn2,btn3,btn4,btn5,btn7,btn8;
	 JScrollPane scrollp;
		
	 SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
//Constructeur
	public Ajouter_Vente() {
		setTitle("Ajouter une vendre");
		setBackground(Color.gray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1100, 600);
		setLocationRelativeTo(null);
		
		setLayout(null);
		
		
		 
		
		
//--------------------------------------------Instanciation------------------------------------------------------------------
		l1=new JLabel("Ajouter Une Vente");
		l2=new JLabel("Code Client          :");
		l3=new JLabel("Nom Complet de Client:");
		l4=new JLabel("Garantie valable jusqu'a :");
		l5=new JLabel("Nom du Produit    :");
		l6=new JLabel("Quantité             :");
		l7=new JLabel("Rechercher :");
		l8=new JLabel("Le Montant a paye est :");
		l9=new JLabel("0.0 DH");
		l10=new JLabel("Facture N° : ");
		l11=new JLabel();
		t1=new JTextField(); 
		t2=new JTextField();
		
		
		t5=new JTextField();
		t6=new JTextField();
		
		
		t3=new JComboBox<String>(cn.lesNomsProduit());
		
		model=new SpinnerDateModel();
		sp=new JSpinner(model);
		JComponent editeur=new JSpinner.DateEditor(sp, "dd/MM/yyyy");
		sp.setEditor(editeur);
		btn1=new JButton("Ajouter");
		btn2=new JButton("vider ");
		btn3=new JButton("Retour ");
		btn4=new JButton("Rechercher");
		
	
		scrollp=new JScrollPane(jt);
		
		btn5=new JButton("Actualiser");
		btn7=new JButton("Modifier");
		btn8=new JButton("Supprimer");
		
//----------------------------------------PROPRIETE-----------------------------------------------------------------------
		l1.setFont(new Font("Arial",Font.PLAIN,30));
		l8.setFont(new Font("Arial",Font.PLAIN,20));
		l9.setFont(new Font("Arial",Font.PLAIN,20));
		l10.setFont(new Font("Arial",Font.PLAIN,15));
		l11.setFont(new Font("Arial",Font.PLAIN,15));
		
//---------------------------------------Localisation---------------------------------------------------------------------
		
		
			l1.setBounds(200,20, 300,40);
			
			
			l2.setBounds(100, 120, 200, 20);
			t1.setBounds(360, 120, 200, 20);
			
			l3.setBounds(100, 160, 200, 20);
			t2.setBounds(360, 160, 200, 20);
			
			l4.setBounds(100,200, 200, 20);
			sp.setBounds(360, 200, 200, 20);
			
			l5.setBounds(100, 240, 200, 20);
			t3.setBounds(360, 240, 200, 20);
			
			l6.setBounds(100, 280, 200, 20);
			t5.setBounds(360, 280, 200, 20);
			
			l7.setBounds(580, 5, 100, 20);
			t6.setBounds(680, 5, 100, 20);
			btn4.setBounds(780, 5, 110, 20);
		
			l8.setBounds(70,370,300,40);
			l9.setBounds(290,370,100,40);
			
			l10.setBounds(200,70,200,20);
			l11.setBounds(287,70,100,20);
			
			scrollp.setBounds(580, 30, 500, 500);
			
			btn3.setBounds(10,10, 100,20);
			
			
		
			
			
			btn1.setBounds(30, 490, 80, 20);
			btn2.setBounds(130, 490, 70, 20);
			btn5.setBounds(230, 490, 100, 20);
			btn7.setBounds(356,490,90,20);
			btn8.setBounds(470, 490, 100, 20);
			
			
			
			

		
		
		
//-----------------------------------------------Ajouter a la fenetre----------------------------------------------------------
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(t1);
		add(t2);
		add(t3);
		add(l10);
		add(l11);
		add(t5);
		add(t6);
		add(sp);
		add(scrollp);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
	
		add(btn7);
		add(btn8);
		
		
	//------------------------------Ajouter-----------------------------------------------------------------------------------	
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String idcl, String nomcplt, String nomP, double qteV,double montant,Date dateGarantie)
				try {
					if(t1.getText().equals("") || t5.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"S'il vous plait, Remplir tout les champs", "Un champ vide !",
								JOptionPane.ERROR_MESSAGE);
					}else {
						String nom=t3.getSelectedItem().toString();
						double q=Double.parseDouble(t5.getText()),qdb=cn.QuantiteDB(nom);
				
					
						if(q>qdb) {
							JOptionPane.showMessageDialog(null,"Quantite est insuffisant", "Probleme de Stock !",
									JOptionPane.ERROR_MESSAGE);
						}else {
					double p=cn.prixVendre((String) t3.getSelectedItem());
						cn.ajouterFacture(new Facture(t1.getText(), t2.getText(),(String) t3.getSelectedItem(),Double.parseDouble(t5.getText()),Double.parseDouble(t5.getText())*p,(Date)sp.getValue()));
						cn.deminuerQuantite((String) t3.getSelectedItem(), Double.parseDouble(t5.getText()));
						afficherF();
						vider();
					}}
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
			}});
		
//------------------------------------vider------------------------------------------------------------------------
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vider();
				
			}});
		
		//-------------------------retour--------------------------------------------------------------------------------
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Accueil();
			}});
	//-------------------------------------Rechercher-----------------------------------------------------------------------	
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				 int n=0;
					
					ResultSet rs1=cn.chercherFacture(t6.getText());
					

					String clmn[]= {"N.facture","Code cient","Nom Complet","Produit","Quantite","Date de Vendre","Montant","Date Garantie"};
					try {while(rs1.next()){n++;}} catch (Exception e2){}
					ResultSet rs=cn.chercherFacture(t6.getText());	
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
					
					 mod=new DefaultTableModel(data,clmn);
					jt.setModel(mod);
		
				
				
			}});
		
//-------------------------------------Acctualiser-----------------------------------------------------------------------	
				btn5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					afficherF();
					}});
//-------------------------------------Modifier-----------------------------------------------------------------------	
				btn7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String code="";
						try {
							if(t1.getText().equals("") || t5.getText().equals("")) {
								JOptionPane.showMessageDialog(null,"S'il vous plait, Remplir tout les champs", "Un champ vide !",
										JOptionPane.ERROR_MESSAGE);
							}else {
								String nom=t3.getSelectedItem().toString();
								double q=Double.parseDouble(t5.getText()),qdb=cn.QuantiteDB(nom);
							
							
								if(q>qdb) {
									JOptionPane.showMessageDialog(null,"Quantite est insuffisant", "Probleme de Stock !",
											JOptionPane.ERROR_MESSAGE);
								}else {
							double p=cn.prixVendre((String) t3.getSelectedItem());
							int sr=jt.getSelectedRow();
							if(sr>=0) {
								 code=(jt.getValueAt(sr, 0).toString());
							}

							cn.modifierFacture(new Facture(t1.getText(), t2.getText(),(String) t3.getSelectedItem(),Double.parseDouble(t5.getText()),Double.parseDouble(t5.getText())*p,(Date)sp.getValue()),code);
								afficherF();
							vider();
							JOptionPane.showMessageDialog(null,"Modifier avec succes", "Info",
									JOptionPane.INFORMATION_MESSAGE);
								}
								}
						} catch (Exception e1) {
						e1.printStackTrace();
							JOptionPane.showMessageDialog(null,"Erreur de modification", "Erreur",
									JOptionPane.ERROR_MESSAGE);
						}
						
						
						
					
					}});
//-------------------------------------Supprimer-----------------------------------------------------------------------	
				btn8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int code=0;
						int sr=jt.getSelectedRow();
						if(sr>=0) {
						 code=Integer.parseInt(jt.getValueAt(sr, 0).toString());
						
						}
						int a = JOptionPane.showConfirmDialog(null,"Voulez-vous vraiment supprimer?", 
								"Bonjour", JOptionPane.YES_NO_OPTION);
								if(a == JOptionPane.YES_OPTION) {
									
									cn.supprimerFacture(code);
									afficherF();
									vider();		
								
					}
						
					}});		
		
		
//-------------afficher tous les Facture quand la fenetre ouvrir------------------------------------------------------------
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {


				 afficherF();
				

					t2.setEditable(false);
					
				
				
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
		
//-------------------afficher l'element selectionner de JTable dans des TextFields-----------------------------------------------
		jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {int sr=jt.getSelectedRow();
				if(sr>=0) {
					l11.setText(jt.getValueAt(sr, 0).toString());
					t1.setText(jt.getValueAt(sr, 1).toString());
					t2.setText(jt.getValueAt(sr, 2).toString());
					t3.setSelectedItem(jt.getValueAt(sr,3).toString());
					//t4.setText(jt.getValueAt(sr,4).toString());
					t5.setText(jt.getValueAt(sr,4).toString());
					//t6.setSelectedItem(jt.getValueAt(sr, 2).toString());
					l9.setText(jt.getValueAt(sr, 6).toString()+ " DH");
					model.setValue(sdf.parse((String) jt.getValueAt(sr,7)));
					
				}}catch (Exception e1) {
					
				}
				
			}
		});

		
		
//-----------------------------------afficheer les info de client d'apres son id--------------------------------------		
	
		
		
		
		
		
		t1.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {

			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
try {
				
					
					ResultSet rs=cn.infoClient(t1.getText());
					while(rs.next()){
						
							t2.setText(rs.getString(1)+" "+rs.getString(2));
						
						
					}
					
}catch (Exception e1) {
	e1.printStackTrace();
}
				
				
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {


				
				
			}
		});
		
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
//------------------------------------------la methode vider-----------------------------------------------------------------	
	public void vider() {
		t1.setText("");
		t2.setText("");
		t3.setSelectedIndex(0);
		t5.setText("");
		t6.setText("");
		
		
		try {
			model.setValue((sdf.parse(sdf.format(new Date()))));
			
		} catch (ParseException e1) {
		}
	}







//----------------------------------------------------la methode Afficher----------------------------------------------------
	public void afficherF() {
		 //`numf`, `idCl`, `nomcplt`, `nomP`, `qteV`, `dateVendre`, `montant`, `dateGarantie
		 int n=0;
			ResultSet rs=cn.afficherFacture();
			ResultSet rs1=cn.afficherFacture();
			
			String clmn[]= {"N.facture","Code cient","Nom Complet","Produit","Quantite","Date de Vendre","Montant","Date Garantie"};
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
				
				
					l11.setText((cn.numFacture()+1)+"");
					
				
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			
			 mod=new DefaultTableModel(data,clmn);
			jt.setModel(mod);

			
	}


}
