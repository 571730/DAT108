import java.util.function.Function;

public class Oppg3 {

    public static Function<Integer, Integer> okMedProsent(int prosent){
        return x ->   ((x * prosent/100) + x);
    }

    public static void main(String[] args){
        Ansatt ansatt1 = new Ansatt("Mikkel", "Birkeland", 'm', "Leder", 500000);
        Ansatt ansatt2 = new Ansatt("Hans", "Nilsen", 'm', "Vask", 400000);
        Ansatt ansatt3 = new Ansatt("Per", "Hansen", 'm', "Vask", 200000);

        Function<Integer, Integer> fn = x -> {
            if (x < 300000){
                return x + 100000;
            } else {
                System.out.println(ansatt3.getFornavn() + " tjener for mye til aa oke aarslonn!");
                return x;
            }
        };

        System.out.println(ansatt1.getFornavn() + " har nå " + ansatt1.getAarslonn() + " i aarslonn.");
        ansatt1.endreLonn(x -> x + 500000);
        System.out.println(ansatt1.getFornavn() + " har nå " + ansatt1.getAarslonn() + " i aarslonn.");

        System.out.println(ansatt2.getFornavn() + " har nå " + ansatt2.getAarslonn() + " i aarslonn.");
        ansatt2.endreLonn(okMedProsent(25));
        System.out.println(ansatt2.getFornavn() + " har nå " + ansatt2.getAarslonn() + " i aarslonn.");

        System.out.println(ansatt3.getFornavn() + " har nå " + ansatt3.getAarslonn() + " i aarslonn.");
        ansatt3.endreLonn(fn);
        System.out.println(ansatt3.getFornavn() + " har nå " + ansatt3.getAarslonn() + " i aarslonn.");

        ansatt3.endreLonn(fn);
        System.out.println(ansatt3.getFornavn() + " har nå " + ansatt3.getAarslonn() + " i aarslonn.");
    }
}
