package MafiaGame;

public abstract class Command {
    public Command() {}
}

class SilencePlayerCommand extends Command {
    private int playerID;
    public SilencePlayerCommand(int playerID) {this.playerID = playerID;}
    public int getPlayerID() {return playerID;}
}

