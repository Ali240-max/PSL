package model;

public class Bowler extends Player {

    // INTENTIONAL ISSUE: should be double, stored as String
    private String bowlingAverage;
    private String economyRate;
    private int totalT20Wickets;
    private String bestBowling;
    private int matchesPlayed;


    public Bowler(String fullName, String dateOfBirth, String nationality,
                  String teamName, String bowlingAverage, String economyRate,
                  int totalT20Wickets, String bestBowling, int matchesPlayed) {
        super(fullName, dateOfBirth, nationality, "Bowler", teamName);
        this.bowlingAverage = bowlingAverage;
        this.economyRate = economyRate;
        this.totalT20Wickets = totalT20Wickets;
        this.bestBowling = bestBowling;
        this.matchesPlayed = matchesPlayed;
    }


    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Bowling Avg  : " + bowlingAverage);
        System.out.println("Economy Rate : " + economyRate);
        System.out.println("T20 Wickets  : " + totalT20Wickets);
        System.out.println("Best Bowling : " + bestBowling);
        System.out.println("Matches      : " + matchesPlayed);
    }


    public String getBowlingAverage() { return bowlingAverage; }
    public void setBowlingAverage(String bowlingAverage) { this.bowlingAverage = bowlingAverage; }

    public String getEconomyRate() { return economyRate; }
    public void setEconomyRate(String economyRate) { this.economyRate = economyRate; }

    public int getTotalT20Wickets() { return totalT20Wickets; }
    public void setTotalT20Wickets(int totalT20Wickets) { this.totalT20Wickets = totalT20Wickets; }

    public String getBestBowling() { return bestBowling; }
    public void setBestBowling(String bestBowling) { this.bestBowling = bestBowling; }

    public int getMatchesPlayed() { return matchesPlayed; }
    public void setMatchesPlayed(int matchesPlayed) { this.matchesPlayed = matchesPlayed; }


    @Override
    public String toString() {
        return String.format("%-25s | Bowler     | Avg: %-6s | Eco: %-6s | Wickets: %d",
                getFullName(), bowlingAverage, economyRate, totalT20Wickets);
    }
}