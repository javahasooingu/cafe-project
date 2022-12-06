package dto.goods.beverage;

import lombok.Data;
import vo.BeverageNamesets;
import vo.Seasonsets;


@Data
public class NonCaffeine 
	extends Beverage {
	
	public NonCaffeine(BeverageNamesets name, int price, int stock, Seasonsets season) {
		super(name, price, stock, season);
	} // constructor

} // end class
