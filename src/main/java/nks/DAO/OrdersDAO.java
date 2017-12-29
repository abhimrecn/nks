package nks.DAO;

import java.util.Calendar;
import java.util.List;
import java.util.TreeMap;

import nks.beans.Customer;
import nks.beans.Order;
import nks.beans.Product;


public interface OrdersDAO {

	public List<Order> getALLOrders();
	public int assignTask(int id,String EmpName);
	public int PlaceOrder(String d1,String d2, int days,TreeMap<Product,Integer> t,Customer c);
}
