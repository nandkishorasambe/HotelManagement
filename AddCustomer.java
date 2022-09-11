
package hotelmanagement;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class AddCustomer extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JTextField t1,t2,t3,t4,t5,t6;
        JComboBox comboBox;
        JRadioButton r1,r2;
        Choice c1;
	
	public AddCustomer() throws SQLException {
	
                
		
		JLabel Head = new JLabel("NEW CUSTOMER FORM");
		Head.setFont(new Font("Yu Mincho", Font.PLAIN, 20)); 
                Head.setFont(new Font("Times New Roman",Font.PLAIN,17));
		Head.setBounds(118, 11, 260, 53);
		add(Head);
                
                JLabel id = new JLabel("ID :");
                   id.setFont(new Font("Times New Roman",Font.PLAIN,17));
		id.setBounds(35, 76, 200, 14);
		add(id);
                
                comboBox = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving license"});
                  // I1.setFont(new Font("Times New Roman",Font.PLAIN,17));
		comboBox.setBounds(271, 73, 150, 20);
		add(comboBox);
                
                JLabel number = new JLabel("NUMBER");
                   number.setFont(new Font("Times New Roman",Font.PLAIN,17));
	        number.setBounds(35, 111, 200, 14);
	        add(number);
                
                t1 = new JTextField();
		t1.setBounds(271, 111, 150, 20);
                 
		add(t1);
		t1.setColumns(10);
		
		JLabel Name = new JLabel("NAME");
		Name.setBounds(35, 151, 200, 14);
                   Name.setFont(new Font("Times New Roman",Font.PLAIN,17));
		add(Name);
		
		t2 = new JTextField();
		t2.setBounds(271, 151, 150, 20);
		add(t2);
		t2.setColumns(10);

                
		JLabel Gender = new JLabel("GENDER");
		Gender.setBounds(35, 191, 200, 14);
                   Gender.setFont(new Font("Times New Roman",Font.PLAIN,17));
		add(Gender);
                
                r1 = new JRadioButton("MALE");
                r1.setFont(new Font("Raleway", Font.BOLD, 14));
                r1.setBackground(Color.WHITE);
                r1.setBounds(271, 191, 80, 12);
                add(r1);
                
                r2 = new JRadioButton("FEMALE");
                r2.setFont(new Font("Raleway", Font.BOLD, 14));
                r2.setBackground(Color.WHITE);
                r2.setBounds(350, 191, 100, 12);
		add(r2);
                
		JLabel Country = new JLabel("COUNTRY");
		Country.setBounds(35, 231, 200, 14);
                   Country.setFont(new Font("Times New Roman",Font.PLAIN,17));
		add(Country);
		
		JLabel RoomNumber = new JLabel("ALLOCATED ROOM NUMBER");
		RoomNumber.setBounds(35, 274, 200, 14);
                RoomNumber.setFont(new Font("Times New Roman",Font.PLAIN,17));
		add(RoomNumber);
                
                c1 = new Choice();
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from room");
                    while(rs.next()){
                        c1.add(rs.getString("room_number"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(271, 274, 150, 20);
		add(c1);
		
		JLabel Status = new JLabel("CHECK-IN");
		Status.setBounds(35, 316, 200, 14);
                   Status.setFont(new Font("Times New Roman",Font.PLAIN,17));
		add(Status);
		
		JLabel Deposite = new JLabel("DEPOSITE");
		Deposite.setBounds(35, 359, 200, 14);
                  Deposite.setFont(new Font("Times New Roman",Font.PLAIN,17));
		add(Deposite);
		
		t3 = new JTextField();
		t3.setBounds(271, 231, 150, 20);
		add(t3);
		t3.setColumns(10);
		
		
		t5 = new JTextField();
		t5.setBounds(271, 316, 150, 20);
		add(t5);
		t5.setColumns(10);
		
		t6 = new JTextField();
		t6.setBounds(271, 359, 150, 20);
		add(t6);
		t6.setColumns(10);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            Conn c = new Conn();
                            String radio = null;
                            
                            if(r1.isSelected()){ 
                                radio = "Male";
                            }
                            else if(r2.isSelected()){ 
                                radio = "Female";
                            }
                            
                            String RoomNumber = c1.getSelectedItem();
                          
                            try{
	    			
                                String id = (String)comboBox.getSelectedItem(); 
	    			String number =  t1.getText();
	    			String Name =  t2.getText();
                                String gender =  radio;
	    			String contary =  t3.getText();
	    			String Status =  t5.getText();
                                String Deposite =  t6.getText();
                                
                                String q1 = "insert into customer values('"+id+"','"+number+"','"+Name+"','"+gender+"','"+contary+"','"+RoomNumber+"','"+Status+"','"+Deposite+"')";
                                String q2 = "update room set available = 'Occupied' where room_number = '"+RoomNumber+"'";
                                c.s.executeUpdate(q1);
                                c.s.executeUpdate(q2);
	    			
	    			
	    			JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                                new Reception().setVisible(true);
                                setVisible(false);
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
		    		catch(NumberFormatException s){
		    			JOptionPane.showMessageDialog(null, "Please enter a valid Number");
			}
			}
		});
		btnNewButton.setBounds(100, 430, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		add(btnNewButton);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            new Reception().setVisible(true);
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(260, 430, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		add(btnExit);
                
                    
       getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(400,200,600,600);
        setVisible(true);
    ;
	}
    public static void main(String []args) throws SQLException{
        new AddCustomer().setVisible(true);
        
    }
    
}


