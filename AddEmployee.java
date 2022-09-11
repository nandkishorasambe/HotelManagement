package hotelmanagement;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;


public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1,b2;
    AddEmployee(){
    JLabel name =new JLabel("NAME");
    name.setFont(new Font("Times New Roman",Font.PLAIN,17));
    name.setBounds(60,50,120,30);
    add(name);
    
    t1=new JTextField();
    t1.setBounds(200,50,150,30);
    add(t1);
    
    JLabel age =new JLabel("AGE");
    age.setFont(new Font("Times New Roman",Font.PLAIN,17));
    age.setBounds(60,80,120,60);
    add(age);
    
    t2=new JTextField();
    t2.setBounds(200,90,150,30);
    add(t2);
    
   JLabel gender =new JLabel("GENDER");
    gender.setFont(new Font("Times New Roman",Font.PLAIN,17));
    gender.setBounds(60,120,120,60);
    add(gender);
    
    r1 = new JRadioButton("MALE");
    r1.setFont(new Font("Times New Roman",Font.PLAIN,17));
    r1.setBounds(200, 135, 80, 27);
    add(r1);
	
    r2 = new JRadioButton("FEMALE");
    r2.setFont(new Font("Times New Roman",Font.PLAIN,17));
    r2.setBounds(280, 135, 100, 27);
    add(r2);
            
    
      
    JLabel job =new JLabel("JOB");
    job.setFont(new Font("Times New Roman",Font.PLAIN,17));
    job.setBounds(60,195,120,60);
    add(job);
    
    String course[] = {"            ","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef","Security","Gardner"};
    c1 = new JComboBox(course);
    c1.setFont(new Font("Times New Roman",Font.PLAIN,15));
    c1.setBounds(200,210,150,30);
    c1.setBackground(Color.WHITE);
    add(c1);
            
    
     
    JLabel salary =new JLabel("SALARY");
    salary.setFont(new Font("Times New Roman",Font.PLAIN,17));
    salary.setBounds(60,235,120,60);
    add(salary);
    
    t3=new JTextField();
    t3.setBounds(200,255,150,30);
    add(t3);
    
    JLabel phone = new JLabel("PHONE");
    phone.setFont(new Font("Times New Roman", Font.PLAIN, 17));
    phone.setBounds(60, 280, 150, 60);
    add(phone);
	
    t4 = new JTextField();
    t4.setBounds(200, 300, 150, 27);
    add(t4);
	
    JLabel aadhar = new JLabel("AADHAR");
    aadhar.setFont(new Font("Times New Roman", Font.PLAIN, 17));
    aadhar.setBounds(60, 340, 150, 27);
    add(aadhar);
			
    t5 = new JTextField();
    t5.setBounds(200, 340, 150, 27);
    add(t5);
	
            
    JLabel email = new JLabel("EMAIL");
    email.setFont(new Font("Times New Roman", Font.PLAIN, 17));
    email.setBounds(60, 380, 150, 27);
    add(email);
			
    t6 = new JTextField();
    t6.setBounds(200, 380, 150, 27);
    add(t6);
    
    JLabel qualification =new JLabel("QUALIFICATION");
    qualification.setFont(new Font("Times New Roman",Font.PLAIN,17));
    qualification.setBounds(60,170,150,30);
    add(qualification);
    
    t7=new JTextField();
    t7.setBounds(200,170,150,30);
    add(t7);
    
    
    JLabel Headline = new JLabel("ADD EMPLOYEE DETAILS");
    Headline.setFont(new Font("Book Antiqua",Font.PLAIN,20));
    Headline.setBounds(55,10, 500,45);
    add(Headline);
    
    
     b1=new JButton("SUBMIT");
        b1.setBounds(150,440,130,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
       
        setLayout(null);
        setBounds(400,100,500,700);
        setVisible(true);
  
    }
  

  @Override
       public void actionPerformed(ActionEvent ae){
        
           String name = t1.getText();
            String age = t2.getText();
            String job =(String)c1.getSelectedItem();
            String salary =t3.getText();
            String phone =t4.getText();
            String aadhar =t5.getText();
            String email =t6.getText();
            String qualification =t7.getText();
            
            String gender = null;
            if(r1.isSelected()){
            gender ="Male";
                    }else if (r2.isSelected()){
                        gender="Female";
                    }
            
            Conn c = new Conn();
          
                String str="insert into employee value('"+name+"','"+age+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"','"+qualification+"','"+gender+"')";
              try{
                 c.s.executeUpdate(str);
                 JOptionPane.showMessageDialog(null,"Add New Employee");
                 this.setVisible(false);
                    }catch(HeadlessException | SQLException e){
                    System.out.println(e);  
                    }
       }
       
  public static void main (String[] args){
    new AddEmployee().setVisible(true);
        }
}

    
   
     


 