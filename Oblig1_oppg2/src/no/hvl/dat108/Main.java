package no.hvl.dat108;

public class Main {
    /**
     * Starter opp noen konsumere og producere og setter dem i gang
     * @param args ikke i bruk
     */
    public static void main(String[] args){
        Buffer buffer = new Buffer();
        Consumer cons = new Consumer(buffer);
        Consumer cons2 = new Consumer(buffer);
        Producer prod = new Producer(buffer);
        prod.start();
        cons.start();
        cons2.start();

        // Svar oppgave d)
        // println() burde vaere synkronisert ja, saa ikke forskjellige traader prover aa printe ut samtidig


    }
}
