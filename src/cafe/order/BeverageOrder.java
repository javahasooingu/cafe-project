package cafe.order;

import dto.goods.nonbeverage.Topping;
import lombok.Data;
import vo.BeverageNamesets;


@Data
public class BeverageOrder extends CafeOrder {
	
	private Topping topping;

	public BeverageOrder(BeverageNamesets name, int amount, Topping topping) {
		super(name.name(), amount);

		this.topping = topping;
	} // constructor

} // end class
