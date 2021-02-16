package zad1;

public class Peony extends Flower {

	private static final String Nazwa = "piwonia";
	private static final String Kolor = "czerwony";
	
	public Peony(int i) {
		super(i);
	}

	 String getName()  { return Nazwa; }
	 String getColor() { return Kolor; }
}