package backEndPackage;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import global_variables_functions.GlobalVariablesFunctions;

public class FreshBill_functionality {
	CustomerDetailsPOJO customerDetailsPOJO=new CustomerDetailsPOJO();
	GlobalVariablesFunctions globalVariablesFunctions=new GlobalVariablesFunctions();
	AddNewFruitsPOJO addNewFruitsPOJO =new AddNewFruitsPOJO();
	int sellPrice;
	int sellqty;

	public void freshBill(){
		globalVariablesFunctions.scan=new Scanner(System.in);
		LocalDate ld= LocalDate.now();
		System.out.println("Enter Customer name: ");
		customerDetailsPOJO.setCostumername(globalVariablesFunctions.scan.next());
//		System.out.println("Enter Customer contact number :");
//		customerDetailsPOJO.setContact(globalVariablesFunctions.scan.next());
		System.out.println(" date : "+ld);
		
		// file
		try {
			globalVariablesFunctions.fileWriter= new FileWriter("C:\\java\\squad\\javad1\\Guru_Fruit's_Shop_Management\\Files\\CustomerBill.txt",true);
			globalVariablesFunctions.fileWriter.append("\t"+ "\n* * * Bill * * * \nname :"+customerDetailsPOJO.getCostumername()+
					"\nDate :"+ld+"\n");
			
			//Connection 
			int grandTotal=0;
			int check=1;
//			sellPrice=0;
//			sellqty=0;
			
			
			do {
			System.out.println("Enter Fruit Name : ");
			addNewFruitsPOJO.setNameOfFruit(globalVariablesFunctions.scan.next());
			
				Connection con=globalVariablesFunctions.getConnection();
				globalVariablesFunctions.preparedStatement=con.prepareStatement("select * from guru_fruits_shop where name=?");
				globalVariablesFunctions.preparedStatement.setString(1, addNewFruitsPOJO.getNameOfFruit());
				globalVariablesFunctions.resultSet=globalVariablesFunctions.preparedStatement.executeQuery();
				
				int databaseqty=0;
				int databasesellqty=0;
				while(globalVariablesFunctions.resultSet.next()) {
					databaseqty=globalVariablesFunctions.resultSet.getInt(2);
					databasesellqty=globalVariablesFunctions.resultSet.getInt(6);
					System.out.println("Qty : ");
					addNewFruitsPOJO.setQty(globalVariablesFunctions.scan.nextInt());
					
					
					
					if(databaseqty >= addNewFruitsPOJO.getQty())  {
//						addNewFruitsPOJO.setPrice(globalVariablesFunctions.resultSet.getInt(3));
						System.out.println("Enter Unit of the fruit : ");
						String userUnit=globalVariablesFunctions.scan.next();
						System.out.println("Enter Price : ");
						sellPrice=globalVariablesFunctions.scan.nextInt();
						globalVariablesFunctions.fileWriter.append(addNewFruitsPOJO.getQty()+" "+userUnit+" "+addNewFruitsPOJO.getNameOfFruit()+
								" X "+sellPrice+
								" = "+ ((addNewFruitsPOJO.getQty() )* sellPrice)+"/-\n");
				
						globalVariablesFunctions.preparedStatement =con.prepareStatement("update guru_fruits_shop set qty=? where name=? ");
						globalVariablesFunctions.preparedStatement.setInt(1,(databaseqty - addNewFruitsPOJO.getQty())) ;
						globalVariablesFunctions.preparedStatement.setString(2, addNewFruitsPOJO.getNameOfFruit());
						int row =globalVariablesFunctions.preparedStatement.executeUpdate();
						System.out.println(row +" row updated !!");
						
						//adding sold_qty in database code  
						globalVariablesFunctions.preparedStatement =con.prepareStatement("update guru_fruits_shop set sold_qty=? where name=? ");
						globalVariablesFunctions.preparedStatement.setInt(1,(databasesellqty + addNewFruitsPOJO.getQty())) ;
						globalVariablesFunctions.preparedStatement.setString(2, addNewFruitsPOJO.getNameOfFruit());
						int row1 =globalVariablesFunctions.preparedStatement.executeUpdate();
						System.out.println(row1 +" row updated succssfully in Database !!"); 
						
						//adding sell_price in data base
//						globalVariablesFunctions.preparedStatement =con.prepareStatement("update guru_fruits_shop set sell_price=? where name=? ");
//						globalVariablesFunctions.preparedStatement.setInt(1,((sellPrice+globalVariablesFunctions.resultSet.getInt(sellPrice)))) ;
//						globalVariablesFunctions.preparedStatement.setString(2, addNewFruitsPOJO.getNameOfFruit());
//						int row2 =globalVariablesFunctions.preparedStatement.executeUpdate();
//						System.out.println(row1 +" row is updated succssfully in Database price column !!");
						
					}
					else {
						System.err.println("OUT OF STOCK !!");
					}
				}
				System.out.println("Do you want to add more Fruits in your cart (if no press '0')");
//				System.out.println(sellPrice);
//				System.out.println(sellqty);
				check =globalVariablesFunctions.scan.nextInt();
				if(check==0) {
					grandTotal= grandTotal + ((addNewFruitsPOJO.getQty()) *  sellPrice);
					globalVariablesFunctions.fileWriter.append("GrandTotal : "+grandTotal+"\n");
					globalVariablesFunctions.fileWriter.append("\n--------------------\n");
					System.out.println("Bill generated Successfully !!");
					break;
				}
				} while (check != 0);
				globalVariablesFunctions.fileWriter.close();

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

		
		

