package sunrise.DAO;

import java.util.Calendar;
import java.util.List;
import java.util.TreeMap;

import sunrise.beans.Customer;
import sunrise.beans.Order;
import sunrise.beans.Product;


public interface OrdersDAO {

	public List<Order> getALLOrders();
	public int assignTask(int id,String EmpName);
	public int PlaceOrder(String d1,String d2, int days,TreeMap<Product,Integer> t,Customer c);
}
