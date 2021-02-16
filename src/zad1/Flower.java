package zad1;

abstract class Flower
{
	abstract String getName();

	abstract String getColor();

	private int amount = 0;

	public Flower(int i)
		{
			amount = i;
		}

	double getValue()
		{
			return (PriceList.getValue(getName()) * getAmount());
		}

	int getAmount()
		{
			return amount;
		}

	
	public String toString()
		{
			return (getName()+", kolor: "+getColor()+", ilość: "+getAmount()+", cena: "+PriceList.getValue(getName())+"\n");		
		}
	
	
}