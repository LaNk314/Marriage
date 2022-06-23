import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class Population {

    ArrayList<String> male;
    ArrayList<String> female;
    ArrayList<String> femalesPartner;
    ArrayList<String> unengagedMales;

    List<List<String>> malesPref;
    List<List<String>> femalesPref;
    int size;

    public Population(int size){
        male = new ArrayList<>();
        female = new ArrayList<>();
        malesPref = new ArrayList<>();
        femalesPref = new ArrayList<>();
        femalesPartner = new ArrayList<>();
        unengagedMales = new ArrayList<>();
        this.size = size;
        generatePopulation();
        generatePreferences();
        fillPartnersTableList();
    }

    private void fillPartnersTableList() {
        for(int i = 0; i < size; i++){
            femalesPartner.add("None");
        }
    }

    public void findUnengagedMales(){
//        unengagedMales.addAll(male);
//        unengagedMales.removeIf(male -> femalesPartner.contains(male));
        unengagedMales.addAll(male);
        for(String male : femalesPartner){
            if (!male.equals("None")){
                unengagedMales.remove(male);
            }
        }
    }

    private void generatePreferences() {
        for(int i = 0; i < size; i++){
            femalesPref.add(randomize(male));
            malesPref.add(randomize(female));
        }
    }

    private void generatePopulation() {
        for(int i = 0; i < size; i++){
            male.add("M" + (i+1));
            female.add("F" + (i+1));
        }
    }

    public void findStableMatches(){
//        while(exist male not engaged){
//            for(male : not engaged males) {
//                if male not engaged {
//                    propose till succes
//                }
//            }
//        }
        findUnengagedMales();
        while (femalesPartner.contains("None")){
            for(String male : unengagedMales){
                int hisIndex = male.indexOf(male);
                for(String female : malesPref.get(hisIndex)) {
                    if (propose(male, female)) {
                        break;
                    }

                }
            }
            findUnengagedMales();
            System.out.println("loop");
        }
    }

    public boolean propose(String man, String woman){
        int herIndex = female.indexOf(woman);
        String herFiance = femalesPartner.get(herIndex);
        if(herFiance.equals("None")){
            femalesPartner.set(herIndex, man);
            return true;
        } else if(femalesPref.get(herIndex).indexOf(man) < femalesPref.get(herIndex).indexOf(herFiance)){
            femalesPartner.set(herIndex, man);
            return true;
        }
        else return false;
    }

    private ArrayList<String> randomize(ArrayList<String> list){
        ArrayList<String> result = new ArrayList<>();
        result.addAll(list);
        Collections.shuffle(result);
        return result;
    }
}
