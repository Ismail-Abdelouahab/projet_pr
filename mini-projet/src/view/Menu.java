package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import controller.ClientFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Menu extends javax.swing.JPanel {
    private javax.swing.JButton contact;
    private javax.swing.JButton btnProfil;
    private javax.swing.JButton Logout;
    private javax.swing.JButton group;
    private javax.swing.JLabel jLabel1;

	/**
	 * Create the application.
	 */
	public Menu() {
		setBackground(Color.WHITE);
		initialize();
		
	}
	
	public JButton getcontact() {
        return contact;
    }
	
	public JButton getProfil() {
        return btnProfil;
    }
	
	public JButton getLogOut() {
        return Logout;
    }
	
	public JButton getgroups() {
        return group;
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 245, 245));

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/images/icons8-chat.gif")));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(184)
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(191, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(100, Short.MAX_VALUE))
        );
        panel.setLayout(null);
        
        
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setBounds(206, 11, 189, 60);
        panel.add(jLabel1);
        
                jLabel1.setFont(new Font("Trebuchet MS", Font.BOLD, 30)); // NOI18N
                jLabel1.setForeground(new Color(0, 102, 255));
                jLabel1.setText("ENSA CHAT");
                contact = new javax.swing.JButton();
                contact.setBorder(null);
                contact.setFocusable(false);
                contact.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                	}
                });
                contact.setBackground(new Color(245, 245, 245));
                contact.setBounds(20, 94, 152, 60);
                panel.add(contact);
                
                        contact.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
                        contact.setForeground(new Color(0, 102, 255));
                        contact.setText("Users");
                        
                        btnProfil = new javax.swing.JButton();
                        btnProfil.setBorder(null);
                        btnProfil.setBackground(new Color(245, 245, 245));
                        btnProfil.setBounds(165, 94, 175, 60);
                        btnProfil.setFocusable(false);
                        panel.add(btnProfil);
                        btnProfil.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        	}
                        });
                        btnProfil.setText("profil");
                        btnProfil.setForeground(new Color(0, 102, 255));
                        btnProfil.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
                        
                        group = new javax.swing.JButton();
                        group.setBorder(null);
                        group.setBackground(new Color(245, 245, 245));
                        group.setText("Groups");
                        group.setFocusable(false);
                        group.setForeground(new Color(0, 102, 255));
                        group.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
                        group.setBounds(337, 94, 175, 60);
                        panel.add(group);
                        group.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        	}
                        });
                        
                        Logout = new javax.swing.JButton(); 
                        Logout.setBorder(null);
                        Logout.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        	}
                        });
                        Logout.setBackground(new Color(245, 245, 245));
                        Logout.setText("Log Out");
                        Logout.setFocusable(false);
                        Logout.setForeground(new Color(0, 102, 255));
                        Logout.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
                        Logout.setBounds(522, 94, 136, 60);
                        panel.add(Logout);
        this.setLayout(layout);
	}

}
