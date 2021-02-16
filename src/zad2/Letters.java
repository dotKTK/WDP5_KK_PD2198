package zad2;

import java.util.ArrayList;

public class Letters extends Thread
{
	ArrayList<Thread> threads = new ArrayList<Thread>();

	public Letters(String s)
	{
		for (int i = 0; i < s.length(); i++)
		{
			String litera = s.substring(i, i + 1);

			Runnable myThread = () ->
			{
				while (true)
				{
					try
					{
						System.out.print(litera);
						Thread.sleep(1000);
					} catch (InterruptedException ie)
					{
						break;
					}
				}
			};
			
			threads.add(new Thread(myThread, "Thread " + litera));
			
		}
	}

	public ArrayList<Thread> getThreads()
	{
		return threads;
	}
	
}
