package com.reservationservice.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String resObject;
    private String firstName;
    private String lastName;
    private String resDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
    	this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
    	this.version = version;
    }

    public String getResObject() {
        return resObject;
    }

    public void setResObject(String resObject) {
    	if(resObject == null || resObject.equals("")) {
        	throw new IllegalArgumentException("resObject must be filled out");
        }
    	this.resObject = resObject;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
    	if(firstName == null || firstName.equals("")) {
        	throw new IllegalArgumentException("firstName must be filled out");
        }
    	this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
    	if(lastName == null || lastName.equals("")) {
        	throw new IllegalArgumentException("lastName must be filled out");
        }
    	this.lastName = lastName;
    }

    public String getResDate() {
        return resDate;
    }

    public void setResDate(String resDate) {
    	if(resDate == null || resDate.equals("") || resDate.length()>16) {
        	throw new IllegalArgumentException("Negative value");
        }
    	this.resDate = resDate;
    }

}
