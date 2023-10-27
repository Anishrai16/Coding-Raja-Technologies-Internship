package Bank_Management_System;

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

public class FastCash extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4,b5,b6,b7;
	String pin,cardno;
	
	FastCash(String pin,String cardno)
	{
		this.pin=pin;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.png"));
		Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1550,830);
		add(image);
		
		JLabel l1=new JLabel("SELECT WITHDRAWAL AMOUNT:");
		l1.setFont(new Font("System",Font.BOLD,26));
		l1.setBounds(450,320,450,50);  
		image.add(l1);
		
		b1=new JButton("Rs. 100");
		b1.setBounds(340,385,150,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		image.add(b1);
		
		b2=new JButton("Rs. 500");
		b2.setBounds(800,385,150,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		image.add(b2);
		
		b3=new JButton("Rs. 1000");
		b3.setBounds(340,420,150,30);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);
		image.add(b3);
		
		b4=new JButton("Rs. 2000");
		b4.setBounds(800,420,150,30);
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		b4.addActionListener(this);
		image.add(b4);
		
		b5=new JButton("Rs. 5000");
		b5.setBounds(340,455,150,30);
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		b5.addActionListener(this);
		image.add(b5);
		
		b6=new JButton("Rs. 10000");
		b6.setBounds(800,455,150,30);
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.WHITE);
		b6.addActionListener(this);
		image.add(b6);
		
		b7=new JButton("BACK");
		b7.setBounds(800,490,150,30);
		b7.setBackground(Color.BLACK);
		b7.setForeground(Color.WHITE);
		b7.addActionListener(this);
		image.add(b7);
		
		setLayout(null);
		setSize(1550,1080);
		setLocation(0,0);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) 
	{
		 if (e.getSource()==b7) 
		 {
	            setVisible(false);
	            new Transaction(pin,cardno);
	     }
		 else 
		 {
	            String amount = ((JButton)e.getSource()).getText().substring(4);
	            Conn c = new Conn();
	            java.util.Date date = new java.util.Date();
	            try{
	                ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
	                int balance =0;
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

	                if (e.getSource() != b7 && balance < Integer.parseInt(amount))
	                {
	                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
	                    return;
	                }

	                c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"', 'withdrawl', '"+amount+"', '"+balance+"','"+cardno+"')");
	                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
	                
	            }
	            catch (Exception E)
	            {
	                E.printStackTrace();
	            }
	            
	            setVisible(false);
	            new Transaction(pin,cardno);
	        }

	}
	public static void main(String[] args)
	{
		new FastCash("","");

	}

}
