package ru.softwerke.view.devicesmenu;

import ru.softwerke.controller.device.ControllerOutputDevices;
import ru.softwerke.controller.device.DeviceController;
import ru.softwerke.model.device.Color;
import ru.softwerke.model.device.TypeOfDevice;
import ru.softwerke.view.main.MenuItems;

import java.math.BigDecimal;
import java.util.List;

import static ru.softwerke.view.main.Output.output;

/**
 * Created by Тапок on 07.05.2018.
 */
public class WorkWithDeviceMenu {
    public void itemMenu(String item, DeviceController deviceController){
        ControllerOutputDevices outForDevice = new ControllerOutputDevices();
        String releaseDate;
        TypeOfDevice type;
        Color color;
        String manufactured;
        BigDecimal price;
        switch (item) {
            case DevicesMenuItems.ADD_DEVICE:
                type = outForDevice.enterDeviceType();
                manufactured = outForDevice.enterDeviceManuf();
                releaseDate = outForDevice.enterDeviceReleaseDate();
                color = outForDevice.enterColor();
                price = outForDevice.enterPrice();
                deviceController.addDevice(type, manufactured, releaseDate, color, price);
                output.printTheString("Device was add");
                break;

            case DevicesMenuItems.SHOW_DEVICES_LIST:
                deviceController.showListOfDevices();
                break;

            case DevicesMenuItems.SORT_DEVICES_BY_TYPE_SHOW:
                List sortedDevicesByType = deviceController.sortDeviceByType();
                deviceController.showListOfDevices(sortedDevicesByType);
                break;
            case DevicesMenuItems.SHOW_DEVICES_SORT_BY_MANUFACT:
                List sortedDevicesByManuf = deviceController.sortDeviceByManuFactured();
                deviceController.showListOfDevices(sortedDevicesByManuf);
                break;
            case DevicesMenuItems.DELETE_DEVICE_BY_TYPE_AND_MANUF:
                    output.printTheString("Enter type of device (Laptop, Mp3_Player, Smartphone, Tablet):");
                    String strType = output.readInputLine();
                    output.printTheString("Enter manufactured of device:");
                    String strManuf  = output.readInputLine();
                    deviceController.deleteDeviceByTypeManuf(strType, strManuf);
                break;
        }
    }
}
