package Bank_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mini extends JFrame implements ActionListener
{
	String pin,cardno;
    JButton b1;

	Mini(String pin,String cardno)
	{
		this.pin = pin;
		this.cardno=cardno;
		
		setLayout(null);
		getContentPane().setBackground(new Color(255,204,204));
		setSize(400,600);
		setLocation(20,20);
		
		
		JLabel l1=new JLabel();
		l1.setBounds(20,140,400,200);
		add(l1);
		
		JLabel l2=new JLabel("Anish Rai");
		l2.setFont(new Font("System",Font.BOLD,16));
		l2.setBounds(150,20,200,50);
		add(l2);
		
		JLabel l3=new JLabel();
		l3.setBounds(20,80,300,20);
		add(l3);
		
		JLabel l4=new JLabel();
		l4.setBounds(20,430,300,20);
		add(l4);
		
		try 
		{
			Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from login where pin = '"+pin+"'");
            while (resultSet.next())
            {
                l3.setText("Card Number:  "+ resultSet.getString("card_no").substring(0,4) + "XXXXXXXX"+ resultSet.getString("card_no").substring(12));
		    }
		}
        catch (Exception e)
        {
            e.printStackTrace();
            
        }   
		
		try{
            int balance =0;
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
            while (resultSet.next())
            {

                l1.setText(l1.getText() + "<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+ "<br><br><html>");

                if (resultSet.getString("type").equals("Deposit"))
                {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }
                else 
                {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            l4.setText("Your Total Balance is Rs "+balance);
        }
		catch (Exception e)
		{
            e.printStackTrace();
        }
		
		b1 = new JButton("Exit");
        b1.setBounds(20,500,100,25);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		setVisible(false);
	}
	public static void main(String[] args) 
	{
		new Mini("","");
	}

}
