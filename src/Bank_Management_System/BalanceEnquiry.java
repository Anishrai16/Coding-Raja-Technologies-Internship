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

public class BalanceEnquiry extends JFrame implements ActionListener
{
	JLabel l2;
	String pin,cardno;
	JButton b1;
	BalanceEnquiry(String pin,String cardno)
	{
		this.pin=pin;
		this.cardno=cardno;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.png"));
		Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1550,830);
		add(image);
		
		JLabel l1=new JLabel("Your Current Balance is Rs ");
		l1.setFont(new Font("Raleway",Font.BOLD,16));
		l1.setBounds(470,310,700,35);
		image.add(l1);
		
		l2=new JLabel();
		l2.setFont(new Font("Raleway",Font.BOLD,16));
		l2.setBounds(470,350,400,35);
		image.add(l2);
		
		b1=new JButton("Back");
		b1.setBounds(800,430,150,35);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		image.add(b1);
		
		int balance =0;
        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("Select * from bank where pin = '"+pin+"'");
            while (resultSet.next())
            {
                if (resultSet.getString("type").equals("Deposit"))
                {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }
                else 
                {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }
        
        l2.setText(""+balance);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
        setVisible(false);
        new Transaction(pin,cardno);
    }

	
	public static void main(String[] args)
	{
		new BalanceEnquiry("","");
	}

}
