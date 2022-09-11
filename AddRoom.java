
package hotelmanagement;

import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class AddRoom extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JComboBox c1,c2,c3;
    JButton b1,b2;
            
    AddRoom(){
        
        JLabel I1=new JLabel("ADD ROOMS");
        I1.setFont(new Font("Book Antiqua",Font.PLAIN,17));
        I1.setBounds(200,20,150,20);
        add(I1);
        
        JLabel room=new JLabel("ROOM NUMBER");
        room.setFont(new Font("Book Antiqua",Font.PLAIN,17));
        room.setBounds(100,80,150,20);
        add(room);
        
        t1= new JTextField();
        t1.setBounds(300,80,150,25);
        add(t1);
    
        JLabel available=new JLabel("AVAILABLE");
        available.setFont(new Font("Book Antiqua",Font.PLAIN,17));
        available.setBounds(100,125,150,20);
        add(available);
        
        String s1[] = { "Available", "Occupied" };
        c1 = new JComboBox(s1);
        c1.setFont(new Font("Times New Roman",Font.PLAIN,15));
        c1.setBounds(300,125,150,30);
        c1.setBackground(Color.WHITE);
        add(c1);
    
   
        JLabel status=new JLabel("CLEANING STATUS");
        status.setFont(new Font("Book Antiqua",Font.PLAIN,17));
        status.setBounds(100,163,200,20);
        add(status);
        
        String s2[] = { "Cleaned","Dirty"};
        c2 = new JComboBox(s2);
        c2.setFont(new Font("Times New Roman",Font.PLAIN,15));
        c2.setBounds(300,160,150,30);
        c2.setBackground(Color.WHITE);
        add(c2);
    
        
        JLabel price=new JLabel("PRICE");
        price.setFont(new Font("Book Antiqua",Font.PLAIN,17));
        price.setBounds(100,203,150,20);
        add(price);
       
        t2= new JTextField();
        t2.setBounds(300,203,150,25);
        add(t2);
       
        JLabel type=new JLabel("BED TYPE");
        type.setFont(new Font("Book Antiqua",Font.PLAIN,17));
        type.setBounds(100,245,150,20);
        add(type);
        
        String s3[] = { "Single Bed", "Double Bed"};
        c3 = new JComboBox(s3);
        c3.setFont(new Font("Times New Roman",Font.PLAIN,15));
        c3.setBounds(300,240,150,30);
        c3.setBackground(Color.WHITE);
        add(c3);
        
        b1=new JButton("ADD ROOM");
        b1.setBounds(100,320,130,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("CANCEL");
        b2.setBounds(300,320,130,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1= new ImageIcon(("C:\\Users\\NandKishor\\Documents\\NetBeansProjects\\HotelManagement\\src\\hotelmanagement\\icons\\hotel.jpg"));
    Image i2 = i1.getImage().getScaledInstance(350,400,Image.SCALE_DEFAULT);
    JLabel l1= new JLabel(i1);
    l1.setBounds(470,30,400,400);
    add(l1);
    
        setBounds(400,150,900,500);
        setLayout(null);
        setVisible(true);
    }
    
    public static void main(String []args){
    new AddRoom().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==b1){
            
            String room= t1.getText();
            String available = (String)c1.getSelectedItem();
            String status=(String)c2.getSelectedItem();
            String price=t2.getText();
            String type = (String)c3.getSelectedItem();
            
            Conn c = new Conn();
            try{
                String str="insert into room value('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"New Room Added");
            }catch(HeadlessException | SQLException e){
            System.out.println(e);
            }
            
        }else if(ae.getSource()==b2){
        this.setVisible(false);
        }
         
    }
    
}
