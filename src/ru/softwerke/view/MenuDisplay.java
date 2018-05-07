package ru.softwerke.view;

import static ru.softwerke.view.Output.output;

public class MenuDisplay {

    public void displayMainMenu(){
        output.printTheString("0 - Exit");
        output.printTheString("1 - work with client");
        output.printTheString("2 - work with device");
        output.printTheString("3 - make invoice");
        output.printTheString("4 - show list of invoices");
    }

    public void displayClientMenu(){
        output.printTheString("1 - add the client");
        output.printTheString("2 - show clients list");
        output.printTheString("3 - delete client from list by ID");
        output.printTheString("4 - delete client from list by last name");
    }
    public void displayDeviceMenu(){
        output.printTheString("1 - add the device");
        output.printTheString("2 - show devices list");
        output.printTheString("3 - show devices sort by Type");
        output.printTheString("4 - show devices sort by Manufactured");
        output.printTheString("5 - delete device by Type and Manufactured");
    }
}
