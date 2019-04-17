package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;
import com.sun.javafx.scene.accessibility.Action;
import javafx.scene.*;
import javafx.scene.control.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.*;


public class SampleController implements Initializable {
	
	Connection conn=null;
	@FXML
	private TextField email;
	
	@FXML
	private TextField password;
	
	//private TextInputControl email;
	//private TextInputControl email;
	//private TextInputControl password;
	@Override
	public void initialize(URL url,ResourceBundle rb)
	{
		
	    System.out.println("initialize");
	   // PasswordField password;
	}
	
	@FXML
	public void test(MouseEvent event)
	{
		System.out.println("test");
		try
		{
			System.out.println("enter try");
			//TextInputControl email = null;
			String em = email.getText().toString();
			//TextInputControl password = null;
			String pwd = password.getText().toString();
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("hi");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=pucchi143");
			PreparedStatement st1=prepareStatement("select * from users where name=? and password=?");
			st1.setString(1,em);
			st1.setString(2,pwd);
			ResultSet rs=st1.executeQuery();
			if(rs.next())
			{
				System.out.println("hello");
				System.exit(0);
			}
			else
			{
				System.out.println("sorry");
			}
			
		}
		catch(Exception e)
		{
			
		}
	}

	private PreparedStatement prepareStatement(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
