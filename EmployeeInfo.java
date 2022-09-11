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

public  class EmployeeInfo extends JFrame{
   	Connection conn = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblJob;
	private JLabel lblName;
	private JLabel lblDepartment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInfo frame = new EmployeeInfo();
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
	
	public EmployeeInfo() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(430, 200, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 34, 1000, 450);
		contentPane.add(table);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                    Conn c = new Conn();
				String displayCustomersql = "select * from Employee";
				ResultSet rs = c.s.executeQuery(displayCustomersql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
			
		});
		btnLoadData.setBounds(350, 500, 120, 30);
                btnLoadData.setBackground(Color.BLACK);
                btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(510, 500, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		lblNewLabel = new JLabel("NAME");
		lblNewLabel.setBounds(41, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblJob = new JLabel("AGE");
		lblJob.setBounds(159, 11, 46, 14);
		contentPane.add(lblJob);
		
		lblName = new JLabel("JOB");
		lblName.setBounds(263, 11, 46, 14);
		contentPane.add(lblName);
		
		lblDepartment = new JLabel("SALARY");
		lblDepartment.setBounds(350, 11, 86, 14);
		contentPane.add(lblDepartment);
                
                JLabel l1 = new JLabel("PHONE NUMBER");
		l1.setBounds(450, 11, 120, 14);
		contentPane.add(l1);
                
                JLabel l2 = new JLabel("ADHAR NUMBER");
		l2.setBounds(560, 11,120, 14);
		contentPane.add(l2);
                
                JLabel l3 = new JLabel("GMAIL");
		l3.setBounds(700, 11, 86, 14);
		contentPane.add(l3);
                
                JLabel l4 = new JLabel("QUALIFICATION");
		l4.setBounds(780, 11, 120, 14);
		contentPane.add(l4);
                
                JLabel l5 = new JLabel("GENDER");
		l5.setBounds(896, 11, 86, 14);
		contentPane.add(l5);
                
                getContentPane().setBackground(Color.WHITE);
	}
}