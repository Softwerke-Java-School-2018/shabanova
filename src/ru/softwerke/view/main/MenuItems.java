package ru.softwerke.view.main;

import static ru.softwerke.view.main.Output.output;

public class MenuItems {

    public final static String EXIT = "0";
    public final static String WORK_WITH_CLIENT = "1";
    public final static String WORK_WITH_DEVICE = "2";
    public final static String WORK_WITH_INVOICE = "3";
    public void displayMainMenu(){
        output.printTheString("0 - Exit");
        output.printTheString("1 - work with client");
        output.printTheString("2 - work with device");
        output.printTheString("3 - work with invoice");
    }
}
