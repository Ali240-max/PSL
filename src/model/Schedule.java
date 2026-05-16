package model;
import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private List<Match> matches;

    public Schedule() {
        this.matches = new ArrayList<>();
    }

    public void addMatch(Match match) {
        if (match == null) {
            System.out.println("Cannot add a null match.");
            return;
        }
        matches.add(match);
    }

    public int getTotalMatches() {
        return matches.size();
    }

    public List<Match> getMatches() {
        return new ArrayList<>(matches);
    }

    public void displayFullSchedule() {
        if (matches.isEmpty()) {
            System.out.println("No matches scheduled.");
            return;
        }
        System.out.println("\n=== PSL 2025 Match Schedule ===");
        System.out.printf("%-10s | %-25s | %-25s | %-12s | %-15s%n",
                "Match", "Team 1", "Team 2", "Date", "Venue");
        System.out.println("-------------------------------" +
                           "-------------------------------" +
                           "------------------------------");
        for (Match match : matches) {
            match.displayMatchSummary();
        }
        System.out.println("Total Matches: " + matches.size());
    }

    public void displayMatchByNumber(String matchNumber) {
        for (Match match : matches) {
            if (match.getMatchNumber().equalsIgnoreCase(matchNumber)) {
                match.displayMatch();
                return;
            }
        }
        System.out.println("Match #" + matchNumber + " not found in schedule.");
    }
}