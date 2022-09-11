
package hotelmanagement;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HotelManagement extends JFrame implements ActionListener{ 

    HotelManagement()
    {
    setBounds(300,100,1024,682);
    
            
    ImageIcon i1= new ImageIcon(("C:\\Users\\NandKishor\\Documents\\NetBeansProjects\\HotelManagement\\src\\hotelmanagement\\icons\\Homepage.jpg"));
    JLabel l1= new JLabel(i1);
    l1.setBounds(0,0,1024,682);
    add(l1);
    
    JLabel l2= new JLabel("Hotel Management System");
    l2.setBounds(20,450,1000,70);
    l2.setForeground(Color.WHITE);
    l2.setFont(new Font("serif",Font.PLAIN,70));
    l1.add(l2);
    
    
    JLabel l3= new JLabel("ADMIN");
    l3.setBounds(800,370,150,30);
    l3.setForeground(Color.WHITE);
    l3.setFont(new Font("serif",Font.PLAIN,15));
   //l3.setForeground(Color.BLACK);
    l1.add(l3);
    
    JButton b1=new JButton("Next");
  b1.setFont(new Font("Times New Roman",Font.PLAIN,17));
    b1.setForeground(Color.BLACK);
    b1.setBounds(800,400,80,40);
    b1.addActionListener(this);
   l1.add(b1);
    setLayout(null);
    setVisible(true);
    
    
    while(true){
        l2.setVisible(false);
        try{
            Thread.sleep(500);
        }catch(Exception e){
        }
            l2.setVisible(true);
            try{
                Thread.sleep(500);
                
            }catch(Exception e){}
        }
    }
    

public void actionPerformed(ActionEvent ae){
                new Login().setVisible(true);
                this.setVisible(false);
                
        }
        
        public static void main(String[] args) {
                HotelManagement window = new HotelManagement();
                window.setVisible(true);			
	}
}




      