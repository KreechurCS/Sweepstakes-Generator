package ie.steve.martin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateSweepstake {
    List<String> team = new ArrayList<String>();
    List<String> peeps = new ArrayList<String>();
    List<String> copy = new ArrayList<String>();
    ArrayList<Picks> allPicks = new ArrayList<Picks>();

    GenerateSweepstake(List<String> team, List<String> peeps, List<String> copy) {
        this.team = team;
        this.peeps = peeps;
        this.copy = copy;
    }

    public ArrayList<Picks> generatePicks() {
        while(team.size() > 0 && peeps.size() > 0){
            Picks pic = new Picks(selectTeam(), selectPerson());
            //System.out.println(pic.getPerson() + "\t" + pic.getTeam());
            allPicks.add(pic);
            if (peeps.size() == 0)
            {
                    peeps = new ArrayList<String>(copy);
            }
        }
        Collections.sort(allPicks, Picks.personNameComparator);
        return allPicks;
    }


    public String selectTeam()
    {
        int r = (int)(Math.random() * team.size());
        String selectedTeam = team.get(r);
        team.remove(r);
        return selectedTeam;
    }

    public String selectPerson()
    {
        int r = (int)(Math.random() * peeps.size());
        String selectedPerson = peeps.get(r);
        peeps.remove(r);
        return selectedPerson;
    }
}
