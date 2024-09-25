package global_variables_functions;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GlobalVariablesFunctions {

	public Scanner scan;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;
	public Statement statement;
	public File file;
	public FileWriter fileWriter;
	
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost/aradhana","root","rootpas@12#12");
		return con;
	}

}
