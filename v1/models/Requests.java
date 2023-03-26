package com.bigbrain.v1.models;

import java.util.Date;


public class Requests {

	public enum Priorities {
        Low,
        Medium,
        High,
        Severe
    }
	
	public enum Statuses {
        Received,
        Assigned,
        In_progress,
        Completed,
        Delayed
    }
	

	private int requestIDPK;

	private int requestUserIDFK;

	private String title;

	private String description;

	private Date requestDate;

	private int addressIDFK;

	private int maintenanceIdFK;

	private String priority;

	private String status;

	private Addresses address;

	public Requests() {
	}

	public Requests(int requestUserIDFK, String title, String description, Date requestDate, int addressIDFK, int maintenanceIdFK, String priority, String status, Addresses address) {
		this.requestUserIDFK = requestUserIDFK;
		this.title = title;
		this.description = description;
		this.requestDate = requestDate;
		this.addressIDFK = addressIDFK;
		this.maintenanceIdFK = maintenanceIdFK;
		this.priority = priority;
		this.status = status;
		this.address = address;
	}

	public int getRequestIDPK() {
		return requestIDPK;
	}

	public void setRequestIDPK(int requestIDPK) {
		this.requestIDPK = requestIDPK;
	}

	public Addresses getAddress() {
		return address;
	}

	public void setAddress(Addresses address) {
		this.address = address;
	}
	
	
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public int getRequestUserIDFK() {
		return requestUserIDFK;
	}

	public void setRequestUserIDFK(int requestUserIDFK) {
		this.requestUserIDFK = requestUserIDFK;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public int getAddressIDFK() {
		return addressIDFK;
	}

	public void setAddressIDFK(int addressIDFK) {
		this.addressIDFK = addressIDFK;
	}

	public int getMaintenanceIdFK() {
		return maintenanceIdFK;
	}

	public void setMaintenanceIdFK(int maintenanceIdFK) {
		this.maintenanceIdFK = maintenanceIdFK;
	}

	@Override
	public String toString() {
		return "Requests{" +
				"requestIDPK=" + requestIDPK +
				", requestUserIDFK=" + requestUserIDFK +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", requestDate=" + requestDate +
				", addressIDFK=" + addressIDFK +
				", maintenanceIdFK=" + maintenanceIdFK +
				", priority='" + priority + '\'' +
				", status='" + status + '\'' +
				", address=" + address +
				'}';
	}
}
