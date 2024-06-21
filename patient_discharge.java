package hms;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

public class patient_discharge extends JFrame {

	patient_discharge(){

		JPanel panel= new JPanel();
		panel.setBounds(5,5,790,390);
		panel.setBackground(new Color(90,156,163));
		panel.setLayout(null);
		add(panel);
		
		JLabel label1= new JLabel("Check-out");
		label1.setBounds(100,20,150,20);
		label1.setFont(new Font("Tahoma",Font.BOLD,20));
		label1.setForeground(Color.WHITE);
		panel.add(label1);
		
		JLabel label2= new JLabel("Customer Id");
		label2.setBounds(30,80,150,20);
		label2.setFont(new Font("Tahoma",Font.BOLD,14));
		label2.setForeground(Color.WHITE);
		panel.add(label2);
		
		Choice choice= new Choice();
		choice.setBounds(200,80,150,25);
		panel.add(choice);
		
		try {
			conn c= new conn();
			ResultSet resultSet= c.statement.executeQuery("select * from Patient_Info");
			while(resultSet.next()) {
				choice.add(resultSet.getString("number"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		JLabel label3= new JLabel("Room Number");
		label3.setBounds(30,130,150,20);
		label3.setFont(new Font("Tahoma",Font.BOLD,14));
		label3.setForeground(Color.WHITE);
		panel.add(label3);
		
		
		JLabel RNo= new JLabel();
		RNo.setBounds(200,130,150,20);
		RNo.setFont(new Font("Tahoma",Font.BOLD,14));
		RNo.setForeground(Color.WHITE);
		panel.add(RNo);
		
		JLabel label4= new JLabel("In Time");
		label4.setBounds(30,180,150,20);
		label4.setFont(new Font("Tahoma",Font.BOLD,14));
		label4.setForeground(Color.WHITE);
		panel.add(label4);
		
		JLabel INTime= new JLabel("");
		INTime.setBounds(200,180,250,20);
		INTime.setFont(new Font("Tahoma",Font.BOLD,14));
		INTime.setForeground(Color.WHITE);
		panel.add(INTime);
		
		JLabel label5= new JLabel("Out Time");
		label5.setBounds(30,230,150,20);
		label5.setFont(new Font("Tahoma",Font.BOLD,14));
		label5.setForeground(Color.WHITE);
		panel.add(label5);
		
		Date date= new Date();
		
		JLabel OUTTime= new JLabel(""+date);
		OUTTime.setBounds(200,230,250,20);
		OUTTime.setFont(new Font("Tahoma",Font.BOLD,14));
		OUTTime.setForeground(Color.WHITE);
		panel.add(OUTTime);
		
		JButton discharge= new JButton("Discharge");
		discharge.setBounds(30,300,120,38);
		discharge.setBackground(Color.BLACK);
		discharge.setForeground(Color.WHITE);
		panel.add(discharge);
		discharge.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				conn c= new conn();
				try {
					c.statement.executeUpdate("delete from Patient_Info where number ='"+choice.getSelectedItem()+"'");
					c.statement.executeUpdate("update room set Availability = 'Available' where room_no = '"+RNo.getText()+"'" );
					JOptionPane.showMessageDialog(null, "Done");
					setVisible(false);
				
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		
		
		
		JButton Check= new JButton("Check");
		Check.setBounds(170,300,120,38);
		Check.setBackground(Color.BLACK);
		Check.setForeground(Color.WHITE);
		panel.add(Check);
		Check.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				conn c= new conn();
				try {
					ResultSet resultSet=c.statement.executeQuery("select * from Patient_Info where number ='"+choice.getSelectedItem()+"'");
					while(resultSet.next()) {
						RNo.setText(resultSet.getString("Room_Number"));
						INTime.setText(resultSet.getString("Time"));
					}
				
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		
		
		JButton Back= new JButton("Back");
		Back.setBounds(300,300,120,38);
		Back.setBackground(Color.BLACK);
		Back.setForeground(Color.WHITE);
		panel.add(Back);
		Back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			}
			
			});
		
		setSize(800,400);
		setLocation(400,250);
		setLayout(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new patient_discharge();
	}

}
