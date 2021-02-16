package zad1;

import java.util.ArrayList;

public class Customer
{

	String imie = "";
	Double portwel = 0.0;
	private ShoppingCart shoppingCart;

	public Customer(String s, int i)
	{
		imie = s;
		portwel = Double.valueOf(i);
		shoppingCart = new ShoppingCart(this);

	}

	public void pay()
	{
		portwel -= shoppingCart.getStorageValue(true);

	}

	public ShoppingCart getShoppingCart()
	{
		return shoppingCart;
	}

	public void get(Flower flower)
	{
		shoppingCart.put(flower);
	}

	public Double getCash()
	{

		return portwel;
	}

	public void pack(Box box)
	{
		for (Flower f : new ArrayList<Flower>(this.getShoppingCart()))
		{
			box.put(f);
			this.getShoppingCart().remove(f);
		}
	}

	public String toString()
	{
		return imie;
	}

}
