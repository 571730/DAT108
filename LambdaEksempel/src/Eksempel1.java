import java.util.*;

class AlfabetiskkComparator implements Comparator <String> {

    @Override
    public int compare(String o1, String o2) {

        return o1.toLowerCase().compareTo(o2.toLowerCase());
    }
}

public class Eksempel1 {
    public static void main(String[] args){
        List<String> listen = Arrays.asList("Hallo", "blabla", "knut", "Per");
        Collections.sort(listen);
        System.out.println("Vanlig sort: " + listen);
        Collections.sort(listen, new AlfabetiskkComparator());
        System.out.println("Comparator: " + listen);


        //Anonym klasse
        Collections.sort(listen, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        System.out.println("Etter lengde: " + listen);

        Collections.sort(listen, (o1, o2) -> o1.length() - o2.length());

        System.out.println("Etter lengde: " + listen);

    }
}
