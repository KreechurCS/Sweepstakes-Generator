package ie.steve.martin;

import java.util.Comparator;

public class Picks {
    String team;
    String person;

    Picks(String team, String person){
        this.team = team;
        this.person = person;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public static Comparator<Picks> personNameComparator = new Comparator<Picks>() {
       public int compare(Picks p1, Picks p2) {
           String personName1 = p1.getPerson().toUpperCase();
           String personName2 = p2.getPerson().toUpperCase();

           return personName1.compareTo(personName2);
       }
    };
}
