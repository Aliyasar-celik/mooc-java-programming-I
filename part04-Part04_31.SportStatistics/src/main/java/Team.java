public class Team {

    private String teamName;
    private int wins;
    private int losses;
    private int games;

    public Team(String teamName) {

        this.teamName = teamName;
        this.wins = 0;
        this.losses = 0;
        this.games = 0;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getGames(){
        return this.games;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void incrementWins() {
        this.wins += 1;
        this.games += 1;
    }

    public void incrementLosses() {
        this.losses += 1;
        this.games += 1;
    }

    public String toString() {
        return "Games: " + this.games + "\nWins: " + this.wins + "\nLosses: " + this.losses;
    }
}