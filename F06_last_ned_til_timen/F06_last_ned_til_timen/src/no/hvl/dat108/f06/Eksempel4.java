package no.hvl.dat108.f06;

public class Eksempel4 {

    public static Runnable lagRunnnable(String input){
        return () -> System.out.println("Hallo " + input);
    }

	public static void main(String[] args) {
		
		//Lage en runnable som sier Hallo
		//Lage og kjøre 2 tråder med denne runnable-en
		//Skulle ønske at de to trådene også skriver ut tråd-id-en.

		Thread t1 = new Thread(lagRunnnable("T1"), "T1");
		Thread t2 = new Thread(lagRunnnable("T2"), "T2");
        t1.start();
        t2.start();

	}
		
}
