package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;


import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Login extends javax.swing.JPanel{

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public Login() {
		setVisible(true);

		setForeground(Color.WHITE);
		setBorder(null);
		setBackground(new Color(255, 255, 255));
		initialize();
		initComponents();
	}

    public JButton getBtOK() {
        return btOK;
    }
    public JButton getBtSignUp_welcome() {
        return btOK_1;
    }

   

    public JTextField getTfNickname() {
        return tfNickname;
    }

   

    public JPasswordField getTfPass() {
        return tfPass;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNickname = new javax.swing.JTextField();
        btOK = new javax.swing.JButton();
        btOK.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        tfPass = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Century", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Login");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel2.setText("Username");

        tfNickname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfNickname.setToolTipText("Username must be unique");

        btOK.setBackground(Color.WHITE);
        btOK.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btOK.setForeground(new Color(51, 51, 204));
        btOK.setText("Login");

        tfPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfPass.setToolTipText("Nickname must be unique");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel6.setText("Password");
        
        JPanel panel = new JPanel();
        panel.setForeground(Color.WHITE);
        panel.setBackground(new Color(51, 51, 204));
        
                btOK_1 = new javax.swing.JButton();
        btOK_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btOK_1.setText("SignUp");
        btOK_1.setForeground(new Color(0, 204, 51));
        btOK_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        btOK_1.setBackground(Color.WHITE);
        btOK_1.addMouseListener((MouseListener) new MouseAdapter() {
	           public void mouseClicked(MouseEvent e) {
	       			new SignUpPanel();
	       			setVisible(false);
	       			
	           }
	       });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(332, Short.MAX_VALUE)
        			.addComponent(jLabel1)
        			.addGap(318))
        		.addComponent(panel, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(136)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(btOK, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
        					.addComponent(btOK_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
        					.addGap(229))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(tfPass, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
        						.addComponent(tfNickname, Alignment.TRAILING, 225, 225, 225))
        					.addContainerGap(253, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
        			.addComponent(jLabel1)
        			.addGap(34)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(tfNickname, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        			.addGap(31)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(tfPass, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        			.addGap(43)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btOK_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btOK))
        			.addGap(70))
        );
        
        JLabel txtpnEnsaChat = new JLabel();
        txtpnEnsaChat.setFont(new Font("Tahoma", Font.PLAIN, 21));
        txtpnEnsaChat.setForeground(Color.WHITE);
        txtpnEnsaChat.setBounds(229, 150, 502, 394);
        txtpnEnsaChat.setText("ENSA CHAT");
        panel.add(txtpnEnsaChat);
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOK;
    private javax.swing.JButton btOK_1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tfNickname;
    private javax.swing.JPasswordField tfPass;
}
