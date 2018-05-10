package ru.softwerke.view.devicesmenu;

import static ru.softwerke.view.main.Output.output;

/**
 * Created by DS on 10.05.2018.
 */
public class DevicesMenuItems {
    public final static String ADD_DEVICE = "1";
    public final static String SHOW_DEVICES_LIST = "2";
    public final static String SORT_DEVICES_BY_TYPE_SHOW = "3";
    public final static String SHOW_DEVICES_SORT_BY_MANUFACT = "4";
    public final static String DELETE_DEVICE_BY_TYPE_AND_MANUF = "5";

    public void displayDeviceMenu(){
        output.printTheString("1 - add the device");
        output.printTheString("2 - show devices list");
        output.printTheString("3 - show devices sort by Type");
        output.printTheString("4 - show devices sort by Manufactured");
        output.printTheString("5 - delete device by Type and Manufactured");
    }
}
