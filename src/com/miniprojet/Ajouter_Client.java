package com.miniprojet;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Ajouter_Client extends JFrame implements ActionListener{
//------------------------------------Declaration--------------------------------------------------------
	Connect cn=Connect.getInstance();
	JTable jt=new JTable();

			JPanel pn1,pn2;
			JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
			JTextField t1,t2,t3,t4,t5,t8,t9;
			JComboBox<String> t6,t7;
			JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
			 JScrollPane scrollp;
			 SpinnerDateModel model;
			 SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	
			 
//------------------------------Constructeur qui contient le code de la fenetre ajouter_client----------------------------
	public Ajouter_Client() {
		
//-------------Configurer quelque Propriete de la fenetre-------------------------------------------------------------
		setTitle("Acceuil");
		setBackground(Color.gray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1100, 600);
		setLocationRelativeTo(null);
		
		setLayout(null);
		
//--------------------------------------Instanciation---------------------------------------------------------------------
		l1=new JLabel("Ajouter Un Client");
		l2=new JLabel("Nom                  :");
		l3=new JLabel("Prenom               :");
		l4=new JLabel("Adresse              :");
		l5=new JLabel("ville                :");
		l6=new JLabel("E-mail               :");
		l7=new JLabel("Sexe                 :");
		l8=new JLabel("Type de Client       :");
		l9=new JLabel("Telephone            :");
		l10=new JLabel("Date de naissance   :");
		
		l11=new JLabel("Rechercher :");
		
		
		t1=new JTextField(); 
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		
		String g[]= {"Homme","Femme"};
		t6=new JComboBox<String>(g);
		String ef[]= {"Potentiel","actuel","fidéle","ancien"};
		t7=new JComboBox<String>(ef);
		t8=new JTextField();
		t9=new JTextField();
		
		model=new SpinnerDateModel();
		JSpinner sp=new JSpinner(model);
		JComponent editeur=new JSpinner.DateEditor(sp, "dd/MM/yyyy");
		sp.setEditor(editeur);
		
		btn1=new JButton("Ajouter");
		btn2=new JButton("vider ");
		btn3=new JButton("Retour ");
		btn4=new JButton("Rechercher");
		t9=new JTextField();
		
		scrollp=new JScrollPane(jt);
		
	
		btn5=new JButton("Actualiser");
	
		btn7=new JButton("Modifier");
		btn8=new JButton("Supprimer");
		
		
		
//-----------------------------------PROPRIETE-----------------------------------------------------------------
		l1.setFont(new Font("Arial",Font.PLAIN,30));
		
		
		
//----------------------------------Localisation--------------------------------------------------------------
		
		
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
			t7.setBounds(360, 360, 200, 20);
			
			l9.setBounds(100, 400, 200, 20);
		    t8.setBounds(360, 400, 200, 20);
			
			l10.setBounds(100,440, 200, 20);
			sp.setBounds(360,440, 200, 20);
			
			scrollp.setBounds(580, 30, 500, 500);
			
			btn3.setBounds(10,10, 100,20);
			
			l11.setBounds(580, 5, 100, 20);
			t9.setBounds(680, 5, 100, 20);
			btn4.setBounds(790, 5, 110, 20);
			
			btn1.setBounds(30, 490, 80, 20);
			btn2.setBounds(130, 490, 70, 20);
			btn5.setBounds(230, 490, 100, 20);
			btn7.setBounds(356,490,90,20);
			btn8.setBounds(470, 490, 100, 20);
			
			
			
//---------------------------------------Ajouter a la fenetre-----------------------------------------------------------
		
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
		add(t8);
		add(sp);
		add(scrollp);
		add(btn1);
		add(btn2);
		add(btn3);
		
		
		add(l11);
		add(t9);
		add(btn4);
		
		add(btn5);
	
		add(btn7);
		add(btn8);
		
		
//------------------------les actions des composants-------------------------------------------------------------------	
		
		//la boutton ajouter
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("") || t5.getText().equals("") ||  t8.getText().equals("") ) {
						JOptionPane.showMessageDialog(null,"S'il vous plait, Remplir tout les champs", "Un champ vide !",
								JOptionPane.ERROR_MESSAGE);
					}else {
						cn.ajouterClient(new Client(t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText(),(String) t6.getSelectedItem(),(String) t7.getSelectedItem(), t8.getText(),(Date)sp.getValue()));
						afficher();
						vider();}
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					
				
				
				
				
				
			}});
		
		//la boutton vider
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			vider();
			}});
		
		// la boutton retour
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Accueil();
			}});
		
		//la boutton Acctualiser
		
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			afficher();
			}});
		
		
		
		//la boutton modifier
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code="";
				try {
					int sr=jt.getSelectedRow();
					if(sr>=0) {
						 code=(jt.getValueAt(sr, 0).toString());
						 
					}
					if(t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("") || t5.getText().equals("") ||  t8.getText().equals("") ) {
						JOptionPane.showMessageDialog(null,"S'il vous plait, Remplir tout les champs", "Un champ vide !",
								JOptionPane.ERROR_MESSAGE);
					}else {
					cn.modifierClient(new Client(t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText(),(String) t6.getSelectedItem(),(String) t7.getSelectedItem(), t8.getText(),(Date)sp.getValue()),code);
					afficher();
					vider();
					JOptionPane.showMessageDialog(null,"Modifier avec succes", "Info",
							JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (DateinvalideException e1) {
				
					JOptionPane.showMessageDialog(null,"Erreur de modification", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			afficher();
				
				
				
			}});
		
		
		
		//la boutton Supprimer
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
							
							cn.supprimerClient(code);
							afficher();
							vider();		
						
			}
				
				
			}});

		
		//la boutton chercher
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 int n=0;
					ResultSet rs=cn.chercherClient(t9.getText());
					ResultSet rs1=cn.chercherClient(t9.getText());
					String clmn[]= {"ID","Nom","Prenom","Adreese","Ville","E-mail","Sexe","Type-Client","Telephone","Date de Naissance"};
					try {while(rs1.next()){n++;}} catch (Exception e2){}
						
					String data[][]=new String[n][10];
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
							data[i][8]=rs.getString(9);
							data[i][9]=rs.getString(10);
							i++;
							n++;
						}
					}catch (Exception e1) {
						
					}
					
					DefaultTableModel md=new DefaultTableModel(data,clmn);
					jt.setModel(md);

				vider();
				
			}});
			
//afficher l'element selectionner de JTable dans des TextFields
		jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {int sr=jt.getSelectedRow();
				if(sr>=0) {
					t1.setText(jt.getValueAt(sr, 1).toString());
					t2.setText(jt.getValueAt(sr, 2).toString());
					t3.setText(jt.getValueAt(sr, 3).toString());
					t4.setText(jt.getValueAt(sr, 4).toString());
					t5.setText(jt.getValueAt(sr,5).toString());
					t6.setSelectedItem(jt.getValueAt(sr, 6).toString());
					t7.setSelectedItem(jt.getValueAt(sr, 7).toString());
					t8.setText(jt.getValueAt(sr, 8).toString());
					model.setValue(sdf.parse((String) jt.getValueAt(sr,9)));

					
				}}catch (Exception e1) {
					
				}
				
			}
		});

			

			
		
		
//afficher tous les clients quand la fenetre ouvrir
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
			afficher();
		
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


	
	
//la methode Afficher
	public void afficher() {
		
		 int n=0;
			ResultSet rs=cn.afficherClient();
			ResultSet rs1=cn.afficherClient();
			String clmn[]= {"ID","Nom","Prenom","Adreese","Ville","E-mail","Sexe","Type-Client","Telephone","Date de Naissance"};
			try {while(rs1.next()){n++;}} catch (Exception e2){}
				
			String data[][]=new String[n][10];
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
					data[i][8]=rs.getString(9);
					data[i][9]=rs.getString(10);
					i++;
					n++;
				}
			}catch (Exception e1) {
				
			}
			
			DefaultTableModel md=new DefaultTableModel(data,clmn);
			jt.setModel(md);
			
	}
	
	
	
//la methode vider	
	public void vider() {
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t8.setText("");
		t6.setSelectedIndex(0);
		t7.setSelectedIndex(0);
		
		try {
			model.setValue((sdf.parse(sdf.format(new Date()))));
		} catch (ParseException e1) {
		}
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
