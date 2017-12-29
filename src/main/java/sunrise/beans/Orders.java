package sunrise.beans;

public class Orders {
	
	int orderID;
	String ProductName;
	int Quantity;
	public Orders(int orderID, String productName, int quantity) {
		super();
		this.orderID = orderID;
		ProductName = productName;
		Quantity = quantity;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	@Override
	public String toString() {
		return "Orders [orderID=" + orderID + ", ProductName=" + ProductName + ", Quantity=" + Quantity + "]";
	}
	
	


}
