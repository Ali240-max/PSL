package model;

public class Batsman extends Player {

    private String battingAverage;
    private String strikeRate;
    private int totalT20Runs;
    private String highestScore;
    private int matchesPlayed;


    public Batsman(String fullName, String dateOfBirth, String nationality,
                   String teamName, String battingAverage, String strikeRate,
                   int totalT20Runs, String highestScore, int matchesPlayed) {
        super(fullName, dateOfBirth, nationality, "Batsman", teamName);
        this.battingAverage = battingAverage;
        this.strikeRate = strikeRate;
        this.totalT20Runs = totalT20Runs;
        this.highestScore = highestScore;
        this.matchesPlayed = matchesPlayed;
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


    public String getBattingAverage() { return battingAverage; }
    public void setBattingAverage(String battingAverage) { this.battingAverage = battingAverage; }

    public String getStrikeRate() { return strikeRate; }
    public void setStrikeRate(String strikeRate) { this.strikeRate = strikeRate; }

    public int getTotalT20Runs() { return totalT20Runs; }
    public void setTotalT20Runs(int totalT20Runs) { this.totalT20Runs = totalT20Runs; }

    public String getHighestScore() { return highestScore; }
    public void setHighestScore(String highestScore) { this.highestScore = highestScore; }

    public int getMatchesPlayed() { return matchesPlayed; }
    public void setMatchesPlayed(int matchesPlayed) { this.matchesPlayed = matchesPlayed; }

    @Override
    public String toString() {
        return String.format("%-25s | Batsman    | Avg: %-6s | SR: %-6s | Runs: %d",
                getFullName(), battingAverage, strikeRate, totalT20Runs);
    }
}