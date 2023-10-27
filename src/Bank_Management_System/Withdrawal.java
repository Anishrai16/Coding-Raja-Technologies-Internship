package Bank_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Withdrawal extends JFrame implements ActionListener
{
	String pin,cardno;
	TextField tf;
	JButton b1,b2;
	Withdrawal(String pin,String cardno)
	{
		this.pin=pin;
		this.cardno=cardno;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.png"));
		Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1550,830);
		add(image);
		
		JLabel l1=new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
		l1.setFont(new Font("Raleway",Font.BOLD,16));
		l1.setBounds(470,310,700,35);
		image.add(l1);
		
		JLabel l2=new JLabel("PLEASE ENTER YOUR AMOUNT");
		l2.setFont(new Font("Raleway",Font.BOLD,16));
		l2.setBounds(470,350,400,35);
		image.add(l2);
		
		tf=new TextField();
		tf.setBounds(470,390,320,25);
		tf.setFont(new Font("Raleway",Font.BOLD,22));
		image.add(tf);
		
		b1=new JButton("WITHDRAW");
		b1.setBounds(800,430,150,35);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		image.add(b1);
		
		b2=new JButton("BACK");
		b2.setBounds(800,470,150,35);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		image.add(b2);
		
		setLayout(null);
		setSize(1550,1080);
		setLocation(0,0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
		try {
			String amount=tf.getText();
			java.util.Date date=new java.util.Date();
			
			if(tf.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please Enter the amount you want to Withdraw");
			}
			else
			{
				Conn c=new Conn();
				ResultSet resultSet=c.statement.executeQuery("select* from bank where pin='"+pin+"'");
				int balance=0;
				while(resultSet.next())
				{
					if(resultSet.getString("type").equals("Deposit"))
					{
						balance+=Integer.parseInt(resultSet.getString("amount"));
					}
					else
					{
						balance-=Integer.parseInt(resultSet.getString("amount"));
					}
				}
				if(balance<Integer.parseInt(amount))
				{
					JOptionPane.showMessageDialog(null,"Insufficient Balance");
					return;
				}
				
				c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawal','"+amount+"','"+balance+"','"+cardno+"')");
				JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");
				setVisible(false);
				new Transaction(pin,cardno);
			}
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
		}else if(e.getSource()==b2)
		{
			setVisible(false);
			new Transaction(pin,cardno);
		}
	}

	public static void main(String[] args) 
	{
		new Withdrawal("","");
		

	}

}
