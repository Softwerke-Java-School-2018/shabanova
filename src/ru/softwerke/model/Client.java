package ru.softwerke.model;

import java.time.LocalDate;

public class Client {
    private String firstName;
    private String lastName;
    private LocalDate dataBirth;
    private long id;
    private static long COUNTER = 1;

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

    public LocalDate getDataBirth() {
        return dataBirth;
    }

    public void setDataBirth(LocalDate dataBirth) {
        this.dataBirth = dataBirth;
    }

    public long getId() {
        return id;
    }

    public void setId() {
        id = COUNTER++;
    }
}
