package model;

public class Person {

    private String fullName;
    private String dateOfBirth;
    private String nationality;


    public Person(String fullName, String dateOfBirth, String nationality) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
    }

    public Person(String fullName) {
        this.fullName = fullName;
        this.dateOfBirth = "Unknown";
        this.nationality = "Unknown";
    }

    public void displayInfo() {
        System.out.println("Name         : " + fullName);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Nationality  : " + nationality);
    }


    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }


    @Override
    public String toString() {
        return fullName + " (" + nationality + ")";
    }
}