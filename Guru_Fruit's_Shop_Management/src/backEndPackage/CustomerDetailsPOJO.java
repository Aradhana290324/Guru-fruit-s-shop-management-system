package backEndPackage;

public class CustomerDetailsPOJO {
//details for order and bill both
	private String costumername;
	private int sellprice;
//	private String billdate;
	
//Detail for order	
	private int Orderprice;
	private String orderContact;
	private String deliverydate;
	
	
	public String getCostumername() {
		return costumername;
	}
	public void setCostumername(String costumername) {
		this.costumername = costumername;
	}
	public int getSellprice() {
		return sellprice;
	}
	public void setSellprice(int sellprice) {
		this.sellprice = sellprice;
	}
//	public String getBilldate() {
//		return billdate;
//	}
//	public void setBilldate(String billdate) {
//		this.billdate = billdate;
//	}
	
	//order Details
	public int getOrderprice() {
		return Orderprice;
	}
	public void setOrderprice(int orderprice) {
		Orderprice = orderprice;
	}
	public String getOrderContact() {
		return orderContact;
	}
	public void setOrderContact(String orderContact) {
		this.orderContact = orderContact;
	}
	public String getDeliverydate() {
		return deliverydate;
	}
	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}
	
	
}
