package no.hvl.dat108;

import java.util.LinkedList;

/**
 * A shared buffer for consumers and producers. The item type is int. The buffer
 * is implemented by using a double ended queue.
 *
 * @author Atle Geitung
 * @version 17.05.2018 C++ version
 * @version 30.08.2018 Java version
 */
public class Buffer {

    private final static int SIZE = 1;
    private LinkedList<Integer> buffer = new LinkedList<Integer>();

    /**
     * Add a new item to the buffer. If the buffer is full, wait.
     *
     * @param item the new item
     */
    public void add(Integer item) {
        while (true) {
            // TODO

            if (buffer.size() == SIZE){
                System.out.println("List is full! waiting..");
                try{
                    wait();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            } else {
                buffer.add(item);
                notify();

                return;
            }
        }
    }

    /**
     * Remove next available item from the buffer. If the buffer is empty, wait.
     *
     * @return next item
     */
    public Integer remove() {
        while (true) {

            if (buffer.isEmpty()){
                System.out.println("List is empty! Waiting..");
                try{
                    wait();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            } else {
                Integer back = buffer.removeFirst();
                notify();
                return back;
            }

        }
    }

}
