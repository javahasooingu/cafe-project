package dto;

import java.util.List;

import cafe.order.Order;
import lombok.Data;


@Data
public class User {

	private String name;
	private String sno;
	private int money;
	private int point;
	private String grade; // basic, vip, vvip, vvvip
	
	private List<Order> orderList;
	

	public User(String name, String sno, int money, int point, String grade) {
		this.name = name;
		this.sno = sno;
		this.money = money;
		this.point = point;
		this.grade = grade;
		
		this.orderList = null;
	} // constructor
	
	@Override
	public String toString(){
		return "" + this.grade + "등급" + this.name;
	} // toString
			
	
} // end class