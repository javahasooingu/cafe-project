package cafe.order;

import lombok.Data;
import vo.MdNamesets;


@Data
public class MdOrder extends CafeOrder {

	public MdOrder(MdNamesets name, int amount) {
		super(name.name(), amount);
	} // constructor

} // end class
