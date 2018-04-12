package ru.softwerke.model;

import java.time.LocalDate;

public class Client {
    private String firstName;
    private String lastName;
    private LocalDate dataBirth;
    private String patronymic;
    private long id;
    private static long COUNTER = 1;

    public Client(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        patronymic = builder.patronymic;
        dataBirth = builder.dataBirth;
        id = builder.id;
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

    public String getPatronymic() {
        return patronymic;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private LocalDate dataBirth;
        private String patronymic = "no_patronymic";
        private long id;

        public Builder firstName(String fName) {
            firstName = fName;
            return this;
        }

        public Builder lastName(String lName) {
            lastName = lName;
            return this;
        }

        public Builder dataBirth(LocalDate date) {
            dataBirth = date;
            return this;
        }

        public Builder patronymic(String patr) {
            patronymic = patr;
            return this;
        }

        public Builder id() {
            id = COUNTER++;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }
}
