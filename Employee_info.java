package hms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Employee_info extends JFrame{

	Employee_info(){
		
		JPanel panel= new JPanel();
		panel.setBounds(5,5,990,590);
		panel.setBackground(new Color(109,164,170));
		add(panel);
		
		JTable table= new JTable();
		table.setBounds(10,34,980,450);
		table.setBackground(new Color(109,164,170));
		table.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(table);
		
		try {
			conn c= new conn();
			String q= "select * from EMP_INFO";
			ResultSet resultSet= c.statement.executeQuery(q);
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		JLabel label1= new JLabel("Name");
		label1.setBounds(41,9,70,20);
		label1.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label1);
		
		JLabel label2= new JLabel("Age");
		label2.setBounds(165,9,70,20);
		label2.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label2);
		
//		JLabel label3= new JLabel("Phone Number");
//		label3.setBounds(431,11,150,20);
//		label3.setFont(new Font("Tahoma",Font.BOLD,14));
//		panel.add(label3);
//		
//		JLabel label4= new JLabel("Salary");
//		label4.setBounds(431,11,150,20);
//		label4.setFont(new Font("Tahoma",Font.BOLD,14));
//		panel.add(label4);
//		
//		JLabel label5= new JLabel("Gmail");
//		label5.setBounds(431,11,150,20);
//		label5.setFont(new Font("Tahoma",Font.BOLD,14));
//		panel.add(label5);
//		
//		JLabel label6= new JLabel("Aadhar Number");
//		label6.setBounds(431,11,150,20);
//		label6.setFont(new Font("Tahoma",Font.BOLD,14));
//		panel.add(label6);
//		
//		
		JButton button= new JButton("Back");
		button.setBounds(350,500,120,30);
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		panel.add(button);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
			
		});
		
		
		setSize(1000,600);
		setLocation(350,230);
		setLayout(null);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Employee_info();
	}

}
