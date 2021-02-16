package zad1;

import java.util.ArrayList;


abstract class Koszyk extends ArrayList<Flower> {

		Customer wlasciciel = null;
	
	public Koszyk(Customer customer) {
		wlasciciel = customer;
	}
	
	public void remove(Flower kwiatek) { this.remove((Object) kwiatek); }
	public void put(Flower kwiatek)    { this.add(kwiatek);}
	
	public Customer getwłasciciel(){ return wlasciciel; }
	public double getStorageValue(boolean checkoutFlag){
		
		double wartoscZamowienia = 0;
		double wartoscOstatniegoProduktu = 0;
		
		for(Flower kwiatek: new ArrayList<Flower>(this) )
		{	
			if(kwiatek.getValue() > 0 ) wartoscZamowienia +=kwiatek.getValue();
			
			
			if(checkoutFlag)
			{
				if(kwiatek.getValue() <= 0)
				{
				  this.remove(kwiatek);
				}
			
				
				if( wartoscZamowienia > wlasciciel.getCash() )
				{
					
					wartoscOstatniegoProduktu =kwiatek.getValue();
					wartoscZamowienia -=kwiatek.getValue();
					this.remove(kwiatek);
				}
			}	
		}
		return  wartoscZamowienia;
	}


	public String toString() {
		
		StringBuffer buffer = new StringBuffer();
		
		if (this instanceof ShoppingCart) {
			buffer.append("Wózek");
		}
		else
			buffer.append("Pudełko");
		
		buffer.append(" właściciel ").append(wlasciciel);
		if( this.size() > 0 )
		{
			buffer.append("\n");
			for(Flower kwiatek : this)
				buffer.append(kwiatek);
		}
		else buffer.append(" -- pusto");

		return buffer.toString();
	}

	
	
}