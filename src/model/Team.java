package model;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String teamName;
    private String homeGround;
    private String captain;
    private String coach;
    private int foundedYear;
    private int titlesWon;

    private int matchesPlayed;
    private int wins;
    private int losses;
    private double nrr;

    private int points;
    private List<Player> players;


    public Team(String teamName, String homeGround, String captain, String coach,
                int foundedYear, int titlesWon, int matchesPlayed, int wins,
                int losses, double nrr) {
        this.teamName = teamName;
        this.homeGround = homeGround;
        this.captain = captain;
        this.coach = coach;
        this.foundedYear = foundedYear;
        this.titlesWon = titlesWon;
        this.matchesPlayed = matchesPlayed;
        this.wins = wins;
        this.losses = losses;
        this.nrr = nrr;
        this.points = wins * 2;

        this.players = new ArrayList<>();
    }


    public void addPlayer(Player player) {
        if (player == null) {
            System.out.println("Cannot add a null player.");
            return;
        }
        players.add(player);
    }


    public void removePlayer(String fullName) {
        boolean removed = players.removeIf(p ->
            p.getFullName().equalsIgnoreCase(fullName));
        if (!removed) {
            System.out.println("Player '" + fullName + "' not found in " + teamName + ".");
        } else {
            System.out.println("Player '" + fullName + "' removed from " + teamName + ".");
        }
    }


    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    public int getSquadSize() {
        return players.size();
    }

    public void displayTeamInfo() {
        System.out.println("============================================");
        System.out.println("Team         : " + teamName);
        System.out.println("Home Ground  : " + homeGround);
        System.out.println("Captain      : " + captain);
        System.out.println("Coach        : " + coach);
        System.out.println("Founded      : " + foundedYear);
        System.out.println("Titles Won   : " + titlesWon);
        System.out.println("--------------------------------------------");
        System.out.println("Matches      : " + matchesPlayed);
        System.out.println("Wins         : " + wins);
        System.out.println("Losses       : " + losses);
        System.out.println("Points       : " + (wins * 2));
        System.out.println("NRR          : " + nrr);
        System.out.println("--------------------------------------------");
        System.out.println("Squad (" + getSquadSize() + " players):");
        if (players.isEmpty()) {
            System.out.println("  No players loaded.");
        } else {
            for (Player p : players) {
                System.out.println("  " + p.toString());
            }
        }
        System.out.println("============================================");
    }

    public void displayPointsTableRow() {
        // INTENTIONAL ISSUE: points calculated inline as wins * 2 again
        System.out.printf("%-25s | MP: %2d | W: %2d | L: %2d | Pts: %2d | NRR: %+.3f%n",
                teamName, matchesPlayed, wins, losses, wins * 2, nrr);
    }


    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public String getHomeGround() { return homeGround; }
    public void setHomeGround(String homeGround) { this.homeGround = homeGround; }

    public String getCaptain() { return captain; }
    public void setCaptain(String captain) { this.captain = captain; }

    public String getCoach() { return coach; }
    public void setCoach(String coach) { this.coach = coach; }

    public int getFoundedYear() { return foundedYear; }
    public void setFoundedYear(int foundedYear) { this.foundedYear = foundedYear; }

    public int getTitlesWon() { return titlesWon; }
    public void setTitlesWon(int titlesWon) { this.titlesWon = titlesWon; }

    public int getMatchesPlayed() { return matchesPlayed; }
    public void setMatchesPlayed(int matchesPlayed) { this.matchesPlayed = matchesPlayed; }

    public int getWins() { return wins; }
    public void setWins(int wins) {
        this.wins = wins;
        this.points = wins * 2;
    }

    public int getLosses() { return losses; }
    public void setLosses(int losses) { this.losses = losses; }

    public double getNrr() { return nrr; }
    public void setNrr(double nrr) { this.nrr = nrr; }

    public int getPoints() { return points; }

    @Override
    public String toString() {
        return teamName + " | Points: " + points + " | NRR: " + nrr;
    }
}