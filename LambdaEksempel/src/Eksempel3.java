interface Betingelse2{
    boolean erSant(String streng);
}

public class Eksempel3 {

    public static Betingelse2 starterMed(char c){
        return x -> x.charAt(0) == c;
    }

    public static Betingelse2 mindreEnn(int tall){
        return x -> x.length() < tall;
    }

    public static void main(String[] args){
        String streng = "Test";
        String streng2 = "Begynner på B";
        betingetUtskrift(streng, x -> x.length()<10);
        betingetUtskrift(streng2, starterMed('B'));

    }

    private static void betingetUtskrift(String streng, Betingelse2 betingelse){
        if (betingelse.erSant(streng)){
            System.out.println(streng);
        }
    }
}
