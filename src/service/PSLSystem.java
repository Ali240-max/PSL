package service;
import model.*;
import java.util.*;

public class PSLSystem {

    private List<Team>    teams;
    private List<Stadium> stadiums;
    private List<Umpire>  umpires;
    private Schedule      schedule;

    public PSLSystem() {
        DataLoader loader = new DataLoader();
        teams    = loader.loadAllTeams();
        stadiums = loader.loadStadiums();
        umpires  = loader.loadUmpires();
        schedule = loader.loadSchedule(teams, stadiums, umpires);

        if (teams.isEmpty()) {
            System.out.println("Warning: No teams loaded. Check your data/ folder.");
        }
    }

    public void displayPointsTable() {
        System.out.println("\n========== PSL 2025 Points Table ==========");
        System.out.printf("%-25s | %3s | %3s | %3s | %4s | %7s%n",
                "Team", "MP", "W", "L", "Pts", "NRR");
                System.out.println("============================================================");

        teams.sort((a, b) -> b.getPoints() - a.getPoints());

        for (Team team : teams) {
            team.displayPointsTableRow();
        }
        System.out.println("============================================================");
    }


    public void displaySchedule() {
        schedule.displayFullSchedule();
    }

    public void displayTeamInfo(String teamName) {
        Team team = findTeamByName(teamName);
        if (team != null) {
            team.displayTeamInfo();
        } else {
            System.out.println("Team '" + teamName + "' not found.");
        }
    }

    public void displayTeamPlayers(String teamName) {
        Team team = findTeamByName(teamName);
        if (team != null) {
            System.out.println("\n=== Players of " + teamName + " ===");
            for (Player p : team.getPlayers()) {
                System.out.println("  " + p.toString());
            }
        } else {
            System.out.println("Team '" + teamName + "' not found.");
        }
    }


    public void displayAllTeamNames() {
        System.out.println("\nAvailable Teams:");
        for (Team t : teams) {
            System.out.println("  - " + t.getTeamName());
        }
    }


    public Team findTeamByName(String teamName) {
        for (Team t : teams) {
            if (t.getTeamName().equalsIgnoreCase(teamName)) {
                return t;
            }
        }
        return null;
    }


    public List<Team>    getTeams()    { return new ArrayList<>(teams); }
    public List<Stadium> getStadiums() { return new ArrayList<>(stadiums); }
    public List<Umpire>  getUmpires()  { return new ArrayList<>(umpires); }
    public Schedule      getSchedule() { return schedule; }
}
