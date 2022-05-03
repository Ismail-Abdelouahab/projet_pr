package server;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author acer
 */
public class Source {

    public void changeColor(JPanel panel1) {
        panel1.setBackground(new Color(240, 240, 240));

    }

    public void normalColor(JPanel panel1) {
        panel1.setBackground(new Color(204, 204, 204));

    }

    public void serverChange(JLabel label1) {
        label1.setForeground(Color.GREEN);
    }

    public void serverNormal(JLabel label1) {
        label1.setForeground(Color.BLACK);
    }

    public void NormalWhite(JPanel panel1) {
        panel1.setBackground(new Color(255, 255, 255));
    }

    
}
