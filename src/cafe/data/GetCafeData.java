package cafe.data;

import java.util.ArrayList;
import java.util.List;

import cafe.order.BakeryOrder;
import cafe.order.BeverageOrder;
import cafe.order.CafeOrder;
import cafe.order.Order;
import dto.goods.Goods;
import dto.goods.beverage.Caffeine;
import dto.goods.beverage.NonCaffeine;
import dto.goods.nonbeverage.Bakery;
import dto.goods.nonbeverage.Md;
import dto.goods.nonbeverage.Topping;
import lombok.extern.log4j.Log4j2;
import vo.BakeryNamesets;
import vo.BeverageNamesets;
import vo.MdNamesets;
import vo.Seasonsets;
import vo.ToppingNamesets;

@Log4j2
public abstract class GetCafeData {

	protected static List<Goods> getBeverageMenuList() {
		log.trace("getBeverageMenuList() invoked.");

		List<Goods> beverageMenuList = new ArrayList<>();

		beverageMenuList.add(new Caffeine(BeverageNamesets.에스프레소, 4000, 500, Seasonsets.always));
		beverageMenuList.add(new Caffeine(BeverageNamesets.아메리카노, 4500, 1000, Seasonsets.always));
		beverageMenuList.add(new Caffeine(BeverageNamesets.콜드브루, 4900, 500, Seasonsets.always));
		beverageMenuList.add(new Caffeine(BeverageNamesets.카페라떼, 4800, 250, Seasonsets.always));
		beverageMenuList.add(new Caffeine(BeverageNamesets.바닐라라떼, 5000, 250, Seasonsets.always));
		beverageMenuList.add(new Caffeine(BeverageNamesets.아포가토, 5500, 50, Seasonsets.always));
		beverageMenuList.add(new Caffeine(BeverageNamesets.자바칩프라프치노, 5900, 100, Seasonsets.always));
		beverageMenuList.add(new Caffeine(BeverageNamesets.녹차프라프치노, 5900, 100, Seasonsets.always));
		
		beverageMenuList.add(new NonCaffeine(BeverageNamesets.복숭아티, 4400, 250, Seasonsets.always));
		beverageMenuList.add(new NonCaffeine(BeverageNamesets.우유, 4000, 100, Seasonsets.always));
		beverageMenuList.add(new NonCaffeine(BeverageNamesets.밀크티, 5500, 250, Seasonsets.now));

		return beverageMenuList;
	} //getBeverageMenuList

	protected static List<Goods> getBakeryMenuList() {
		log.trace("getBakeryMenuList() invoked.");

		List<Goods> bakeryMenuList = new ArrayList<>();
		
		bakeryMenuList.add(new Bakery(BakeryNamesets.단팥빵, 1700, 50, Seasonsets.always));
		bakeryMenuList.add(new Bakery(BakeryNamesets.붕어빵, 1000, 50, Seasonsets.always));
		bakeryMenuList.add(new Bakery(BakeryNamesets.롤케이크, 19000, 30, Seasonsets.commingSoon));
		bakeryMenuList.add(new Bakery(BakeryNamesets.수제쿠키, 2300, 50, Seasonsets.always));
		bakeryMenuList.add(new Bakery(BakeryNamesets.터프쿠키, 5500, 10, Seasonsets.always));
		bakeryMenuList.add(new Bakery(BakeryNamesets.뉴진스쿠키, 3000, 5, Seasonsets.now));
		bakeryMenuList.add(new Bakery(BakeryNamesets.뉴진세쿠키, 3500, 15, Seasonsets.now));
		
		return bakeryMenuList;
	} //getBakeryMenuList
		
		
		protected static List<Goods> getMDMenuList() {
			log.trace("getMDMenuList() invoked.");

			List<Goods> MDMenuList = new ArrayList<>();
		
		MDMenuList.add(new Md(MdNamesets.다이어리2023, 18000, 100, Seasonsets.now));
		MDMenuList.add(new Md(MdNamesets.달력2023, 22000, 100, Seasonsets.now));
		MDMenuList.add(new Md(MdNamesets.머그컵, 8800, 50, Seasonsets.always));
		MDMenuList.add(new Md(MdNamesets.텀블러, 7500, 7, Seasonsets.now));
		MDMenuList.add(new Md(MdNamesets.무드등, 13000, 1, Seasonsets.past));

		return MDMenuList;
	} //getMDMenuList

	protected static List<Goods> getToppingMenuList() {
		log.trace("getToppingMenuList() invoked.");
		
		List<Goods> toppingMenuList = new ArrayList<>();

		toppingMenuList.add(new Topping(ToppingNamesets.샷, 500, 500, Seasonsets.always));
		toppingMenuList.add(new Topping(ToppingNamesets.펄, 500, 200, Seasonsets.now));
		toppingMenuList.add(new Topping(ToppingNamesets.휘핑, 500, 100, Seasonsets.always));
		toppingMenuList.add(new Topping(ToppingNamesets.생크림, 500, 0, Seasonsets.now));
		toppingMenuList.add(new Topping(ToppingNamesets.우유, 500, 200, Seasonsets.always));
		toppingMenuList.add(new Topping(ToppingNamesets.아이스크림, 500, 50, Seasonsets.past));
		
		return toppingMenuList;
	} //getToppingMenuList
	
	public static List<Order> getCafeOrderList() {
		log.trace("getMenuList() invoked.");

		List<Order> orderList = new ArrayList<>();

		orderList.add(new BeverageOrder(BeverageNamesets.아메리카노, 4, null));
		orderList.add(new BeverageOrder(BeverageNamesets.자바칩프라프치노, 2, null));
		orderList.add(new BeverageOrder(BeverageNamesets.복숭아티, 7, null));
		orderList.add(new BakeryOrder(BakeryNamesets.단팥빵, 5));
		orderList.add(new BakeryOrder(BakeryNamesets.붕어빵, 20));
		orderList.add(new BakeryOrder(BakeryNamesets.뉴진스쿠키, 20));
		

		return orderList;
	} // gerOrderList







} // main
