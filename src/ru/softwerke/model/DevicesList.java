package ru.softwerke.model;

import java.util.ArrayList;

public class DevicesList {
    ArrayList<Device> devices = new ArrayList<>();

    public void addDevice(Device device){
        devices.add(device);
    }
    public ArrayList<Device> getDevicesList() {return devices; }
}
