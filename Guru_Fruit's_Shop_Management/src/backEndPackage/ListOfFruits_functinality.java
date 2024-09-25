package backEndPackage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import global_variables_functions.GlobalVariablesFunctions;

public class ListOfFruits_functinality {
	GlobalVariablesFunctions globalVariablesFunctions = new GlobalVariablesFunctions();

	public void listOfFruits() {
		

		try {
			Connection con = globalVariablesFunctions.getConnection();
			// globalVariablesFunctions.preparedStatement=con.prepareStatement("select *
			// from guru_fruits_shop");
			globalVariablesFunctions.statement = con.createStatement();
			globalVariablesFunctions.resultSet = globalVariablesFunctions.statement.executeQuery("select * from guru_fruits_shop");
			while(globalVariablesFunctions.resultSet.next()) {
				//LocalDate ld = LocalDate.now();
				String currentdate ="20-12-2023";
				String localdate[] = currentdate.split("-");
				String dbDate[] = (globalVariablesFunctions.resultSet.getString(5).split("-"));
				if ((Integer.parseInt(localdate[0]) - (Integer.parseInt(dbDate[0])) >=1) && (Integer.parseInt(localdate[1]) - (Integer.parseInt(dbDate[1])) ==0) 
									&&((Integer.parseInt(localdate[2]) - (Integer.parseInt(dbDate[2])) ==0))) {
//				if ((Integer.parseInt(dbDate[0]) - (Integer.parseInt(localdate[0])) ==1) && (Integer.parseInt(dbDate[1]) - (Integer.parseInt(localdate[1])) ==0) 
//						&&((Integer.parseInt(dbDate[2]) - (Integer.parseInt(localdate[2])) ==0))) {
//				if ((Integer.parseInt(dbDate[0]) - (Integer.parseInt(localdate[0])) ==1)){
					System.err.println(globalVariablesFunctions.resultSet.getString(1) + " "
							+ globalVariablesFunctions.resultSet.getInt(2) + " "
							+ globalVariablesFunctions.resultSet.getString(3) + " "
							+ globalVariablesFunctions.resultSet.getInt(4)+" "
							+globalVariablesFunctions.resultSet.getString(5));
				}
				else {
					 
					System.out.println(globalVariablesFunctions.resultSet.getString(1) + " "
							+ globalVariablesFunctions.resultSet.getInt(2) + " "
							+ globalVariablesFunctions.resultSet.getString(3) + " "
							+ globalVariablesFunctions.resultSet.getInt(4)+" "
							+globalVariablesFunctions.resultSet.getString(5));
					}

				}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
