package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import server.Database;

import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Dimension;

public class Room extends javax.swing.JPanel{

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Room window = new Room();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */	        String USER;

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	  public Room() {
	        initComponents();
			initialize();

	    }

	    public JLabel getLbRoom1() {
	        return lbRoom1;
	    }

	    public JLabel getLbRoom2() {
	        return lbRoom2;
	    }

	    public JLabel getLbRoom3() {
	        return lbRoom3;
	    }

	    public JLabel getLbRoom4() {
	        return lbRoom4;
	    }

	    public JLabel getLbRoom5() {
	        return lbRoom5;
	    }

	    public JLabel getLbRoom6() {
	        return lbRoom6;
	    }

	    public JLabel getLbRoom7() {
	        return lbRoom7;
	    }

	    public JLabel getLbRoom8() {
	        return lbRoom8;
	    }
	    public JLabel getLbBack_room() {
	        return lbBack_room;
	    }
	    public JList<String> getOnlineList_rp() {
	        return onlineList_rp;
	    }
	    
	    /**
	     * This method is called from within the constructor to initialize the form.
	     * WARNING: Do NOT modify this code. The content of this method is always
	     * regenerated by the Form Editor.
	     */
	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	    private void initComponents() {

	        lbRoom1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        lbRoom3 = new javax.swing.JLabel();
	        lbRoom2 = new javax.swing.JLabel();
	        lbRoom4 = new javax.swing.JLabel();
	        jLabel1 = new javax.swing.JLabel();
	        lbRoom5 = new javax.swing.JLabel();
	        lbRoom6 = new javax.swing.JLabel();
	        lbRoom7 = new javax.swing.JLabel();
	        lbRoom8 = new javax.swing.JLabel();
	        Statement stmt = null;
	        Connection conn = null;

	        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
	        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
	        jLabel1.setText("Online Users");
	        jLabel1.setToolTipText("");
	        onlineList_rp = new javax.swing.JList<>();
	        onlineList_rp.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	            	onlineList_rpMouseClicked(evt);
	            }
	        });
	        
	        	   
	        lbBack_room = new javax.swing.JLabel();

	        	       
	        
	        	     
	        
	        
	        
	        	        onlineList_rp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
	        	        onlineList_rp.setModel(new javax.swing.AbstractListModel<String>() {
	        	            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
	        	            public int getSize() { return strings.length; }
	        	            public String getElementAt(int i) { return strings[i]; }
	        	        });
	        	        onlineList_rp.setToolTipText("double-click to send a message");
	    
	        	       
	        	        lbBack_room.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
	        	        lbBack_room.setToolTipText("Back");
	       


	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        layout.setHorizontalGroup(
	        	layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(layout.createSequentialGroup()
	        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
	        				.addGroup(layout.createSequentialGroup()
	        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
	        							.addComponent(lbRoom7, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
	        							.addComponent(lbRoom3, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
	        							.addComponent(lbRoom1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
	        							.addComponent(lbRoom5, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
	        						.addComponent(lbRoom4, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
	        						.addComponent(lbRoom2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
	        						.addComponent(lbRoom6, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
	        					.addGap(45)
	        					.addComponent(onlineList_rp, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE))
	        				.addComponent(lbRoom8, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
	        				.addGroup(layout.createSequentialGroup()
	        					.addGap(92)
	        					.addComponent(jLabel2))
	        				.addGroup(layout.createSequentialGroup()
	        					.addGap(23)
	        					.addComponent(lbBack_room)
	        					.addGap(189)
	        					.addComponent(jLabel1)))
	        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	        	layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(layout.createSequentialGroup()
	        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        				.addGroup(layout.createSequentialGroup()
	        					.addGap(46)
	        					.addComponent(jLabel2)
	        					.addGap(11)
	        					.addComponent(lbBack_room)
	        					.addGap(30)
	        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        						.addComponent(lbRoom1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
	        						.addComponent(lbRoom2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
	        					.addGap(18)
	        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        						.addComponent(lbRoom3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
	        						.addComponent(lbRoom4, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
	        					.addGap(21)
	        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        						.addComponent(lbRoom6, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
	        						.addComponent(lbRoom5, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
	        					.addGap(61)
	        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        						.addComponent(lbRoom8, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
	        						.addComponent(lbRoom7, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
	        				.addGroup(layout.createSequentialGroup()
	        					.addGap(74)
	        					.addComponent(jLabel1)
	        					.addGap(33)
	        					.addComponent(onlineList_rp, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)))
	        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        this.setLayout(layout);
	    }// </editor-fold>//GEN-END:initComponents
	    
	    
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel lbRoom1;
	    private javax.swing.JLabel lbRoom2;
	    private javax.swing.JLabel lbRoom3;
	    private javax.swing.JLabel lbRoom4;
	    private javax.swing.JLabel lbRoom5;
	    private javax.swing.JLabel lbRoom6;
	    private javax.swing.JLabel lbRoom7;
	    private javax.swing.JLabel lbBack_room;

	    private javax.swing.JLabel lbRoom8;
	    public javax.swing.JList<String> onlineList_rp;
	    private void onlineList_rpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onlineList_rpMouseClicked

	    }//G
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
