package ru.softwerke.controller.device;

import ru.softwerke.model.device.Color;
import ru.softwerke.model.device.Device;
import ru.softwerke.model.device.DevicesList;
import ru.softwerke.model.device.TypeOfDevice;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static ru.softwerke.view.main.Output.output;

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
            if (strManufact.equalsIgnoreCase(device.getManufactured())) {
                devicewithManufactured = device;
            }
        }
        return devicewithManufactured;
    }

    public List sortDeviceByType() {
        TypeComparator typeComparator = new TypeComparator();
        List<Device> copiedDevices = new ArrayList<>();
        copiedDevices.addAll(devices);
        Collections.sort(copiedDevices, typeComparator);
        return copiedDevices;
    }

    public void deleteDeviceId (long id){
        devicesList.deleteDeviceFromListById(id);
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
            long id = Long.parseLong(output.readInputLine());
            devicesList.deleteDeviceFromListById(id);
            output.printTheString("Device was deleted");

        }


}

    public List sortDeviceByManuFactured() {
        ManufacturedComparator manufComparator = new ManufacturedComparator();
        List<Device> copiedDevices = new ArrayList<>();
        copiedDevices.addAll(devices);
        Collections.sort(copiedDevices, manufComparator);
        return copiedDevices;
    }

    public List sortDeviceByReleaseDate() {
        ReleaseDateComparator relDateComparator = new ReleaseDateComparator();
        List<Device> copiedDevices = new ArrayList<>();
        copiedDevices.addAll(devices);
        Collections.sort(copiedDevices, relDateComparator);
        return copiedDevices;
    }

    public List findDeviceByType(String type) {
        List<Device> devicesList = new ArrayList<>();
        for (Device device : devices) {
            if (type.equalsIgnoreCase(String.valueOf(device.getType()))) {
                devicesList.add(device);
            }
        }
        return devicesList;
    }

    public List findDeviceByManuf(String str) {
        List<Device> devicesList = new ArrayList<>();
        for (Device device : devices) {
            if (str.equalsIgnoreCase(device.getManufactured())) {
                devicesList.add(device);
            }
        }
        return devicesList;
    }
}