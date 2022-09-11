package hotelmanagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem I1,I2,I3,I4,i5,i6,i7;
    
    Dashboard (){
        mb=new JMenuBar();
        add(mb);
        
        m1=new JMenu("HOTEL MANAGEMENT");
        m1.setForeground(Color.BLACK);
        mb.add(m1);
        
        m2=new JMenu("ADMIN");
        m2.setForeground(Color.BLACK);
        mb.add(m2);
        
        I1=new JMenuItem("RECEPTION");
        I1.addActionListener(this);
        m1.add(I1);
        
         
       
        
         I2=new JMenuItem("ADD EMPLOYEE");
         I2.addActionListener(this);
        m2.add(I2);
        
         I3=new JMenuItem("ADD ROOM");
         I3.addActionListener(this);
        m2.add(I3);
        
         I4=new JMenuItem("ADD DRIVER");
         I4.addActionListener(this);
        m2.add(I4);
        
        mb.setBounds(0,0,1920,30);
        
                
    ImageIcon i1= new ImageIcon(("C:\\Users\\NandKishor\\Documents\\NetBeansProjects\\HotelManagement\\src\\hotelmanagement\\icons\\new.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1600, 800,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel L1 = new JLabel(i3);
    L1.setBounds(0, 0, 1600,800); 
    add(L1);
    
    JLabel L2=new JLabel("WELCOMES TO SHEGAON HOTEL");
    L2.setBounds(450,50,1000,50);
    L2.setForeground(Color.BLACK);
    L2.setFont(new Font("Tahoma",Font.PLAIN,46));
    L1.add(L2);
        
        setLayout(null);
        setBounds(0,0,1920,1080);
        setVisible(true);
    }
    public static void main(String[] args){
    new Dashboard().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("RECEPTION")){
       new Reception().setVisible(true);
    }else if(ae.getActionCommand().equals("ADD EMPLOYEE")){
        new AddEmployee().setVisible(true);
    }else if(ae.getActionCommand().equals("ADD ROOM")){
       new AddRoom().setVisible(true);
    }else if (ae.getActionCommand().equals("ADD DRIVER")){
       new AddDriver().setVisible(true);
    }
}   }
