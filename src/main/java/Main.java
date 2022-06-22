public class Main {

    public static void main(String[] args) {
        Population populacja = new Population(25);
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
        for(String male : populacja.male){
            System.out.print(male + ", ");
        }





    }
}
