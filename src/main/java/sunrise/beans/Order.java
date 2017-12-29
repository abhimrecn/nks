package sunrise.beans;

import java.util.Date;

public class Order {

	private int OrderID;
	
	private String CustId;
	private Date StartDate,EndDate;
	private String PackingEmploye;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderID, String custId, Date startDate, Date endDate, String packingEmploye) {
		super();
		OrderID = orderID;
		CustId = custId;
		StartDate = startDate;
		EndDate = endDate;
		PackingEmploye = packingEmploye;
	}
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public String getCustId() {
		return CustId;
	}
	public void setCustId(String custId) {
		CustId = custId;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public String getPackingEmploye() {
		return PackingEmploye;
	}
	public void setPackingEmploye(String packingEmploye) {
		PackingEmploye = packingEmploye;
	}
	@Override
	public String toString() {
		return "Order [OrderID=" + OrderID + ", CustId=" + CustId + ", StartDate=" + StartDate + ", EndDate=" + EndDate
				+ ", PackingEmploye=" + PackingEmploye + "]";
	}
	
	
}

