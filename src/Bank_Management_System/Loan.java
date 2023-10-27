package Bank_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Loan extends JFrame implements ActionListener
{
	String pin,cardno;
	JTextField name,accno,purpose,lamt,lterm;
	JComboBox comboBox,comboBox1;
	JButton apply,b2;
	Conn c1;
	
	Random r=new Random();
	long f4=(r.nextLong()%9000L)+1000L;
	String first=" "+Math.abs(f4);
	Loan(String pin,String cardno)
	{
        super("LOAN APPLICATION FORM");
        this.pin=pin;
		this.cardno=cardno;
		c1 = new Conn();
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bank.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(25, 10, 100, 100);
		add(image);
		
		JLabel l1=new JLabel("APPLICATION FORM NO."+first);
		l1.setFont(new Font("Raleway",Font.BOLD,38));
		l1.setBounds(160,20,600,40);
		add(l1);
		
		JLabel l2=new JLabel("Loan Details");
		l2.setFont(new Font("Raleway",Font.BOLD,22));
		l2.setBounds(310,90,600,30);
		add(l2);
		
		JLabel lName=new JLabel("Name :");
		lName.setFont(new Font("Raleway",Font.BOLD,20));
		lName.setBounds(100,190,100,30);
		add(lName);
		
		name=new JTextField();
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(300,190,400,30);
		add(name);
		
		JLabel laccno=new JLabel("Account No:");
		laccno.setFont(new Font("Raleway",Font.BOLD,20));
		laccno.setBounds(100,250,150,30);
		add(laccno);
		
		accno=new JTextField();
		accno.setFont(new Font("Raleway",Font.BOLD,20));
		accno.setBounds(300,250,400,30);
		add(accno);
		
		JLabel l3=new JLabel("Type of Loan: ");
		l3.setFont(new Font("Raleway",Font.BOLD,18));
		l3.setBounds(100,310,150,30);
		add(l3);
		
		String loans[]= {"Personal Loan","Home Loan","Business Loan","Vehicle Loan","Other"};
		comboBox=new JComboBox(loans);
		comboBox.setBackground(new Color(253,208,76));
		comboBox.setFont(new Font("Raleway",Font.BOLD,14));
		comboBox.setBounds(350,310,320,30);
		add(comboBox);
		
		JLabel l4=new JLabel("Income: ");
		l4.setFont(new Font("Raleway",Font.BOLD,18));
		l4.setBounds(100,370,100,30);
		add(l4);
		
		String income[]= {"NUll","< 1,00,000","< 2,50,000","< 4,50,000","upto 10,00,000","above 10,00,000"};
		comboBox1=new JComboBox(income);
		comboBox1.setBackground(new Color(253,208,76));
		comboBox1.setFont(new Font("Raleway",Font.BOLD,14));
		comboBox1.setBounds(350,370,320,30);
		add(comboBox1);
		
		JLabel l5=new JLabel("Loan Purpose: ");
		l5.setFont(new Font("Raleway",Font.BOLD,18));
		l5.setBounds(100,430,150,30);
		add(l5);
		
		purpose=new JTextField();
		purpose.setFont(new Font("Raleway",Font.BOLD,20));
		purpose.setBounds(350,430,400,30);
		add(purpose);
		
		JLabel l6=new JLabel("Loan Amount Required (in rupees): ");
		l6.setFont(new Font("Raleway",Font.BOLD,18));
		l6.setBounds(100,500,320,30);
		add(l6);
		
		lamt=new JTextField();
		lamt.setFont(new Font("Raleway",Font.BOLD,20));
		lamt.setBounds(420,500,400,30);
		add(lamt);
		
		JLabel l7=new JLabel("Preferred Loan term (in years): ");
		l7.setFont(new Font("Raleway",Font.BOLD,18));
		l7.setBounds(100,570,320,30);
		add(l7);
		
		lterm=new JTextField();
		lterm.setFont(new Font("Raleway",Font.BOLD,20));
		lterm.setBounds(400,570,400,30);
		add(lterm);
		
		apply=new JButton("Apply");
		apply.setFont(new Font("Raleway",Font.BOLD,14));
		apply.setBackground(Color.BLACK);
		apply.setForeground(Color.WHITE);
		apply.setBounds(620,710,80,30);
		apply.addActionListener(this);
		add(apply);
		
		b2=new JButton("BACK");
		b2.setBounds(720,710,80,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		setLayout(null);
		setSize(850,800);
		setLocation(360,40);
		getContentPane().setBackground(new Color(222,255,228));
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		String formno=first;
		String n=name.getText();
		String ano=accno.getText();
        String ltype=(String)comboBox.getSelectedItem();
		String inc=(String)comboBox1.getSelectedItem();
		String lp=purpose.getText();
		String lamnt=lamt.getText();
		String lt=lterm.getText();
		
		if(e.getSource()==apply)
		{
			
		try {
			if(accno.getText().equals("") && name.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Fill all the fields");
			}
			else
			{
				Statement statement = c1.connection.createStatement();
                String q = "INSERT INTO loan VALUES('" + formno + "', '" + n + "', '" + ano + "', '"
                        + ltype + "', '" + inc + "', '" + lp + "', '" + lamnt + "', '" + lt + "')";
                statement.executeUpdate(q);
                statement.close();

                // Retrieve the user's balance
                String selectQuery = "SELECT balance FROM bank WHERE pin = '" + pin
                        + "' ORDER BY date DESC LIMIT 1";
                statement = c1.connection.createStatement();
                ResultSet resultSet = statement.executeQuery(selectQuery);

                int balance = 0;
                if (resultSet.next()) {
                    balance = resultSet.getInt("balance");
                }

                int clamt = Integer.parseInt(lamnt);
                int nBalance = balance + clamt;

                // Update the user's balance
                String updateQuery = "UPDATE bank SET balance = '" + nBalance + "' WHERE pin = '" + pin + "'";
                statement = c1.connection.createStatement();
                statement.executeUpdate(updateQuery);

                resultSet.close();
                statement.close();

                JOptionPane.showMessageDialog(null, "Loan Amount of Rs." + lamnt + " has been sanctioned.");
                setVisible(false);
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
		new Loan("","");

	}

}
