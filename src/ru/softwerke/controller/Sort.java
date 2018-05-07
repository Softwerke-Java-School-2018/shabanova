package ru.softwerke.controller;

import ru.softwerke.model.DevicesList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DS on 07.05.2018.
 */
public class Sort {
    DevicesList devices = new DevicesList();
    public List SortDevicesByType(){
        return devices.sortByType();
    }


}
