package model;

public class Match {

    private String matchNumber;
    private Team team1;
    private Team team2;
    private Stadium stadium;
    private Umpire umpire;
    private String matchDate;
    private String matchTime;
    private String result;

    public Match(String matchNumber, Team team1, Team team2, Stadium stadium,
                 Umpire umpire, String matchDate, String matchTime, String result) {
        this.matchNumber = matchNumber;
        this.team1 = team1;
        this.team2 = team2;
        this.stadium = stadium;
        this.umpire = umpire;
        this.matchDate = matchDate;
        this.matchTime = matchTime;
        this.result = result;
    }

    public void displayMatch() {
        System.out.println("============================================");
        System.out.println("Match #      : " + matchNumber);
        System.out.println("Teams        : " + team1.getTeamName() + " vs " + team2.getTeamName());
        System.out.println("Date         : " + matchDate);
        System.out.println("Time         : " + matchTime);
        System.out.println("Venue        : " + stadium.toString());
        System.out.println("Umpire       : " + umpire.toString());
        System.out.println("Result       : " + result);
        System.out.println("============================================");
    }

    public void displayMatchSummary() {
        System.out.printf("Match %-3s | %-25s vs %-25s | %s | %s%n",
                matchNumber,
                team1.getTeamName(),
                team2.getTeamName(),
                matchDate,
                stadium.getCity());
    }

    public String getMatchNumber() { return matchNumber; }
    public void setMatchNumber(String matchNumber) { this.matchNumber = matchNumber; }

    public Team getTeam1() { return team1; }
    public void setTeam1(Team team1) { this.team1 = team1; }

    public Team getTeam2() { return team2; }
    public void setTeam2(Team team2) { this.team2 = team2; }

    public Stadium getStadium() { return stadium; }
    public void setStadium(Stadium stadium) { this.stadium = stadium; }

    public Umpire getUmpire() { return umpire; }
    public void setUmpire(Umpire umpire) { this.umpire = umpire; }

    public String getMatchDate() { return matchDate; }
    public void setMatchDate(String matchDate) { this.matchDate = matchDate; }

    public String getMatchTime() { return matchTime; }
    public void setMatchTime(String matchTime) { this.matchTime = matchTime; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }


    @Override
    public String toString() {
        return "Match " + matchNumber + ": " + team1.getTeamName() +
               " vs " + team2.getTeamName() + " on " + matchDate;
    }
}