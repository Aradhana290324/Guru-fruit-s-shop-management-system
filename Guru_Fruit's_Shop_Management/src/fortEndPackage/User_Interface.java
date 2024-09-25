package fortEndPackage;

import java.util.Scanner;
import backEndPackage.AddNewFruits_functionality;
import backEndPackage.FreshBill_functionality;
import backEndPackage.ListOfFruits_functinality;
import backEndPackage.PreOrder_fuctionality;
import backEndPackage.UpdateFruits_functionality;
import global_variables_functions.GlobalVariablesFunctions;

public class User_Interface {
	GlobalVariablesFunctions globalVariablesFunctions = new GlobalVariablesFunctions();
	AddNewFruits_functionality addNewFruits_functionality = new AddNewFruits_functionality();
	UpdateFruits_functionality updateFruits_functionality = new UpdateFruits_functionality();
	ListOfFruits_functinality listOfFruits_functinality = new ListOfFruits_functinality();
	FreshBill_functionality freshBill_functionality = new FreshBill_functionality();
	PreOrder_fuctionality preOrder_fuctionality = new PreOrder_fuctionality();

	public void userInterface() {
		globalVariablesFunctions.scan = new Scanner(System.in);
		do {

			System.err.println(" * * * Guru Fruit's Shop Management * * * ");
			System.err.println("1. Add New Fruit's \n2.Update Fruit's Details \n3.Generate Fresh Bill"
					+ " \n4.Pre-Orders \n5.List of Fruits \n6.Exist");
			switch (globalVariablesFunctions.scan.nextInt()) {
			case 1:
				addNewFruits_functionality.addNewFruits();
				break;
			case 2:
				updateFruits_functionality.updatefruits();
				break;
			case 3:
				freshBill_functionality.freshBill();
				break;
			case 4:
				System.out.println("1.Place new order \n2.View list of order");
				switch (globalVariablesFunctions.scan.nextInt()) {
				case 1:
					preOrder_fuctionality.placeorder();
					break;
				case 2:
					System.out.println("3.search order by Date \n4.search order by name ");
					switch (globalVariablesFunctions.scan.nextInt()) {
					case 3:
						preOrder_fuctionality.listOfOrderbydate();
						break;
					case 4:
						preOrder_fuctionality.listoforderbyname();
						break;
					}

					break;

				}
				break;
			case 5:
				listOfFruits_functinality.listOfFruits();
				break;
			case 6:
				System.exit(0);
				break;
			}

		} while (true);
	}

}

//			System.out.println("2.find orders by Name of the customer \n1.find ordersd by delivery date ");
//			switch(globalVariablesFunctions.scan.nextInt()) {
//			case 1:
//				preOrder_fuctionality.listOfOrder();
//				break;
//			case 3:
//				bill_Functionality.duplicateBill();
//				break;
//			}
