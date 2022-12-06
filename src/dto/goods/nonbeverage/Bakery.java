package dto.goods.nonbeverage;

import dto.goods.Goods;
import lombok.Data;
import vo.BakeryNamesets;
import vo.Seasonsets;


@Data
public class Bakery 
	extends Goods{
	
	public Bakery( BakeryNamesets name, int price, int stock, Seasonsets season) {
		super(name.name(), price, stock, season);
	} // constructor
	
} // end class
