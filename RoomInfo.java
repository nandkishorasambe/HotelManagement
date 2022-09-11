
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

public class RoomInfo extends JFrame {
    Connection Conn = null;
  JPanel contentPane;
 JTable table;
 JLabel lblAvailability;
 JLabel lblCleanStatus;
 JLabel lblNewLabel;
 JLabel lblNewLabel_1;
 JLabel lblRoomNumber;
 JLabel lblId;
    
 public static void  main(String[]args){
     EventQueue.invokeLater(new Runnable(){
         public void run(){
             try{
                 
                 RoomInfo frame=new RoomInfo();
                 frame.setVisible(true);
             }catch(SQLException e){
                 e.printStackTrace();
             }
         }
     });
 }
 public RoomInfo()throws SQLException{
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	setBounds(450, 200, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                
		
		table = new JTable();
		table.setBounds(0, 40, 500, 400);
		contentPane.add(table);
		
		JButton btnLoadData = new JButton("LOAD DATA");
				btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                    Conn c = new Conn();
					String displayCustomersql = "select * from room";
					//PrepareStatement pst = conn.prepareStatement(displayCustomersql);
					ResultSet rs = c.s.executeQuery(displayCustomersql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnLoadData.setBounds(100, 470, 120, 30);
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
		btnNewButton.setBounds(290, 470, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		lblAvailability = new JLabel("AVAILABILITY");
		lblAvailability.setBounds(119, 15, 100, 14);
		contentPane.add(lblAvailability);
		
		lblCleanStatus = new JLabel("CLEAN STATUS");
		lblCleanStatus.setBounds(216, 15, 100, 14);
		contentPane.add(lblCleanStatus);
		
		lblNewLabel = new JLabel("PRICE");
		lblNewLabel.setBounds(330, 15, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("BED TYPE");
		lblNewLabel_1.setBounds(417, 15, 110, 14);
		contentPane.add(lblNewLabel_1);

		
		lblId = new JLabel("ROOM NUMBER");
		lblId.setBounds(12, 15, 110, 14);
		contentPane.add(lblId);
                
                getContentPane().setBackground(Color.WHITE);
	}

}
 
         
         
         
         
         
         
         
         
         
         
    

