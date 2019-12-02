package MafiaGame;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        game.addCitizen(new Citizen(1, Role.Citizen));
        game.addCitizen(new Detective(2, Role.Detective));
        game.addMafia(new Mafia(3, Role.Mafia));
        game.addMafia(new GodFather(4, Role.Godfather));
        game.addCitizen(new Doctor(5, Role.Doctor));
        game.addMafia(new Natasha(6, Role.Natasha));
        game.addCitizen(new Sniper(7, Role.Sniper));
        game.addCitizen(new Citizen(8, Role.Citizen));
        game.addCitizen(new Citizen(9, Role.Citizen));
        game.addCitizen(new Citizen(10, Role.Citizen));
        game.addMafia(new Mafia(11, Role.Mafia));

        while((Mafia.getNumOfPlayers() != 0) && (Citizen.getNumOfPlayers() != Mafia.getNumOfPlayers())) {
            System.out.println("Every body should sleep!");
            game.sleepAllPlayers();
            System.out.println("Mafia should wake up!");
            game.wakeUpMafias();
            System.out.println("Select a citizen to kill.");
            game.selectCitizenIDToKill();
            System.out.println("Mafia should sleep right now!");
            game.sleepMafias();
            System.out.println("Sniper! kill one of players!");
            game.killPlayerBySniper();
            System.out.println("Doctor! wake up");
            game.wakeUpPlayer(Role.Doctor);
            System.out.println("Select one person and do your job!");
            game.selectPersonIDByDoctor();
            System.out.println("Detective! wake up!");
            game.wakeUpPlayer(Role.Detective);
            game.InformPlayerRoleToDetective();
            game.setTime(Time.Day);
            System.out.println("Night finished. Now is Day.");
            System.out.println("silence person with ID\n============================");
            game.selectPersonToBeSilencedByNatasha();
            System.out.println("wake up all person!");
            game.wakeUpAllPlayers();
            System.out.println("Start Voting to find suspected and kill!");
            game.startVotingProcess();

            game.displayCitizenInfo();
            game.restartForNextIteration();
        }
    }
}
