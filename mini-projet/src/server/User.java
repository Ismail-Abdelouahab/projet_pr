/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author AnhTu
 */
public class User {
    String username;
    String password;
    String nom;
    String prenom;
    String email;
    private String room;

    public User(String nom, String prenom,String email,String username,String password) {
        this.username = username;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public User(String username) {
        this.username = username;
    }

    public String getRoom() {
        return room;
    }

    
    public void setRoom(String room) {
        this.room = room;
    }
    
    
}
