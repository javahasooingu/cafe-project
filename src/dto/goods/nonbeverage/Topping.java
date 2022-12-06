package dto.goods.nonbeverage;

import dto.goods.Goods;
import vo.Seasonsets;
import vo.ToppingNamesets;

public class Topping extends Goods {

	public Topping(ToppingNamesets name, int price, int stock, Seasonsets season) {
		super(name.name(), price, stock, season);
	} // Topping

}
