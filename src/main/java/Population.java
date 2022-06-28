import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Population {

    ArrayList<String> male;
    ArrayList<String> female;
    ArrayList<String> femalesPartner;
    List<List<String>> malesPref;
    List<List<String>> femalesPref;
    int size;

    public Population(int size){
        male = new ArrayList<>();
        female = new ArrayList<>();
        malesPref = new ArrayList<>();
        femalesPref = new ArrayList<>();
        femalesPartner = new ArrayList<>();
        this.size = size;
        generatePopulation();
        generatePreferences();
        fillPartnersTableList();
    }

    //Population setup methods
    private void generatePopulation() {
        for(int i = 0; i < size; i++){
            male.add("M" + (i+1));
            female.add("F" + (i+1));
        }
    }
    private void generatePreferences() {
        for(int i = 0; i < size; i++){
            femalesPref.add(randomize(male));
            malesPref.add(randomize(female));
        }
    }
    private void fillPartnersTableList() {
        for(int i = 0; i < size; i++){
            femalesPartner.add("None");
        }
    }
    private ArrayList<String> randomize(ArrayList<String> list){
        ArrayList<String> result = new ArrayList<>();
        result.addAll(list);
        Collections.shuffle(result);
        return result;
    }
    //End of population setup methods


    public void findStableMatches(){
        while(femalesPartner.contains("None")) {
            for (String man : male) {
                if (!femalesPartner.contains(man)) {
                    findWife(man);
                }
            }
        }
    }
    private void findWife(String man){
        int hisIndex = male.indexOf(man);

        for(String woman : malesPref.get(hisIndex)){
            int herIndex = female.indexOf(woman);
            if(propose(man, woman)) {
                femalesPartner.set(herIndex, man);
                break;
            }
        }
    }
    private boolean propose(String man, String woman){
        int herIndex = female.indexOf(woman);

        if(!femalesPartner.get(herIndex).equals("None")){
            String herFiance = femalesPartner.get(herIndex);
            int fiancesPositionInHerPreferences = femalesPref.get(herIndex).indexOf(herFiance);
            return femalesPref.get(herIndex).indexOf(man) < fiancesPositionInHerPreferences;
        } else {
            return true;
        }
    }








}
