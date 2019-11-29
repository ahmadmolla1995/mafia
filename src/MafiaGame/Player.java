package MafiaGame;

import java.util.Scanner;

public abstract class Player {
    protected int personID;
    protected Role roll;
    protected boolean awake;
    protected boolean isAlive;

    public Player(int personID, Role roll) {
        this.personID = personID;
        this.roll = roll;
        this.isAlive = true;
        this.awake = true;
    }

    public int getPersonID() {
        return personID;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAliveStatus(boolean status) {
        this.isAlive = status;
    }

    public void printInfo() {
        System.out.print("id: " + personID + '\t');
        System.out.print("role: " + roll + '\t');
        System.out.print("awake: " + awake + '\t');
        System.out.print("isAlive: " + isAlive + '\n');
    }

    public void setAwakeStatus(boolean status) {
        this.awake = status;
    }

    public boolean getAwakeStatus() {
        return this.awake;
    }

    public Role getRoll() {
        return this.roll;
    }
}

class Mafia extends Player {
    public Mafia(int personID, Role role){
        super(personID, role);
    }
}

class GodFather extends Mafia {
    public GodFather(int personID, Role role){
        super(personID, role);
    }

    public SilencePlayerCommand sendSilencePlayerCommand() {
        Scanner scanner = new Scanner(System.in);
        int playerID = scanner.nextInt();

        return new SilencePlayerCommand(playerID);
    }
}

class Natasha extends Mafia {
    public Natasha(int personID, Role role){
        super(personID, role);
    }

    public void silencePlayer(SilencePlayerCommand cmd) {
        
    }
}

class Citizen extends Player {
    public Citizen(int personID, Role role){
        super(personID, role);
    }
}

class Doctor extends Citizen {
    public Doctor(int personID, Role role){
        super(personID, role);
    }
}

class Detective extends Citizen {
    public Detective(int personID, Role role){
        super(personID, role);
    }
}

class Sniper extends Citizen {
    public Sniper(int personID, Role role) {
        super(personID, role);
    }
}

