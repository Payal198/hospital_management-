package hms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.print.DocFlavor.URL;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	
	JTextField textfield;
	JPasswordField passwordfield;
	JButton b1, b2;
	Login(){
		
		JLabel namelabel= new JLabel("Username");
		namelabel.setBounds(40,20,100,30);
		namelabel.setFont(new Font("Tahoma",Font.BOLD,16));
		namelabel.setForeground(Color.BLACK);
		add(namelabel);
		
		JLabel password= new JLabel("password");
		password.setBounds(40,70,100,30);
		password.setFont(new Font("Tahoma",Font.BOLD,16));
		password.setForeground(Color.BLACK);
		add(password);
		
		textfield= new JTextField();
		textfield.setBounds(150,20,150,30);
		textfield.setFont(new Font("Tahoma",Font.BOLD,16));
		textfield.setBackground(new Color(255,255,255));
		add(textfield);
		
		passwordfield= new JPasswordField();
		passwordfield.setBounds(150,70,150,30);
		passwordfield.setFont(new Font("Tahoma",Font.PLAIN,15));
		passwordfield.setBackground(new Color(255,255,255));
		add(passwordfield);
		
		
		
		ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/icon.jpg"));
		Image image1 = i11.getImage().getScaledInstance(300,100,Image.SCALE_DEFAULT);
		ImageIcon i22 = new ImageIcon(image1);
		JLabel label1 = new JLabel(i22);
		label1.setBounds(400,50,250,100);
		add(label1);
		
		b1=new JButton("Login");
		b1.setBounds(40,140,120,30);
		b1.setFont(new Font("Tahoma",Font.BOLD,15));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Cancel");
		b2.setBounds(180,140,120,30);
		b2.setFont(new Font("Tahoma",Font.BOLD,15));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);

		add(b2);
		
		getContentPane().setBackground(new Color(173, 216, 230));
		setSize(750,300);
		setLocation(400,270);
		setLayout(null);
		setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==b1) {
			try {
				conn c= new conn();
				String user= textfield.getText();
				String Pass= passwordfield.getText();
				String q= "select * from login where Id='"+user+"' and PW='"+Pass+"'";
				ResultSet resultset = c.statement.executeQuery(q);
				
				if(resultset.next()) {
					new Reception();
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null,"InValid");
				}
				
			}catch(Exception E) {
				E.printStackTrace();
			}
		}
		else {
			System.exit(10);
		}
	}

}
