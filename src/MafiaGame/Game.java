package MafiaGame;

import java.util.*;

public class Game {
    private ArrayList<Citizen> citizens;
    private ArrayList<Mafia> mafias;
    private int selectedPersonIDToKill;
    private Time time;

    public Game() {
        this.citizens = new ArrayList<>();
        this.mafias = new ArrayList<>();
        this.time = Time.Night;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void addCitizen(Citizen citizen) {
        this.citizens.add(citizen);
    }

    public void addMafia(Mafia mafia) {
        this.mafias.add(mafia);
    }

    public void displayCitizenInfo() {
        for (Citizen c: citizens)
            c.printInfo();
    }

    public void sleepAllPlayers() {
        for (Citizen citizen : citizens)
            citizen.setAwakeStatus(false);
        for (Mafia mafia : mafias)
            mafia.setAwakeStatus(false);
    }

    public void wakeUpMafias() {
        for (Mafia m : mafias)
            m.setAwakeStatus(true);
    }

    public void selectCitizenIDToKill() {
        displayCitizenInfo();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Citizen ID:");
        this.selectedPersonIDToKill = scanner.nextInt();
    }

    public void sleepMafias() {
        for (Mafia m : mafias)
            m.setAwakeStatus(false);
    }

    public void wakeUpPlayer(Role role) {
        for (Citizen c : citizens) {
            if (c.getRoll() == role) {
                c.setAwakeStatus(true);
                return;
            }
        }
    }

    public void selectPersonIDByDoctor() {
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        if (id != selectedPersonIDToKill) {
            removePlayer(selectedPersonIDToKill);
            System.out.printf("Player with ID %d removed.\n", selectedPersonIDToKill);
        }
    }

    private void removePlayer(int playerID) {
        for (int i = 0; i < citizens.size(); i++) {
            if (citizens.get(i).getPersonID() == playerID) {
                citizens.get(i).setAliveStatus(false);
                citizens.remove(i);
                Citizen.decreaseNumberOfPlayers();
                return;
            }
        }

        for (int i = 0; i < mafias.size(); i++) {
            if (mafias.get(i).getPersonID() == playerID) {
                mafias.get(i).setAliveStatus(false);
                mafias.remove(i);
                Mafia.decreaseNumberOfPlayers();
                return;
            }
        }
    }

    private Player getPlayerByID(int playerID) {
        for (Citizen c : citizens)
            if (c.getPersonID() == playerID)
                return c;
        for (Mafia m : mafias)
            if (m.getPersonID() == playerID)
                return m;
        return null;
    }

    public void selectPersonToBeSilencedByNatasha() {
        for (Mafia m : mafias) {
            if (m.getRoll() == Role.Natasha) {
                Scanner scanner = new Scanner(System.in);
                Player player = getPlayerByID(scanner.nextInt());

                if (player != null)
                    Natasha.silencePlayer(player);
            }
        }
    }

    public void wakeUpAllPlayers() {
        for (Citizen c : citizens)
            c.setAwakeStatus(true);
        for (Mafia m : mafias)
            m.setAwakeStatus(true);
    }

    public void startVotingProcess() {
        List<Integer> polls = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        for (Citizen c : citizens) {
            if (c.canTalk) {
                Detective.hintToCitizenAboutMafia();
                System.out.print("Suspected PersonID:");
                polls.add(scanner.nextInt());
            }
        }

        for (Mafia m : mafias) {
            if (m.canTalk) {
                System.out.print("Suspected PersonID:");
                polls.add(scanner.nextInt());
            }
        }

        removePlayer(maxRepeatedElement(polls));
    }

    public void restartForNextIteration() {
        for (Citizen c : citizens)
            c.setTalkAbleStatus(true);
        for (Mafia m : mafias)
            m.setTalkAbleStatus(true);
    }

    private int maxRepeatedElement(List<Integer> polls) {
        System.out.println("remove element");

        int repeat = 0;
        int maxRepetition = 0;
        int maxRepeatedElement = 0;

        for (int i = 0; i < polls.size(); i++) {
            for (int j = i; j < polls.size(); j++)
                if (polls.get(i).equals(polls.get(j)))
                    repeat++;
            if (repeat > maxRepetition) {
                maxRepetition = repeat;
                maxRepeatedElement = polls.get(i);
                repeat = 0;
            }
        }

        return maxRepeatedElement;
    }


    public void killPlayerBySniper() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which player should I kill? ");

        int playerID = scanner.nextInt();
        Player player = getPlayerByID(playerID);

        if (player != null) {
            Sniper.kill(player);
            removePlayer(playerID);
        }
    }

    public void InformPlayerRoleToDetective() {
        System.out.print("Inform me Role of player ID: ");
        Scanner scanner = new Scanner(System.in);
        int playerID = scanner.nextInt();

        Player player = getPlayerByID(playerID);
        if (player != null)
            Detective.insertItem(playerID, player.getRoll());
    }
}
