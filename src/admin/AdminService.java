package admin;

import com.google.gson.*;
import model.*;
import service.PSLSystem;
import java.io.*;
import java.util.*;

public class AdminService {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "psl1234";

    private PSLSystem pslSystem;
    private Scanner   scanner;
    private static final String DATA_PATH = "data/";

    public AdminService(PSLSystem pslSystem, Scanner scanner) {
        this.pslSystem = pslSystem;
        this.scanner   = scanner;
    }

    public boolean login() {
        System.out.println("\n========== Admin Login ==========");
        try {
            System.out.print("Username: ");
            String username = scanner.nextLine().trim();

            System.out.print("Password: ");
            String password = scanner.nextLine().trim();

            if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                System.out.println("Login successful. Welcome, Admin!");
                return true;
            } else {
                System.out.println("Invalid username or password.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Login error: " + e.getMessage());
            return false;
        }
    }

    public void showAdminMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n========== Admin Panel ==========");
            System.out.println("1. Add Player to Team");
            System.out.println("2. Remove Player from Team");
            System.out.println("3. Add Umpire");
            System.out.println("4. Add Stadium");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1: addPlayer();    break;
                    case 2: removePlayer(); break;
                    case 3: addUmpire();    break;
                    case 4: addStadium();   break;
                    case 5: running = false; break;
                    default: System.out.println("Invalid choice. Enter 1-5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private void addPlayer() {
        try {
            pslSystem.displayAllTeamNames();
            System.out.print("Enter team name: ");
            String teamName = scanner.nextLine().trim();

            Team team = pslSystem.findTeamByName(teamName);
            if (team == null) {
                System.out.println("Team '" + teamName + "' not found.");
                return;
            }

            System.out.println("Player type: 1. Batsman  2. Bowler  3. AllRounder");
            System.out.print("Enter choice: ");
            int typeChoice = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Full Name       : ");
            String fullName = scanner.nextLine().trim();
            if (fullName.isEmpty()) {
                System.out.println("Player name cannot be empty.");
                return;
            }

            System.out.print("Date of Birth (YYYY-MM-DD): ");
            String dob = scanner.nextLine().trim();

            System.out.print("Nationality     : ");
            String nationality = scanner.nextLine().trim();

            System.out.print("Matches Played  : ");
            int matchesPlayed = Integer.parseInt(scanner.nextLine().trim());

            Player newPlayer = null;
            JsonObject playerJson = new JsonObject();

            if (typeChoice == 1) {
                System.out.print("Batting Average : ");
                double battingAvg = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Strike Rate     : ");
                double strikeRate = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Total T20 Runs  : ");
                int runs = Integer.parseInt(scanner.nextLine().trim());
                System.out.print("Highest Score   : ");
                String highestScore = scanner.nextLine().trim();

                newPlayer = new Batsman(fullName, dob, nationality, teamName,
                        battingAvg, strikeRate, runs, highestScore, matchesPlayed);

                playerJson.addProperty("type",           "Batsman");
                playerJson.addProperty("fullName",        fullName);
                playerJson.addProperty("dateOfBirth",     dob);
                playerJson.addProperty("nationality",     nationality);
                playerJson.addProperty("battingAverage",  battingAvg);
                playerJson.addProperty("strikeRate",      strikeRate);
                playerJson.addProperty("totalT20Runs",    runs);
                playerJson.addProperty("highestScore",    highestScore);
                playerJson.addProperty("matchesPlayed",   matchesPlayed);

            } else if (typeChoice == 2) {
                System.out.print("Bowling Average : ");
                double bowlingAvg = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Economy Rate    : ");
                double economyRate = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Total T20 Wickets: ");
                int wickets = Integer.parseInt(scanner.nextLine().trim());
                System.out.print("Best Bowling    : ");
                String bestBowling = scanner.nextLine().trim();

                newPlayer = new Bowler(fullName, dob, nationality, teamName,
                        bowlingAvg, economyRate, wickets, bestBowling, matchesPlayed);

                playerJson.addProperty("type",             "Bowler");
                playerJson.addProperty("fullName",          fullName);
                playerJson.addProperty("dateOfBirth",       dob);
                playerJson.addProperty("nationality",       nationality);
                playerJson.addProperty("bowlingAverage",    bowlingAvg);
                playerJson.addProperty("economyRate",       economyRate);
                playerJson.addProperty("totalT20Wickets",   wickets);
                playerJson.addProperty("bestBowling",       bestBowling);
                playerJson.addProperty("matchesPlayed",     matchesPlayed);

            } else if (typeChoice == 3) {
                System.out.print("Batting Average : ");
                double battingAvg = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Strike Rate     : ");
                double strikeRate = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Bowling Average : ");
                double bowlingAvg = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Economy Rate    : ");
                double economyRate = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Total T20 Runs  : ");
                int runs = Integer.parseInt(scanner.nextLine().trim());
                System.out.print("Total T20 Wickets: ");
                int wickets = Integer.parseInt(scanner.nextLine().trim());
                System.out.print("Highest Score   : ");
                String highestScore = scanner.nextLine().trim();
                System.out.print("Best Bowling    : ");
                String bestBowling = scanner.nextLine().trim();

                newPlayer = new AllRounder(fullName, dob, nationality, teamName,
                        battingAvg, strikeRate, bowlingAvg, economyRate,
                        runs, wickets, highestScore, bestBowling, matchesPlayed);

                playerJson.addProperty("type",             "AllRounder");
                playerJson.addProperty("fullName",          fullName);
                playerJson.addProperty("dateOfBirth",       dob);
                playerJson.addProperty("nationality",       nationality);
                playerJson.addProperty("battingAverage",    battingAvg);
                playerJson.addProperty("strikeRate",        strikeRate);
                playerJson.addProperty("bowlingAverage",    bowlingAvg);
                playerJson.addProperty("economyRate",       economyRate);
                playerJson.addProperty("totalT20Runs",      runs);
                playerJson.addProperty("totalT20Wickets",   wickets);
                playerJson.addProperty("highestScore",      highestScore);
                playerJson.addProperty("bestBowling",       bestBowling);
                playerJson.addProperty("matchesPlayed",     matchesPlayed);

            } else {
                System.out.println("Invalid player type.");
                return;
            }

            team.addPlayer(newPlayer);

            savePlayerToJson(teamName, playerJson);
            System.out.println("Player '" + fullName + "' added to " + teamName + " successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error adding player: " + e.getMessage());
        }
    }

    private void removePlayer() {
        try {
            pslSystem.displayAllTeamNames();
            System.out.print("Enter team name: ");
            String teamName = scanner.nextLine().trim();

            Team team = pslSystem.findTeamByName(teamName);
            if (team == null) {
                System.out.println("Team '" + teamName + "' not found.");
                return;
            }

            System.out.println("\nCurrent Players:");
            for (Player p : team.getPlayers()) {
                System.out.println("  - " + p.getFullName());
            }

            System.out.print("Enter player name to remove: ");
            String playerName = scanner.nextLine().trim();

            team.removePlayer(playerName);

            removePlayerFromJson(teamName, playerName);

        } catch (Exception e) {
            System.out.println("Error removing player: " + e.getMessage());
        }
    }

    private void addUmpire() {
        try {
            System.out.print("Full Name          : ");
            String fullName = scanner.nextLine().trim();
            if (fullName.isEmpty()) {
                System.out.println("Umpire name cannot be empty.");
                return;
            }
            System.out.print("Date of Birth      : ");
            String dob = scanner.nextLine().trim();
            System.out.print("Nationality        : ");
            String nationality = scanner.nextLine().trim();
            System.out.print("Matches Officiated : ");
            int matches = Integer.parseInt(scanner.nextLine().trim());

            // Save to JSON
            JsonObject umpireJson = new JsonObject();
            umpireJson.addProperty("fullName",           fullName);
            umpireJson.addProperty("dateOfBirth",        dob);
            umpireJson.addProperty("nationality",        nationality);
            umpireJson.addProperty("matchesOfficiated",  matches);

            saveToVenuesJson("umpires", umpireJson);
            System.out.println("Umpire '" + fullName + "' added successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered.");
        } catch (Exception e) {
            System.out.println("Error adding umpire: " + e.getMessage());
        }
    }

    private void addStadium() {
        try {
            System.out.print("Stadium Name : ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Stadium name cannot be empty.");
                return;
            }
            System.out.print("City         : ");
            String city = scanner.nextLine().trim();
            System.out.print("Capacity     : ");
            int capacity = Integer.parseInt(scanner.nextLine().trim());

            JsonObject stadiumJson = new JsonObject();
            stadiumJson.addProperty("stadiumName", name);
            stadiumJson.addProperty("city",        city);
            stadiumJson.addProperty("capacity",    capacity);

            saveToVenuesJson("stadiums", stadiumJson);
            System.out.println("Stadium '" + name + "' added successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid capacity entered.");
        } catch (Exception e) {
            System.out.println("Error adding stadium: " + e.getMessage());
        }
    }

    private void savePlayerToJson(String teamName, JsonObject playerJson) {
        try {
            String fileName = DATA_PATH + teamName.toLowerCase().replace(" ", "_") + ".json";
            Reader reader   = new FileReader(fileName);
            JsonObject root = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();

            JsonArray players = root.getAsJsonArray("players");
            players.add(playerJson);

            Writer writer = new FileWriter(fileName);
            new GsonBuilder().setPrettyPrinting().create().toJson(root, writer);
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("Team file not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error saving player to JSON: " + e.getMessage());
        }
    }

    private void removePlayerFromJson(String teamName, String playerName) {
        try {
            String fileName = DATA_PATH + teamName.toLowerCase().replace(" ", "_") + ".json";
            Reader reader   = new FileReader(fileName);
            JsonObject root = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();

            JsonArray players    = root.getAsJsonArray("players");
            JsonArray updated    = new JsonArray();
            boolean   found      = false;

            for (JsonElement e : players) {
                JsonObject p = e.getAsJsonObject();
                if (!p.get("fullName").getAsString().equalsIgnoreCase(playerName)) {
                    updated.add(p);
                } else {
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Player '" + playerName + "' not found in JSON file.");
                return;
            }

            root.add("players", updated);
            Writer writer = new FileWriter(fileName);
            new GsonBuilder().setPrettyPrinting().create().toJson(root, writer);
            writer.close();

            System.out.println("Player '" + playerName + "' removed from JSON file.");

        } catch (FileNotFoundException e) {
            System.out.println("Team file not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error removing player from JSON: " + e.getMessage());
        }
    }

    private void saveToVenuesJson(String arrayKey, JsonObject newEntry) {
        try {
            String     fileName = DATA_PATH + "venues_and_umpires.json";
            Reader     reader   = new FileReader(fileName);
            JsonObject root     = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();

            JsonArray array = root.getAsJsonArray(arrayKey);
            array.add(newEntry);

            Writer writer = new FileWriter(fileName);
            new GsonBuilder().setPrettyPrinting().create().toJson(root, writer);
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("venues_and_umpires.json not found.");
        } catch (Exception e) {
            System.out.println("Error saving to venues JSON: " + e.getMessage());
        }
    }
}