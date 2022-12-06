package cafe.data;

import java.util.*;

import dto.*;
import dto.goods.Goods;
import lombok.Data;
import lombok.extern.log4j.Log4j2;


@Log4j2
@Data
public class CafeStorage
	extends GetCafeData	 {
	
	private static final CafeStorage STORAGE;
	
	private static Map<String, List<Goods>> cafeMenu;
	
	private static int money;
	
	static {
		log.trace("default constructor invoked.");
		
		STORAGE = new CafeStorage();
		cafeMenu = new HashMap<>();
		CafeStorage.cafeMenu.put("beverage", GetCafeData.getBeverageMenuList());
		CafeStorage.cafeMenu.put("bakery", GetCafeData.getBakeryMenuList());
		CafeStorage.cafeMenu.put("MD", GetCafeData.getMDMenuList());
		CafeStorage.cafeMenu.put("topping", GetCafeData.getToppingMenuList());
	} // static initializer
	
	private CafeStorage() {
		log.trace("default constructor invoked.");
	} // constructor
	
	public static CafeStorage getStorgeInstance() {
		log.trace("getStorgeInstance() invoked.");
		
		return STORAGE;
	} // getStorgeInstance
	
	public static List<Goods> getBeverageMenuList(){
		log.trace("getCafeMenu() invoked.");
		
		return STORAGE.cafeMenu.get("beverage");
	} // getBeverageMenuList
	
	public static List<Goods> getBakeryList(){
		log.trace("getBakeryList() invoked.");
		
		return STORAGE.cafeMenu.get("bakery");
	} // getBakeryList
	
	public static List<Goods> getMDList(){
		log.trace("getMDList() invoked.");
		
		return STORAGE.cafeMenu.get("MD");
	} // getMDList
	
	public static List<Goods> getToppingMenuList(){
		log.trace("getCafeMenu() invoked.");
		
		return STORAGE.cafeMenu.get("topping");
	} // getBeverageMenuList
	
} // end class
