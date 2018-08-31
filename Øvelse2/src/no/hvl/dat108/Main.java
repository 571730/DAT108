package no.hvl.dat108;

public class Main {
    public static void main(String[] args){
        Buffer buffer = new Buffer();
        Consumer cons = new Consumer(buffer);
        Consumer cons2 = new Consumer(buffer);
        Producer prod = new Producer(buffer);
        prod.start();
        cons.start();
        cons2.start();



    }
}
