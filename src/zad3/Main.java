/**
 *
 *  @author Koszykowski Krzysztof PD2198
 *
 */

package zad3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

	public static ArrayList<Towar> arrayL = new ArrayList<>();
	public static Scanner scan = null;
	public static Towar aktualnyTowar;
	public static Towar poprzedniTowar;
	public static Boolean zasialnie;
	static int licznik;
	static double suma;

	public Main()
	{
		licznik = 0;
		aktualnyTowar = null;
		poprzedniTowar = null;
		zasialnie = false;
		suma = 0.0;
	}

	public static String KatalogWyzej(String path)
	{
		String znak = null;
		if (path.indexOf("\\") != -1)
			znak = "\\";
		if (path.indexOf("/") != -1)
			znak = "/";
		if ((znak != null) && (path.indexOf(znak) != path.lastIndexOf(znak)))
		{
			if (path.substring(path.length() - 1, path.length()).equalsIgnoreCase(znak))
				path = path.substring(0, path.length() - 1);
			path = path.substring(0, path.lastIndexOf(znak) + 1);
		}

		return path;
	}

	public static void main(String[] args)
	{

		Main obiekt = new Main();
		obiekt.wskazPlik();
		obiekt.watkowo();

	}

	public void watkowo()
	{
		Thread watekA = new Thread(new Runnable()
		{
			public void run()
			{
				zasialnie = true;
				while (scan.hasNext())
				{
					czytajPlik();

				}

				// System.out.println("koniec paliwa");
				zasialnie = false;
			}
		});

		Thread watekB = new Thread(new Runnable()
		{
			public void run()
			{

				while (zasialnie)
				{
					sumujWage();

				}
				System.out.printf("suma wynosi %.2f",suma);
			// System.out.println("suma wynosi :" + suma);

			}
		});
		
		
		watekA.start();
		watekB.start();
		
		

		try
		{
			watekA.join();
			watekB.join();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

	}

	public void wskazPlik()

	{
		String fname = KatalogWyzej(System.getProperty("user.dir")) + "Towary.txt";
		// System.out.println(fname);
		try
		{
			scan = new Scanner(new File(fname));
		} catch (FileNotFoundException exc)
		{
			System.out.println("***");
			System.exit(0);
		}

	}

	public synchronized void czytajPlik()
	{

		String zmienna = scan.nextLine();
		String[] tabliczka = zmienna.split(" ");
		Towar KillObject = new Towar(tabliczka[0], Double.valueOf(tabliczka[1]));
		arrayL.add(KillObject);
		aktualnyTowar = KillObject;
		licznik++;
		if ((arrayL.size() != 0) && (arrayL.size() % 200 == 0))
			System.out.println("utworzono " + arrayL.size() + " obiektów");

		try
		{
			notify();
			if (scan.hasNextLine())	wait();

		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void sumujWage()
	{

		if (aktualnyTowar != poprzedniTowar)
		{
			suma += aktualnyTowar.waga;
			if ((licznik != 0) && (licznik % 100 == 0))
				System.out.println("policzono wage " + licznik + " towarów");

			poprzedniTowar = aktualnyTowar;
			
		}

		try
		{

			notify();
			if (zasialnie)
				wait();

		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

	}

}