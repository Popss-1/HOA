package com.bigbrain.v1.models;

public class Maintenances {

    private int maintenanceIdPk;
    private int userIdFk;
    private int numberOfRequests;
    private String availability;
    private String firstName;

    public Maintenances() {
    }

    // Db has trigger to add maintenance worker when a new worker is created in Users
    public Maintenances(int userIdFk, String availability) {
        this.userIdFk = userIdFk;
        this.availability = availability;
    }

    public void setMaintenanceIdPk(int maintenanceIdPk) {
        this.maintenanceIdPk = maintenanceIdPk;
    }

    public int getMaintenanceIdPk() {
        return maintenanceIdPk;
    }

    public int getUserIdFk() {
        return userIdFk;
    }

    public void setUserIdFk(int userIdFk) {
        this.userIdFk = userIdFk;
    }

    public int getNumberOfRequests() {
        return numberOfRequests;
    }


    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Maintenances{" +
                "maintenanceIdPk=" + maintenanceIdPk +
                ", userIdFk=" + userIdFk +
                ", numberOfRequests=" + numberOfRequests +
                ", availability='" + availability + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    public enum Availabilities{
        Available,
        Not_available
    }
}
