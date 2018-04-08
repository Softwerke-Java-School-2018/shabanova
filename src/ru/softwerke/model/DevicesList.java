package ru.softwerke.model;

import java.util.LinkedList;

public class DevicesList {
    LinkedList<Device> devices = new LinkedList<>();

    public void addDevice(Device device){
        devices.add(device);
    }



}
