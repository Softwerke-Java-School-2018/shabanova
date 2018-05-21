package ru.softwerke.view.main;

import static ru.softwerke.view.main.Output.getOutput;

public class MenuItems {

    public final static String EXIT = "0";
    public final static String WORK_WITH_CLIENT = "1";
    public final static String WORK_WITH_DEVICE = "2";
    public final static String WORK_WITH_INVOICE = "3";
    public void displayMainMenu(){
        getOutput().printTheString("0 - Exit");
        getOutput().printTheString("1 - work with client");
        getOutput().printTheString("2 - work with device");
        getOutput().printTheString("3 - work with invoice");
    }
}
