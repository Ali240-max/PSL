package model;

public class Stadium {

    private String stadiumName;
    private String city;
    private int capacity;

    public Stadium(String stadiumName, String city, int capacity) {
        this.stadiumName = stadiumName;
        this.city = city;
        this.capacity = capacity;
    }

    public void displayInfo() {
        System.out.println("Stadium  : " + stadiumName);
        System.out.println("City     : " + city);
        System.out.println("Capacity : " + capacity);
    }


    public String getStadiumName() { return stadiumName; }
    public void setStadiumName(String stadiumName) { this.stadiumName = stadiumName; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    @Override
    public String toString() {
        return stadiumName + ", " + city + " (Capacity: " + capacity + ")";
    }
}