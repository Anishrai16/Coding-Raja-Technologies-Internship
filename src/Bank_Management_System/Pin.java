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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Pin extends JFrame implements ActionListener
{
	JButton b1,b2;
	JPasswordField p1,p2;
	String pin,cardno;
	Pin(String pin,String cardno)
	{
		this.pin=pin;
		this.cardno=cardno;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.png"));
		Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1550,830);
		add(image);
		
		JLabel l1=new JLabel("CHANGE YOUR PIN");
		l1.setFont(new Font("Raleway",Font.BOLD,16));
		l1.setBounds(540,340,400,35);
		image.add(l1);
		
		JLabel l2=new JLabel("New PIN");
		l2.setFont(new Font("Raleway",Font.BOLD,16));
		l2.setBounds(440,380,150,35);
		image.add(l2);
		
		p1=new JPasswordField();
		p1.setBounds(610,380,180,25);
		p1.setFont(new Font("Raleway",Font.BOLD,22));
		image.add(p1);
		
		JLabel l3=new JLabel("Re-Enter New PIN");
		l3.setFont(new Font("Raleway",Font.BOLD,16));
		l3.setBounds(440,410,400,35);
		image.add(l3);
		
		p2=new JPasswordField();
		p2.setBounds(610,410,180,25);
		p2.setFont(new Font("Raleway",Font.BOLD,22));
		image.add(p2);
		
		b1=new JButton("CHANGE");
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
		try{

            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if (!pin1.equals(pin2))
            {
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            if (e.getSource()==b1)
            {
                if (p1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Enter New PIN");
                    return;
                }
                if (p2.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
                    return;
                }

                Conn c = new Conn();
                String q1 = "update bank set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q2 = "update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update signupthreee set pin = '"+pin1+"' where pin = '"+pin+"'";
                
                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);
                new Transaction(pin,cardno);

            } 
            else if (e.getSource()==b2) 
            {
                new Transaction(pin,cardno);
                setVisible(false);
            }
        }
		catch (Exception E)
		{
            E.printStackTrace();
        }
		
	}
	public static void main(String[] args) 
	{
		new Pin("","");

	}

}
