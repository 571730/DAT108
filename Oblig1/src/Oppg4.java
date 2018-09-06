import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Oppg4 {

    public static void main(String[] args) {
//        Ansatt ansatt1 = new Ansatt("Ola", "Nordmann", 'm', "sjef", 400000);
//        Ansatt ansatt2 = new Ansatt("Hans", "Hansen", 'm', "arbeider", 300000);
//        Ansatt ansatt3 = new Ansatt("Kari", "Simonsen", 'k', "arbeider", 300000);
//        Ansatt ansatt4 = new Ansatt("Lise", "Olsen", 'k', "arbeider", 350000);
//        Ansatt ansatt5 = new Ansatt("Lotte", "Fransen", 'k', "sjef", 500000);
//        Ansatt ansatt6 = new Ansatt("Kari", "Kronstad", 'k', "arbeider", 340000);

        List<Ansatt> ansattListe = Arrays.asList(
                new Ansatt("Ola", "Nordmann", 'm', "sjef", 400000),
                new Ansatt("Hans", "Hansen", 'm', "arbeider", 300000),
                new Ansatt("Kari", "Simonsen", 'k', "arbeider", 300000),
                new Ansatt("Lise", "Olsen", 'k', "arbeider", 350000),
                new Ansatt("Lotte", "Fransen", 'k', "sjef", 500000),
                new Ansatt("Kari", "Kronstad", 'k', "arbeider", 340000)
        );
//        ansattListe.add(ansatt1);
//        ansattListe.add(ansatt2);
//        ansattListe.add(ansatt3);
//        ansattListe.add(ansatt4);
//        ansattListe.add(ansatt5);
//        ansattListe.add(ansatt6);

        // ---- oppgave a) ----

        List<String> resultatA = ansattListe.stream().map(x -> x.getEtternavn()).collect(toList());
        System.out.println(resultatA);

        // ---- oppgave b) ----

        int resultatB = (int) ansattListe.stream().filter(x -> x.getKjonn() == 'k').count();
        System.out.println("Det er " + resultatB + " kvinner");

        // ---- oppgave c) ----

        double resultatC = ansattListe.stream().filter(x -> x.getKjonn() == 'k').collect(Collectors.averagingInt(x -> x.getAarslonn()));
        System.out.println("Snittlonn for kvinnene er " + resultatC + "kr");

        // ---- oppgave d) ----

        for (Ansatt a : ansattListe){
            if (a.getStilling().equals("sjef")){
                System.out.println(a.getFornavn() + " sin lonn er " + a.getAarslonn());
            }
        }
        ansattListe.stream().filter(x -> x.getStilling().equals("sjef"))
                .forEach(sjef -> sjef.endreLonn(Oppg3.okMedProsent(7)));

        for (Ansatt a : ansattListe){
            if (a.getStilling().equals("sjef")){
                System.out.println(a.getFornavn() + " sin lonn er " + a.getAarslonn()
                        + " etter forhoyning med 7 prosent");
            }
        }

        // ---- oppgave e) ----

        boolean oppgaveE = ansattListe.stream().anyMatch(x -> x.getAarslonn() > 800000);
        System.out.println("Det er noen som tjener over 800 000kr: " + oppgaveE);

        // ---- oppgave f) ----

        ansattListe.stream().forEach(ansatt -> System.out.println(ansatt.toString()));

        // ---- oppgave g) ----

        int minLonn = ansattListe.stream().min(Comparator.comparing(Ansatt::getAarslonn)).get().getAarslonn();
        List<Ansatt> listeLavestLonn = ansattListe.stream().filter(x -> x.getAarslonn() == minLonn).collect(toList());

        System.out.println("De med lavest lonn er:");
        listeLavestLonn.forEach(ansatt -> System.out.println(ansatt.toString()));

        // ---- oppgave h) ----
        int sum = IntStream.range(1, 1000).filter(x -> x % 3 == 0 || x % 5 == 0).sum();
        System.out.println("Summen av tall 1-1000 som er delelig med 3 eller 5: " + sum);


    }

}
