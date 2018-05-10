package ru.softwerke.model.client;

import java.time.LocalDate;

public class Client {
    private String firstName;
    private String lastName;
    private LocalDate dataBirth;
    private long id;
    private static long COUNTER = 1;

    public Client(String firstName, String lastName, LocalDate dataBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dataBirth = dataBirth;
        this.id = COUNTER++;
    }


    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDataBirth() {
        return dataBirth;
    }



}
