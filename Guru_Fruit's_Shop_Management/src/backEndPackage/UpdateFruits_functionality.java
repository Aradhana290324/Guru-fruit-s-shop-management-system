package backEndPackage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import global_variables_functions.GlobalVariablesFunctions;

public class UpdateFruits_functionality {
	AddNewFruitsPOJO addNewFruitsPOJO=new AddNewFruitsPOJO();
	GlobalVariablesFunctions globalVariablesFunctions=new GlobalVariablesFunctions();
	public void updatefruits() {
		
		globalVariablesFunctions.scan=new Scanner(System.in);
		System.out.println("Enter name of the fruit : ");
		addNewFruitsPOJO.setNameOfFruit(globalVariablesFunctions.scan.next());
//		System.out.println("Enter qty of the fruit");
//		addNewFruitsPOJO.setQty(globalVariablesFunctions.scan.nextInt());
		try {
			Connection con=globalVariablesFunctions.getConnection();
			globalVariablesFunctions.preparedStatement=con.prepareStatement("select * from guru_fruits_shop where name=? and qty=? ");
			globalVariablesFunctions.preparedStatement.setString(1, addNewFruitsPOJO.getNameOfFruit());
			globalVariablesFunctions.preparedStatement.setInt(2, addNewFruitsPOJO.getQty());
			globalVariablesFunctions.resultSet=globalVariablesFunctions.preparedStatement.executeQuery();
			
			if((globalVariablesFunctions.resultSet.next() !=false) && (addNewFruitsPOJO.getNameOfFruit().equals(globalVariablesFunctions.resultSet.getString(1)))) 
//					&& (addNewFruitsPOJO.getQty()==globalVariablesFunctions.resultSet.getInt(2)))
			{
				addNewFruitsPOJO.setQty(globalVariablesFunctions.resultSet.getInt(2));
				addNewFruitsPOJO.setUnit(globalVariablesFunctions.resultSet.getString(3));
				addNewFruitsPOJO.setPrice(globalVariablesFunctions.resultSet.getInt(4));
				addNewFruitsPOJO.setdate(globalVariablesFunctions.resultSet.getString(5));
				
				System.out.println(globalVariablesFunctions.resultSet.getString(1)+" "+globalVariablesFunctions.resultSet.getInt(2)+" "+globalVariablesFunctions.resultSet.getString(3)+" "+globalVariablesFunctions.resultSet.getInt(4)+" "+globalVariablesFunctions.resultSet.getString(5));
			
				int count=0;
				while(count < 4) {
				System.out.println("1.qty \n2.price \n3.Date \n4.Done");
			
			switch(count=globalVariablesFunctions.scan.nextInt()) {
			case 1:
				System.out.println("Previous qty : "+addNewFruitsPOJO.getQty()+" Enter New Qty : \n");
				addNewFruitsPOJO.setQty(globalVariablesFunctions.scan.nextInt());
				break;
//			case 2:
//				System.out.println("Previous unit : "+addNewFruitsPOJO.getUnit()+"Enter New unit : ");
//				addNewFruitsPOJO.setUnit(globalVariablesFunctions.scan.next());
//				break;
			case 2:
				System.out.println("Previous price : "+addNewFruitsPOJO.getPrice()+" Enter new price : \n");
				addNewFruitsPOJO.setPrice(globalVariablesFunctions.scan.nextInt());
				break;
			case 3:
				System.out.println("Previous Date : "+addNewFruitsPOJO.getdate()+" Enter new Date : \n");
				addNewFruitsPOJO.setdate(globalVariablesFunctions.scan.next());
				break;
			}
			
			}
				
				//connecting to db
				globalVariablesFunctions.preparedStatement=con.prepareStatement("update guru_fruits_shop set qty=?, price=?, date=? where name= ?");
				globalVariablesFunctions.preparedStatement.setString(5,globalVariablesFunctions.resultSet.getString(1));
				globalVariablesFunctions.preparedStatement.setInt(1, addNewFruitsPOJO.getQty());
//				globalVariablesFunctions.preparedStatement.setString(2, addNewFruitsPOJO.getUnit());
				globalVariablesFunctions.preparedStatement.setInt(2, addNewFruitsPOJO.getPrice());
				globalVariablesFunctions.preparedStatement.setString(3, addNewFruitsPOJO.getdate());
				int row=globalVariablesFunctions.preparedStatement.executeUpdate();
				System.err.println(row+" fruit detail is updated !!");
				
			}
			else {
				System.err.println("No such fruit available in database ! ");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
