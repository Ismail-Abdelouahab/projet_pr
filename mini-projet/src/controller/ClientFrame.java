
package controller;


import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


import server.Database;
import server.UserDatabase;
import view.ClientPanel;
import view.Login;
import view.Menu;
import view.PrivateChat;
import view.Room;
import view.Profil;
import view.signUp;
import view.WelcomePanel;

import view.RoomPanel;



public class ClientFrame extends JFrame implements Runnable {
    static String serverHost;
    public static final String NICKNAME_EXIST = "This username is already login in another place! Please using another username";
    public static final String NICKNAME_VALID = "This username is OK";
    public static final String NICKNAME_INVALID = "username or password is incorrect";
    public static final String SIGNUP_SUCCESS = "Sign up successful!";
    public static final String ACCOUNT_EXIST = "This username has been used! Please use another username!";
	       String USER;
    UserDatabase conn;
    static String name;
    String room;
    Socket socketOfClient;
    static BufferedWriter bw;
    static BufferedReader br;
    
	Database con = new Database();
	PreparedStatement prepared = null;
	ResultSet resultat = null;
    
    JPanel mainPanel;
    Login loginPanel;
    Menu menu;
    Profil profil;
    ClientPanel clientPanel;
    WelcomePanel welcomePanel;
    signUp signUp;
    Room roomPanel;
    RoomPanel groups;
    PrivateChat PrivateChat;
    
    Thread clientThread;
    boolean isRunning;
    
 
    
    SendFileFrame sendFileFrame;
    
    StringTokenizer tokenizer;
    String myDownloadFolder;
    
    Socket socketOfSender, socketOfReceiver;
    
    DefaultListModel<String> listModel, listModelThisRoom, listModel_rp;
        
    boolean isConnectToServer;
    
    static int timeClicked = 0;    
    static int time = 0;
    
    
    static Hashtable<String, PrivateChat> listReceiver;
    
    public ClientFrame(String name) {
        this.name = name;
        socketOfClient = null;
        bw = null;
        br = null;
        isRunning = true;
        listModel = new DefaultListModel<>();
        listModelThisRoom = new DefaultListModel<>();
        listModel_rp = new DefaultListModel<>();
        isConnectToServer = false;
        listReceiver = new Hashtable<>();
        
        mainPanel = new JPanel();
        loginPanel = new Login();
        clientPanel = new ClientPanel();
        welcomePanel = new WelcomePanel();
        signUp = new signUp();
        roomPanel = new Room();
        menu = new Menu();
        profil = new Profil();
        groups = new RoomPanel();
        
        //mainPanel.setSize(570, 450);
       //welcomePanel.setVisible(true);
        signUp.setVisible(false);
        loginPanel.setVisible(true);
        roomPanel.setVisible(false);
        clientPanel.setVisible(false);
        menu.setVisible(false);
        profil.setVisible(false);
        groups.setVisible(false);
        
        //mainPanel.add(welcomePanel);
        mainPanel.add(signUp);
        mainPanel.add(loginPanel);
        mainPanel.add(roomPanel);
        mainPanel.add(clientPanel);
        mainPanel.add(menu);
        mainPanel.add(profil);
        mainPanel.add(groups);
        
        addEventsForWelcomePanel();
        addEventsForSignUpPanel();
        addEventsForLogin();
        addEventsForClientPanel();
        addEventsForRoomPanel();
        addEventsForMenu();
        addEventsForProfil();
        
 
        
        pack();
        
        add(mainPanel);
        setSize(770, 490);
        setLocation(400, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(name);
        
        
       
        
    }
   
    public void jLabel1MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        MailBox MailBox = new MailBox(name);
        MailBox.show();
    
    }//GEN-LAST:event_jLabel1MouseClicked
    public void jLabel3MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Inbox inbox = new Inbox(name);
        inbox.show();
    
    }//GEN-LAST:event_jLabel1MouseClicked

   
  
 

    
    //event for profil
    
    private void addEventsForProfil() {
  	//contact
          profil.modifier().addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
  				String sql ="update users set password = ?, username = ? where username= ?";
  				try {
  					prepared=con.obtenirconnexion().prepareStatement(sql);
  					String Username=profil.getUsername().getText();
  					String Password=profil.getPassword().getText();
  					
  					prepared.setString(1,Password);
  					prepared.setString(2,Username);
  					prepared.setString(3, name);
  					int resultat = prepared.executeUpdate();
  					if(resultat==1) {
  						profil.getUsername().setText(Username);
  						profil.getPassword().setText(Password);
  						
  						JOptionPane.showMessageDialog(null,"Modification successful");
  					}
  					}
  				 catch (SQLException e1) {
  					// TODO Auto-generated catch block
  					e1.printStackTrace();
  				}
              }
          });
          
          profil.getRetour().addMouseListener(new MouseAdapter() {
              @Override
              public void mouseClicked(MouseEvent e) {
                  signUp.setVisible(false);
                  loginPanel.setVisible(false);
                  clientPanel.setVisible(false);
                  roomPanel.setVisible(false);
                  menu.setVisible(true);
                  groups.setVisible(false);
                  profil.setVisible(false);


              }
          });
          profil.jLabel_1().addMouseListener(new MouseAdapter() {
              @Override
              public void mouseClicked(MouseEvent evt) {
              	jLabel1MouseClicked(evt);

          	}
          });
          
         profil.jLabel_3().addMouseListener(new MouseAdapter() {
              @Override
              public void mouseClicked(MouseEvent me) {
            	
                	jLabel3MouseClicked(me);
                   
          	}
          });
       
          
    }
    
    //event for menu
    
  private void addEventsForMenu() {
	//contact
        menu.getcontact().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menu.setVisible(false);
                loginPanel.setVisible(false);
                clientPanel.setVisible(false);
                roomPanel.setVisible(true);
                profil.setVisible(false);
                groups.setVisible(false);


            }
        });
        
      //profil
        menu.getProfil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menu.setVisible(false);
                loginPanel.setVisible(false);
                clientPanel.setVisible(false);
                roomPanel.setVisible(false);
                profil.setVisible(true);
                groups.setVisible(false);
                
                String Email, lastName,firstName,Password,Username;
  				String sql="select email,nom,prenom,password,username from users where username= ? and password = ? ";
  				try {
  					prepared = con.obtenirconnexion().prepareStatement(sql);
  					
  					String nickname = loginPanel.getTfNickname().getText().trim();
  					String pass = loginPanel.getTfPass().getText().trim();
  					prepared.setString(1, nickname);
  					prepared.setString(2, pass);
  					ResultSet resultat = prepared.executeQuery();
  					if(resultat.next()==true) {
  						
  						Email=resultat.getString(1);
  						lastName=resultat.getString(2);
  						firstName=resultat.getString(3);
  						Password=resultat.getString(4);
  						Username=resultat.getString(5);
  						
  						profil.email.setText(Email);
  						profil.nom.setText(lastName);
  						profil.prenom.setText(firstName);
  						profil.password.setText(Password);
  						profil.username.setText(Username);
  					}
  					}
  				 catch (SQLException e1) {
  					// TODO Auto-generated catch block
  					e1.printStackTrace();
  				}

            }
        });
        
      //logout
        menu.getLogOut().addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent ae) {
            	try {
                    isRunning = false;
                    //this.disconnect();
                    System.exit(0);
                    
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                   
                }
            });
            
                

        
        menu.getgroups().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menu.setVisible(false);
                loginPanel.setVisible(false);
                clientPanel.setVisible(false);
                roomPanel.setVisible(false);
                groups.setVisible(true);
                profil.setVisible(false);
            }
        });
        
    }

    

	private void addEventsForWelcomePanel() {
        
        welcomePanel.getBtLogin_welcome().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                signUp.setVisible(false);
                loginPanel.setVisible(true);
                clientPanel.setVisible(false);
                roomPanel.setVisible(false);
                menu.setVisible(false);
                groups.setVisible(false);
                profil.setVisible(false);
                


            }
        });
        loginPanel.getBtSignUp_welcome().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                signUp.setVisible(true);
                loginPanel.setVisible(false);
                clientPanel.setVisible(false);
                roomPanel.setVisible(false);
                menu.setVisible(false);
                groups.setVisible(false);
                profil.setVisible(false);


            }
        });
        
    }

    private void addEventsForSignUpPanel() {
        signUp.getLbBack_signup().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                signUp.setVisible(false);
                loginPanel.setVisible(true);
                clientPanel.setVisible(false);
                roomPanel.setVisible(false);
                menu.setVisible(false);
                groups.setVisible(false);
                profil.setVisible(false);


            }
        });
        signUp.getBtSignUp().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btSignUpEvent();
                

            }
        });
    }

    private void addEventsForLogin() {
        loginPanel.getTfNickname().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_ENTER) btOkEvent();
            }
            
        });
        loginPanel.getTfPass().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_ENTER) btOkEvent();
            }
            
        });
        loginPanel.getBtOK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btOkEvent();
            }
        });
       
    }

    private void addEventsForClientPanel() {
        clientPanel.getBtSend().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btSendEvent();
            }
        });
      
        clientPanel.getTaInput().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    btSendEvent();
                    btClearEvent();
                }
            }
        });
        
      
    }
    
    public void addEventsForRoomPanel() {
        groups.getLbRoom1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ClientFrame.this.room = groups.getLbRoom1().getText();
                labelRoomEvent();
            }
        });
        groups.getLbRoom2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ClientFrame.this.room = groups.getLbRoom2().getText();
                labelRoomEvent();
            }
        });
        groups.getLbRoom3().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ClientFrame.this.room = groups.getLbRoom3().getText();
                labelRoomEvent();
            }
        });
        groups.getLbRoom4().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ClientFrame.this.room = groups.getLbRoom4().getText();
                labelRoomEvent();
            }
        });
        groups.getLbRoom5().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ClientFrame.this.room = groups.getLbRoom5().getText();
                labelRoomEvent();
            }
        });
        groups.getLbRoom6().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ClientFrame.this.room = groups.getLbRoom6().getText();
                labelRoomEvent();
            }
        });
        groups.getLbRoom7().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ClientFrame.this.room = groups.getLbRoom7().getText();
                labelRoomEvent();
            }
        });
        groups.getLbRoom8().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ClientFrame.this.room = groups.getLbRoom8().getText();
                labelRoomEvent();
            }
        });
        
        roomPanel.getOnlineList_rp().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                //openPrivateChatOutsideRoom();
                ListMenu();

            }
        });
        roomPanel.getLbBack_room().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                signUp.setVisible(false);
                loginPanel.setVisible(false);
                clientPanel.setVisible(false);
                roomPanel.setVisible(false);
                menu.setVisible(true);
                groups.setVisible(false);
                profil.setVisible(false);


            }
        });
        
        
        
    
   groups.getLbBack_room_2().addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent me) {
            signUp.setVisible(false);
            loginPanel.setVisible(false);
            clientPanel.setVisible(false);
            roomPanel.setVisible(false);
            menu.setVisible(true);
            groups.setVisible(false);
            profil.setVisible(false);


        }
    });
    
    
    
}
    public static void open(String receiver) {
    	 if(time == 0) {
             Thread countingTo500ms = new Thread(counting);
             countingTo500ms.start();
         }

         if(time == 0) {  
             String privateReceiver = receiver;
             PrivateChat pc = listReceiver.get(privateReceiver);
             if(pc == null) {    
                 pc = new PrivateChat(name, privateReceiver, serverHost, bw, br);
                 
                 pc.getLbReceiver().setText("Private chat with \""+pc.receiver+"\"");
                 pc.setTitle(pc.receiver);
                 pc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                 pc.setVisible(true);

                 listReceiver.put(privateReceiver, pc);
             } else {
                 pc.setVisible(true);
             }
         }
         
     }
    	
    
 
            
    private void openPrivateChatOutsideRoom() {
        timeClicked++;

        if(timeClicked == 1) {
            Thread countingTo500ms = new Thread(counting);
            countingTo500ms.start();
        }

        if(timeClicked == 2) {  
            String privateReceiver = roomPanel.getOnlineList_rp().getSelectedValue();
            PrivateChat pc = listReceiver.get(privateReceiver);
            this.setVisible(false);
         
            if(pc == null) {    
                pc = new PrivateChat(name, privateReceiver, serverHost, bw, br);
                
                pc.getLbReceiver().setText("Private chat with \""+pc.receiver+"\"");
                pc.setTitle(pc.receiver);
                pc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                pc.setVisible(true);

                listReceiver.put(privateReceiver, pc);
            } else {
                pc.setVisible(true);
            }
        }
    }
    

    
    static Runnable counting = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            timeClicked = 0;
        }
    };
    
    private void labelRoomEvent() {
        this.clientPanel.getTpMessage().setText("");
        this.sendToServer("CMD_ROOM|"+this.room);
        try {
            Thread.sleep(200);      
        } catch (InterruptedException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.groups.setVisible(false);
        this.clientPanel.setVisible(true);
        this.setTitle("\""+this.name+"\" - "+this.room);
        clientPanel.getLbRoom().setText(this.room);
    }
    
    private void leaveRoom() {
        this.sendToServer("CMD_LEAVE_ROOM|"+this.room);
        try {
            Thread.sleep(200);      
        } catch (InterruptedException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.roomPanel.setVisible(true);
        this.clientPanel.setVisible(false);
        //clear the textPane message:
        clientPanel.getTpMessage().setText("");
        this.setTitle("\""+this.name+"\"");
    }
    
    
    ////////////////////////Events////////////////////////////
    private void btOkEvent() {
        String hostname = "localhost";
        String nickname = loginPanel.getTfNickname().getText().trim();
        String pass = loginPanel.getTfPass().getText().trim();
 
        
        this.serverHost = hostname;
        this.name = nickname;

        
        if(hostname.equals("") || nickname.equals("") || pass.equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill up all fields", "Notice!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!isConnectToServer) {
            isConnectToServer = true;   
                                        
                                         
            this.connectToServer(hostname); 
        }    
        this.sendToServer("CMD_CHECK_NAME|" +this.name+"|"+pass);      
        
        String response = this.recieveFromServer();
        if(response != null) {
            if (response.equals(NICKNAME_EXIST) || response.equals(NICKNAME_INVALID)) {
                JOptionPane.showMessageDialog(this, response, "Error", JOptionPane.ERROR_MESSAGE);
                loginPanel.getBtOK().setText("OK");
            } else if(response.equals(NICKNAME_VALID)) {
            	  loginPanel.setVisible(false);
                  roomPanel.setVisible(false);
                  clientPanel.setVisible(false);
                  menu.setVisible(true);
                  openPrivateChatOutsideRoom();
                  
                  ListMenu();
                  this.setTitle("\""+name+"\"");

              


                // On va developer apres
                clientThread = new Thread(this);
                clientThread.start();
                this.sendToServer("CMD_ROOM|"+this.room);   
                System.out.println("this is \""+name+"\"");
                //loginPanel.getBtOK().setText("OK");
            }
        } else System.out.println("[btOkEvent()] Server is not open yet, or already closed!");
    }
    public void ListMenu(){
        
        roomPanel.onlineList_rp.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
        	
        	  int index  = roomPanel.onlineList_rp.getSelectedIndex();
              String s = (String) roomPanel.onlineList_rp.getSelectedValue();
              final String selectedUser = roomPanel.onlineList_rp.getSelectedValue(); 
       
            
            if(e.getButton() ==  MouseEvent.BUTTON1 && e.getClickCount() == 1 && index != -1){
                JPopupMenu pop = new JPopupMenu();
                JMenuItem menu1 = new JMenuItem("Add Friend");	        	                 
                ActionListener menuListener = new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                   if("Add Friend".equals(event.getActionCommand())){
                        int opt = JOptionPane.showConfirmDialog(null, "Confirm Friend Request?","Confirmation",JOptionPane.YES_NO_OPTION);
                        if(opt != JOptionPane.NO_OPTION){
                            String sql = "INSERT INTO request(request,requestSender,requestReceiver,status)VALUES('Add Friend','"+name+"','"+selectedUser+"','pending')";
                            try{  
                                conn = new UserDatabase();

								Statement stmt = conn.connect().createStatement();
                                if(stmt.executeUpdate(sql) == 1){
                                    JOptionPane.showMessageDialog(null, "Friend Request Sent");
                                }
                            
                            }catch(Exception ex){
                                System.out.println(ex);
                            }
                        }
                    }
                }
                };
                pop.add(menu1);
                menu1.addActionListener(menuListener);
                roomPanel.onlineList_rp.setComponentPopupMenu(pop);    
            }   
          }
    });
    
    }
    

    
    private void btSignUpEvent() {
    	
    	
            String password = this.signUp.getTfPass().getText();
         
            String username = signUp.getTfName().getText().trim();
            String nom = signUp.getTfNom().getText().trim();
            String prenom = signUp.getTfPrenom().getText().trim();
            String email = signUp.getTfEmail().getText().trim();


            
            String hostName = "localhost";
            if(hostName.equals("") || username.equals("") || password.equals("")|| nom.equals("")|| prenom.equals("")|| email.equals("")) {
                JOptionPane.showMessageDialog(this, "Please fill up all fields", "Notice!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if(!isConnectToServer) {
                isConnectToServer = true;   
                                            
                                            
                this.connectToServer(hostName); 
            }    
            this.sendToServer("CMD_SIGN_UP|" + nom+"|" + prenom +"|"+ email +"|"+ username +"|"+password);       
        
            String response = this.recieveFromServer();
            if(response != null) {
                if(response.equals(NICKNAME_EXIST) || response.equals(ACCOUNT_EXIST)) {
                    JOptionPane.showMessageDialog(this, response, "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, response+"\nYou can now go back and login to join chat room", "Success!", JOptionPane.INFORMATION_MESSAGE);
                    signUp.clearTf();
                }
            }
        
        
    }
            // Envoyer un message de chat au serveur
    private void btSendEvent() {
        String message = clientPanel.getTaInput().getText().trim();
        if(message.equals("")) clientPanel.getTaInput().setText("");
        else {
            this.sendToServer("CMD_CHAT|" + message);       
            this.btClearEvent();
        }
        
    }

    private void btClearEvent() {
        clientPanel.getTaInput().setText("");
    }

  
    //button contact 
   

  
    
    public void connectToServer(String hostAddress) {   
        try {
            socketOfClient = new Socket(hostAddress, 9999);
            bw = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
            
        } catch (java.net.UnknownHostException e) {
            JOptionPane.showMessageDialog(this, "Host IP is not correct.\nPlease try again!", "Failed to connect to server", JOptionPane.ERROR_MESSAGE);
        } catch (java.net.ConnectException e) {
            JOptionPane.showMessageDialog(this, "Server is unreachable, maybe server is not open yet, or can't find this host.\nPlease try again!", "Failed to connect to server", JOptionPane.ERROR_MESSAGE);
        } catch(java.net.NoRouteToHostException e) {
            JOptionPane.showMessageDialog(this, "Can't find this host!\nPlease try again!", "Failed to connect to server", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public void sendToServer(String line) {
        try {
            this.bw.write(line);
            this.bw.newLine();   
            this.bw.flush();
        } catch (java.net.SocketException e) {
            JOptionPane.showMessageDialog(this, "Server is closed, can't send message!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (java.lang.NullPointerException e) {
            System.out.println("[sendToServer()] Server is not open yet, or already closed!");
        } catch (IOException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String recieveFromServer() {
        try {
            return this.br.readLine();  
        } catch (java.lang.NullPointerException e) {
            System.out.println("[recieveFromServer()] Server is not open yet, or already closed!");
        } catch (IOException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
  
    
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClientFrame client = new ClientFrame(null);
        client.setVisible(true);
    }

    @Override
    public void run() {
        String response;
        String sender, receiver, fileName, thePersonIamChattingWith, thePersonSendFile;
        String msg;
        String cmd, icon;
        PrivateChat pc;
        
        while(isRunning) {
            response = this.recieveFromServer();   
            tokenizer = new StringTokenizer(response, "|");
            cmd = tokenizer.nextToken();
            switch (cmd) {
                case "CMD_CHAT":    
                    sender = tokenizer.nextToken();
                    msg = response.substring(cmd.length()+sender.length()+2, response.length());
                    
                    if(sender.equals(this.name)) this.clientPanel.appendMessage(sender+": ", msg, Color.BLACK, new Color(0, 102, 204));
                    else this.clientPanel.appendMessage(sender+": ", msg, Color.MAGENTA, new Color(56, 224, 0));
                    

                    break;
                    
                case "CMD_PRIVATECHAT":     
                   
                    sender = tokenizer.nextToken();
                    msg = response.substring(cmd.length()+sender.length()+2, response.length());
                    
                    pc = listReceiver.get(sender);
                    
                    if(pc == null) {
                        pc = new PrivateChat(name, sender, serverHost, bw, br);
                        pc.sender = name;
                        pc.receiver = sender;
                        pc.serverHost = this.serverHost;
                        pc.bw = ClientFrame.this.bw;
                        pc.br = ClientFrame.this.br;

                        pc.getLbReceiver().setText("Private chat with \""+pc.receiver+"\"");
                        pc.setTitle(pc.receiver);
                        pc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        pc.setVisible(true);    

                        listReceiver.put(sender, pc);
                    } else {
                        pc.setVisible(true);
                    }
                    //pc.appendMessage(sender+": ", msg, Color.CYAN, Color.GREEN);
                    pc.appendMessage_Left(sender+": ", msg);
                    break;
                    
                case "CMD_ONLINE_USERS":
                    listModel.clear();
                    listModel_rp.clear();
                    while(tokenizer.hasMoreTokens()) {
                        cmd = tokenizer.nextToken();
                        listModel.addElement(cmd);
                        listModel_rp.addElement(cmd);
                    }
                    
                    listModel_rp.removeElement(this.name);
                    roomPanel.getOnlineList_rp().setModel(listModel_rp);


                    break;
                    
                case "CMD_ONLINE_THIS_ROOM":
                    listModelThisRoom.clear();
                    while(tokenizer.hasMoreTokens()) {
                        cmd = tokenizer.nextToken();
                        listModelThisRoom.addElement(cmd);
                    }
                    clientPanel.getOnlineListThisRoom().setModel(listModelThisRoom);
                    break;
                    
//                case "CMD_SERVERISBUSY":
//                    JOptionPane.showMessageDialog(this, "Server is busy, please try to send file later", "Info", JOptionPane.INFORMATION_MESSAGE);
//                    break;
                    
                case "CMD_FILEAVAILABLE":
                    System.out.println("file available");
                    fileName = tokenizer.nextToken();
                    thePersonIamChattingWith = tokenizer.nextToken();
                    thePersonSendFile = tokenizer.nextToken();
                    
                    pc = listReceiver.get(thePersonIamChattingWith);
                    
                    if(pc == null) {
                        sender = this.name;
                        receiver = thePersonIamChattingWith;
                        pc = new PrivateChat(sender, receiver, serverHost, bw, br);
                        
                        pc.getLbReceiver().setText("Private chat with \""+pc.receiver+"\"");
                        pc.setTitle(pc.receiver);
                        pc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        
                        listReceiver.put(receiver, pc);
                    }
                    
                    pc.setVisible(true);    
                    pc.insertButton(thePersonSendFile, fileName);
                    break;
                    
                    
              
                    
                default:
                    if(!response.startsWith("CMD_")) {      
                        if(response.equals("Warnning: Server has been closed!")) {
                            this.clientPanel.appendMessage(response, Color.RED);
                        }
                        else this.clientPanel.appendMessage(response, new Color(153, 153, 153));
                    }
                   
                    
            }
        }
        System.out.println("Disconnected to server!");
    }

    private javax.swing.JLabel jLabel1;

}
