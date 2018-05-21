package ru.softwerke.view.main;

import java.util.Scanner;

public class Output {
    private Output(){
    }
    private static  class OutputHolder {
        private static Output output = new Output();
    }
    public static Output getOutput(){
        return OutputHolder.output;
    }

    private Scanner sc = new Scanner(System.in);

    public void listClientsIsEmpty() {
        printTheString("List of clients is empty");
    }

    public void printTheString (String string){
        System.out.println(string);
    }

    public String readInputLine(){
        return sc.nextLine();
    }

//    public void printFormattedString(String ...strings) {
//        System.out.printf(strings);
//    }

    public void printNamesOfDevice(){
        System.out.printf("|%5s| |%20s| |%12s| |%12s| |%12s| \n",
                "ID", "Device","Color", "Release date", "Price");
    }
    public void printNamesOfClients(){
        System.out.printf("|%5s| |%12s| |%12s| |%14s| \n",
                "ID", "Name","Last name", "Date of birth");
    }

    public void printNamesOfInvoice(){
        System.out.printf("|%5s| |%20s| |%12s| |%12s| |%10s| |%5s| |%25s| \n",
                "ID", "Device","Color", "Release date", "Price",
                "Sold", "Sold date");
    }

    public void listDevicesIsEmpty() {
        printTheString("List of devices is empty");
    }
}
