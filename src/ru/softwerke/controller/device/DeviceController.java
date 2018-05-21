package ru.softwerke.controller.device;

import ru.softwerke.model.device.Color;
import ru.softwerke.model.device.Device;
import ru.softwerke.model.device.DevicesList;
import ru.softwerke.model.device.TypeOfDevice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static ru.softwerke.view.main.Output.getOutput;

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
    public List<Device> sortDeviceByType() {
        TypeComparator typeComparator = new TypeComparator();
        List<Device> copiedDevices = new ArrayList<>();
        copiedDevices.addAll(devices);
        Collections.sort(copiedDevices, typeComparator);
        return copiedDevices;
    }

    public void deleteDeviceId (long id){
        devicesList.deleteDeviceFromListById(id);
    }

    public void deleteDeviceByTypeManufacturer(String strType, String manufacturer) {
        List<Device> foundDevices = new ArrayList<>();
        for (Device device: devices) {
            if(strType.equalsIgnoreCase(device.getType().toString()) &&
                    manufacturer.equalsIgnoreCase(device.getManufactured())){
                foundDevices.add(device);
            }
        }
        if (foundDevices.size() == 0){
            getOutput().printTheString("Not found: " + strType + " " + manufacturer);
        }else if (foundDevices.size() ==  1){
            Device device = foundDevices.get(0);
            long id = device.getId();
            deleteDeviceId(id);
            getOutput().printTheString("Device was deleted");
        }else{
            getOutput().printTheString("Found devices: ");
            getOutput().printNamesOfDevice();
            showListOfDevices(foundDevices);
            getOutput().printTheString("Choose ID od device to delete: ");
            long id = Long.parseLong(getOutput().readInputLine());
            devicesList.deleteDeviceFromListById(id);
            getOutput().printTheString("Device was deleted");
        }
}

    public List<Device> findDeviceByManufacturer() {
        ManufacturerComparator manufacturerComparator = new ManufacturerComparator();
        List<Device> copiedDevices = new ArrayList<>();
        copiedDevices.addAll(devices);
        copiedDevices.sort(manufacturerComparator);
        return copiedDevices;
    }

    public List<Device> sortDeviceByReleaseDate() {
        ReleaseDateComparator relDateComparator = new ReleaseDateComparator();
        List<Device> copiedDevices = new ArrayList<>();
        copiedDevices.addAll(devices);
        copiedDevices.sort(relDateComparator);
        return copiedDevices;
    }

    public List<Device> findDeviceByType(String type) {
        List<Device> devicesList = new ArrayList<>();
        for (Device device : devices) {
            if (type.equalsIgnoreCase(String.valueOf(device.getType()))) {
                devicesList.add(device);
            }
        }
        return devicesList;
    }

    public List<Device> findDeviceByManufacturer(String str) {
        List<Device> devicesList = new ArrayList<>();
        for (Device device : devices) {
            if (str.equalsIgnoreCase(device.getManufactured())) {
                devicesList.add(device);
            }
        }
        return devicesList;
    }
}