package service;

import com.google.gson.*;
import model.*;
import java.io.*;
import java.util.*;

public class DataLoader {

    private static final String DATA_PATH = "data/";

    private static final String[] TEAM_FILES = {
        "islamabad_united.json",
        "lahore_qalandars.json",
        "multan_sultans.json",
        "peshawar_zalmi.json",
        "quetta_gladiators.json",
        "karachi_kings.json"
    };

    public List<Team> loadAllTeams() {
        List<Team> teams = new ArrayList<>();
        for (String fileName : TEAM_FILES) {
            try {
                Team team = loadTeam(fileName);
                if (team != null) {
                    teams.add(team);
                }
            } catch (Exception e) {
                System.out.println("Warning: Could not load " + fileName + " — " + e.getMessage());
            }
        }
        return teams;
    }

    private Team loadTeam(String fileName) {
        try {
            JsonObject json = readJsonFile(DATA_PATH + fileName);

            Team team = new Team(
                json.get("teamName").getAsString(),
                json.get("homeGround").getAsString(),
                json.get("captain").getAsString(),
                json.get("coach").getAsString(),
                json.get("foundedYear").getAsInt(),
                json.get("titlesWon").getAsInt(),
                json.get("matchesPlayed").getAsInt(),
                json.get("wins").getAsInt(),
                json.get("losses").getAsInt(),
                json.get("nrr").getAsDouble()
            );

            JsonArray playersArray = json.getAsJsonArray("players");
            List<Player> players = loadPlayers(playersArray, team.getTeamName());
            for (Player p : players) {
                team.addPlayer(p);
            }

            return team;

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return null;
        } catch (Exception e) {
            System.out.println("Error loading team from " + fileName + ": " + e.getMessage());
            return null;
        }
    }

    private List<Player> loadPlayers(JsonArray playersArray, String teamName) {
        List<Player> players = new ArrayList<>();

        for (JsonElement element : playersArray) {
            try {
                JsonObject p = element.getAsJsonObject();
                String type  = p.get("type").getAsString();

                switch (type) {
                    case "Batsman":
                        players.add(new Batsman(
                            p.get("fullName").getAsString(),
                            p.get("dateOfBirth").getAsString(),
                            p.get("nationality").getAsString(),
                            teamName,
                            p.get("battingAverage").getAsString(),
                            p.get("strikeRate").getAsString(),
                            p.get("totalT20Runs").getAsInt(),
                            p.get("highestScore").getAsString(),
                            p.get("matchesPlayed").getAsInt()
                        ));
                        break;

                    case "Bowler":
                        players.add(new Bowler(
                            p.get("fullName").getAsString(),
                            p.get("dateOfBirth").getAsString(),
                            p.get("nationality").getAsString(),
                            teamName,
                            p.get("bowlingAverage").getAsString(),
                            p.get("economyRate").getAsString(),
                            p.get("totalT20Wickets").getAsInt(),
                            p.get("bestBowling").getAsString(),
                            p.get("matchesPlayed").getAsInt()
                        ));
                        break;

                    case "AllRounder":
                        players.add(new AllRounder(
                            p.get("fullName").getAsString(),
                            p.get("dateOfBirth").getAsString(),
                            p.get("nationality").getAsString(),
                            teamName,
                            p.get("battingAverage").getAsString(),
                            p.get("strikeRate").getAsString(),
                            p.get("bowlingAverage").getAsString(),
                            p.get("economyRate").getAsString(),
                            p.get("totalT20Runs").getAsInt(),
                            p.get("totalT20Wickets").getAsInt(),
                            p.get("highestScore").getAsString(),
                            p.get("bestBowling").getAsString(),
                            p.get("matchesPlayed").getAsInt()
                        ));
                        break;

                    case "Coach":
                       
                        break;

                    default:
                        System.out.println("Unknown player type: " + type + " — skipped.");
                }
            } catch (Exception e) {
                System.out.println("Warning: Could not parse a player entry — " + e.getMessage());
            }
        }
        return players;
    }

    public List<Stadium> loadStadiums() {
        List<Stadium> stadiums = new ArrayList<>();
        try {
            JsonObject json     = readJsonFile(DATA_PATH + "venues_and_umpires.json");
            JsonArray  arr      = json.getAsJsonArray("stadiums");
            for (JsonElement e : arr) {
                JsonObject s = e.getAsJsonObject();
                stadiums.add(new Stadium(
                    s.get("stadiumName").getAsString(),
                    s.get("city").getAsString(),
                    s.get("capacity").getAsInt()
                ));
            }
        } catch (Exception e) {
            System.out.println("Error loading stadiums: " + e.getMessage());
        }
        return stadiums;
    }

    public List<Umpire> loadUmpires() {
        List<Umpire> umpires = new ArrayList<>();
        try {
            JsonObject json = readJsonFile(DATA_PATH + "venues_and_umpires.json");
            JsonArray  arr  = json.getAsJsonArray("umpires");
            for (JsonElement e : arr) {
                JsonObject u = e.getAsJsonObject();
                umpires.add(new Umpire(
                    u.get("fullName").getAsString(),
                    u.get("dateOfBirth").getAsString(),
                    u.get("nationality").getAsString(),
                    u.get("matchesOfficiated").getAsInt()
                ));
            }
        } catch (Exception e) {
            System.out.println("Error loading umpires: " + e.getMessage());
        }
        return umpires;
    }

    public Schedule loadSchedule(List<Team> teams, List<Stadium> stadiums, List<Umpire> umpires) {
        Schedule schedule = new Schedule();
        try {
            JsonObject json    = readJsonFile(DATA_PATH + "schedule.json");
            JsonArray  matches = json.getAsJsonArray("matches");

            for (JsonElement e : matches) {
                try {
                    JsonObject m = e.getAsJsonObject();

                    Team    t1      = findTeam(teams,    m.get("team1").getAsString());
                    Team    t2      = findTeam(teams,    m.get("team2").getAsString());
                    Stadium stadium = findStadium(stadiums, m.get("stadiumName").getAsString());
                    Umpire  umpire  = findUmpire(umpires,   m.get("umpireName").getAsString());

                    if (t1 == null || t2 == null || stadium == null || umpire == null) {
                        System.out.println("Warning: Match " + m.get("matchNumber").getAsString()
                            + " has unresolved references — skipped.");
                        continue;
                    }

                    schedule.addMatch(new Match(
                        m.get("matchNumber").getAsString(),
                        t1, t2, stadium, umpire,
                        m.get("matchDate").getAsString(),
                        m.get("matchTime").getAsString(),
                        m.get("result").getAsString()
                    ));
                } catch (Exception ex) {
                    System.out.println("Warning: Could not parse a match entry — " + ex.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading schedule: " + e.getMessage());
        }
        return schedule;
    }

    private JsonObject readJsonFile(String filePath) throws FileNotFoundException {
        Reader reader = new FileReader(filePath);
        return JsonParser.parseReader(reader).getAsJsonObject();
    }

    private Team findTeam(List<Team> teams, String name) {
        for (Team t : teams)
            if (t.getTeamName().equalsIgnoreCase(name)) return t;
        return null;
    }

    private Stadium findStadium(List<Stadium> stadiums, String name) {
        for (Stadium s : stadiums)
            if (s.getStadiumName().equalsIgnoreCase(name)) return s;
        return null;
    }

    private Umpire findUmpire(List<Umpire> umpires, String name) {
        for (Umpire u : umpires)
            if (u.getFullName().equalsIgnoreCase(name)) return u;
        return null;
    }
}
