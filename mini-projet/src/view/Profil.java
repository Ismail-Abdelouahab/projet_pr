package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import controller.ClientFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class Profil extends javax.swing.JPanel {
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel_1;
    public javax.swing.JLabel jLabel_3;


    public JTextField nom;
    public JTextField prenom;
    public JTextField email;
    public javax.swing.JTextField username;
    public JTextField password;
    public javax.swing.JButton modifier;
    public javax.swing.JLabel retour;
	/**
	 * Create the application.
	 */
	public Profil() {
		setBackground(Color.WHITE);
		initialize();
	}
	

	public JButton modifier() {
		return modifier;
	}
	public JLabel jLabel_1() {
		return jLabel_1;
	}
	public JLabel jLabel_3() {
		return jLabel_3;
	}
	
	

	public JLabel getRetour() {
		return retour;
	}
	
	


	public JTextField getUsername() {
		return username;
	}

	public JTextField getPassword() {
		return password;
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 245, 245));
        
        nom = new JTextField();
        nom.setEditable(false);
        nom.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        nom.setBackground(new Color(255,255,255));
        nom.setColumns(10);
        
        prenom = new JTextField();
        prenom.setEditable(false);
        prenom.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        prenom.setBackground(new Color(255,255,255));
        prenom.setColumns(10);
        
        email = new JTextField();
        email.setEditable(false);
        email.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        email.setBackground(new Color(255,255,255));
        email.setColumns(10);
        
        username = new javax.swing.JTextField();
        username.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        username.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Nom");
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        
        JLabel lblPrenom = new JLabel("Pr\u00E9nom    ");
        lblPrenom.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        
        JLabel lblEmail = new JLabel("Email ");
        lblEmail.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        
        JLabel lblUsename = new JLabel("Usename ");
        lblUsename.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
     
        
        
        password = new JTextField();
        password.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        password.setColumns(10);
        
        modifier = new javax.swing.JButton();
        modifier.setFocusable(false);
        modifier.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        modifier.setText("Modifier");
        
        retour= new javax.swing.JLabel();
        retour.setHorizontalAlignment(SwingConstants.CENTER);
        retour.setIcon(new ImageIcon(Profile.class.getResource("/images/back.png")));
        retour.setToolTipText("Back");
        retour.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
        	}
        });
        
        jLabel_1 =new javax.swing.JLabel();
        jLabel_1.setIcon(new ImageIcon("/images/friendIcon.png"));
        jLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        jLabel_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jLabel_1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
        	}
        });
        
        jLabel_3 =new javax.swing.JLabel();
        jLabel_3.setIcon(new ImageIcon("/images/mail.png"));
        jLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        jLabel_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jLabel_3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
        	}
        });
        
    
      
      


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(modifier, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(retour, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
        							.addGap(220))
        						.addGroup(layout.createSequentialGroup()
        							.addGap(184)
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        								.addComponent(lblUsename, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 88, Short.MAX_VALUE)
        								.addComponent(lblEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
        								.addComponent(lblPrenom, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
        								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lblPassword, Alignment.LEADING))
        							.addGap(5)))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(prenom, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
        						.addComponent(nom, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
        						.addComponent(email, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
        						.addComponent(username, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
        						.addComponent(password, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))))
        			.addGap(74)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jLabel_1)
        				.addComponent(jLabel_3))
        			.addGap(98))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(retour, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        							.addGap(13)
        							.addComponent(lblNewLabel))
        						.addComponent(nom, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(prenom, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblPrenom))
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(lblEmail)
        						.addComponent(email, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        					.addGap(18))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel_1)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jLabel_3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblUsename)
        				.addComponent(username, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addGap(15)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(password, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblPassword))
        			.addGap(26)
        			.addComponent(modifier, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        			.addGap(22))
        );
        panel.setLayout(null);

        
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setBounds(234, 11, 189, 60);
        panel.add(jLabel1);
        
                jLabel1.setFont(new Font("Trebuchet MS", Font.BOLD, 30)); // NOI18N
                jLabel1.setForeground(new Color(0, 102, 255));
                jLabel1.setText("ENSA CHAT");
        this.setLayout(layout);
	}
}
