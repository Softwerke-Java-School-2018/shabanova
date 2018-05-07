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

import static ru.softwerke.view.Output.output;

public class DeviceController {

    private DevicesList devicesList = new DevicesList();
    private List<Device> devices = devicesList.getDevicesList();
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

    public void showListOfDevices() {
        for (Device device : devices) {
            outDevice.showDevice(device);
        }

    }

    public void showListOfDevices(List<Device> devices) {
        for (Device device : devices) {
            outDevice.showDevice(device);
        }

    }

    public Device findDeviceById(long idDevice) {
        Device devicewithId = null;
        for (Device device : devices) {
            if (idDevice == device.getId()) {
                devicewithId = device;
            }
        }
        return devicewithId;
    }

    public Device findDeviceByManufactured(String strManufact) {
        Device devicewithManufactured = null;
        for (Device device : devices) {
            if (strManufact.equals(device.getManufactured())) {
                devicewithManufactured = device;
            }
        }
        return devicewithManufactured;
    }

    public List sortDeviceByType() {
        return devicesList.sortByType();
    }

//    public List sortDeviceByManuFactured() {
//        List<Device> sortedDevices = new ArrayList();
//        Map<Long, String> stringslist = new HashMap<>();
//        Map<Long, String> sortedStringslist = new HashMap<>();
//        String strForCompare1;
//        String strForCpmpare2;
//        for (Device device : devicesList.getDevicesList()) {
//            stringslist.put(device.getId(), device.getManufactured());
//
//        }
//        Iterator<Map.Entry<Long, String>> iterator1 = stringslist.entrySet().iterator();
//        while (iterator1.hasNext()) {
//            Map.Entry<Long, String> elementOut = iterator1.next();
//            strForCompare1 = elementOut.getValue();
//            Iterator<Map.Entry<Long, String>> iterator2 = stringslist.entrySet().iterator();
//            while (iterator2.hasNext()) {
//                Map.Entry<Long, String> elementIn = iterator2.next();
//                strForCpmpare2 = elementIn.getValue();
//                if (strForCompare1.equals(strForCpmpare2)) {
//                    if (!sortedStringslist.containsKey(elementIn.getKey())) {
//                        sortedStringslist.put(elementIn.getKey(), elementIn.getValue());
//                        long id = elementIn.getKey();
//                        sortedDevices.add(findDeviceById(id));
//                    }
//                }
//            }
//        }
//        return sortedDevices;
//    }
public List createSortedListManufacture() {
    List<String> returnedList = new ArrayList();
    Set<String> stringslist = new TreeSet<>();
    Set<String> sortedStringslist = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
    String strForCompare1;
    String strForCpmpare2;
    for (Device device : devicesList.getDevicesList()) {
        stringslist.add(device.getManufactured());
 }
    Iterator<String> iterator1 = stringslist.iterator();
    while (iterator1.hasNext()) {
        strForCompare1 = iterator1.next();
        Iterator<String> iterator2 = stringslist.iterator();
        while (iterator2.hasNext()) {
            strForCpmpare2 = iterator2.next();
            if (strForCompare1.equals(strForCpmpare2)) {
                    sortedStringslist.add(strForCpmpare2);
            }
        }
    }
    iterator1 = stringslist.iterator();
    while (iterator1.hasNext()) {
        returnedList.add(iterator1.next());
    }
    return returnedList;
}

public List sortDeviceByManuFactured(){
        List<Device> returnedSortedList = new ArrayList<>();
        List<String> allSortedManufactured = createSortedListManufacture();
    for (String string: allSortedManufactured) {
        for (Device device : devicesList.getDevicesList()) {
            if (string.equals(device.getManufactured())){
                returnedSortedList.add(device);
            }
        }

    }
    return returnedSortedList;
}
    public void deleteDeviceId (long id){
        devicesList.deleteDeviceFromListById(id);
    }
    public boolean checkEmptyListClient(){
        if (devices.size() == 0){
            return true;
        }else{
            return false;
        }
    }
    public void deleteDeviceByTypeManuf(String strType, String strManuf) {
        List<Device> foundDevices = new ArrayList();
        for (Device device: devices) {
            if(strType.equalsIgnoreCase(device.getType().toString()) &&
                    strManuf.equalsIgnoreCase(device.getManufactured())){
                foundDevices.add(device);
            }
        }
        if (foundDevices.size() == 0){
            output.printTheString("Not found: " + strType + " " + strManuf);
        }else if (foundDevices.size() ==  1){
            Device device = foundDevices.get(0);
            long id = device.getId();
            deleteDeviceId(id);
            output.printTheString("Device was deleted");
        }else{
            output.printTheString("Found devices: ");
            output.printNamesOfDevice();
            showListOfDevices(foundDevices);
            output.printTheString("Choose ID od device to delete: ");
            long id = output.readInputLong();
            devicesList.deleteDeviceFromListById(id);
            output.printTheString("Device was deleted");

        }


}
}