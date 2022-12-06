package vo;

public enum Seasonsets {

	always(true),
	commingSoon(false),
	now(true),
	past(false);
	
	public boolean canOrder;
	
	private Seasonsets(boolean canOrder) {
		this.canOrder = canOrder;
	} // costructor?
	
} // end enum
