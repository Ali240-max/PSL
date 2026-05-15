package model;

public class Umpire extends Person {

    private int matchesOfficiated;

    public Umpire(String fullName, String dateOfBirth, String nationality,
                  int matchesOfficiated) {
        super(fullName, dateOfBirth, nationality);
        this.matchesOfficiated = matchesOfficiated;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Matches Officiated: " + matchesOfficiated);
    }

    public int getMatchesOfficiated() { return matchesOfficiated; }
    public void setMatchesOfficiated(int matchesOfficiated) {
        this.matchesOfficiated = matchesOfficiated;
    }
    @Override
    public String toString() {
        return getFullName() + " (" + getNationality() + ") | Matches: " + matchesOfficiated;
    }
}