package hms;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class update_patient_details extends JFrame{
	update_patient_details(){
		
		JPanel panel = new JPanel();
		panel.setBounds(5,5,940,490);
		panel.setBackground(new Color(90,156,163));
		panel.setLayout(null);
		add(panel);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fp.jpg"));
		Image image = i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(image);
		JLabel label = new JLabel(i2);
		label.setBounds(500,60,300,300);
		panel.add(label);		
		
		JLabel label1= new JLabel ("Update Patient Details");
		label1.setBounds(124,11,260,25);
		label1.setFont(new Font("Tahoma",Font.BOLD,20));
		label1.setForeground(Color.WHITE);
		panel.add(label1);
		
		JLabel label2= new JLabel ("Name :");
		label2.setBounds(25,88,100,14);
		label2.setFont(new Font("Tahoma",Font.PLAIN,14));
		label2.setForeground(Color.WHITE);
		panel.add(label2);
		
		Choice choice= new Choice();
		choice.setBounds(248,85,100,25);
		panel.add(choice);
		
		try {
			conn c= new conn();
			ResultSet resultSet= c.statement.executeQuery("select * from Patient_info");
			while(resultSet.next()) {
				choice.add(resultSet.getString("Name"));
			}
		}catch(Exception e) {
			e.printStackTrace()
;		}
		JLabel label3= new JLabel ("Room Number :");
		label3.setBounds(25,129,100,14);
		label3.setFont(new Font("Tahoma",Font.PLAIN,14));
		label3.setForeground(Color.WHITE);
		panel.add(label3);
		
		JTextField textFieldR= new JTextField();
		textFieldR.setBounds(248,129,148,20);
		panel.add(textFieldR);
		
		JLabel label4= new JLabel ("In Time :");
		label4.setBounds(25,174,100,14);
		label4.setFont(new Font("Tahoma",Font.PLAIN,14));
		label4.setForeground(Color.WHITE);
		panel.add(label4);
		
		JTextField textFieldINTime= new JTextField();
		textFieldINTime.setBounds(248,174,148,20);
		panel.add(textFieldINTime);
		
		JLabel label5= new JLabel ("Ampount Paid :");
		label5.setBounds(25,216,100,14);
		label5.setFont(new Font("Tahoma",Font.PLAIN,14));
		label5.setForeground(Color.WHITE);
		panel.add(label5);
		
		JTextField textFieldAmount= new JTextField();
		textFieldAmount.setBounds(248,216,148,20);
		panel.add(textFieldAmount);
		
		
		JLabel label6= new JLabel ("Pending Amount :");
		label6.setBounds(25,261,100,14);
		label6.setFont(new Font("Tahoma",Font.PLAIN,14));
		label6.setForeground(Color.WHITE);
		panel.add(label6);
		
		JTextField textFieldPending= new JTextField();
		textFieldPending.setBounds(248,261,148,20);
		panel.add(textFieldPending);
		
		JButton check = new JButton("Check");
		check.setBounds(281,378,89,23);
		check.setBackground(Color.BLACK);
		check.setForeground(Color.WHITE);
		panel.add(check);
		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id=choice.getSelectedItem();
				String q="select * from Patient_info where Name= '"+id+"'";
				
				try {
					conn c= new conn();
					ResultSet resultSet= c.statement.executeQuery(q);
					while(resultSet.next()) {
						textFieldR.setText(resultSet.getString("Room_Number"));
						textFieldINTime.setText(resultSet.getString("Time"));
						textFieldAmount.setText(resultSet.getString("Deposite"));

					}
					
					ResultSet resultSet1= c.statement.executeQuery("select * from room where room_no ='"+textFieldR.getText()+"'");
					while(resultSet1.next()) {
						String price= resultSet1.getString("price");
						int amountPaid=Integer.parseInt(price)-Integer.parseInt(textFieldAmount.getText());
						textFieldPending.setText(""+amountPaid);
					}
					
					
					
					
				}catch(Exception E) {
					E.printStackTrace();
				}
			}
			
		});
		
		JButton Update = new JButton("Update");
		Update.setBounds(56,378,89,23);
		Update.setBackground(Color.BLACK);
		Update.setForeground(Color.WHITE);
		panel.add(Update);
		Update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					
					conn c= new conn();
					String q= choice.getSelectedItem();
					String room=textFieldR.getText();
					String time=textFieldINTime.getText();
					String amount=textFieldAmount.getText();
					c.statement.executeUpdate("update Patient_Info set Room_Number ='"+room+"',Time='"+time+"',Deposite='"+amount+"' where name='"+q+"'");
					
					JOptionPane.showMessageDialog(null, "Update Successfully");
					setVisible(false);
					
					
				}catch(Exception E) {
					E.printStackTrace();
				}
			}
			
		});

		JButton back = new JButton("back");
		back.setBounds(168,378,89,23);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		panel.add(back);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
			
		});

		
		
		
		
		setSize(950,500);
		setLayout(null);
		setLocation(400,250);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new update_patient_details();
	}

}
