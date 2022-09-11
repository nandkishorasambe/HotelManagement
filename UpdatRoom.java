
package hotelmanagement;

import java.awt.BorderLayout;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdatRoom extends JFrame{
    Connection conn = null;
PreparedStatement pst = null;
	//private JPanel contentPane;
	private JTextField txt_ID;
	private JTextField txt_Ava;
	private JTextField txt_Status;
	private JTextField txt_Room;
        
        Choice c1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatRoom frame = new UpdatRoom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close(){
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public UpdatRoom() throws SQLException {
		
		JLabel lblUpdateRoomStatus = new JLabel("Update Room Status");
		lblUpdateRoomStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateRoomStatus.setBounds(85, 11, 206, 34);
		add(lblUpdateRoomStatus);
		
		JLabel lblNewLabel = new JLabel("Guest ID:");
		lblNewLabel.setBounds(27, 87, 90, 14);
		add(lblNewLabel);
                
                c1 = new Choice();
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                        c1.add(rs.getString("number"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(160, 84, 140, 20);
		add(c1);
		
		JLabel lblAvailability = new JLabel("Availability:");
		lblAvailability.setBounds(27, 187, 90, 14);
		add(lblAvailability);
		
		JLabel lblCleanStatus = new JLabel("Clean Status:");
		lblCleanStatus.setBounds(27, 240, 90, 14);
		add(lblCleanStatus);
		
		
		txt_Ava = new JTextField();
		txt_Ava.setBounds(160, 184, 140, 20);
		add(txt_Ava);
		txt_Ava.setColumns(10);
		
		txt_Status = new JTextField();
		txt_Status.setBounds(160, 237, 140, 20);
		add(txt_Status);
		txt_Status.setColumns(10);
                
                txt_Room = new JTextField();
		txt_Room.setBounds(160, 130, 140, 20);
		add(txt_Room);
		txt_Room.setColumns(10);
                
                JButton b1 = new JButton("Check");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try{
                                String s1 = c1.getSelectedItem();
				Conn c = new Conn();
                                
                                ResultSet rs1 = c.s.executeQuery("select * from customer where number= "+s1);
                                
                                while(rs1.next()){
                                    txt_Room.setText(rs1.getString("room"));    
                                }
                            }catch(Exception ee){}
                            try{
                                Conn c  = new Conn();
                                ResultSet rs2 = c.s.executeQuery("select * from room where room_number = "+txt_Room.getText());
                                while(rs2.next()){
                                    txt_Ava.setText(rs2.getString("available")); 
                                    txt_Status.setText(rs2.getString("status"));
                                }
                            }catch(Exception ee){}
                        }
		});
		b1.setBounds(120, 315, 89, 23);
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);
		add(b1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) throws NumberFormatException {
				
				try{
                                    Conn c = new Conn();
                                    String str = "update room set status = '"+txt_Status.getText()+"'room where room_number = '"+txt_Room.getText()+"'";
                                    c.s.executeUpdate(str);
                                    JOptionPane.showMessageDialog(null, "Update Sucessful");
                                    
                                    new Reception().setVisible(true);
                                    setVisible(false);
				}catch (Exception ee){
					ee.printStackTrace();
				}
				
			
			}
		});
		btnUpdate.setBounds(60, 355, 89, 23);
                btnUpdate.setBackground(Color.BLACK);
                btnUpdate.setForeground(Color.WHITE);
		add(btnUpdate);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(180, 355, 89, 23);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		add(btnExit);
		
		JLabel lblRoomId = new JLabel("Room Number:");
		lblRoomId.setBounds(27, 133, 100, 14);
	        add(lblRoomId);
                
		ImageIcon i1= new ImageIcon(("C:\\Users\\NandKishor\\Documents\\NetBeansProjects\\HotelManagement\\src\\hotelmanagement\\icons\\uproom.jpg"));
    Image i2 = i1.getImage().getScaledInstance(400, 400,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel L1 = new JLabel(i3);
    L1.setBounds(320,60,400,316); 
    add(L1);
    
                
                 setLayout(null);
                 setBounds(500,200,750,600);
                 setVisible(true);
		getContentPane().setBackground(Color.WHITE);
	}

}
    
