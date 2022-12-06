package dto.goods.nonbeverage;

import dto.goods.Goods;
import lombok.Data;
import vo.MdNamesets;
import vo.Seasonsets;


@Data
public class Md 
	extends Goods{
	
	public Md(MdNamesets name, int price, int stock, Seasonsets season) {
		super(name.name(), price, stock, season);
	} // constructor

} // end class
