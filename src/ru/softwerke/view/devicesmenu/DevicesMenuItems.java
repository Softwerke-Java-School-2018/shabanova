package ru.softwerke.view.devicesmenu;

import static ru.softwerke.view.main.Output.output;

/**
 * Created by DS on 10.05.2018.
 */
public class DevicesMenuItems {
    public final static String ADD_DEVICE = "1";
    public final static String SHOW_DEVICES_LIST = "2";
    public final static String SORT_DEVICES_BY_TYPE_SHOW = "3";
    public final static String SORT_DEVICES_BY_MANUFACT = "4";
    public final static String SORT_DEVICES_BY_RELEASEDATE = "5";
    public final static String FIND_DEVICES_BY_TYPE = "6";
    public final static String FIND_DEVICES_BY_MANUF = "7";
    public final static String DELETE_DEVICE_BY_TYPE_AND_MANUF = "8";

    public void displayDeviceMenu(){
        output.printTheString("1 - add the device");
        output.printTheString("2 - show devices list");
        output.printTheString("3 - show devices sort by Type");
        output.printTheString("4 - show devices sort by Manufacture");
        output.printTheString("5 - show devices sort by release date");
        output.printTheString("6 - find devices by type");
        output.printTheString("7 - find devices by manufacture");
        output.printTheString("8 - delete device by Type and Manufacture");
    }
}
