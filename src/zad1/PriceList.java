package zad1;

import java.util.HashMap;

public class PriceList
{

	public static final PriceList INSTANCE = new PriceList();
	static HashMap<String,Double> priceList = new HashMap<String,Double>();
	
	
	public static PriceList getInstance() { return INSTANCE; }

	public void put(String s, double i) {
		priceList.put(s, i);
	}
	
	public static double getValue(String s){
		return (priceList.containsKey(s) ) ? priceList.get(s) : -1;
	}

	
		
}

