package cafe;

import cafe.data.GetCafeData;
import dto.User;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class CafeTest {

	public static void main(String[] args) throws Exception{

		User user1 = new User("송인구", "951024", 1_000_000_000, 1_000, "vvvip");
		
		user1.setOrderList(GetCafeData.getCafeOrderList());
		
		System.out.println("주문목록");
		user1.getOrderList().forEach(System.out::println);
		
		Calculation.calculate(user1);
		
		System.out.println("주문 완료");
		user1.getOrderList().forEach(System.out::println);
		
		
	} // main

} // end class
