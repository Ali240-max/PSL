package service;
import model.*;
import java.util.*;

public class SearchService {

    private PSLSystem pslSystem;

    public SearchService(PSLSystem pslSystem) {
        this.pslSystem = pslSystem;
    }

    public void searchPlayer(String playerName) {
        if (playerName == null || playerName.trim().isEmpty()) {
            System.out.println("Please enter a valid player name.");
            return;
        }

        boolean found = false;
        System.out.println("\n=== Search Results for Player: \"" + playerName + "\" ===");

        for (Team team : pslSystem.getTeams()) {
            for (Player player : team.getPlayers()) {
                if (player.getFullName().toLowerCase().contains(playerName.toLowerCase())) {
                    System.out.println("\nFound in team: " + team.getTeamName());
                    player.displayInfo();
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No player found with name: \"" + playerName + "\"");
        }
    }

    public void searchTeam(String teamName) {
        if (teamName == null || teamName.trim().isEmpty()) {
            System.out.println("Please enter a valid team name.");
            return;
        }

        boolean found = false;
        System.out.println("\n=== Search Results for Team: \"" + teamName + "\" ===");

        for (Team team : pslSystem.getTeams()) {
            if (team.getTeamName().toLowerCase().contains(teamName.toLowerCase())) {
                team.displayTeamInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No team found with name: \"" + teamName + "\"");
        }
    }
}