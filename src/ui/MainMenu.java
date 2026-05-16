package ui;

import admin.AdminService;
import model.*;
import service.*;
import java.util.*;

public class MainMenu {

    private PSLSystem     pslSystem;
    private SearchService searchService;
    private AdminService  adminService;
    private Scanner       scanner;


    public MainMenu() {
        scanner       = new Scanner(System.in);
        pslSystem     = new PSLSystem();
        searchService = new SearchService(pslSystem);
        adminService  = new AdminService(pslSystem, scanner);
    }

    public void start() {
        System.out.println("==========================================");
        System.out.println("   Welcome to PSL Management System");
        System.out.println("==========================================");

        boolean running = true;
        while (running) {
            printMenu();
            try {
                String input  = scanner.nextLine().trim();
                int    choice = Integer.parseInt(input);

                switch (choice) {
                    case 1: handleViewTeams();        break;
                    case 2: handleViewPlayers();      break;
                    case 3: handleMatchSchedule();    break;
                    case 4: handlePointsTable();      break;
                    case 5: handleSearch();           break;
                    case 6: handleAdminLogin();       break;
                    case 7:
                        System.out.println("Thank you for using PSL Management System. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private void printMenu() {
        System.out.println("\n========== Main Menu ==========");
        System.out.println("1. View Teams");
        System.out.println("2. View Players");
        System.out.println("3. Match Schedule");
        System.out.println("4. Points Table");
        System.out.println("5. Search");
        System.out.println("6. Admin Login");
        System.out.println("7. Exit");
        System.out.print("Enter choice: ");
    }

    private void handleViewTeams() {
        try {
            pslSystem.displayAllTeamNames();
            System.out.print("\nEnter team name for details (or press Enter to go back): ");
            String teamName = scanner.nextLine().trim();

            if (!teamName.isEmpty()) {
                pslSystem.displayTeamInfo(teamName);
            }
        } catch (Exception e) {
            System.out.println("Error viewing teams: " + e.getMessage());
        }
    }

    private void handleViewPlayers() {
        try {
            pslSystem.displayAllTeamNames();
            System.out.print("\nEnter team name to view players: ");
            String teamName = scanner.nextLine().trim();

            if (teamName.isEmpty()) {
                System.out.println("No team name entered.");
                return;
            }

            pslSystem.displayTeamPlayers(teamName);

            System.out.print("\nEnter player name for full details (or press Enter to go back): ");
            String playerName = scanner.nextLine().trim();
            if (!playerName.isEmpty()) {
                displayPlayerDetails(teamName, playerName);
            }
        } catch (Exception e) {
            System.out.println("Error viewing players: " + e.getMessage());
        }
    }

    private void handleMatchSchedule() {
        try {
            pslSystem.displaySchedule();
            System.out.print("\nEnter match number for full details (or press Enter to go back): ");
            String matchNum = scanner.nextLine().trim();
            if (!matchNum.isEmpty()) {
                pslSystem.getSchedule().displayMatchByNumber(matchNum);
            }
        } catch (Exception e) {
            System.out.println("Error displaying schedule: " + e.getMessage());
        }
    }

    private void handlePointsTable() {
        try {
            pslSystem.displayPointsTable();
        } catch (Exception e) {
            System.out.println("Error displaying points table: " + e.getMessage());
        }
    }

  
    private void handleSearch() {
        try {
            System.out.println("\n=== Search ===");
            System.out.println("1. Search Player");
            System.out.println("2. Search Team");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(scanner.nextLine().trim());

            if (choice == 1) {
                System.out.print("Enter player name: ");
                String name = scanner.nextLine().trim();
                searchService.searchPlayer(name);
            } else if (choice == 2) {
                System.out.print("Enter team name: ");
                String name = scanner.nextLine().trim();
                searchService.searchTeam(name);
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter 1 or 2.");
        } catch (Exception e) {
            System.out.println("Error during search: " + e.getMessage());
        }
    }

    private void handleAdminLogin() {
        try {
            boolean loggedIn = adminService.login();
            if (loggedIn) {
                adminService.showAdminMenu();
            }
        } catch (Exception e) {
            System.out.println("Error during admin login: " + e.getMessage());
        }
    }


    private void displayPlayerDetails(String teamName, String playerName) {
        try {
            Team team = pslSystem.findTeamByName(teamName);
            if (team == null) {
                System.out.println("Team not found.");
                return;
            }
            for (Player p : team.getPlayers()) {
                if (p.getFullName().equalsIgnoreCase(playerName)) {
                    p.displayInfo();
                    return;
                }
            }
            System.out.println("Player '" + playerName + "' not found in " + teamName + ".");
        } catch (Exception e) {
            System.out.println("Error displaying player details: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new MainMenu().start();
    }
}