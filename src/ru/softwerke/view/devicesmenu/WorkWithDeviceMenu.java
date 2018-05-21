package ru.softwerke.view.devicesmenu;

import ru.softwerke.controller.device.ControllerOutputDevices;
import ru.softwerke.controller.device.DeviceController;
import ru.softwerke.model.device.Color;
import ru.softwerke.model.device.TypeOfDevice;

import java.math.BigDecimal;
import java.util.List;

import static ru.softwerke.view.main.Output.getOutput;

/**
 * Created by Тапок on 07.05.2018.
 */
public class WorkWithDeviceMenu {
    public void itemMenu(String item, DeviceController deviceController) {
        ControllerOutputDevices outForDevice = new ControllerOutputDevices();
        String releaseDate;
        TypeOfDevice type;
        Color color;
        String manufactured;
        BigDecimal price;
        switch (item) {
            case DevicesMenuItems.ADD_DEVICE:
                type = outForDevice.enterDeviceType();
                manufactured = outForDevice.enterDeviceManufacturer();
                releaseDate = outForDevice.enterDeviceReleaseDate();
                color = outForDevice.enterColor();
                price = outForDevice.enterPrice();
                deviceController.addDevice(type, manufactured, releaseDate, color, price);
                getOutput().printTheString("Device was add");
                break;

            case DevicesMenuItems.SHOW_DEVICES_LIST:
                deviceController.showListOfDevices();
                break;

            case DevicesMenuItems.SORT_DEVICES_BY_TYPE_SHOW:
                List sortedDevicesByType = deviceController.sortDeviceByType();
                deviceController.showListOfDevices(sortedDevicesByType);
                break;
            case DevicesMenuItems.SORT_DEVICES_BY_MANUFACTURER:
                List sortedDevicesByManuf = deviceController.findDeviceByManufacturer();
                deviceController.showListOfDevices(sortedDevicesByManuf);
                break;
            case DevicesMenuItems.SORT_DEVICES_BY_RELEASE_DATE:
                List sortedDevicesByRelDate = deviceController.sortDeviceByReleaseDate();
                deviceController.showListOfDevices(sortedDevicesByRelDate);

                break;
            case DevicesMenuItems.DELETE_DEVICE_BY_TYPE_AND_MANUFACTURER:
                getOutput().printTheString("Enter type of device (Laptop, Mp3_Player, Smartphone, Tablet):");
                String strType = getOutput().readInputLine();
                getOutput().printTheString("Enter manufactured of device:");
                String strManuf = getOutput().readInputLine();
                deviceController.deleteDeviceByTypeManufacturer(strType, strManuf);
                break;
            case DevicesMenuItems.FIND_DEVICES_BY_TYPE:
                getOutput().printTheString("Enter type of device (Laptop, Mp3_Player, Smartphone, Tablet):");
                String typeStr = getOutput().readInputLine();
                List devicesWithTypes = deviceController.findDeviceByType(typeStr);
                if (devicesWithTypes.size() != 0) {
                    getOutput().printNamesOfDevice();
                    deviceController.showListOfDevices(devicesWithTypes);
                } else {
                    getOutput().printTheString("Not found device: " + typeStr);
                }
                break;
            case DevicesMenuItems.FIND_DEVICES_BY_MANUFACTURER:
                String str = outForDevice.enterDeviceManufacturer();
                List devicesWithManuf = deviceController.findDeviceByManufacturer(str);
                if (devicesWithManuf.size() != 0) {
                    getOutput().printNamesOfDevice();
                    deviceController.showListOfDevices(devicesWithManuf);
                } else {
                    getOutput().printTheString("Not found device: " + str);
                }
                break;
        }
    }
}
