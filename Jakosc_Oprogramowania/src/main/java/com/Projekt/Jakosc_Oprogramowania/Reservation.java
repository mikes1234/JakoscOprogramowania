package com.Projekt.Jakosc_Oprogramowania;

import java.util.ArrayList;
import java.util.Date;

public class Reservation {

    int Id;

    String ResObject;

    String FirstName;

    String LastName;

    Date ResDate;

    public Reservation() {
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int value) {
        this.Id = value;
    }

    public String getResObject() {
        return this.ResObject;
    }

    public void setResObject(String value) {
        this.ResObject = value;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public void setFirstName(String value) {
        this.FirstName = value;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setLastName(String value) {
        this.LastName = value;
    }

    public Date getResDate() {
        return this.ResDate;
    }

    public void setResDate(Date value) {
        this.ResDate = value;
    }

}
