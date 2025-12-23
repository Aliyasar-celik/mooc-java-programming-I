
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("File:");
        String file = scan.nextLine();

        ArrayList<Team> teams = readTeamsAndMatchesFromFile(file);

        System.out.println("Team: ");
        String teamToSearch = scan.nextLine();
        boolean isTeamToSearchFound = false;

        for (Team team : teams) {
            if (teamToSearch.equalsIgnoreCase(team.getTeamName())) {
                System.out.println(team);
                //System.out.println("Games: " + team.getGames());
                isTeamToSearchFound = true;
            }
        }
        scan.close();
        if(!isTeamToSearchFound){

            System.out.println("Games: 0\nWins: 0\nLosses: 0");
        }
    }

    public static ArrayList<Team> readTeamsAndMatchesFromFile(String file) {
        ArrayList<Team> teams = new ArrayList<>();

        try (Scanner filScanner = new Scanner(Paths.get(file))) {
            while (filScanner.hasNextLine()) {
                String line = filScanner.nextLine();

                Team firstTeam;
                Team secondTeam;

                String[] parts = line.split(",");
                String firstTeamName = parts[0];
                String secondTeamName = parts[1];
                int firstTeamScore = Integer.valueOf(parts[2]);
                int secondTeamScore = Integer.valueOf(parts[3]);

                firstTeam = new Team(firstTeamName);
                secondTeam = new Team(secondTeamName);
                boolean wasFirstTeamAddedToList = false;
                boolean wasSecondTeamAddedToList = false;
                for (Team team : teams) {

                    if (team.getTeamName().equals(firstTeamName)) {
                        wasFirstTeamAddedToList = true;
                        if (firstTeamScore > secondTeamScore) {

                            team.incrementWins();
                        } else {
                            team.incrementLosses();
                        }

                    } else if (team.getTeamName().equals(secondTeamName)) {
                        wasSecondTeamAddedToList = true;
                        if (firstTeamScore > secondTeamScore) {

                            team.incrementLosses();
                        } else {
                            team.incrementWins();
                        }

                    }
                }

                if (!wasFirstTeamAddedToList && wasSecondTeamAddedToList) {
                    
                    firstTeam = new Team(firstTeamName);
                    if (firstTeamScore > secondTeamScore) {

                        firstTeam.incrementWins();
                    } else {
                        firstTeam.incrementLosses();
                    }
                    teams.add(firstTeam);

                } else if (wasFirstTeamAddedToList && !wasSecondTeamAddedToList) {

                    secondTeam = new Team(secondTeamName);
                    if (firstTeamScore > secondTeamScore) {

                        secondTeam.incrementLosses();
                    } else {
                        secondTeam.incrementWins();
                    }
                    teams.add(secondTeam);

                } else if (!wasFirstTeamAddedToList && !wasSecondTeamAddedToList) {

                    firstTeam = new Team(firstTeamName);
                    secondTeam = new Team(secondTeamName);

                    if (firstTeamScore > secondTeamScore) {

                        firstTeam.incrementWins();
                        secondTeam.incrementLosses();
                    } else {
                        secondTeam.incrementWins();
                        firstTeam.incrementLosses();
                    }

                    teams.add(firstTeam);
                    teams.add(secondTeam);

                }

            }

        } catch (Exception e) {

            System.out.println("Error while reading the file: " + e);
        }

        return teams;
    }

}
