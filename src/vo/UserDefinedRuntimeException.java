package vo;

public class UserDefinedRuntimeException 
	extends RuntimeException {

	public UserDefinedRuntimeException() {
		super();
	} // default constructor
	
	public UserDefinedRuntimeException(String message) {
		super(message);
	} // constructor
	
} // end class
