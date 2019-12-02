package MafiaGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Player {
    protected int personID;
    protected Role roll;
    protected boolean awake;
    protected boolean alive;
    protected boolean canTalk;

    public Player(int personID, Role roll) {
        this.personID = personID;
        this.roll = roll;
        this.alive = true;
        this.awake = true;
        this.canTalk = true;
    }

    public Role getRoll() {
        return this.roll;
    }

    public int getPersonID() {
        return personID;
    }

    public void setAliveStatus(boolean status) {
        this.alive = status;
    }

    public void setAwakeStatus(boolean status) {
        this.awake = status;
    }

    public void setTalkAbleStatus(boolean status) {
        this.canTalk = status;
    }

    public void printInfo() {
        System.out.print("id: " + personID + '\t');
        System.out.print("role: " + roll + '\t');
        System.out.print("awake: " + awake + '\t');
        System.out.print("can talk: " + canTalk + '\t');
        System.out.print("isAlive: " + alive + '\n');
    }
}

class Mafia extends Player {
    private static int numOfPlayers = 0;
    protected static ArrayList<Integer> mafiaPersonIDs = new ArrayList<>();

    public Mafia(int personID, Role role) {
        super(personID, role);
        mafiaPersonIDs.add(personID);
        numOfPlayers++;
    }

    public static int getNumOfPlayers() {
        return numOfPlayers;
    }

    public static void decreaseNumberOfPlayers() {
        numOfPlayers --;
    }
}

class Citizen extends Player {
    private static int numOfPlayers = 0;

    public Citizen(int personID, Role role) {
        super(personID, role);
        numOfPlayers ++;
    }

    public static int getNumOfPlayers() {
        return numOfPlayers;
    }

    public static void decreaseNumberOfPlayers() {
        numOfPlayers --;
    }
}

class GodFather extends Mafia {
    public GodFather(int personID, Role role) {
        super(personID, role);
    }
}

class Natasha extends Mafia {
    public Natasha(int personID, Role role) {
        super(personID, role);
    }

    public static void silencePlayer(Player player) {
        player.setTalkAbleStatus(false);
    }
}

class Doctor extends Citizen {
    public Doctor(int personID, Role role) {
        super(personID, role);
    }
}

class Detective extends Citizen {
    private static Map<Integer, Role> playerIdentity = new HashMap<>();

    public Detective(int personID, Role role) {
        super(personID, role);
    }

    public static void insertItem(int playerID, Role role) {
        playerIdentity.put(playerID, role);
    }

    public static void hintToCitizenAboutMafia() {
        System.out.printf("PlayerID %d is %s\n", playerIdentity.entrySet().iterator().next().getKey(),
                                                 playerIdentity.entrySet().iterator().next().getValue());
    }
}

class Sniper extends Citizen {
    public Sniper(int personID, Role role) {
        super(personID, role);
    }

    public static void kill(Player player) {
        player.setAliveStatus(false);
    }
}

