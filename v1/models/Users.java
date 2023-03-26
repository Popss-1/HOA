package com.bigbrain.v1.models;

import java.util.Date;
import java.util.List;

// datatype in sql server vs in model
public class Users {

    // handled by sql server
    private int UserIdPK;
    private String email;
    private String firstName;
    private String lastName;
    private String role;
    private String phoneNumber;
    private String subscriptionStatus;
    private Date subscriptionExpirationDate;
    private List<Bills> bills;
    private Addresses address;
	private List<Incidents> incidents;
	private List<Requests> requests;
	private List<Announcements> announcements;
    private Date registrationDate;

    public Users(){

    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public Users(String email, Date registrationDate, String firstName, String lastName, String phoneNumber, Roles role, SubscriptionStatues subscriptionStatus, Addresses address) {
        this.email = email;
        this.registrationDate = registrationDate;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role.toString();
        this.subscriptionStatus = subscriptionStatus.toString();
        this.address = address;
    }

    // New user registration
    public Users(String email, String firstName, String lastName){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public List<Requests> getRequests() {
		return requests;
	}

	public void addRequest(Requests request) {
		requests.add(request);
	}

    public List<Announcements> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(List<Announcements> announcements) {
        this.announcements = announcements;
    }

    public void setSubscriptionExpirationDate(Date subscriptionExpirationDate) {
		this.subscriptionExpirationDate = subscriptionExpirationDate;
	}

	public List<Incidents> getIncidents() {
		return incidents;
	}

	public void addIncidents(Incidents incident) {
		incidents.add(incident);
	}

	public Date getSubscriptionExpirationDate() {
        return subscriptionExpirationDate;
    }

    public List<Bills> getBills() {
        return bills;
    }

    public void addBills(Bills bill) {

        this.bills.add(bill);
    }

    public Addresses getAddress() {
        return address;
    }

    public void setAddress(Addresses address) {
        this.address = address;
    }

    public void setUserIdPK(int userIdPK) {
        UserIdPK = userIdPK;
    }
    public int getUserIdPK() {
        return UserIdPK;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(Roles role) {

        this.role = role.toString();
    }

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }


    public enum Roles {
        Admin,
        Homeowner,
        Maintenance,
        Manager
    }

    public enum SubscriptionStatues {
        Pending,
        Valid,
        Expired,
        Not_applicable
    }

    @Override
    public String toString() {
        return "Users{" +
                "UserIdPK=" + UserIdPK +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", subscriptionStatus='" + subscriptionStatus + '\'' +
                ", subscriptionExpirationDate=" + subscriptionExpirationDate +
                ", bills=" + bills +
                ", address=" + address +
                ", incidents=" + incidents +
                ", requests=" + requests +
                ", announcements=" + announcements +
                ", registrationDate=" + registrationDate +
                '}';
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBills(List<Bills> bills) {
        this.bills = bills;
    }

    public void setIncidents(List<Incidents> incidents) {
        this.incidents = incidents;
    }

    public void setRequests(List<Requests> requests) {
        this.requests = requests;
    }

}
