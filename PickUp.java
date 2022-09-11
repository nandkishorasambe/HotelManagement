
package hotelmanagement;


import java.awt.BorderLayout;
import java.awt.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PickUp extends JFrame{
    
    	Connection Conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
        JTable table;
        Choice c1;
        
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PickUp frame = new PickUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close()
	{
		this.dispose();
	}
	public PickUp() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		
		JLabel lblPickUpService = new JLabel("PICK UP SERVICE");
		lblPickUpService.setFont(new Font("Times New Roman",Font.PLAIN,15));
		lblPickUpService.setBounds(90, 11, 250, 25);
		add(lblPickUpService);
		
		JLabel lblTypeOfCar = new JLabel("TYPE OF CAR");
		lblTypeOfCar.setBounds(32, 97, 150, 14);
                lblTypeOfCar.setFont(new Font("Times New Roman",Font.PLAIN,15));
		add(lblTypeOfCar);

		
                c1 = new Choice();
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from driver");
                    while(rs.next()){
                        c1.add(rs.getString("model"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(200, 94, 150, 25);
		add(c1);

                
		
		JLabel lblInfo = new JLabel("NAME");
		lblInfo.setBounds(24, 208, 46, 14);
                lblInfo.setFont(new Font("Times New Roman",Font.PLAIN,15));
		add(lblInfo);
		
		JButton btnRegister = new JButton("DISPLAY");
                btnRegister.setFont(new Font("Times New Roman",Font.PLAIN,15));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String SQL = "select * from driver where model = '"+c1.getSelectedItem()+"'";
				try{
				
					Conn c = new Conn();
					rs = c.s.executeQuery(SQL);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
				
				
			}
		});
		btnRegister.setBounds(200, 400, 120, 30);
                btnRegister.setBackground(Color.BLACK);
                btnRegister.setForeground(Color.WHITE);
		add(btnRegister);
		
		JButton btnExit = new JButton("BACK");
                btnExit.setFont(new Font("Times New Roman",Font.PLAIN,15));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(420, 400, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		add(btnExit);
		
		table = new JTable();
		table.setBounds(0, 233, 800, 250);
		add(table);
		
		JLabel lblNewLabel = new JLabel("AGE");
		lblNewLabel.setBounds(165, 208, 46, 14);
                lblNewLabel.setFont(new Font("Times New Roman",Font.PLAIN,15));
		add(lblNewLabel);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setBounds(264, 208,80, 14);
                lblGender.setFont(new Font("Times New Roman",Font.PLAIN,15));
		add(lblGender);
		
		JLabel lblTypeOfDriver = new JLabel("COMPANY");
		lblTypeOfDriver.setBounds(366, 208, 80, 14);
                lblTypeOfDriver.setFont(new Font("Times New Roman",Font.PLAIN,15));
		add(lblTypeOfDriver);
		
		JLabel lblDateOfThe = new JLabel("BRAND");
		lblDateOfThe.setBounds(486, 208, 105, 14);
                lblDateOfThe.setFont(new Font("Times New Roman",Font.PLAIN,15));
		add(lblDateOfThe);
	
		JLabel lblAirport = new JLabel("AVAILABLE");
		lblAirport.setBounds(600, 208, 100, 14);
                lblAirport.setFont(new Font("Times New Roman",Font.PLAIN,15));
		add(lblAirport);
		
		JLabel lblAvailable = new JLabel("LOCATION");
		lblAvailable.setBounds(700, 208, 100, 14);
                lblAvailable.setFont(new Font("Times New Roman",Font.PLAIN,15));
		add(lblAvailable);
                
                 setLayout(null);
                 setBounds(400,200,850,500);
                 setVisible(true);
     
                
                getContentPane().setBackground(Color.WHITE);
	}
}
        
