package zad1;

public class Rose extends Flower
{
	private static final String Nazwa = "róża";
	private static final String Kolor = "czerwony";
	
	public Rose(int i) {
		super(i);
	}

	String getName() 
		{
		return Nazwa;
		}
	
	String getColor()
		{
		return Kolor; 
		}	
}