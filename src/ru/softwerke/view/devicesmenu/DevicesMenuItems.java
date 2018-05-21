package ru.softwerke.view.devicesmenu;

import static ru.softwerke.view.main.Output.getOutput;

/**
 * Created by DS on 10.05.2018.
 */
public class DevicesMenuItems {
    public final static String ADD_DEVICE = "1";
    public final static String SHOW_DEVICES_LIST = "2";
    public final static String SORT_DEVICES_BY_TYPE_SHOW = "3";
    public final static String SORT_DEVICES_BY_MANUFACTURER = "4";
    public final static String SORT_DEVICES_BY_RELEASE_DATE = "5";
    public final static String FIND_DEVICES_BY_TYPE = "6";
    public final static String FIND_DEVICES_BY_MANUFACTURER = "7";
    public final static String DELETE_DEVICE_BY_TYPE_AND_MANUFACTURER = "8";

    public void displayDeviceMenu(){
        getOutput().printTheString("0 - back to main menu");
        getOutput().printTheString("1 - add the device");
        getOutput().printTheString("2 - show devices list");
        getOutput().printTheString("3 - show devices sort by Type");
        getOutput().printTheString("4 - show devices sort by Manufacture");
        getOutput().printTheString("5 - show devices sort by release date");
        getOutput().printTheString("6 - find devices by type");
        getOutput().printTheString("7 - find devices by manufacture");
        getOutput().printTheString("8 - delete device by Type and Manufacture");
    }
}
