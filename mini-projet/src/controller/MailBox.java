/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import server.UserDatabase;
import java.awt.Color;

/**
 *
 * @author alger
 */
public class MailBox extends javax.swing.JFrame {

    UserDatabase conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Statement st = null;
    String username;
    String id;
    String friends;
    String name;
    
    public MailBox(String name) {
    	this.name = name;
    	
        
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mail_tbl.setRowHeight(mail_tbl.getRowHeight() + 4);
        friend_tbl.setRowHeight(mail_tbl.getRowHeight() + 4);
        mail_tbl.setShowGrid(false);
        mail_tbl.setIntercellSpacing(new Dimension(0, 0));

    }
  
	public void FriendDisplay(){
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        friend_tbl.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        DefaultTableModel model = (DefaultTableModel) friend_tbl.getModel();
        model.setRowCount(0);
        String sql = "SELECT * FROM friends WHERE you = '"+name+"' AND status = 'friends' ";
     
        try{
            ps = conn.connect().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                friends = rs.getString("yourFriend");
                Object[] row = {friends};
                model.addRow(row);
            
            }
        }catch(Exception ex){
        
        }
    }
    public void RequestDisplay(){
        String sql = "SELECT * FROM request WHERE requestReceiver = '"+name+"' AND status = 'pending' ";
        DefaultTableModel model = (DefaultTableModel) mail_tbl.getModel();
        model.setRowCount(0);
        try{    
            ps = conn.connect().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String requestSender = rs.getString("requestSender");
                String id = rs.getString("id_request");
                Object[] row = {id,requestSender};
                model.addRow(row);
            }
        
        }catch(Exception ex){
            System.out.println(ex);
        }
    
    }
    public void FriendRequest(){
        
        DefaultTableModel model = (DefaultTableModel) mail_tbl.getModel();
        String sql = "SELECT * FROM request WHERE requestReceiver = '"+name+"' AND status = 'pending' ORDER BY requestSender";
        mail_tbl.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent e){
            JTable tbl =(JTable) e.getSource();
            Point p = e.getPoint();
            int row = tbl.rowAtPoint(p);
            if(e.getClickCount() == 2){
                String sender = mail_tbl.getValueAt(row, 1).toString();
                String id = mail_tbl.getValueAt(row, 0).toString();
                int opt = JOptionPane.showConfirmDialog(null, "Respond to Friend Request?","Confirmation",JOptionPane.YES_NO_OPTION);
                if(opt == JOptionPane.YES_OPTION){
                    String sql1 = "INSERT INTO friends (you,yourFriend,status) VALUES('"+name+"','"+sender+"','friends')";
                    String sql3 = "INSERT INTO friends (you,yourFriend,status) VALUES('"+sender+"','"+name+"','friends')";
                    String sql2 = "UPDATE request SET status = 'closed' WHERE id_request = '"+id+"'";
                    try{
                        st = conn.connect().createStatement();
                        st.executeUpdate(sql1);
                        st.executeUpdate(sql2);
                        st.executeUpdate(sql3);
                        RequestDisplay();
                        FriendDisplay();
                    }catch(Exception ex){
                        System.out.println(ex);
                    }
                }else{
                    String sql3 = "UPDATE REQUEST SET status = 'close' WHERE id_request = '"+id+"'";
                    try{
                        st = conn.connect().createStatement();
                        st.executeUpdate(sql3);
                        RequestDisplay();
                    }catch(Exception ex){
                        System.out.println(ex);
                    }
                }
            }
        }
        });
        
        
    
    }
    public void ListMenu(){
      
        friend_tbl.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
            final int index  = friend_tbl.getSelectedRow();
            if(e.getButton() ==  MouseEvent.BUTTON1 && e.getClickCount() == 1 && index != -1){
                JPopupMenu pop = new JPopupMenu();
                JMenuItem menu0 = new JMenuItem("Private Message");
                JMenuItem menu1 = new JMenuItem("Remove Friend");
                ActionListener menuListener = new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    if("Private Message".equals(event.getActionCommand())){
                        Private pm = new Private();
                        pm.username = friend_tbl.getValueAt(index, 0).toString();
                        pm.yourUsername = username;
                        pm.show();
                    }else if("Remove Friend".equals(event.getActionCommand())){
                        int opt = JOptionPane.showConfirmDialog(null, "","",JOptionPane.YES_NO_OPTION);
                        if(opt == JOptionPane.YES_OPTION){
                            String yourFriend = friend_tbl.getValueAt(index, 0).toString();
                            String sql = "UPDATE FRIENDS SET status = 'unfriend' WHERE yourFriend = '"+yourFriend+"'";
                            try{
                                st = conn.connect().createStatement();
                                if(st.executeUpdate(sql) == 1){
                                    JOptionPane.showMessageDialog(null, "Friend Removed");
                                    FriendDisplay();
                                }
                            }catch(Exception ex){
                                System.out.println(ex);
                            }
                        }
                    }
                }
                };
                pop.add(menu0);
                pop.add(menu1);
                menu0.addActionListener(menuListener);
                menu1.addActionListener(menuListener);
                friend_tbl.setComponentPopupMenu(pop);    
            }   
          }
    });
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        friend_tbl = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        mail_tbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new Color(0, 51, 204));

        friend_tbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        friend_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Friend"
            }
        ));
        friend_tbl.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(friend_tbl);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Friends", jPanel2);

        mail_tbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mail_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request ID", "Sender"
            }
        ));
        mail_tbl.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(mail_tbl);

        jTabbedPane1.addTab("Friend Request", jScrollPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    	conn = new UserDatabase();
        FriendDisplay();
        FriendRequest();
        ListMenu();
        RequestDisplay();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        int col = mail_tbl.getColumnCount();
        for(int i = 0; i < col; i++){
            mail_tbl.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        mail_tbl.setDefaultEditor(Object.class,null);
        
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MailBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MailBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MailBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MailBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MailBox(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable friend_tbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable mail_tbl;
    // End of variables declaration//GEN-END:variables
}
