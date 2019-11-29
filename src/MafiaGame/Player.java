package MafiaGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    public void talk(String message) {
        System.out.println(message);
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
    public Mafia(int personID, Role role) {
        super(personID, role);
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

class Citizen extends Player {
    public Citizen(int personID, Role role) {
        super(personID, role);
    }
}

class Doctor extends Citizen {
    public Doctor(int personID, Role role){
        super(personID, role);
    }
}

class Detective extends Citizen {
    private static Map<Integer, Role> playerIdentities;

    public Detective(int personID, Role role) {
        super(personID, role);
        playerIdentities = new HashMap<>();
    }

    public static void insertItem(int playerID, Role role) {
        playerIdentities.put(playerID, role);
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

