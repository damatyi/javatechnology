package hu.api;

public class Simcard {
	
	private int pin1;
	private int pin2;
	private int puk1;
	private int puk2;
	
	public Simcard() {
		super();
	}
	
	public Simcard(int pin1, int pin2, int puk1, int puk2) {
		super();
		this.pin1 = pin1;
		this.pin2 = pin2;
		this.puk1 = puk1;
		this.puk2 = puk2;
	}

	public int getPin1() {
		return pin1;
	}

	public void setPin1(int pin1) {
		this.pin1 = pin1;
	}

	public int getPin2() {
		return pin2;
	}

	public void setPin2(int pin2) {
		this.pin2 = pin2;
	}

	public int getPuk1() {
		return puk1;
	}

	public void setPuk1(int puk1) {
		this.puk1 = puk1;
	}

	public int getPuk2() {
		return puk2;
	}

	public void setPuk2(int puk2) {
		this.puk2 = puk2;
	}

	@Override
	public String toString() {
		return "simcard [pin1=" + pin1 + ", pin2=" + pin2 + ", puk1=" + puk1 + ", puk2=" + puk2 + "]";
	}
	
	

}
