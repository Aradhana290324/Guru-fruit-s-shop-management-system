package backEndPackage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import global_variables_functions.GlobalVariablesFunctions;

public class AddNewFruits_functionality {
	
	public void addNewFruits() {
		
		GlobalVariablesFunctions globalVariablesFunctions=new GlobalVariablesFunctions();
		AddNewFruitsPOJO addNewFruitsPOJO=new AddNewFruitsPOJO();
		globalVariablesFunctions.scan=new Scanner(System.in);
		//ask for adding fruits details
		System.out.println("Enter name of the fruit :");
		addNewFruitsPOJO.setNameOfFruit(globalVariablesFunctions.scan.next());
		System.out.println("Enter quantity :");
		addNewFruitsPOJO.setQty(globalVariablesFunctions.scan.nextInt());
		System.out.println("Enter Unit of the fruit");
		addNewFruitsPOJO.setUnit(globalVariablesFunctions.scan.next());
		System.out.println("Enter price of the fruit :");
		addNewFruitsPOJO.setPrice(globalVariablesFunctions.scan.nextInt());
		System.out.println("Enter Date (DD-MM-YYYY) :");
		addNewFruitsPOJO.setdate(globalVariablesFunctions.scan.next());
		
		//db connection	
		try {
			Connection con=globalVariablesFunctions.getConnection();
			globalVariablesFunctions.getConnection();
			globalVariablesFunctions.preparedStatement=con.prepareStatement("insert into guru_fruits_shop(name,qty,unit,price,date) values(?,?,?,?,?)");
			globalVariablesFunctions.preparedStatement.setString(1,addNewFruitsPOJO.getNameOfFruit());
			globalVariablesFunctions.preparedStatement.setInt(2, addNewFruitsPOJO.getQty());
			globalVariablesFunctions.preparedStatement.setString(3, addNewFruitsPOJO.getUnit());
			globalVariablesFunctions.preparedStatement.setInt(4, addNewFruitsPOJO.getPrice());
			globalVariablesFunctions.preparedStatement.setString(5, addNewFruitsPOJO.getdate());
			int row =globalVariablesFunctions.preparedStatement.executeUpdate();
			System.err.println(row+"fruit is added !");
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
