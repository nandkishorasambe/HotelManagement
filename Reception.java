
package hotelmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Reception extends JFrame implements ActionListener{
    
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;

    Reception() {
        b1=new JButton("NEW CUSTOMER");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Times New Roman",Font.PLAIN,15));
        b1.addActionListener(this);
        b1.setBounds(10,30,250,30);
        add(b1);
        
        b2=new JButton("ROOM INFORMATION");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Times New Roman",Font.PLAIN,15));
        b2.addActionListener(this);
        b2.setBounds(10,70,250,30);
        add(b2);
        
        b3=new JButton("DEPARTMENT");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Times New Roman",Font.PLAIN,15));
        b3.setBounds(10,110,250,30);
        b3.addActionListener(this);
        add(b3);
        
        b4=new JButton("ALL EMPLOYEES");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("Times New Roman",Font.PLAIN,15));
        b4.setBounds(10,150,250,30);
        b4.addActionListener(this);
        add(b4);
        
        b5=new JButton("ALL CUSTOMERS");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setFont(new Font("Times New Roman",Font.PLAIN,15));
        b5.setBounds(10,190,250,30);
        b5.addActionListener(this);
        add(b5);
        
        b6=new JButton("SEARCH ROOM");
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setFont(new Font("Times New Roman",Font.PLAIN,15));
        b6.setBounds(10,230,250,30);
        b6.addActionListener(this);
        add(b6);
        
        b7=new JButton("CHECK OUT");
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setFont(new Font("Times New Roman",Font.PLAIN,15));
        b7.setBounds(10,270,250,30);
        b7.addActionListener(this);
        add(b7);
        
        b8=new JButton("UPDATE CHECK STATUS");
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.setFont(new Font("Times New Roman",Font.PLAIN,15));
        b8.setBounds(10,310,250,30);
        b8.addActionListener(this);
        add(b8);
        
        b9=new JButton("UPDATE ROOM STATUS");
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        b9.setFont(new Font("Times New Roman",Font.PLAIN,15));
        b9.setBounds(10,350,250,30);
        b9.addActionListener(this);
        add(b9);
        b10=new JButton("PICK UP SERCICE");
        b10.setBackground(Color.BLACK);
        b10.setForeground(Color.WHITE);
        b10.setFont(new Font("Times New Roman",Font.PLAIN,15));
        b10.setBounds(10,390,250,30);
        b10.addActionListener(this);
        add(b10);
        
    
        
        b12=new JButton("LOGOUT");
        b12.setBackground(Color.BLACK);
        b12.setForeground(Color.WHITE);
        b12.setFont(new Font("Times New Roman",Font.PLAIN,15));
        b12.setBounds(10,430,250,30);
        b12.addActionListener(this);
        add(b12);
        
                
    ImageIcon i1= new ImageIcon(("C:\\Users\\NandKishor\\Documents\\NetBeansProjects\\HotelManagement\\src\\hotelmanagement\\icons\\second.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900,560,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2); 
    JLabel L1 = new JLabel(i3);
    L1.setBounds(0, 0, 900,560); 
    add(L1);
    
        setLayout(null);
        setBounds(400,150,800,600);
        setVisible(true);
    }
    
    public static void main(String[] args){
    new Reception().setVisible(true);
    }

     public void actionPerformed(ActionEvent ae) {
      if(ae.getSource()==b1){
          try {
              new AddCustomer().setVisible(true);
          } catch (SQLException ex) {
              Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
          }
        this.setVisible(false);
      }else if(ae.getSource()==b2){
           try {
              new RoomInfo().setVisible(true);
          } catch (SQLException ex) {
              Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
          }
        this.setVisible(false);
 
      }else if(ae.getSource()==b3){
          
           try {
              new Department().setVisible(true);
          } catch (SQLException ex) {
              Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
          }
        this.setVisible(false);
        
      }else if(ae.getSource()==b4){
          
           try {
              new EmployeeInfo().setVisible(true);
          } catch (SQLException ex) {
              Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
          }
        this.setVisible(false);
        
      }else if(ae.getSource()==b5){
          
           try {
              new CustomerInfo().setVisible(true);
          } catch (SQLException ex) {
              Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
          }
        this.setVisible(false);
        
      }else if(ae.getSource()==b6){
          
           try {
              new SearchRoom().setVisible(true);
          } catch (SQLException ex) {
              Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
          }
        this.setVisible(false);
        
      }else if(ae.getSource()==b7){
          
          new CheckOut().setVisible(true);
        this.setVisible(false);
        
      }else if(ae.getSource()==b8){
          
          new UpdateCheck().setVisible(true);
        this.setVisible(false);
        
      }else if(ae.getSource()==b9){
          
           try {
              new UpdatRoom().setVisible(true);
          } catch (SQLException ex) {
              Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
          }
        this.setVisible(false);
        
      }else if(ae.getSource()==b10){
          
          try {
              new PickUp().setVisible(true);
          } catch (SQLException ex) {
              Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
          }
        this.setVisible(false);
 
      }else if(ae.getSource()==b12){
          new Login().setVisible(true);
        this.setVisible(false);
        
      }
}  
}
