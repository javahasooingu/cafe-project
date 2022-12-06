package dto.goods.beverage;

import dto.goods.Goods;
import lombok.Data;
import vo.BeverageNamesets;
import vo.Seasonsets;


@Data
public class Beverage 
	extends Goods {
	
	public Beverage(BeverageNamesets name , int price, int stock, Seasonsets season) {
		super(name.name(), price, stock, season);
		
	} // constructor
	
} // end class
