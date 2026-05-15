package model;

public class AllRounder extends Player {
    private String battingAverage;
    private String strikeRate;
    private String bowlingAverage;
    private String economyRate;
    private int totalT20Runs;
    private int totalT20Wickets;
    private String highestScore;
    private String bestBowling;
    private int matchesPlayed;


    public AllRounder(String fullName, String dateOfBirth, String nationality,
                      String teamName, String battingAverage, String strikeRate,
                      String bowlingAverage, String economyRate, int totalT20Runs,
                      int totalT20Wickets, String highestScore, String bestBowling,
                      int matchesPlayed) {
        super(fullName, dateOfBirth, nationality, "All-Rounder", teamName);
        this.battingAverage = battingAverage;
        this.strikeRate = strikeRate;
        this.bowlingAverage = bowlingAverage;
        this.economyRate = economyRate;
        this.totalT20Runs = totalT20Runs;
        this.totalT20Wickets = totalT20Wickets;
        this.highestScore = highestScore;
        this.bestBowling = bestBowling;
        this.matchesPlayed = matchesPlayed;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("--- Batting ---");
        System.out.println("Batting Avg  : " + battingAverage);
        System.out.println("Strike Rate  : " + strikeRate);
        System.out.println("T20 Runs     : " + totalT20Runs);
        System.out.println("Highest Score: " + highestScore);
        System.out.println("--- Bowling ---");
        System.out.println("Bowling Avg  : " + bowlingAverage);
        System.out.println("Economy Rate : " + economyRate);
        System.out.println("T20 Wickets  : " + totalT20Wickets);
        System.out.println("Best Bowling : " + bestBowling);
        System.out.println("Matches      : " + matchesPlayed);
    }


    public String getBattingAverage() { return battingAverage; }
    public void setBattingAverage(String battingAverage) { this.battingAverage = battingAverage; }

    public String getStrikeRate() { return strikeRate; }
    public void setStrikeRate(String strikeRate) { this.strikeRate = strikeRate; }

    public String getBowlingAverage() { return bowlingAverage; }
    public void setBowlingAverage(String bowlingAverage) { this.bowlingAverage = bowlingAverage; }

    public String getEconomyRate() { return economyRate; }
    public void setEconomyRate(String economyRate) { this.economyRate = economyRate; }

    public int getTotalT20Runs() { return totalT20Runs; }
    public void setTotalT20Runs(int totalT20Runs) { this.totalT20Runs = totalT20Runs; }

    public int getTotalT20Wickets() { return totalT20Wickets; }
    public void setTotalT20Wickets(int totalT20Wickets) { this.totalT20Wickets = totalT20Wickets; }

    public String getHighestScore() { return highestScore; }
    public void setHighestScore(String highestScore) { this.highestScore = highestScore; }

    public String getBestBowling() { return bestBowling; }
    public void setBestBowling(String bestBowling) { this.bestBowling = bestBowling; }

    public int getMatchesPlayed() { return matchesPlayed; }
    public void setMatchesPlayed(int matchesPlayed) { this.matchesPlayed = matchesPlayed; }

    @Override
    public String toString() {
        return String.format("%-25s | All-Rounder | Runs: %d | Wickets: %d",
                getFullName(), totalT20Runs, totalT20Wickets);
    }
}