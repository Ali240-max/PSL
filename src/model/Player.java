package model;


public class Player extends Person {

    private String role;
    private String teamName;


    public Player(String fullName, String dateOfBirth, String nationality,
                      String role, String teamName) {
        super(fullName, dateOfBirth, nationality);
        this.role = role;
        this.teamName = teamName;
    }

    public Player(String fullName, String role, String teamName) {
        super(fullName);
        this.role = role;
        this.teamName = teamName;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Name         : " + getFullName()); 
        System.out.println("Role         : " + role);
        System.out.println("Team         : " + teamName);
    }


    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }


    @Override
    public String toString() {
        return getFullName() + " | " + role + " | " + teamName;
    }
}