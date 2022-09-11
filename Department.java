
package hotelmanagement;


import java.awt.BorderLayout;
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


public class Department  extends JFrame {
    	Connection Conn = null;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

        	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Department frame = new Department();
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

	public Department() throws SQLException {
		
		
		
		table = new JTable();
		table.setBounds(0, 40, 700, 350);
		add(table);
		
		JButton btnNewButton = new JButton("LOAD DATA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                    Conn c = new Conn();
                                    
					String displayCustomersql = "select * from Department";
					ResultSet rs = c.s.executeQuery(displayCustomersql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(170, 410, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
                add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new Reception().setVisible(true);
                                        setVisible(false);
			}
		});
		btnNewButton_1.setBounds(400, 410, 120, 30);
                btnNewButton_1.setBackground(Color.BLACK);
                btnNewButton_1.setForeground(Color.WHITE);
		add(btnNewButton_1);
		
		lblNewLabel = new JLabel("DEPARTMENT");
		lblNewLabel.setBounds(145, 11, 105, 14);
                lblNewLabel.setFont(new Font("Times New Roman",Font.PLAIN,15));
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("BUDGET");
		lblNewLabel_1.setBounds(431, 11, 75, 14);
                lblNewLabel_1.setFont(new Font("Times New Roman",Font.PLAIN,15));
		add(lblNewLabel_1);
                
                 setLayout(null);
                 setBounds(500,200,750,600);
                 setVisible(true);
     
                getContentPane().setBackground(Color.WHITE);
	}

}

    

