package MafiaGame;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        System.out.println("salaam");
        game.addCitizen(new Citizen(1, Role.Citizen));
        game.addCitizen(new Detective(2, Role.Detective));
        game.addMafia(new Mafia(3, Role.Mafia));
        game.addMafia(new GodFather(4, Role.Godfather));
        game.addCitizen(new Doctor(5, Role.Doctor));
        game.addMafia(new Natasha(6, Role.Natasha));

        System.out.println("Every body should sleep!");
        game.sleepAllPlayers();
        System.out.println("Every mafia! wake up!");
        game.wakeUpMafias();

        System.out.println("Select a citizen to kill!");
        game.selectCitizenToKill();

        System.out.println("Every body who is mafia should sleep right now!");
        game.sleepMafias();

        System.out.println("Doctor! wake up");
        game.wakeUpPlayer(Role.Doctor);

        System.out.println("Select one person and do your job!");
        game.selectPersonIDByDoctor();

        game.setTime(Time.Day);
    }
}
