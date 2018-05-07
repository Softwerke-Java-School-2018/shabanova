package ru.softwerke.controller;

import ru.softwerke.model.Color;
import ru.softwerke.model.Device;
import ru.softwerke.model.DevicesList;
import ru.softwerke.model.TypeOfDevice;
import ru.softwerke.view.Output;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DeviceController {

    private DevicesList devicesList = new DevicesList();
    Output output = new Output();
    Sort sort = new Sort();
    ControllerOutputDevices outDevice = new ControllerOutputDevices();

    public void addDevice(TypeOfDevice type, String manufactured, String releaseDate,
                          Color color, BigDecimal price) {
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

    public void showListOfDevices(){
        List<Device> devices = devicesList.getDevicesList();
        for (Device device: devices) {
            outDevice.showDevice(device);
        }

    }
    public void showListOfDevices(List<Device> devices){
        for (Device device: devices) {
            outDevice.showDevice(device);
        }

    }
    public Device findDeviceById(long idDevice) {
        List<Device> devices = devicesList.getDevicesList();
        Device devicewithId = null;
        for (Device device : devices) {
            if (idDevice == device.getId()) {
                devicewithId = device;
            }
        }
    return  devicewithId;
    }
    public Device findDeviceByManufactured (String strManufact) {
        List<Device> devices = devicesList.getDevicesList();
        Device devicewithManufactured = null;
        for (Device device : devices) {
            if (strManufact.equals(device.getManufactured())) {
                devicewithManufactured = device;
            }
        }
    return  devicewithManufactured;
    }

    public List sortDeviceByType (){
        return devicesList.sortByType();
    }

    public List sortDeviceByManuFactured(){
        List<Device> sortedDevices = new ArrayList();
        Map.Entry<Long, String> stringslist = (Map.Entry<Long, String>) new HashMap();
        Map sortedStringslist = new HashMap<Long, String>();
        String strForCompare1;
        String strForCpmpare2;
        for (Device device: devicesList.getDevicesList()) {
            stringslist.s(device.getId(), device.getManufactured());
            System.out.println(stringslist.ge);
        }

//        Iterator<Map.Entry<Long, String>> iterator1 = stringslist.entrySet().iterator();
//        while(iterator1.hasNext()){
//            Map.Entry<Long, String> elemenet1 = iterator1.next();
//            strForCompare1 = elemenet1.getValue();
//            Iterator<Map.Entry<Long, String>> iterator2 = stringslist.entrySet().iterator();
//            while(iterator2.hasNext()) {
//                Map.Entry<Long, String> elemenet2 = iterator2.next();
//                strForCpmpare2 = elemenet2.getValue();
//                if (strForCompare1.equals(strForCpmpare2)){
//                    if (!sortedStringslist.containsKey(elemenet1.getKey())) {
//                        sortedStringslist.put(elemenet1.getKey(), elemenet1.getValue());
//                    }
//                }
//            }
//        }
        iterator1 = sortedStringslist.entrySet().iterator();
        while(iterator1.hasNext()){
            Map.Entry<Long, String> elemenet = iterator1.next();
            long id = elemenet.getKey();
            sortedDevices.add(findDeviceById(id));
        }
        return sortedDevices;
    }
}
