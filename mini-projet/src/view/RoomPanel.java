/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JLabel;

import javax.swing.JList;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author AnhTu
 */
public class RoomPanel extends javax.swing.JPanel {

    /**
     * Creates new form RoomPanel
     */
    public RoomPanel() {
        initComponents();
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
    
    public JLabel getLbBack_room_2() {
        return lbBack_room_2;
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
        lbRoom3 = new javax.swing.JLabel();
        lbRoom2 = new javax.swing.JLabel();
        lbRoom4 = new javax.swing.JLabel();
        lbRoom5 = new javax.swing.JLabel();
        lbRoom6 = new javax.swing.JLabel();
        lbRoom7 = new javax.swing.JLabel();
        lbRoom8 = new javax.swing.JLabel();

        lbRoom1.setBackground(new Color(51, 51, 255));
        lbRoom1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lbRoom1.setForeground(Color.WHITE);
        lbRoom1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRoom1.setText("Group 1");
        lbRoom1.setOpaque(true);

        lbRoom3.setBackground(new Color(51, 51, 255));
        lbRoom3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lbRoom3.setForeground(Color.WHITE);
        lbRoom3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRoom3.setText("Group 3");
        lbRoom3.setOpaque(true);

        lbRoom2.setBackground(new Color(51, 51, 255));
        lbRoom2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lbRoom2.setForeground(Color.WHITE);
        lbRoom2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRoom2.setText("Group 2");
        lbRoom2.setOpaque(true);

        lbRoom4.setBackground(new Color(51, 51, 255));
        lbRoom4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lbRoom4.setForeground(Color.WHITE);
        lbRoom4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRoom4.setText("Group 4");
        lbRoom4.setOpaque(true);

        lbRoom5.setBackground(new Color(51, 51, 255));
        lbRoom5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lbRoom5.setForeground(Color.WHITE);
        lbRoom5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRoom5.setText("Group 5");
        lbRoom5.setOpaque(true);

        lbRoom6.setBackground(new Color(51, 51, 255));
        lbRoom6.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lbRoom6.setForeground(Color.WHITE);
        lbRoom6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRoom6.setText("Group 8");
        lbRoom6.setOpaque(true);

        lbRoom7.setBackground(new Color(51, 51, 255));
        lbRoom7.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lbRoom7.setForeground(Color.WHITE);
        lbRoom7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRoom7.setText("Group 7");
        lbRoom7.setOpaque(true);

        lbRoom8.setBackground(new Color(51, 51, 255));
        lbRoom8.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lbRoom8.setForeground(Color.WHITE);
        lbRoom8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRoom8.setText("Group 6");
        lbRoom8.setOpaque(true);
        
        lbBack_room_2 = new javax.swing.JLabel();
        lbBack_room_2.setIcon(new ImageIcon("C:\\Users\\VIVOBOOK\\eclipse-workspace\\pr\\pr\\mini-projet\\src\\images\\back.png"));
        lbBack_room_2.setToolTipText("Back");
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lbBack_room_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        			.addGap(37)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(lbRoom1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        					.addGap(223)
        					.addComponent(lbRoom2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lbRoom3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbRoom5, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
        					.addGap(223)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lbRoom4, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbRoom8, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(lbRoom7, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        					.addGap(223)
        					.addComponent(lbRoom6, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(10)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbRoom1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbRoom2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
        			.addGap(38)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(lbRoom3, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
        					.addGap(33)
        					.addComponent(lbRoom5, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(lbRoom4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
        					.addGap(33)
        					.addComponent(lbRoom8, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
        			.addGap(34)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbRoom7, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbRoom6, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(30)
        			.addComponent(lbBack_room_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        );
        setLayout(groupLayout);
    }// </editor-fold>//GEN-END:initComponents
    private javax.swing.JLabel lbRoom1;
    private javax.swing.JLabel lbRoom2;
    private javax.swing.JLabel lbRoom3;
    private javax.swing.JLabel lbRoom4;
    private javax.swing.JLabel lbRoom5;
    private javax.swing.JLabel lbRoom6;
    private javax.swing.JLabel lbRoom7;
    private javax.swing.JLabel lbRoom8;
    private javax.swing.JLabel lbBack_room_2;

    
    // End of variables declaration//GEN-END:variables
}
