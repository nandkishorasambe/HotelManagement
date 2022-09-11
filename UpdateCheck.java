
package hotelmanagement;

import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateCheck extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4,t5,t6;
    Choice c1;
    JButton b1,b2,b3;
    
    UpdateCheck(){
        JLabel I1=new JLabel("CHECK IN DETAILS");
        I1.setFont(new Font("Times New Roman",Font.PLAIN,17));
        I1.setBounds(300,15,150,30);
        I1.setBackground(Color.BLACK);
        add(I1);
        
        JLabel I2=new JLabel("CUSTOMER ID");
        I2.setFont(new Font("Times New Roman",Font.PLAIN,15));
        I2.setBounds(100,50,150,30);
        I2.setBackground(Color.BLACK);
        add(I2);
        
        c1=new Choice();
        try{
            Conn c =new Conn();
            ResultSet rs;
            rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch(Exception e){}
        c1.setBounds(300,50,150,30);
        add(c1);
        JLabel I3=new JLabel("ROOM NUMBER");
        I3.setFont(new Font("Times New Roman",Font.PLAIN,15));
        I3.setBounds(100,100,150,30);
        I3.setBackground(Color.BLACK);
        add(I3);
        
        t1= new JTextField();
        t1.setBounds(300,100,150,30);
        add(t1);
      
        JLabel I4=new JLabel("NAME");
        I4.setFont(new Font("Times New Roman",Font.PLAIN,15));
        I4.setBounds(100,150,150,30);
        I4.setBackground(Color.BLACK);
        add(I4);
        
        t2= new JTextField();
        t2.setBounds(300,150,150,30);
        add(t2);
      
        JLabel I5=new JLabel("CHECK IN");
        I5.setFont(new Font("Times New Roman",Font.PLAIN,15));
        I5.setBounds(100,200,150,30);
        I5.setBackground(Color.BLACK);
        add(I5);
        
        t3= new JTextField();
        t3.setBounds(300,200,150,30);
        add(t3);
      
        JLabel I6=new JLabel("AMOUNT PAID");
        I6.setFont(new Font("Times New Roman",Font.PLAIN,15));
        I6.setBounds(100,250,150,30);
        I6.setBackground(Color.BLACK);
        add(I6);
        
        t4= new JTextField();
        t4.setBounds(300,250,150,30);
        add(t4);
      
        JLabel I7=new JLabel("PENDING AMOUNT");
        I7.setFont(new Font("Times New Roman",Font.PLAIN,15));
        I7.setBounds(100,300,150,30);
        I7.setBackground(Color.BLACK);
        add(I7);
        
        t5= new JTextField();
        t5.setBounds(300,300,150,30);
        add(t5);
        
          b1=new JButton("ADD ROOM");
        b1.setBounds(170,380,130,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("CANCEL");
        b2.setBounds(350,380,130,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
       // add(b2);
      
        b3=new JButton("BACK");
        b3.setBounds(450,380,130,30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);
      
        
        setLayout(null);
        setBounds(400,200,800,500);
        setVisible(false);
     
    }
     @Override
 public void actionPerformed(ActionEvent ae) {
if(ae.getSource()==b1){
    Conn c=new Conn();
    try{
        String room=null;
        
        String id=c1.getSelectedItem();
        String str="select * from customer where number = '"+id+"'";
        ResultSet rs=c.s.executeQuery(str);
        while(rs.next()){
          t1.setText(rs.getString("room"));
          t2.setText(rs.getString("name"));
          t3.setText(rs.getString("status"));
          t4.setText(rs.getString("deposit"));
          room=rs.getString("room");
        }
        ResultSet rs2=c.s.executeQuery("select * from room where room_number = '"+room+"'");
        while(rs2.next()){
         t5.setText(rs2.getString("price"));
        }
    }catch(SQLException e){
        
    }
}else if(ae.getSource()==b2){
    
}else if(ae.getSource()==b3){
    new Reception().setVisible(true);
    this.setVisible(false);
}
}

    public static void main(String[] args){
        new UpdateCheck().setVisible(true);
    }
}
