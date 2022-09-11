/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagement;


import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;


import java.sql.*;	
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class CheckOut extends JFrame implements ActionListener{
    	Connection Conn = null;
	PreparedStatement pst = null;
	private JTextField t1;
        Choice c1;
	JButton b1,b2,b3;

	
	public CheckOut() {
		//conn = Javaconnect.getDBConnection();
	JLabel I1=new JLabel("CHECK IN DETAILS");
        I1.setFont(new Font("Times New Roman",Font.PLAIN,17));
        I1.setBounds(300,15,150,30);
        I1.setBackground(Color.BLACK);
        add(I1);
        
        JLabel id=new JLabel("CUSTOMER ID");
        id.setFont(new Font("Times New Roman",Font.PLAIN,15));
        id.setBounds(100,45,150,30);
        id.setBackground(Color.BLACK);
        add(id);
      
                c1 = new Choice();
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                        c1.add(rs.getString("number"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(300, 50, 150, 20);
		add(c1);
                
                JLabel room=new JLabel("ROOM NUMBER");
                room.setFont(new Font("Times New Roman",Font.PLAIN,15));
                room.setBounds(100,95,150,30);
                room.setBackground(Color.BLACK);
                add(room);
        
                	
		
		t1 = new JTextField();
                t1.setBounds(300, 100, 150, 20);
		add(t1);
                
                 b1 = new JButton("CHECK-OUT");
                 b1.setBounds(100, 200, 150, 25);
                 b1.setBackground(Color.BLACK);
                 b1.setForeground(Color.WHITE);
                 b1.addActionListener(this);
	         add(b1);
                 
                b2 = new JButton("Back");
		b2.setBounds(250, 200, 100, 25);
                b2.setBackground(Color.BLACK);
                b2.setForeground(Color.WHITE);
                b2.addActionListener(this);
		add(b2);
            
                            
    ImageIcon i1= new ImageIcon(("C:\\Users\\NandKishor\\Documents\\NetBeansProjects\\HotelManagement\\src\\hotelmanagement\\icons\\in.jpg"));
    Image i2 = i1.getImage().getScaledInstance(400, 400,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel L1 = new JLabel(i3);
    L1.setBounds(465,30,400,400); 
    add(L1);
    
                 setLayout(null);
        setBounds(500,200,900,500);
        setVisible(true);
     
        }
public static void main (String []args){
new CheckOut().setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent ae) {
        Conn c =new Conn();
        if(ae.getSource()== b1){
     
            String id=c1.getSelectedItem();
            String room=t1.getText();
            String str="Delete from customer where number ='"+id+"'";
            String str2="update room set available ='available' where room_number ='"+room+"'";
           //Conn c=new Conn();
            try{
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"CHECKOUT DONE");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch(Exception e){}
            
        }else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource()==b3){
            
        
            String id =c1.getSelectedItem();
            try{
                ResultSet rs= c.s.executeQuery("select * from customer where number = '"+id+"'");
               while(rs.next()){
                    //System.out.println("clicked");
                    t1.setText(rs.getString("room"));
                }
            }catch(Exception e){}
        }
        }
   
}