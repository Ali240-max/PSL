package model;

public class Batsman extends Player {

    // was String, now correctly double
    private double battingAverage;
    private double strikeRate;
    private int    totalT20Runs;
    private String highestScore;
    private int    matchesPlayed;

    public Batsman(String fullName, String dateOfBirth, String nationality,
                   String teamName, double battingAverage, double strikeRate,
                   int totalT20Runs, String highestScore, int matchesPlayed) {
        super(fullName, dateOfBirth, nationality, "Batsman", teamName);
        this.battingAverage = battingAverage;
        this.strikeRate     = strikeRate;
        this.totalT20Runs   = totalT20Runs;
        this.highestScore   = highestScore;
        this.matchesPlayed  = matchesPlayed;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Batting Avg  : " + battingAverage);
        System.out.println("Strike Rate  : " + strikeRate);
        System.out.println("T20 Runs     : " + totalT20Runs);
        System.out.println("Highest Score: " + highestScore);
        System.out.println("Matches      : " + matchesPlayed);
    }

    public double getBattingAverage() { return battingAverage; }
    public void setBattingAverage(double battingAverage) { this.battingAverage = battingAverage; }

    public double getStrikeRate() { return strikeRate; }
    public void setStrikeRate(double strikeRate) { this.strikeRate = strikeRate; }

    public int getTotalT20Runs() { return totalT20Runs; }
    public void setTotalT20Runs(int totalT20Runs) { this.totalT20Runs = totalT20Runs; }

    public String getHighestScore() { return highestScore; }
    public void setHighestScore(String highestScore) { this.highestScore = highestScore; }

    public int getMatchesPlayed() { return matchesPlayed; }
    public void setMatchesPlayed(int matchesPlayed) { this.matchesPlayed = matchesPlayed; }

    @Override
    public String toString() {
        return String.format("%-25s | Batsman    | Avg: %-6.2f | SR: %-6.2f | Runs: %d",
                getFullName(), battingAverage, strikeRate, totalT20Runs);
    }
}