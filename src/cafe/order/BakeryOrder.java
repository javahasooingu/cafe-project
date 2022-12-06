package cafe.order;

import lombok.Data;
import vo.BakeryNamesets;
import vo.BeverageNamesets;

@Data
public class BakeryOrder extends CafeOrder {

	public BakeryOrder(BakeryNamesets name, int amount) {
		super(name.name(), amount);
	} // constructor

} // end class
