import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Betingelse{
    boolean erSant(int tall);
}

class PartallBetingelse implements Betingelse{
    @Override
    public boolean erSant(int tall) {
        return tall % 2 == 0;
    }
}

public class Eksempel2 {

    public static Betingelse storreEnnGrense(int grense){
        return x -> x > grense;
    }


    public static void main(String[] args){
        List<Integer> listen = Arrays.asList(-4, 9, 2, 7, 6, 0);

        List<Integer> filtrertListe = filter(listen, new PartallBetingelse());
        System.out.println(filtrertListe);

        List<Integer> filtrertListe2 = filter(listen, storreEnnGrense(5));
        System.out.println(filtrertListe2);
    }

    private static List<Integer> filter(List<Integer> liste, Betingelse betingelse){
            List<Integer> nyListe = new ArrayList<>();
            for(int tall : liste){
                if (betingelse.erSant(tall)){
                    nyListe.add(tall);
                }
            }
        return nyListe;
    }
}
