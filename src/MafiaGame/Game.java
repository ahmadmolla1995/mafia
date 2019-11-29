package MafiaGame;

import java.util.*;

public class Game {
    private God god;
    private ArrayList<Citizen> citizens;
    private ArrayList<Mafia> mafias;
    private int selectedPersonIDToKill;
    private Time time;

    public Game() {
        this.god = new God(Role.God);
        this.citizens = new ArrayList<>();
        this.mafias = new ArrayList<>();
        this.time = Time.Night;
    }

    public Time getTime() {
        return this.time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void addCitizen(Citizen citizen) {
        this.citizens.add(citizen);
    }

    public void addMafia(Mafia mafia){
        this.mafias.add(mafia);
    }

    public void display() {
        for(Citizen c: citizens)
            c.printInfo();
        for(Mafia m: mafias)
            m.printInfo();
    }

    public void sleepAllPlayers() {
        for(Citizen citizen: citizens)
            citizen.setAwakeStatus(false);
        for(Mafia mafia: mafias)
            mafia.setAwakeStatus(false);
    }

    public void wakeUpMafias() {
        for(Mafia m: mafias)
            m.setAwakeStatus(true);
    }

    public void selectCitizenToKill() {
        System.out.print("Citizens ID: ");
        for(Citizen c: citizens)
            System.out.print(c.getPersonID() + "\t");
        for(Mafia m: mafias)
            System.out.print(m.getPersonID() + "\t");

        Random rand = new Random();
        System.out.println("\n\nEnter citizen ID to kill!");
        int i = rand.nextInt(citizens.size());
        System.out.println("person id is: " + citizens.get(i).getPersonID());

        this.selectedPersonIDToKill = citizens.get(i).getPersonID();
    }

    public void sleepMafias() {
        for(Mafia m: mafias)
            m.setAwakeStatus(false);
    }

    public void wakeUpPlayer(Role role) {
        for(Citizen c: citizens) {
            if (c.getRoll() == role) {
                c.setAwakeStatus(true);
                return;
            }
        }
    }

    public void selectPersonIDByDoctor() {
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        if(id != selectedPersonIDToKill)
            removePlayer(selectedPersonIDToKill);
    }

    public void removePlayer(int playerID) {
        for(int i = 0; i < citizens.size(); i++) {
            if (citizens.get(i).getPersonID() == playerID) {
                citizens.get(i).setAliveStatus(false);
                citizens.remove(i);
            }
        }
    }
}
