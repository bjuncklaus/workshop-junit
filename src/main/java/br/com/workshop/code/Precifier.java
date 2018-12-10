package br.com.workshop.code;

public class Precifier {
	
	private float value;

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public void giveTenPercentDiscount() {
		value = value *.9f;
	}
	
	

}
