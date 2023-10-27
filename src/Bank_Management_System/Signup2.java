package Bank_Management_System;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Signup2 extends JFrame implements ActionListener
{
	JComboBox comboBox,comboBox1,comboBox2,comboBox3,comboBox4;
	JTextField textPan,textAadhar;
	JRadioButton r1,r2,e1,e2;
	String formno;
	JButton next;
	Signup2(String formno)
	{
		super("APPLICATION FORM");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bank.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(150,5, 100, 100);
		add(image);
		
		this.formno=formno;
		
		JLabel l1=new JLabel("Page 2:");
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		l1.setBounds(300,30,600,40);
		add(l1);
		
		JLabel l2=new JLabel("Additional Details:");
		l2.setFont(new Font("Raleway",Font.BOLD,22));
		l2.setBounds(300,60,600,40);
		add(l2);
		
		JLabel l3=new JLabel("Religion: ");
		l3.setFont(new Font("Raleway",Font.BOLD,18));
		l3.setBounds(100,120,100,30);
		add(l3);
		
		//Dropdown for choosing religion
		String religion[]= {"Hindu","Christian","Muslim","Sikh","Other"};
		comboBox=new JComboBox(religion);
		comboBox.setBackground(new Color(253,208,76));
		comboBox.setFont(new Font("Raleway",Font.BOLD,14));
		comboBox.setBounds(350,120,320,30);
		add(comboBox);
		
		JLabel l4=new JLabel("Category: ");
		l4.setFont(new Font("Raleway",Font.BOLD,18));
		l4.setBounds(100,170,100,30);
		add(l4);
		
		String category[]= {"General","OBC","SC","ST","Other"};
		comboBox1=new JComboBox(category);
		comboBox1.setBackground(new Color(253,208,76));
		comboBox1.setFont(new Font("Raleway",Font.BOLD,14));
		comboBox1.setBounds(350,170,320,30);
		add(comboBox1);
		
		JLabel l5=new JLabel("Income: ");
		l5.setFont(new Font("Raleway",Font.BOLD,18));
		l5.setBounds(100,220,100,30);
		add(l5);
		
		String income[]= {"NUll","< 1,00,000","< 2,50,000","< 4,50,000","upto 10,00,000","above 10,00,000"};
		comboBox2=new JComboBox(income);
		comboBox2.setBackground(new Color(253,208,76));
		comboBox2.setFont(new Font("Raleway",Font.BOLD,14));
		comboBox2.setBounds(350,220,320,30);
		add(comboBox2);
		
		JLabel l6=new JLabel("Educational details: ");
		l6.setFont(new Font("Raleway",Font.BOLD,18));
		l6.setBounds(100,270,200,30);
		add(l6);
		
		String educational[]= {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
		comboBox3=new JComboBox(educational);
		comboBox3.setBackground(new Color(253,208,76));
		comboBox3.setFont(new Font("Raleway",Font.BOLD,14));
		comboBox3.setBounds(350,270,320,30);
		add(comboBox3);
		
		JLabel l7=new JLabel("Occupation: ");
		l7.setFont(new Font("Raleway",Font.BOLD,18));
		l7.setBounds(100,320,150,30);
		add(l7);
		
		String occupation[]= {"Salaried","Self-Employed","Business","Student","Retired","Other"};
		comboBox4=new JComboBox(occupation);
		comboBox4.setBackground(new Color(253,208,76));
		comboBox4.setFont(new Font("Raleway",Font.BOLD,14));
		comboBox4.setBounds(350,320,320,30);
		add(comboBox4);
		
		JLabel l8=new JLabel("PAN NO: ");
		l8.setFont(new Font("Raleway",Font.BOLD,18));
		l8.setBounds(100,370,150,30);
		add(l8);
		
		textPan=new JTextField();
		textPan.setFont(new Font("Raleway",Font.BOLD,18));
		textPan.setBounds(350,370,320,30);
		add(textPan);
		
		JLabel l9=new JLabel("Aadhar NO: ");
		l9.setFont(new Font("Raleway",Font.BOLD,18));
		l9.setBounds(100,420,180,30);
		add(l9);
		
		textAadhar=new JTextField();
		textAadhar.setFont(new Font("Raleway",Font.BOLD,18));
		textAadhar.setBounds(350,420,320,30);
		add(textAadhar);
		
		JLabel l10=new JLabel("Senior Citizen (AGE>60): ");
		l10.setFont(new Font("Raleway",Font.BOLD,18));
		l10.setBounds(100,470,250,30);
		add(l10);
		
		r1=new JRadioButton("YES");
		r1.setFont(new Font("Raleway",Font.BOLD,14));
		r1.setBackground(new Color(252,208,76));
		r1.setBounds(350,470,100,30);
		add(r1);
		
		r2=new JRadioButton("NO");
		r2.setFont(new Font("Raleway",Font.BOLD,14));
		r2.setBackground(new Color(252,208,76));
		r2.setBounds(500,470,100,30);
		add(r2);
		
		ButtonGroup bgrp=new ButtonGroup();
		bgrp.add(r1);
		bgrp.add(r2);
		
		JLabel l11=new JLabel("Existing Account: ");
		l11.setFont(new Font("Raleway",Font.BOLD,18));
		l11.setBounds(100,520,200,30);
		add(l11);
		
		e1=new JRadioButton("YES");
		e1.setFont(new Font("Raleway",Font.BOLD,14));
		e1.setBackground(new Color(252,208,76));
		e1.setBounds(350,520,100,30);
		add(e1);
		
		e2=new JRadioButton("NO");
		e2.setFont(new Font("Raleway",Font.BOLD,14));
		e2.setBackground(new Color(252,208,76));
		e2.setBounds(500,520,100,30);
		add(e2);
		
		ButtonGroup bgrp1=new ButtonGroup();
		bgrp1.add(e1);
		bgrp1.add(e2);
		
		JLabel l12=new JLabel("Form No: ");
		l12.setFont(new Font("Raleway",Font.BOLD,14));
		l12.setBounds(700,10,100,30);
		add(l12);
		
		JLabel l13=new JLabel(formno);
		l13.setFont(new Font("Raleway",Font.BOLD,14));
		l13.setBounds(760,10,100,30);
		add(l13);
		
		next=new JButton("Next");
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(620,710,80,30);
		next.addActionListener(this);
		add(next);

		
		setLayout(null);
		setSize(850,800);
		setLocation(450,30);
		getContentPane().setBackground(new Color(222,255,228));
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String rel=(String)comboBox.getSelectedItem();
		String cat=(String)comboBox1.getSelectedItem();
		String inc=(String)comboBox2.getSelectedItem();
		String edu=(String)comboBox3.getSelectedItem();
		String occ=(String)comboBox4.getSelectedItem();
		String pan=textPan.getText();
		String aadhar=textAadhar.getText();
		
		String sciti="";
		if((r1.isSelected()))
		{
			sciti="Yes";
		}else if((r2.isSelected()))
		{
			sciti="No";
		}
		
		String eacc="";
		if((e1.isSelected()))
		{
			eacc="Yes";
		}else if((e2.isSelected()))
		{
			eacc="No";
		}
		
		try {
			if(textPan.getText().equals("")||textAadhar.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Fill all the fields");
			}
			else
			{
				Conn c1=new Conn();
				String q="Insert into Signuptwo values('"+formno+"','"+rel+"','"+cat+"','"+inc+"','"+edu+"','"+occ+"','"+pan+"','"+aadhar+"','"+sciti+"','"+eacc+"')";
				c1.statement.executeUpdate(q);//executeUpdate is used to import the value into table
				new Signup3(formno);
				setVisible(false);
			}
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
		
	}
	
	public static void main(String[]args)
	{
		new Signup2("");
	}

}
