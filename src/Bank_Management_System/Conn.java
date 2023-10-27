package Bank_Management_System;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;
public class Conn 
{
	Connection connection;
	java.sql.Statement statement;
	public Conn()
	{
		try {
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root","Anishrai@2003");
			statement=connection.createStatement();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
