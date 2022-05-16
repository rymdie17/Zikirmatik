package defaultpackage;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Number implements Serializable{
	private int number = 0;
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int a) {
		this.number = a;
	}
}
