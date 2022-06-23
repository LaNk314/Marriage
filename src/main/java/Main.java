import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Population populacja = new Population(5);
//        for(String man : populacja.man) System.out.print(man +", ");
//        System.out.print("\n");
//        for(String woman : populacja.woman) System.out.print(woman + ", ");
//
//        System.out.print("\n");
//        for(int i = 0; i < populacja.size; i++) {
//            System.out.println((1+i) + ". man preferences: " + populacja.manPref.get(i));
//            System.out.println((1+i) + ". woman preferences: " + populacja.womanPref.get(i));
//        }

        populacja.findStableMatches();
        int j = 0;
        for(List<String> female : populacja.malesPref) {
            System.out.println((j+1)+". Male preferences: " + female);
            j++;
        }
        System.out.println("Female preferences: "+populacja.femalesPref);
        int k = 0;
        for(String male : populacja.femalesPartner){
            System.out.println(populacja.female.get(k) + " matched with " + male);
            k++;
        }



    }
}
