package cafe.order;

import dto.goods.nonbeverage.Topping;
import lombok.Data;
import lombok.NonNull;


@Data
public abstract class Order {

	@NonNull private String name;
	@NonNull private int amount;
	
} // end class
