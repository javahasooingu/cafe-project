package dto.goods;

import lombok.Data;
import lombok.NonNull;
import vo.Seasonsets;


@Data
public abstract class Goods {
	
	@NonNull private String name;
	@NonNull private int price;
	@NonNull private int stock;
	@NonNull private Seasonsets season;

	@NonNull private boolean canOrder;

	public Goods(String name, int price, int stock, Seasonsets season){
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.season = season;
	} // costructor
	
} // end class
