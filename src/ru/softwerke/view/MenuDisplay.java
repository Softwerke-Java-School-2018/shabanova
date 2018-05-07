package ru.softwerke.view;

public class MenuDisplay {

    public void displayMainMenu(){
        Output out = new Output();
        out.printTheString("0 - exit");
        out.printTheString("1 - add the client");
        out.printTheString("2 - add the device");
        out.printTheString("3 - show clients list");
        out.printTheString("4 - show devices list");
        out.printTheString("5 - delete client from list");
        out.printTheString("6 - show devices sort by Type");
        out.printTheString("7 - make invoice");
        out.printTheString("8 - show list of invoices");
        out.printTheString("9 - show devices sort by Manufactured");
    }
}
