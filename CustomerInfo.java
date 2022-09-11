/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagement;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class CustomerInfo  extends JFrame{
    
     Connection Conn = null;
  JPanel contentPane;
 JTable table;
 JLabel lblAvailability;
 JLabel lblCleanStatus;
 JLabel lblNewLabel;
 JLabel lblNewLabel_1;
 JLabel lblRoomNumber;
 JLabel lblId;
   JLabel room,status,deposit;
   
 public static void  main(String[]args){
     EventQueue.invokeLater(new Runnable(){
         public void run(){
             try{
                 
                 CustomerInfo frame=new CustomerInfo();
                 frame.setVisible(true);
             }catch(Exception e){
                 e.printStackTrace();
             }
         }
     });
 }
 public CustomerInfo()throws SQLException{
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	setBounds(450, 200, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                
		
		table = new JTable();
		table.setBounds(0, 40, 600,400);
		contentPane.add(table);
		
		JButton btnLoadData = new JButton("LOAD DATA");
				btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                    Conn c = new Conn();
					String displayCustomersql = "select * from customer";
					//PreparedStatement pst = conn.prepareStatement(displayCustomersql);
					ResultSet rs = c.s.executeQuery(displayCustomersql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnLoadData.setBounds(100, 500, 120, 30);
                btnLoadData.setBackground(Color.BLACK);
                btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnNewButton.setBounds(290, 500, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		lblAvailability = new JLabel("ID");
		lblAvailability.setBounds(40, 15, 100, 14);
		contentPane.add(lblAvailability);
		
		lblCleanStatus = new JLabel("NUMBER");
		lblCleanStatus.setBounds(100, 15, 100, 14);
		contentPane.add(lblCleanStatus);
		
		lblNewLabel = new JLabel("NAME");
		lblNewLabel.setBounds(180, 15, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("GENDER");
		lblNewLabel_1.setBounds(250, 15, 110, 14);
		contentPane.add(lblNewLabel_1);

		
		lblId = new JLabel("COUNTRY");
		lblId.setBounds(320, 15, 110, 14);
		contentPane.add(lblId);
                
                room = new JLabel("ROOM");
		room.setBounds(400, 15, 110, 14);
		contentPane.add(room);
                
                status = new JLabel("CHECK-IN");
		status.setBounds(470, 15, 110, 14);
		contentPane.add(status);
                
                deposit = new JLabel("DEPOSIT");
		deposit.setBounds(540, 15, 110, 14);
		contentPane.add(deposit);
                
                getContentPane().setBackground(Color.WHITE);
	}

}

