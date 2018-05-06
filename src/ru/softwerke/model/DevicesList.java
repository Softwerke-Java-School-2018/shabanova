package ru.softwerke.model;

import java.util.ArrayList;
import java.util.List;

public class DevicesList {
    List<Device> devices = new ArrayList<>();

    public void addDevice(Device device)
    {
        devices.add(device);
    }
    public List<Device> getDevicesList()
    {
        return devices;
    }
}
