import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Graf graf = new Graf(7);
        graf.leggTilKant(0, 1, 4);
        graf.leggTilKant(0, 2, 2);
        graf.leggTilKant(1, 2, 1);
        graf.leggTilKant(0, 3, 1);
        graf.leggTilKant(1, 4, 1);
        graf.leggTilKant(4, 5, 1);
        graf.leggTilKant(0, 6, 1);

        graf.visNoder();
        graf.visKanter();

        //graf.fjernNode(new Node(0));
        //graf.visNoder();
        //graf.visKanter();
        Node nodeNull = graf.hentNodeNummer(0);
        graf.breddeForst(nodeNull);
        System.out.println();
        ArrayList<Kant> mst = graf.mst();
        for (Kant k : mst){
            System.out.println(k);
        }

        // Ny MST test

        Graf mstGraf = new Graf(5);
        mstGraf.leggTilKant(0, 1, 10);
        mstGraf.leggTilKant(0, 2, 7);
        mstGraf.leggTilKant(0, 3, 1);
        mstGraf.leggTilKant(1, 3, 4);
        mstGraf.leggTilKant(2, 4, 1);
        mstGraf.leggTilKant(3, 2, 3);
        mstGraf.leggTilKant(3, 4, 12);

        System.out.println("Test MST:");
        List<Kant> mstTest = mstGraf.mst();
        mstTest.forEach(System.out::println);

    }
}
