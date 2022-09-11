
package hotelmanagement;

import java.awt.BorderLayout;
import java.awt.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SearchRoom extends JFrame{
   
    
    	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	//private JPanel contentPane;
        JTextField t1;
	 JTable table;
        Choice c1;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchRoom frame = new SearchRoom();
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

	/**
	 * Create the frame.
	 * @throws SQLException
	 */
	public SearchRoom() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		
		JLabel lblSearchForRoom = new JLabel("SEARCH FOR ROOM");
		lblSearchForRoom.setBounds(250, 11, 186, 31);
                lblSearchForRoom.setFont(new Font("Times New Roman",Font.PLAIN,15));
		add(lblSearchForRoom);
		
		JLabel lblRoomAvailable = new JLabel("ROOM EED TYPE");
		lblRoomAvailable.setBounds(50, 73, 130, 14);
                lblRoomAvailable.setFont(new Font("Times New Roman",Font.PLAIN,15));
		add(lblRoomAvailable);
		
		JLabel lblRoomType = new JLabel("ROOM NUMBER");
		lblRoomType.setBounds(23, 162, 110, 14);
                lblRoomType.setFont(new Font("Times New Roman",Font.PLAIN,15));
		add(lblRoomType);
		
		JLabel lblRoomAvailable_1 = new JLabel("AVAILABILITY");
		lblRoomAvailable_1.setBounds(175, 162, 120, 14);
                lblRoomAvailable_1.setFont(new Font("Times New Roman",Font.PLAIN,15));
		add(lblRoomAvailable_1);
		
		JLabel lblPrice_1 = new JLabel("PRICE");
		lblPrice_1.setBounds(458, 162, 46, 14);
                lblPrice_1.setFont(new Font("Times New Roman",Font.PLAIN,15));
		add(lblPrice_1);
                
                JLabel l1 = new JLabel("BED TYPE");
		l1.setBounds(580, 162, 96, 14);
                l1.setFont(new Font("Times New Roman",Font.PLAIN,15));
		add(l1);
		
		JCheckBox checkRoom = new JCheckBox("ONLY DISPLAY AVAILABLE");
		checkRoom.setBounds(400, 69, 250, 23);
                checkRoom.setBackground(Color.WHITE);
                checkRoom.setFont(new Font("Times New Roman",Font.PLAIN,15));
                add(checkRoom);
		
		
                c1 = new Choice();
                c1.add("SINGLE BED");
                c1.add("DOUBLE BED");
                c1.setBounds(200, 70, 120, 20);
		add(c1);
		
                 
                 setLayout(null);
                 setBounds(500,200,800,500);
                 setVisible(true);
     
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener((ActionEvent e) -> {
                    String SQL = "select * from Room where bed_type = '"+c1.getSelectedItem()+"'";
                    String SQL2 = "select * from Room where available = 'Available' AND bed_type = '"+c1.getSelectedItem()+"'";
                    try{
                        Conn c = new Conn();
                        rs = c.s.executeQuery(SQL);
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                        
                        if(checkRoom.isSelected())
                        {
                            rs = c.s.executeQuery(SQL2);
                            table.setModel(DbUtils.resultSetToTableModel(rs));
                        }
                        
                        
                    }catch (SQLException ss)
                    {
                    }
                });
		btnSearch.setBounds(200, 400, 120, 30);
                btnSearch.setBackground(Color.BLACK);
                btnSearch.setForeground(Color.WHITE);
		add(btnSearch);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener((ActionEvent e) -> {
                    new Reception().setVisible(true);
                    setVisible(false);
                });
		btnExit.setBounds(380, 400, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		add(btnExit);
		
		table = new JTable();
		table.setBounds(0, 187, 700, 300);
		add(table);
		
		JLabel lblCleanStatus = new JLabel("CLEAN STATUS");
		lblCleanStatus.setBounds(306, 162, 110, 14);
                lblCleanStatus.setFont(new Font("Times New Roman",Font.PLAIN,15));
                lblCleanStatus.setBackground(Color.WHITE);
		add(lblCleanStatus);
                
                getContentPane().setBackground(Color.WHITE);
	}

    static class setVisible {

        public setVisible(boolean b) {
        }
    }
}

