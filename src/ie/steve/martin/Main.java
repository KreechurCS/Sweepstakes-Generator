package ie.steve.martin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<String> teams = new ArrayList<String>();
        List<String> people = new ArrayList<String>();
        List<String> peopleCopy = new ArrayList<String>();
        ArrayList<Picks> generatedPicks = new ArrayList<Picks>();
        int optionPicked = 0;
        GenerateSweepstake test = new GenerateSweepstake(teams, people, peopleCopy);

	    try {
	        File teamsFile = new File("data/teams.txt");
	        File peopleFile = new File("data/people.txt");
            FileReader fileReader = new FileReader(teamsFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while((line = bufferedReader.readLine()) != null) {
                teams.add(line);
            }
            fileReader.close();

            fileReader = new FileReader(peopleFile);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                people.add(line);
                peopleCopy.add(line);
            }
        }
        catch (Exception e) {
	        System.out.println(e);
        }


        while (optionPicked != 3) {

            // MENU
            System.out.println("#############################################");
            System.out.println("#Sweepstake Generator v1.0.1 by Steve Martin#");
            System.out.println("#           __  __ ___ _  _ _   _           #");
            System.out.println("#          |  \\/  | __| \\| | | | |          #");
            System.out.println("#          | |\\/| | _|| .` | |_| |          #");
            System.out.println("#          |_|  |_|___|_|\\_|\\___/           #");
            System.out.println("#                                           #");
            System.out.println("#        1. Generate Sweepstake             #");
            System.out.println("#        2. Output Sweepstake to file       #");
            System.out.println("#        3. Exit                            #");
            System.out.println("#############################################");


            try {
                Scanner sc = new Scanner(System.in);
                optionPicked = sc.nextInt();

            }
            catch (Exception e) {
                System.out.println("Please Enter Valid Input");
            }
            switch (optionPicked) {
                case 1:
                    System.out.println("Random Picks have been Generated");
                    generatedPicks = test.generatePicks();
                    break;

                case 2:
                    System.out.println("Writing to file");
                    try {
                        PrintWriter writer = new PrintWriter("data/output.txt", "UTF-8");
                        System.out.println("Total number of picks  " + generatedPicks.size());
                        for (Picks p : generatedPicks){
                            writer.println(p.getPerson() + "\t" + p.getTeam());
                        }
                        writer.close();
                    }
                    catch (IOException e){
                        System.out.println("Unable to Write to file");
                        System.out.println(e);
                    }
                    break;

                case 3:
                    System.out.println("Good Luck!");
                    System.exit(1);
                    break;
            }
        }
    }
}
