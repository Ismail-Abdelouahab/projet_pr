/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author AnhTu
 */
public class ClientPanel extends javax.swing.JPanel {

    JFileChooser chooser;
    String filePath;
    
    /**
     * Creates new form ClientPanel
     */
    public ClientPanel() {
        initComponents();
        chooser = new JFileChooser();
        
    }
    
    public JButton getBtExit() {
        return btExit;
    }

    public JButton getBtSend() {
        return btSend;
    }

    public JTextArea getTaInput() {
        return taInput;
    }
    
    public JTextPane getTpMessage() {
        return tpMessage;
    }

    
    
    public JList<String> getOnlineListThisRoom() {
        return onlineListThisRoom;
    }

    public JLabel getLbRoom() {
        return lbRoom;
    }

  

    

    //phương thức này ko hiệu quả lắm
    public void appendMessage2(String msg1, String msg2, Color c1, Color c2) {  //thiết lập 2 loại text khác màu nhau trên 1 dòng
        tpMessage.setEditable(true);
        //chèn msg1 trước:
        int len = tpMessage.getDocument().getLength();
        
        StyleContext sc = StyleContext.getDefaultStyleContext();
        
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c1);
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Impact"); //  FontFamily: thiết lập font, chú ý font này là kiểu đậm chứ ko phải ta thiết lập cho nó đậm nhé
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);     //cái này chưa biết tác dụng làm j
        aset = sc.addAttribute(aset, StyleConstants.FontSize, 14);      //kích thước font
        
        tpMessage.setCaretPosition(len);    //vị trí cần chèn text
        tpMessage.setCharacterAttributes(aset, false);  //thiết lập thuộc tính cho text cần chèn
        tpMessage.replaceSelection(msg1);   //chèn text vào vị trí trên
        
        //chèn msg2 ngay sau msg1:
        len = len + msg1.length();
        
        sc = StyleContext.getDefaultStyleContext();
        
        aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c2); 
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Arial"); //  FontFamily: thiết lập font
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);     //cái này chưa biết tác dụng làm j
        aset = sc.addAttribute(aset, StyleConstants.FontSize, 14);      //kích thước font
        
        tpMessage.setCaretPosition(len);
        tpMessage.setCharacterAttributes(aset, false);
        tpMessage.replaceSelection(msg2+"\n");   //nhớ xuống dòng
        
        len = len + msg2.length();
        tpMessage.setCaretPosition(len);
        tpMessage.setEditable(false);
    }
    
    //phương thức này ko hiệu quả lắm
    public void appendMessage2(String message, Color color) {
        int len = tpMessage.getDocument().getLength();
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);
        
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Comic Sans MS"); //  FontFamily: thiết lập font
        
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);     //cái này chưa biết tác dụng làm j
        aset = sc.addAttribute(aset, StyleConstants.FontSize, 14);      //kích thước font
        
        tpMessage.setCaretPosition(len);    //vị trí cần chèn text
        tpMessage.setCharacterAttributes(aset, false);  //thiết lập thuộc tính cho text cần chèn
        tpMessage.replaceSelection(message+"\n");   //chèn text vào vị trí trên
        
    }   
     
    //we should use this method
    public void appendMessage(String msg1, String msg2, Color c1, Color c2) {  //thiết lập 2 loại text khác màu nhau trên 1 dòng
        //chèn msg1 trước:
        int len = tpMessage.getDocument().getLength();
        StyledDocument doc = (StyledDocument) tpMessage.getDocument();
        
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setFontFamily(sas, "Serif");
        StyleConstants.setBold(sas, true);
        StyleConstants.setFontSize(sas, 14);
        StyleConstants.setForeground(sas, c1);
        
        try {
            doc.insertString(len, msg1, sas);
        } catch (BadLocationException ex) {
            Logger.getLogger(ClientPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //sau đó chèn msg2 ngay sau msg1:
        doc = (StyledDocument) tpMessage.getDocument();
        len = len+msg1.length();
        
        sas = new SimpleAttributeSet();
        StyleConstants.setFontFamily(sas, "Arial");
        StyleConstants.setFontSize(sas, 14);
        StyleConstants.setForeground(sas, c2);
        
        try {
            doc.insertString(len, msg2+"\n", sas);      //phai xuong dong
        } catch (BadLocationException ex) {
            Logger.getLogger(ClientPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tpMessage.setCaretPosition(len+msg2.length());
    }
    
    public void appendMessage(String message, Color color) {
        int len = tpMessage.getDocument().getLength();
        StyledDocument doc = (StyledDocument) tpMessage.getDocument();
        
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setFontFamily(sas, "Comic Sans MS");
        StyleConstants.setItalic(sas, true);
        StyleConstants.setFontSize(sas, 14);
        StyleConstants.setForeground(sas, color);
        
        try {
            doc.insertString(len, message+"\n", sas);
        } catch (BadLocationException ex) {
            Logger.getLogger(ClientPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tpMessage.setCaretPosition(len+message.length());
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        btExit = new javax.swing.JButton();
        btExit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btSend = new javax.swing.JButton();
        btSend.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        jScrollPane3 = new javax.swing.JScrollPane();
        taInput = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        lbRoom = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setForeground(new Color(51, 51, 255));
        jScrollPane5 = new javax.swing.JScrollPane();

        btExit.setFont(new Font("Comic Sans MS", Font.PLAIN, 13)); // NOI18N
        btExit.setForeground(new Color(0, 0, 0));
        btExit.setText("Quitte");

        btSend.setFont(new Font("Comic Sans MS", Font.PLAIN, 13)); // NOI18N
        btSend.setForeground(new Color(0, 0, 0));
        btSend.setText("Envoye");

        taInput.setColumns(20);
        taInput.setRows(5);
        jScrollPane3.setViewportView(taInput);

        lbRoom.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // NOI18N
        lbRoom.setForeground(new Color(51, 51, 255));
        lbRoom.setText("Group ?");

        jLabel4.setFont(new Font("Comic Sans MS", Font.BOLD, 14)); // NOI18N
        jLabel4.setText("Online in this Group");
        tpMessage = new javax.swing.JTextPane();
        jScrollPane2.setViewportView(tpMessage);
        
                tpMessage.setEditable(false);
                tpMessage.setFont(new java.awt.Font("Tahoma", 0, 14));
                onlineListThisRoom = new javax.swing.JList<>();
                jScrollPane5.setViewportView(onlineListThisRoom);
                
                        onlineListThisRoom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                        onlineListThisRoom.setForeground(new java.awt.Color(51, 51, 255));
                        GroupLayout groupLayout = new GroupLayout(this);
                        groupLayout.setHorizontalGroup(
                        	groupLayout.createParallelGroup(Alignment.LEADING)
                        		.addGroup(groupLayout.createSequentialGroup()
                        			.addGap(166)
                        			.addComponent(lbRoom, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                        			.addGap(348)
                        			.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
                        		.addGroup(groupLayout.createSequentialGroup()
                        			.addGap(10)
                        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        				.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                        				.addGroup(groupLayout.createSequentialGroup()
                        					.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
                        					.addGap(10)
                        					.addComponent(btSend, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                        				.addComponent(btExit, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
                        			.addGap(188)
                        			.addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                        );
                        groupLayout.setVerticalGroup(
                        	groupLayout.createParallelGroup(Alignment.LEADING)
                        		.addGroup(groupLayout.createSequentialGroup()
                        			.addGap(9)
                        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        				.addComponent(lbRoom, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        				.addGroup(groupLayout.createSequentialGroup()
                        					.addGap(4)
                        					.addComponent(jLabel4)))
                        			.addGap(9)
                        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        				.addGroup(groupLayout.createSequentialGroup()
                        					.addGap(25)
                        					.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
                        					.addGap(18)
                        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        						.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                        						.addComponent(btSend, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                        					.addGap(68)
                        					.addComponent(btExit, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                        				.addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE)))
                        );
                        setLayout(groupLayout);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExit;
    private javax.swing.JButton btSend;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lbRoom;
    private javax.swing.JList<String> onlineListThisRoom;
    private javax.swing.JTextArea taInput;
    private javax.swing.JTextPane tpMessage;
    // End of variables declaration//GEN-END:variables
}
