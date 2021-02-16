package zad1;

public class Freesia extends Flower
{

	private static final String Nazwa = "frezja";
	private static final String Kolor = "żółty";

	public Freesia(int i)
	{
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
