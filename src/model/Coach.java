package model;

public class Coach extends Person {

    private String specialization;
    private String teamName;
    private int yearsOfExperience;


    public Coach(String fullName, String dateOfBirth, String nationality,
                 String specialization, String teamName, int yearsOfExperience) {
        super(fullName, dateOfBirth, nationality);
        this.specialization = specialization;
        this.teamName = teamName;
        this.yearsOfExperience = yearsOfExperience;
    }


    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Specialization  : " + specialization);
        System.out.println("Team            : " + teamName);
        System.out.println("Years Experience: " + yearsOfExperience);
    }


    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }


    @Override
    public String toString() {
        return String.format("%-25s | Coach | %s | %s | %d yrs exp",
                getFullName(), specialization, teamName, yearsOfExperience);
    }
}