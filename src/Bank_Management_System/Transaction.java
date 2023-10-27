package Bank_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transaction extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	String pin,cardno;
	
	Transaction(String pin,String cardno)
	{
		this.pin=pin;
		this.cardno=cardno;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.png"));
		Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1550,830);
		add(image);
		
		JLabel l1=new JLabel("Please Select Your Transaction:");
		l1.setFont(new Font("System",Font.BOLD,28));
		l1.setBounds(450,320,450,50);
		image.add(l1);
		
		b1=new JButton("DEPOSIT");
		b1.setBounds(340,385,150,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		image.add(b1);
		
		b2=new JButton("CASH WITHDRAWAL");
		b2.setBounds(800,385,150,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		image.add(b2);
		
		b3=new JButton("FAST CASH");
		b3.setBounds(340,420,150,30);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);
		image.add(b3);
		
		b4=new JButton("MINI STATEMENT");
		b4.setBounds(800,420,150,30);
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		b4.addActionListener(this);
		image.add(b4);
		
		b5=new JButton("PIN CHANGE");
		b5.setBounds(340,455,150,30);
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		b5.addActionListener(this);
		image.add(b5);
		
		b6=new JButton("BALANCE ENQUIRY");
		b6.setBounds(800,455,150,30);
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.WHITE);
		b6.addActionListener(this);
		image.add(b6);
		
		b7=new JButton("EXIT");
		b7.setBounds(800,490,150,30);
		b7.setBackground(Color.BLACK);
		b7.setForeground(Color.WHITE);
		b7.addActionListener(this);
		image.add(b7);
		
		b8=new JButton("TRANSFER MONEY");
		b8.setBounds(340,490,150,30);
		b8.setBackground(Color.BLACK);
		b8.setForeground(Color.WHITE);
		b8.addActionListener(this);
		image.add(b8);
		
		b9=new JButton("LOAN");
		b9.setBounds(570,470,150,30);
		b9.setBackground(Color.BLACK);
		b9.setForeground(Color.WHITE);
		b9.addActionListener(this);
		image.add(b9);
		
		
		setLayout(null);
		setSize(1550,1080);
		setLocation(0,0);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			new Deposit(pin);
			setVisible(false);
		}
		else if(e.getSource()==b2)
		{
			new Withdrawal(pin,cardno);
			setVisible(false);
		}
		else if(e.getSource()==b3)
		{
			new FastCash(pin,cardno);
			setVisible(false);
		}
		else if(e.getSource()==b4)
		{
			new Mini(pin,cardno);
			setVisible(false);
		}
		else if(e.getSource()==b5)
		{
			new Pin(pin,cardno);
			setVisible(false);
		}
		else if(e.getSource()==b6)
		{
			new BalanceEnquiry(pin,cardno);
			setVisible(false);
		}
		else if(e.getSource()==b7)
		{
			System.exit(0);
		}
		else if(e.getSource()==b8)
		{
			new Transfer(pin,cardno);
			setVisible(false);
		}
		else if(e.getSource()==b9)
		{
			new Loan(pin,cardno);
			setVisible(false);
		}
		
	}

	public static void main(String[] args)
	{
		new Transaction("","");

	}

}
