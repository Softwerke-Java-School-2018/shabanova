package ru.softwerke.controller;

import ru.softwerke.model.Color;
import ru.softwerke.model.Device;
import ru.softwerke.model.DevicesList;
import ru.softwerke.model.Type;
import ru.softwerke.view.OutPut;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DeviceController {

    private DevicesList devicesList = new DevicesList();
    OutPut outPut;
    public void addDevice(Type type, String manufactured, String releaseDate,
                          Color color, BigDecimal price){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate dateRelease = LocalDate.parse(releaseDate, formatter);
        Device device = new Device();
        device.setType(type);
        device.setManufactured(manufactured);
        device.setReleaseDate(dateRelease);
        device.setColor(color);
        device.setPrice(price);
        device.setId();
        devicesList.addDevice(device);

    }
}
