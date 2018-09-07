package no.hvl.dat108.f06;

public class Eksempel4 {

    public static Runnable lagRunnnable(String input){
        return () -> System.out.println("Hallo " + input);
    }

	public static void main(String[] args) {
		
		//Lage en runnable som sier Hallo
		//Lage og kj�re 2 tr�der med denne runnable-en
		//Skulle �nske at de to tr�dene ogs� skriver ut tr�d-id-en.

		Thread t1 = new Thread(lagRunnnable("T1"), "T1");
		Thread t2 = new Thread(lagRunnnable("T2"), "T2");
        t1.start();
        t2.start();

	}
		
}
