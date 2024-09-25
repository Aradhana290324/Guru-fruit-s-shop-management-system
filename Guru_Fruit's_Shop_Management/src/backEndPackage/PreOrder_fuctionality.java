package backEndPackage;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import global_variables_functions.GlobalVariablesFunctions;

public class PreOrder_fuctionality {
	CustomerDetailsPOJO customerDetailsPOJO=new CustomerDetailsPOJO();
	GlobalVariablesFunctions globalVariablesFunctions=new GlobalVariablesFunctions();
	AddNewFruitsPOJO addNewFruitsPOJO=new AddNewFruitsPOJO();
//	public  void preOrder() {
//	globalVariablesFunctions.scan=new Scanner(System.in);
//	try {
//		globalVariablesFunctions.preparedStatement.getConnection();
//		
//	} catch (SQLException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
//	
//	
//		//customer Detail
//		System.out.println("Enter Customer Name : ");
//		customerDetailsPOJO.setCostumername(globalVariablesFunctions.scan.next());
//		System.out.println("Enter contact number : ");
//		customerDetailsPOJO.setOrderContact(globalVariablesFunctions.scan.next());
//
//		
////				if(customerDetailsPOJO.getOrderContact()addNewFruitsPOJO.==0) {
//		System.out.println("Enter Delivery Date(dd-mm-yyyy) : ");
//		customerDetailsPOJO.setDeliverydate(globalVariablesFunctions.scan.next());
//		
//		
//		int check=0;
//		int grandtotal = 0;
//		try {
////			File file=new File("C:\\java\\squad\\javad1\\Guru_Fruit's_Shop_Management\\Files\\Order.txt");
////			file.createNewFile();
//			globalVariablesFunctions.fileWriter=new FileWriter("C:\\java\\squad\\javad1\\Guru_Fruit's_Shop_Management\\Files\\Order.txt",true);
//			globalVariablesFunctions.fileWriter.append("Name of the customer : "+customerDetailsPOJO.getCostumername()+
//					"\nContact Number : "+customerDetailsPOJO.getOrderContact()+" \n Delivery Date : "+customerDetailsPOJO.getDeliverydate()+"\n");
//			
//			do{
//			System.out.println("Enter fruit name : ");
//			addNewFruitsPOJO.setNameOfFruit(globalVariablesFunctions.scan.next());
//			System.out.println("Enter Qty : ");
//			addNewFruitsPOJO.setQty(globalVariablesFunctions.scan.nextInt());
//			System.out.println("Enter unit of the fruit : ");
//			addNewFruitsPOJO.setUnit(globalVariablesFunctions.scan.next());
//			System.out.println("Enter price : ");
//			customerDetailsPOJO.setOrderprice(globalVariablesFunctions.scan.nextInt());
//			
//			globalVariablesFunctions.fileWriter.append("\n"+addNewFruitsPOJO.getQty()+" "+addNewFruitsPOJO.getNameOfFruit()+" X "+customerDetailsPOJO.getOrderprice()+
//					" = "+(addNewFruitsPOJO.getQty() * customerDetailsPOJO.getOrderprice()+"/-\n"));
//			grandtotal=(grandtotal+ addNewFruitsPOJO.getQty() * customerDetailsPOJO.getOrderprice());
//			
//			System.out.println("1.Do you want to add more fruits in your cart ? (if no press '0') : ");
//			check=globalVariablesFunctions.scan.nextInt();
//			
//			
//			if(check ==0) {
//				globalVariablesFunctions.fileWriter.append("\nGrandTotal : "+grandtotal);
//				
//				System.out.println("Total Amount : "+grandtotal);
//				System.out.println("Enter Advance payment  : ");
//				int adv=globalVariablesFunctions.scan.nextInt();
//				int pending=(grandtotal-adv);
//				System.out.println("Pending Payment : "+pending);
//				globalVariablesFunctions.fileWriter.append("\nAdvance : "+adv+"\nRemaining Payment : "+pending);
//				
//				globalVariablesFunctions.fileWriter.append("\n--------------------\n");
//				System.out.println("Order placed successfully !!");  
//				break;
//			}
//			}while(check != 0);
//			globalVariablesFunctions.fileWriter.close();
//		
//		
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	
//	}
	public void placeorder() {
		globalVariablesFunctions.scan=new Scanner(System.in);
		
		//customer Detail
				System.out.println("Enter Customer Name : ");
				customerDetailsPOJO.setCostumername(globalVariablesFunctions.scan.next());
				System.out.println("Enter contact number : ");
				customerDetailsPOJO.setOrderContact(globalVariablesFunctions.scan.next());
				System.out.println("Enter Delivery Date(dd-mm-yyyy) : ");
				customerDetailsPOJO.setDeliverydate(globalVariablesFunctions.scan.next());
				
		//transaction details
				
//				System.out.println("Enter fruit name : ");
//				addNewFruitsPOJO.setNameOfFruit(globalVariablesFunctions.scan.next());
//				System.out.println("Enter quantity of the fruit : ");
//				addNewFruitsPOJO.setQty(globalVariablesFunctions.scan.nextInt());
//				System.out.println("Enter unit of the fruit : ");
//				addNewFruitsPOJO.setUnit(globalVariablesFunctions.scan.next());
//				System.out.println("Enter Price of the fruit : ");
//				addNewFruitsPOJO.setPrice(globalVariablesFunctions.scan.nextInt());
				
		try {
			Connection con=globalVariablesFunctions.getConnection();
			globalVariablesFunctions.preparedStatement= con.prepareStatement("insert into preorder_table(customerName,contact,date) values(?,?,?)");
//			globalVariablesFunctions.preparedStatement= con.prepareStatement("insert into preorder_table values(?,?,?,?,?,?,?)");

			globalVariablesFunctions.preparedStatement.setString(1,customerDetailsPOJO.getCostumername());
			globalVariablesFunctions.preparedStatement.setString(2, customerDetailsPOJO.getOrderContact());
			globalVariablesFunctions.preparedStatement.setString(3, customerDetailsPOJO.getDeliverydate());
//			globalVariablesFunctions.preparedStatement.setString(3,addNewFruitsPOJO.getNameOfFruit());
//			globalVariablesFunctions.preparedStatement.setInt(4,addNewFruitsPOJO.getQty());
//			globalVariablesFunctions.preparedStatement.setString(5,addNewFruitsPOJO.getUnit());
//			globalVariablesFunctions.preparedStatement.setInt(6, addNewFruitsPOJO.getPrice());
			int row = globalVariablesFunctions.preparedStatement.executeUpdate();
			System.out.println("customer details added successfully !");
//			globalVariablesFunctions.resultSet=globalVariablesFunctions.preparedStatement.executeQuery();
			int check =1;
			int grandTotal=0;
			do{
			System.out.println("Enter fruit name : ");
			addNewFruitsPOJO.setNameOfFruit(globalVariablesFunctions.scan.next());
			System.out.println("Enter quantity of the fruit : ");
			addNewFruitsPOJO.setQty(globalVariablesFunctions.scan.nextInt());
			System.out.println("Enter unit of the fruit : ");
			addNewFruitsPOJO.setUnit(globalVariablesFunctions.scan.next());
			System.out.println("Enter Price of the fruit : ");
			addNewFruitsPOJO.setPrice(globalVariablesFunctions.scan.nextInt()); 
			
			globalVariablesFunctions.preparedStatement= con.prepareStatement("insert into preorder_table values(?,?,?,?,?,?,?)");
//			globalVariablesFunctions.preparedStatement=con.prepareStatement("update preorder_table set fruitName=fruitName+ ? where customername = ? ");
			globalVariablesFunctions.preparedStatement.setString(1,customerDetailsPOJO.getCostumername());
			globalVariablesFunctions.preparedStatement.setString(2, customerDetailsPOJO.getOrderContact());
			globalVariablesFunctions.preparedStatement.setString(3,addNewFruitsPOJO.getNameOfFruit());
			globalVariablesFunctions.preparedStatement.setInt(4,addNewFruitsPOJO.getQty());
			globalVariablesFunctions.preparedStatement.setString(5,addNewFruitsPOJO.getUnit());
			globalVariablesFunctions.preparedStatement.setInt(6, addNewFruitsPOJO.getPrice());
			globalVariablesFunctions.preparedStatement.setString(7, customerDetailsPOJO.getDeliverydate());
			int row1 = globalVariablesFunctions.preparedStatement.executeUpdate();
//			globalVariablesFunctions.resultSet=globalVariablesFunctions.preparedStatement.executeQuery();
			grandTotal=(addNewFruitsPOJO.getQty() * addNewFruitsPOJO.getPrice());
			System.out.println("fruit details added successfully");
			System.out.println("Do you want to add more Fruits in your cart (if no press '0')");
			check=globalVariablesFunctions.scan.nextInt();
			if(check==0) {
				
				grandTotal= grandTotal + ((addNewFruitsPOJO.getQty() * addNewFruitsPOJO.getPrice()));
				System.out.println(grandTotal);
				System.out.println("Enter Advance Amount ");
				int advance = globalVariablesFunctions.scan.nextInt();
				int pendingAmount=grandTotal-advance;
				System.out.println(pendingAmount);
				System.out.println("order Placed Successfully !!");
				break;
				
				
			}
			
			
		
		}while(check !=0);
			
//			globalVariablesFunctions.preparedStatement.setString(1,);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public void listOfOrderbydate(){
		try {
			globalVariablesFunctions.scan=new Scanner(System.in);
			Connection con =globalVariablesFunctions.getConnection();
			System.out.println("Enter date");
			customerDetailsPOJO.setDeliverydate(globalVariablesFunctions.scan.next());
			globalVariablesFunctions.preparedStatement=con.prepareStatement("select *  from preorder_table where date= ?");
			globalVariablesFunctions.preparedStatement.setString(1, customerDetailsPOJO.getDeliverydate());
			globalVariablesFunctions.resultSet=globalVariablesFunctions.preparedStatement.executeQuery();
			while(globalVariablesFunctions.resultSet.next()) {
			if((globalVariablesFunctions.resultSet.next() !=false) && customerDetailsPOJO.getDeliverydate().equals(globalVariablesFunctions.resultSet.getString(7))) {
				
				
				System.out.println(globalVariablesFunctions.resultSet.getString(1) + " "
						+ globalVariablesFunctions.resultSet.getInt(2) + " "
						+ globalVariablesFunctions.resultSet.getString(3) + " "
						+ globalVariablesFunctions.resultSet.getInt(4)+ " "
						+globalVariablesFunctions.resultSet.getString(5) + " "
						+globalVariablesFunctions.resultSet.getInt(6)+" "
						+globalVariablesFunctions.resultSet.getString(7));
			}
			else {
				System.err.println("No order on this date !!");
			}
		}
					
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
//		customerDetailsPOJO.setCostumername(globalVariablesFunctions.scan.next());
	}
	
	}
	public void listoforderbyname() {
		globalVariablesFunctions.scan=new Scanner(System.in);
		try {
			Connection con =globalVariablesFunctions.getConnection();
			System.out.println("Enter Name : ");
			customerDetailsPOJO.setCostumername(globalVariablesFunctions.scan.next());
			globalVariablesFunctions.preparedStatement=con.prepareStatement("select *  from preorder_table where customerName=?");
			globalVariablesFunctions.preparedStatement.setString(1, customerDetailsPOJO.getCostumername());
			globalVariablesFunctions.resultSet=globalVariablesFunctions.preparedStatement.executeQuery();
			while(globalVariablesFunctions.resultSet.next()) {
			if((globalVariablesFunctions.resultSet.next() !=false) && customerDetailsPOJO.getCostumername().equals(globalVariablesFunctions.resultSet.getString(1))) {
				
				
				System.out.println(globalVariablesFunctions.resultSet.getString(1) + " "
						+ globalVariablesFunctions.resultSet.getInt(2) + " "
						+ globalVariablesFunctions.resultSet.getString(3) + " "
						+ globalVariablesFunctions.resultSet.getInt(4)+" "
						+globalVariablesFunctions.resultSet.getString(5)
						+globalVariablesFunctions.resultSet.getInt(6)+" "
						+globalVariablesFunctions.resultSet.getString(7));
			}
			else {
				System.err.println("No order with this name !!");
			}
			}
					
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}