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
import javax.swing.SwingUtilities;

public class Transfer extends JFrame implements ActionListener
{
	String pin,cardno;
	TextField tf1,tf2;
	JButton b1,b2;
	Transfer(String pin,String cardno)
	{
		this.pin=pin;
		this.cardno=cardno;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.png"));
		Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1550,830);
		add(image);
		
		JLabel l1=new JLabel("ENTER RECEPIENT ACCOUNT NO :");
		l1.setFont(new Font("Raleway",Font.BOLD,16));
		l1.setBounds(470,310,300,35);
		image.add(l1);
		
		tf1=new TextField();
		tf1.setBounds(470,350,350,25);
		tf1.setFont(new Font("Raleway",Font.BOLD,22));
		tf1.setEnabled(true);
		tf1.requestFocus();
		image.add(tf1);
		
		JLabel l2=new JLabel("ENTER TRANSFER AMOUNT :");
		l2.setFont(new Font("Raleway",Font.BOLD,16));
		l2.setBounds(470,390,300,35);
		image.add(l2);
		
		tf2=new TextField();
		tf2.setBounds(470,430,250,25);
		tf2.setFont(new Font("Raleway",Font.BOLD,22));
		tf2.setEnabled(true);
		tf2.requestFocus();
		image.add(tf2);
		
		b1=new JButton("TRANSFER");
		b1.setBounds(800,435,150,35);
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
		try 
		{
			String raccntno=tf1.getText();
			String tamount=tf2.getText();
			java.util.Date date=new java.util.Date();
			if(tf2.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please Enter the amount you want to Transfer");
			}
			else
			{
				Conn c=new Conn();
				// First, check if the recipient account exists
	            ResultSet rs = c.statement.executeQuery("SELECT * FROM login WHERE card_no = '" + raccntno + "'");
	            if (rs.next()) 
	            {
	                // Get the balance from the sender's account
	                ResultSet rs2 = c.statement.executeQuery("SELECT balance FROM bank WHERE pin = '" + pin + "'");
	                if (rs2.next()) 
	                {
	                
	                    int senderBalance = rs2.getInt("balance");
	                    int transferAmountInt = Integer.parseInt(tamount);
	                    if (senderBalance >= transferAmountInt) 
	                    {
	                        // Deduct the amount from the sender's account
	                        int updatedSenderBalance = senderBalance - transferAmountInt;
	                        int rowsUpdated = c.statement.executeUpdate("UPDATE bank SET balance = '" + updatedSenderBalance + "' WHERE pin = '" + pin + "'");
	                        if (rowsUpdated > 0) 
	                        {
	                            // Add the amount to the recipient's account
	                            ResultSet rs3 = c.statement.executeQuery("SELECT balance FROM bank WHERE card_no = '" + raccntno + "'");
	                            if (rs3.next()) 
	                            {
	                                int recipientBalance = rs3.getInt("balance");
	                                int updatedRecipientBalance = recipientBalance + transferAmountInt;
	                                int recipientRowsUpdated = c.statement.executeUpdate("UPDATE bank SET balance = '" + updatedRecipientBalance + "' WHERE card_no = '" + raccntno + "'");
	                                if (recipientRowsUpdated > 0) 
	                                {
	                                    // Transaction successful
	                                    JOptionPane.showMessageDialog(null, "Money transferred successfully!");
	                                } 
	                                else 
	                                {
	                                    JOptionPane.showMessageDialog(null, "Recipient account update failed");
	                                }
	                            }
	                        } 
	                        else 
	                        {
	                            JOptionPane.showMessageDialog(null, "Sender account update failed");
	                        }
	                    } 
	                    else 
	                    {
	                        JOptionPane.showMessageDialog(null, "Insufficient balance in sender's account");
	                    }
	                }
	            } 
	            else 
	            {
	                JOptionPane.showMessageDialog(null, "Recipient account not found");
	            }
	        }
				
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
		else if(e.getSource()==b2)
		{
			setVisible(false);
			new Transaction(pin,cardno);
		}
		
	}
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
	        public void run() 
	        {
		       new Transfer("","");
	        }
	    });

	}

}
