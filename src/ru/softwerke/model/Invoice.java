package ru.softwerke.model;

import ru.softwerke.model.Client;
import ru.softwerke.model.Device;

import java.time.LocalDate;

public class Invoice {
    Client client;
    Device device;
    LocalDate Date;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }
}
