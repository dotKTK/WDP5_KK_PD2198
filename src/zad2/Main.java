/**
 *
 *  @author Koszykowski Krzysztof PD2198
 *
 */

package zad2;


public class Main {

  public static void main(String[] args) throws InterruptedException {
    Letters letters = new Letters("ABCD");
    for (Thread t : letters.getThreads()) System.out.println(t.getName());
    /*<- tu uruchomić 
         wszystkie kody w wątkach 
         */
    (letters.getThreads()).forEach((t) -> t.start());

    Thread.sleep(5000);

    /*<- tu trzeba zapisać
       fragment, który kończy działanie kodów, wypisujących litery 
    */
    for (Thread t : letters.getThreads()){t.interrupt();}
        
    System.out.println("\nProgram skończył działanie");
    }

  }
