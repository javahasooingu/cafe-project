package cafe;

import cafe.data.CafeStorage;
import cafe.order.BakeryOrder;
import cafe.order.BeverageOrder;
import cafe.order.MdOrder;
import cafe.order.Order;
import dto.User;
import dto.goods.Goods;
import lombok.extern.log4j.Log4j2;
import vo.*;


@Log4j2
public class Calculation {

	static CafeStorage cafeStorage = CafeStorage.getStorgeInstance();

	public static void calculate(User user) throws UserDefinedRuntimeException {
		log.trace("calculate({}) invoked", user);

		int totalPrice = 0;

		for ( Order order : user.getOrderList() ) {
			boolean isInMenu = Calculation.isInMenu(order.getName());

			if (!isInMenu) {	// 일단 메뉴에 있나?
				throw new UserDefinedRuntimeException("메뉴에 존재하지 않습니다.");
			} // if 존재안하면 ㅂ2 아니면 진행

			if( order instanceof BeverageOrder beverageOder) {
				Calculation.calculateBeverage(beverageOder);
			} else if (order instanceof BakeryOrder bakeryOrder) {
				Calculation.calculateBakery(bakeryOrder);
			} else if( order instanceof MdOrder mdOrder) {
				Calculation.calculateMd(mdOrder);
			}
			
			
			
			
			
			
			
			
			
			CafeLogs.showTotalPriceLog(totalPrice);

			int realPrice = Calculation.getRealPrice(totalPrice, user.getGrade());

			int savedPoint = (int)(realPrice * Calculation.getSavePointPer(user.getGrade()) / 100);

			user.setPoint(user.getPoint() + savedPoint);

			CafeLogs.savePintLog(savedPoint);

			if (user.getMoney() < realPrice) {
				CafeLogs.orderFailLog(user.getName());
				throw new UserDefinedRuntimeException("orderFail");
			} // if
			CafeLogs.orderSuccessLog(user.getName(), realPrice);

			user.setMoney(user.getMoney() - realPrice);

			user.getOrderList().clear();

		} // calculate
	}

	
	// 메뉴에 있어?
//	private static boolean isInMenu(String orderName) {
//		log.trace("isInMenu({}) invoked", orderName);
//
//		boolean canOrder = false;
//
//		for (BeverageNamesets name : BeverageNamesets.values()) {	// 음료중에 있나
//			if(name.name().equals(orderName)) {
//				return canOrder = true;
//			} // if
//		} // for
//
//		for (BakeryNamesets name : BakeryNamesets.values()) {	// 베이커리중에 있나
//			if(name.name().equals(orderName)) {
//				return canOrder = true;
//			} // if
//		} // for
//
//		for (MdNamesets name : MdNamesets.values()) {			// MD중에 있나
//			if(name.name().equals(orderName)) {
//				return canOrder = true;
//			} // if
//		} // for
//
//		return canOrder;										// 다없으면 그냥 false
//	} // isInMenu

	// 음료 결제 프로세스
	private static int calculateBeverage(BeverageOrder beverageOrder) {
		log.trace("getBeveragePrice({}) invoked", beverageOrder);

		int beveragePrice = 0;

		for ( Goods beverage : cafeStorage.getBakeryList() ) {
			if(beverageOrder.getName().equals(beverage.getName())) {

				if(!Calculation.isNowSeason(beverage.getSeason())) {
					CafeLogs.notNowSeasonLog(beverageOrder.getName());
					throw new UserDefinedRuntimeException("notNowSeason");
				} // if
				if(!Calculation.isInStock(beverageOrder.getAmount(), beverage.getStock())) {
					CafeLogs.outOfStockLog(beverageOrder.getName());
					throw new UserDefinedRuntimeException("outOfStock");				
				} // if
				
				

			} // if
		} // for

		return beveragePrice;
	} // getBeveragePrice


	// 시즌 상품인가
	private static boolean isNowSeason(Seasonsets season) {
		log.trace("canNowOrder({}) invoked", season);

		boolean isNowSeason = season.canOrder;

		return isNowSeason;
	} // isNowSeason

	// 재고가 있나
	public static boolean isInStock(int orderAmount, int goodsStock) {
		log.trace("isInStock({}, {}) invoked", orderAmount, goodsStock);

		boolean isInStock = false;

		if ( 0 <= orderAmount ) {
			if ( orderAmount <= goodsStock ) {
				isInStock = true;
			} // inner if
		} // outer if

		return isInStock;
	} // isInStock


	// 결제 관련

	// 음료 가격 뽑아내기
	private static int getBeveragePrice(BeverageOrder beverageO, Goods beverage) {
		log.trace("getBeveragePrice({}, {}) invoked", beverageO, beverage);
		
		int beveragePrice = 0;
		
		if ( beverageO.getTopping() == null ) {
			beveragePrice = beverageO.getAmount() * beverage.getPrice();
			
			return beveragePrice;
		} // if
		beveragePrice = beverageO.getAmount() * ( getToppingPrice(null) + beverage.getPrice() );
		
		return beverageO.getAmount();
	} // getBeveragePrice
	
	// 토핑 가격 뽑아내기
	private static int getToppingPrice(String toppingName) {
		log.trace("getToppingPrice({}) invoked", toppingName);

		int toppingPrice = 0;
		
		for(Goods topping : cafeStorage.getToppingMenuList()) {
			if(toppingName.equals(topping.getName())) {
				toppingPrice = topping.getPrice();
				
				return toppingPrice;
			} // if
		} // for
		
		return toppingPrice;
	} // getToppingPrice

	// 다른거 가격 뽑아내기
	
	// 수량 카운팅
	private static void contingStock(int orderAmount , Goods goods) {		
		log.trace("contingStock({}, {}) invoked", orderAmount, goods);
		
		goods.setStock(goods.getStock() - orderAmount);
	} // contingStock


	// 찐가격
	private static int getRealPrice(int totalPrice, String userGrade) {
		log.trace("getRealPrice({}, {}) invoked", totalPrice, userGrade);

		int realPrice = totalPrice - 100 * (int)( ( totalPrice * ( ( Calculation.getDiscountPer(userGrade) ) / 100 ) ) / 100 );
		// 최종 가격 = 총가격 - 할인되는 가격 ( 10원단위 버림 )

		return realPrice;
	} // getRealPrice


	// 할인율 뽑아내기
	private static double getDiscountPer(String userGrade) {
		log.trace("getDiscountPer({}) invoked", userGrade);

		double discountPer = 0.0;

		discountPer = switch(userGrade) {
		default -> { yield 2.5;}
		case "vip" -> { yield 5.0;}
		case "vvip" -> { yield 7.5;}
		case "vvvip" -> { yield 12.5;}
		};

		return discountPer;	
	} // getDiscountPer

	// 적립율 뽑아내기
	private static double getSavePointPer(String userGrade) {
		log.trace("getSavePointPer({}) invoked", userGrade);

		double savePointPer = 0.0;

		savePointPer = switch(userGrade) {
		default -> { yield 1.0;}
		case "vip" -> { yield 1.25;}
		case "vvip" -> { yield 1.5;}
		case "vvvip" -> { yield 2;}
		};

		return savePointPer;	

	} // getSavePointPer




} // end class
