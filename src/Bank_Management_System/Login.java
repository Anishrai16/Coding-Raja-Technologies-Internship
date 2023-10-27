package Bank_Management_System;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
	JLabel label1,label2,label3;
	JTextField tf;
	JPasswordField pf;
	JButton b1,b2,b3;//Three Buttons
	Login() {
		setTitle("AUTOMATED TELLER MACHINE");
		
		// To add an image on to frame
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bank.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(370, 10, 100, 100);
		add(image);
		
		label1=new JLabel("Welcome to ATM");
		label1.setForeground(Color.BLACK);
		label1.setFont(new Font("Times New Roman",Font.BOLD,38));
		label1.setBounds(270, 125, 450, 40);
		add(label1);
		
		label2=new JLabel("Card No:");
		label2.setForeground(Color.WHITE);
		label2.setFont(new Font("Ralway",Font.BOLD,28));
		label2.setBounds(170, 198, 375, 30);
		add(label2);
		
		tf=new JTextField(15);
		tf.setBounds(325,190,230,30);
		tf.setFont(new Font("Arial",Font.BOLD,14));
		add(tf);
		
		label3=new JLabel("PIN: ");
		label3.setForeground(Color.WHITE);
		label3.setFont(new Font("Ralway",Font.BOLD,28));
		label3.setBounds(170, 250, 375, 30);
		add(label3);
		
		pf=new JPasswordField(15);
		pf.setBounds(325, 250,230, 30);
		pf.setFont(new Font("Arial",Font.BOLD,14));
		add(pf);
		
		b1=new JButton("SIGN IN");
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.setFont(new Font("Arial",Font.BOLD,14));
		b1.setBounds(320, 300, 100, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("CLEAR");
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.setFont(new Font("Arial",Font.BOLD,14));
		b2.setBounds(450, 300, 100, 30);
		b2.addActionListener(this);
		add(b2);
		
		b3=new JButton("SIGN UP");
		b3.setForeground(Color.WHITE);
		b3.setBackground(Color.BLACK);
		b3.setFont(new Font("Arial",Font.BOLD,14));
		b3.setBounds(320, 350, 230, 30);
		b3.addActionListener(this);
		add(b3);

		
		ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("images/bg.png"));
		Image ii2 = ii1.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT);
		ImageIcon ii3 = new ImageIcon(ii2);
		JLabel iimage = new JLabel(ii3);
		iimage.setBounds(0, 0, 850, 480);
		add(iimage);
		
		setLayout(null);
		setSize(850,480);
		setVisible(true);// to make the frame visible to user
		setLocation(350, 200);// to set position of frame on screen
	}

	public void actionPerformed(ActionEvent e)
	{
		try {
			if(e.getSource()==b1)
			{
				Conn c=new Conn();
				String cardno=tf.getText();
				String pin=pf.getText();
				String q="select*from login where card_no='"+cardno+"' and pin='"+pin+"'";
				ResultSet resultSet=c.statement.executeQuery(q);
				if(resultSet.next())
				{
					setVisible(false);
					new Transaction(pin,cardno);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Incorrect Card No or PIN");
				}
				
			}else if(e.getSource()==b2)
			{
				tf.setText("");
				pf.setText("");
			}else if(e.getSource()==b3)
			{
				new Signup();
				setVisible(false);
			}
			
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Login();
	}

}
