
package hotelmanagement;

import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class AddDriver extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton j1,j2;
    JComboBox c1;
    JButton b1,b2;
    AddDriver(){
    
    JLabel title=new JLabel ("ADD DRIVERS");
    title.setFont(new Font("Times New Roman",Font.PLAIN,17));
    title.setBounds(120,60,150,30);
    add(title);
     
    JLabel name=new JLabel ("NAME");
    name.setFont(new Font("Times New Roman",Font.PLAIN,17));
    name.setBounds(60,100,100,30);
    add(name);
    
    t1=new JTextField();
    t1.setBounds(250,100,150,30);
    add(t1);
   
    JLabel age=new JLabel ("AGE");
    age.setFont(new Font("Times New Roman",Font.PLAIN,17));
    age.setBounds(60,150,100,30);
    add(age);
    
    t2=new JTextField();
    t2.setBounds(250,150,150,30);
    add(t2);
    
    JLabel gender=new JLabel ("GENDER");
    gender.setFont(new Font("Times New Roman",Font.PLAIN,17));
    gender.setBounds(60,200,100,30);
    add(gender);
    
     j1 = new JRadioButton("MALE");
    j1.setFont(new Font("Times New Roman",Font.PLAIN,17));
    j1.setBounds(250, 200, 80, 27);
    add(j1);
	
    j2= new JRadioButton("FEMALE");
    j2.setFont(new Font("Times New Roman",Font.PLAIN,17));
    j2.setBounds(250,230, 100, 27);
    add(j2);
   
    JLabel car=new JLabel ("CAR COMPANY");
    car.setFont(new Font("Times New Roman",Font.PLAIN,17));
    car.setBounds(60,280,150,30);
    add(car);
    
    t3=new JTextField();
    t3.setBounds(250,280,150,30);
    add(t3);
    
    JLabel model=new JLabel ("CAR MODEL");
    model.setFont(new Font("Times New Roman",Font.PLAIN,17));
    model.setBounds(60,330,100,30);
    add(model);
    
    t4=new JTextField();
    t4.setBounds(250,330,150,30);
    add(t4);
    
    JLabel available=new JLabel ("AVAILABLE");
    available.setFont(new Font("Times New Roman",Font.PLAIN,17));
    available.setBounds(60,380,100,30);
    add(available);
    
     String s1[] = { "AVAILABLE", "BUSY" };
        c1 = new JComboBox(s1);
        c1.setFont(new Font("Times New Roman",Font.PLAIN,15));
        c1.setBounds(250,380,150,30);
        c1.setBackground(Color.WHITE);
        add(c1);
    
    JLabel location=new JLabel ("LOCATION");
    location.setFont(new Font("Times New Roman",Font.PLAIN,17));
    location.setBounds(60,430,100,30);
    add(location);
    
    t5=new JTextField();
    t5.setBounds(250,430,150,30);
    add(t5);
    
     b1=new JButton("ADD DRIVER");
        b1.setBounds(80,490,130,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("CANCEL");
        b2.setBounds(230,490,130,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
    
    setLayout(null);
    setBounds(410,150,800,600);
    setVisible(true);
    
    }
    public static void main(String []args){
    new AddDriver().setVisible(true);
    }
    
    @Override
 public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==b1){
            
            String name= t1.getText();
            String age = t2.getText();
            String car=t3.getText();
            String model=t4.getText();
            String available= (String)c1.getSelectedItem();
            String location =t5.getText();
            
            String gender = null;
            if(j1.isSelected()){
            gender ="Male";
                    }else if (j2.isSelected()){
                        gender="Female";
                    }
            
            Conn c = new Conn();
            try{
                String str="insert into driver value('"+name+"','"+age+"','"+gender+"','"+car+"','"+model+"','"+available+"','"+location+"')";
                c.s.executeUpdate(str);//PrepareStatement is allow function execute(),executeQuery(),executeUpdate()or more..
                
                JOptionPane.showMessageDialog(null,"New Room Added");
            }catch(HeadlessException | SQLException e){
            System.out.println(e);
            }
            
        }else if(ae.getSource()==b2){
        this.setVisible(false);
        }
         
    }
}
   