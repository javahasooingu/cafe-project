package vo;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class CafeLogs {

	//	protected static void saleLog(CafeOrderSheet orderSheet) {
	//	log.info("주문하신 제품의 총 가격은 {} 이고 등급 할인된 가격은 {} 입니다.", orderSheet.);
	//} // saleLog

	public static void noMenuLog(String orderName) {
		log.info("{}은/는 존재하지 않는 메뉴입니다.", orderName);
	} // noMuneLog

	public static void notNowSeasonLog(String orderName) {
		log.info("{}은/는 시즌 한정 메뉴입니다.", orderName);
	} // noMuneLog

	public static void outOfStockLog(String orderName) {
		log.info("{}은/는 재고가 부족합니다.", orderName);
	} // stockLog
	
	public static void showTotalPriceLog(int totalPrice) {
		log.info("총 가격은 {}원 입니다.", totalPrice);
	} // showTotalPrice
	
	public static void savePintLog(int savedPoint) {
		log.info("총 {} Point 적립도와드렸습니다.", savedPoint);
	} // savePintLog
	
	public static void orderFailLog(String userName) {
		log.info("{}님의 주문이 실패했습니다.", userName);
	} // orderFail
	
	public static void orderSuccessLog(String userName, int realPrice) {
		log.info("{}님! 최종 {}원 결제 해드리겠습니다. 감사합니다.", userName, realPrice);
	} // orderSuccess

} // end class
