import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Population populacja = new Population(100); //Enter desired size of the population here; folks shall be generated randomly, along with their preferences
        populacja.findStableMatches();

        System.out.println("List of males:");
        int j = 0;
        for(List<String> female : populacja.malesPref) {
            System.out.println((j+1)+". Male preferences: " + female);
            j++;
        }

        System.out.println("");
        System.out.println("");
        System.out.println("List of females:");
        j = 0;
        for(List<String> male : populacja.femalesPref) {
            System.out.println((j+1)+". Female preferences: " + male);
            j++;
        }

        System.out.println("");
        System.out.println("");
        System.out.println("Result:");

        j = 0;
        for(String male : populacja.femalesPartner){
            System.out.println(populacja.female.get(j) + " matched with " + male);
            j++;
        }
    }
}
