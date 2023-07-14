package com.miniprojet;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Login extends JFrame{
	public Login() {
		setTitle("Acceuil");
		setBackground(Color.gray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 400);
		setLocationRelativeTo(null);
		setLayout(null);
		
		//Declaration
		
		JLabel l1,l2,l3,l4;
		JTextField t1;
		JPasswordField t2;
		JButton btn1;
		ImageIcon img;
		
		
		
		
		//Instanciation
		l1=new JLabel("Connexion");
		l2=new JLabel("E-mail             :");
		l3=new JLabel("Mot de passe :");
		img=new ImageIcon("C:\\Users\\lenovo\\Desktop\\eclipse-workspace\\Mini Projet El-khaldi/images/img1.jpg");
		l4=new JLabel(img);
		t1=new JTextField(); 
		t2=new JPasswordField();
		btn1=new JButton("Connexion");
	
		//ajouter des proprietees
		l1.setFont(new Font("Arial",Font.PLAIN,30));
		
		
		
		//Localisation
		
			l1.setBounds(610,80, 200, 40);
			l2.setBounds(540, 140, 100, 20);
			l3.setBounds(540, 200, 100, 20);
			t1.setBounds(650, 140, 200, 20);
			t2.setBounds(650, 200, 200, 20);
			l4.setBounds(0, 0, 500, 364);
			btn1.setBounds(670, 250, 100, 20);

		
		
		//Ajouter a la fenetre
		
		add(l1);
		add(l2);
		add(l3);
		add(t1);
		add(t2);
		add(btn1);
		add(l4);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if((t1.getText().equals("admin@gmail.com")) && (t2.getText().equals("admin"))) {
				setVisible(false);
				new Accueil();
				
			}else {
				JOptionPane.showMessageDialog(null,"E-mail ou Mot de passe est incorrecte", "Erreur de connexion",
						JOptionPane.ERROR_MESSAGE);

			}
			}});
		
		
		
		setVisible(true);
		
	}

}
