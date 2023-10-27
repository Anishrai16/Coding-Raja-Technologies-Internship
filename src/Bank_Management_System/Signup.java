package Bank_Management_System;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
public class Signup extends JFrame implements ActionListener
{
	JTextField name,fname,email,address,city,pcode,state;
	JDateChooser dateChooser;
	JRadioButton r1,r2,m1,m2,m3;
	JButton next;
	
	Random r=new Random();
	long f4=(r.nextLong()%9000L)+1000L;
	String first=" "+Math.abs(f4);
	Signup()
	{
		super("APPLICATION FORM");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bank.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(25, 10, 100, 100);
		add(image);
		
		JLabel label1=new JLabel("APPLICATION FORM NO."+first);
		label1.setFont(new Font("Raleway",Font.BOLD,38));
		label1.setBounds(160,20,600,40);
		add(label1);
		
		JLabel label2=new JLabel("Page 1");
		label2.setFont(new Font("Raleway",Font.BOLD,22));
		label2.setBounds(350,70,600,30);
		add(label2);
		
		JLabel label3=new JLabel("Personal Details");
		label3.setFont(new Font("Raleway",Font.BOLD,22));
		label3.setBounds(310,90,600,30);
		add(label3);
		
		JLabel lName=new JLabel("Name :");
		lName.setFont(new Font("Raleway",Font.BOLD,20));
		lName.setBounds(100,190,100,30);
		add(lName);
		
		name=new JTextField();
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(300,190,400,30);
		add(name);
		
		JLabel fName=new JLabel("Father's Name :");
		fName.setFont(new Font("Raleway",Font.BOLD,20));
		fName.setBounds(100,240,200,30);
		add(fName);
		
		fname=new JTextField();
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(300,240,400,30);
		add(fname);
		
		JLabel lgender=new JLabel("Gender :");
		lgender.setFont(new Font("Raleway",Font.BOLD,20));
		lgender.setBounds(100,290,200,30);
		add(lgender);
		
		r1=new JRadioButton("Male");
		r1.setFont(new Font("Raleway",Font.BOLD,14));
		r1.setBackground(new Color(222,255,228));
		r1.setBounds(300,290,60,30);
		add(r1);
		
		r2=new JRadioButton("Female");
		r2.setFont(new Font("Raleway",Font.BOLD,14));
		r2.setBackground(new Color(222,255,228));
		r2.setBounds(450,290,90,30);
		add(r2);
		
		//for selecting only one button at a time
		ButtonGroup bgrp=new ButtonGroup();
		bgrp.add(r1);
		bgrp.add(r2);
		
		JLabel dob=new JLabel("Date of Birth :");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100,340,200,30);
		add(dob);
		
		dateChooser=new JDateChooser();
		dateChooser.setForeground(new Color(105,105,105));
		dateChooser.setBounds(300,340,400,30);
		add(dateChooser);
		
		JLabel lemail=new JLabel("Email Address :");
		lemail.setFont(new Font("Raleway",Font.BOLD,20));
		lemail.setBounds(100,390,200,30);
		add(lemail);
		
	    email=new JTextField();
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(300,390,400,30);
		add(email);
		
		JLabel lms=new JLabel("Marital Staus :");
		lms.setFont(new Font("Raleway",Font.BOLD,20));
		lms.setBounds(100,440,200,30);
		add(lms);
		
		m1=new JRadioButton("Married");
		m1.setFont(new Font("Raleway",Font.BOLD,14));
		m1.setBackground(new Color(222,255,228));
		m1.setBounds(300,440,100,30);
		add(m1);
		
		m2=new JRadioButton("Unmarried");
		m2.setFont(new Font("Raleway",Font.BOLD,14));
		m2.setBackground(new Color(222,255,228));
		m2.setBounds(450,440,100,30);
		add(m2);
		
		m3=new JRadioButton("Other");
		m3.setFont(new Font("Raleway",Font.BOLD,14));
		m3.setBackground(new Color(222,255,228));
		m3.setBounds(600,440,100,30);
		add(m3);
		
		//for selecting only one button at a time
		ButtonGroup bgrp1=new ButtonGroup();
		bgrp1.add(m1);
		bgrp1.add(m2);
		bgrp1.add(m3);
		
		JLabel ladd=new JLabel("Address :");
		ladd.setFont(new Font("Raleway",Font.BOLD,20));
		ladd.setBounds(100,490,200,30);
		add(ladd);
		
	    address=new JTextField();
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(300,490,400,30);
		add(address);
		
		JLabel lcity=new JLabel("City :");
		lcity.setFont(new Font("Raleway",Font.BOLD,20));
		lcity.setBounds(100,540,200,30);
		add(lcity);
		
	    city=new JTextField();
		city.setFont(new Font("Raleway",Font.BOLD,20));
		city.setBounds(300,540,400,30);
		add(city);
		
		JLabel lpcode=new JLabel("Pincode :");
		lpcode.setFont(new Font("Raleway",Font.BOLD,20));
		lpcode.setBounds(100,590,200,30);
		add(lpcode);
		
	    pcode=new JTextField();
		pcode.setFont(new Font("Raleway",Font.BOLD,20));
		pcode.setBounds(300,590,400,30);
		add(pcode);
		
		JLabel lstate=new JLabel("State :");
		lstate.setFont(new Font("Raleway",Font.BOLD,20));
		lstate.setBounds(100,640,200,30);
		add(lstate);
		
	    state=new JTextField();
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(300,640,400,30);
		add(state);
		
		next=new JButton("Next");
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(620,710,80,30);
		next.addActionListener(this);
		add(next);

		
		getContentPane().setBackground(new Color(222,255,228));
		setLayout(null);
		setSize(850,800);
		setLocation(360,40);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String formno=first;
		String n=name.getText();
		String fn=fname.getText();
		String DOB=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		String gender=null;
		if(r1.isSelected())
		{
			gender="Male";
		}else if(r2.isSelected())
		{
			gender="Female";
		}
		String eml=email.getText();
		String marital=null;
		if(m1.isSelected())
		{
			marital="Married";
		}else if(m2.isSelected())
		{
			marital="Unmarried";
		}else if(m3.isSelected())
		{
			marital="Other";
		}
		String add=address.getText();
		String ct=city.getText();
		String pincode=pcode.getText();
		String st=state.getText();
		
		try {
			if(name.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Fill all the fields");
			}else
			{
				Conn con1=new Conn();
				String q="insert into signup values('"+formno+"','"+n+"','"+fn+"','"+DOB+"','"+gender+"','"+eml+"','"+marital+"','"+add+"','"+ct+"','"+pincode+"','"+st+"')";
				con1.statement.executeUpdate(q);//executeUpdate is used to import the value into table
				new Signup2(formno);
				setVisible(false);
			}
			
		}catch(Exception E)
		{
			E.printStackTrace();
		}
	}
	
public static void main(String[]args)
{
	new Signup();
}
}
