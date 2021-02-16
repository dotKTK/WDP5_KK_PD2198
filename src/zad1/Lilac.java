package zad1;

public class Lilac extends Flower
{

	private static final String Nazwa = "bez";
	private static final String Kolor = "biały";

	public Lilac(int i)
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